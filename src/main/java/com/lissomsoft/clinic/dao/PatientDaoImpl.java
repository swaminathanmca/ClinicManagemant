package com.lissomsoft.clinic.dao;

import com.lissomsoft.clinic.domain.Blood;
import com.lissomsoft.clinic.domain.Patient;
import com.lissomsoft.clinic.rowmapper.BloodMapper;
import com.lissomsoft.clinic.rowmapper.PatientMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;
import org.springframework.web.bind.annotation.PathVariable;

import javax.swing.text.html.HTMLDocument;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Lissomsoft on 3/24/2017.
 */
public class PatientDaoImpl implements  PatientDao {
    private static final Logger logger = LoggerFactory.getLogger(UserDaoImpl.class);
    DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
    @Autowired(required = false)
    private NamedParameterJdbcTemplate jdbcTemplate;
    @Autowired(required = false)
    private PlatformTransactionManager platformTransactionManager;

    @Override
    public boolean addPatient(Patient patient,Integer clinic_id) {

        int result=0;
        int result_emergency=0;
        int result_mapper=0;

        DefaultTransactionDefinition paramTransactionDefinition = new DefaultTransactionDefinition();
        TransactionStatus status = platformTransactionManager.getTransaction(paramTransactionDefinition);
        try{

            String insertPateientSql="INSERT INTO patient_master(clinic_id,branch_id,first_name,last_name,dob,sex,blood_group_code,address1,address2,city,state,country,pincode,contact_no,mobile_no,email_id,created_at,updated_at) VALUES ((SELECT  b.clinic_id FROM branch_master b where b.branch_id=:branch_id),:branch_id,:first_name,:last_name,:dob,:gender,:blood_group,:address1,:address2,:city,:state,:country,:pincode,:contact_no,:mobile_no,:email_id,:created_at,:created_at)";
            Map<String,Object> parameter=new HashMap<String, Object>();
            parameter.put("branch_id",clinic_id);
            parameter.put("first_name",patient.getFullName());
            parameter.put("last_name",patient.getLastName());
            parameter.put("dob",patient.getDob());
            parameter.put("gender",patient.getGender());
            parameter.put("blood_group",patient.getBloodGroup());
            parameter.put("address1",patient.getAddress1());
            parameter.put("address2",patient.getAddress2());
            parameter.put("city",patient.getCity());
            parameter.put("state",patient.getState());
            parameter.put("country",patient.getCountry());
            parameter.put("pincode",patient.getPincode());
            parameter.put("contact_no",patient.getContact_no());
            parameter.put("mobile_no",patient.getResidental_no());
            parameter.put("email_id",patient.getEmail());
            parameter.put("created_at",format.format(new Date()));
            result=jdbcTemplate.update(insertPateientSql,parameter);


        }catch (Exception e){
            e.printStackTrace();
            platformTransactionManager.rollback(status);
        }
       if((result>0)? true :false){

           try {

               String insertEmergencySql="INSERT INTO emergency_master(name,relation,address1,address2,city,state,country,pincode,contact_no,mobile_no,email_id,created_at,updated_at) VALUES (:name,:relation,:address1,:address2,:city,:state,:country,:pincode,:contact_no,:mobile_no,:email_id,:created_at,:created_at)";
               Map<String,Object> parameter1=new HashMap<String, Object>();
               parameter1.put("name",patient.getEmergency_name());
               parameter1.put("relation",patient.getRelation());
               parameter1.put("address1",patient.getEmergency_address1());
               parameter1.put("address2",patient.getEmergency_address2());
               parameter1.put("city",patient.getEmergency_city());
               parameter1.put("state",patient.getEmergency_state());
               parameter1.put("country",patient.getEmergency_country());
               parameter1.put("pincode",patient.getEmergency_pincode());
               parameter1.put("contact_no",patient.getEmergency_contact_no());
               parameter1.put("mobile_no",patient.getEmergency_residental_no());
               parameter1.put("email_id",patient.getEmergency_email());
               parameter1.put("created_at",format.format(new Date()));

               result_emergency=jdbcTemplate.update(insertEmergencySql,parameter1);

           }catch (Exception e){
               e.printStackTrace();
               platformTransactionManager.rollback(status);
           }
       }


        if((result_emergency >0) ? true :false){

            try {

                String insertMapperSql="INSERT INTO emergency_mapper(patient_id,emergency_id,created_at,updated_at) VALUES ((SELECT patient_id FROM patient_master WHERE contact_no=:contact_no),(SELECT emergency_id FROM emergency_master WHERE contact_no=:phone_no),:created_at,:created_at)";
                Map<String ,Object> maperParameter=new HashMap<String, Object>();
                maperParameter.put("contact_no",patient.getContact_no());
                maperParameter.put("phone_no",patient.getEmergency_contact_no());
                maperParameter.put("created_at",format.format(new Date()));
                result_mapper=jdbcTemplate.update(insertMapperSql,maperParameter);
                platformTransactionManager.commit(status);

            }catch (Exception e){
                e.printStackTrace();
                platformTransactionManager.rollback(status);
            }

        }

        return result_mapper >0 ? true :false;
    }

    @Override
    public List<Blood> bloodtypeDetails() {

       List<Blood> getBlooddetails=null;

        try {
                String BloodSql="SELECT * FROM clinic.blood_master";
                getBlooddetails=jdbcTemplate.query(BloodSql,new BloodMapper());

        }catch (Exception e){
            e.printStackTrace();
        }

        return getBlooddetails;
    }

    @Override
    public List<Patient> validatePatient(String contact_no) {

        List<Patient> PatientDetails=null;
        try{

            String validatePhone="SELECT first_name,last_name,patient_id FROM patient_master WHERE  contact_no=:contact_no";
            Map<String,Object> parameter=new HashMap<String, Object>();
            parameter.put("contact_no",contact_no);

            PatientDetails=jdbcTemplate.query(validatePhone,parameter,new PatientMapper());


        }catch (Exception e){
            e.printStackTrace();
        }



        return PatientDetails;
    }
}