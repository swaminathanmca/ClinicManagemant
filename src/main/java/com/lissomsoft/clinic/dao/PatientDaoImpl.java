package com.lissomsoft.clinic.dao;

import com.lissomsoft.clinic.domain.Blood;
import com.lissomsoft.clinic.domain.Patient;
import com.lissomsoft.clinic.domain.PatientVisit;
import com.lissomsoft.clinic.rowmapper.*;
import org.codehaus.jettison.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;
import org.springframework.web.bind.annotation.PathVariable;

import javax.swing.text.html.HTMLDocument;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.text.DateFormat;
import java.util.Calendar;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by Lissomsoft on 3/24/2017.
 */
public class PatientDaoImpl implements  PatientDao {
    private static final Logger logger = LoggerFactory.getLogger(UserDaoImpl.class);
    DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
    DateFormat format1 = new SimpleDateFormat("dd-MM-yyyy");
    DateFormat dateFormat=new SimpleDateFormat("YYYY-MMM-dd");
    Calendar cal = Calendar.getInstance();
    SimpleDateFormat sdf=new SimpleDateFormat("hh:mm a");
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

            String date =format1.format(new Date());
            String num1=date.replaceAll("-","");
            num1=num1.replaceAll("0","");
            Random generator=new Random();
            int randomno=generator.nextInt(90)+10;
            String uId="OP"+patient.getFullName().charAt(0)+patient.getLastName().substring((patient.getLastName().length()-1))+num1+randomno;
            uId=uId.toUpperCase();
            patient.setPatient_pId(uId);

            String insertPateientSql="INSERT INTO patient_master(clinic_id,branch_id,patient_pid,first_name,last_name,dob,mstatus,sex,blood_group_code,address1,address2,city,state,country,pincode,contact_no,mobile_no,email_id,refered_by,allergy_food,allergy_others,created_at,updated_at) VALUES ((SELECT  b.clinic_id FROM branch_master b where b.branch_id=:branch_id),:branch_id,:patient_pid,:first_name,:last_name,:dob,:mstatus,:gender,:blood_group,:address1,:address2,:city,:state,:country,:pincode,:contact_no,:mobile_no,:email_id,:referred,:allergy_food,:allergy_others,:created_at,:created_at)";
            Map<String,Object> parameter=new HashMap<String, Object>();
            parameter.put("branch_id",clinic_id);
            parameter.put("first_name",patient.getFullName());
            parameter.put("last_name",patient.getLastName());
            parameter.put("patient_pid",patient.getPatient_pId());
            parameter.put("dob",patient.getDob());
            parameter.put("gender",patient.getGender());
            parameter.put("mstatus",patient.getmStatus());
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
            parameter.put("referred",patient.getReferred_by());
            parameter.put("allergy_food",patient.getAllergy_food());
            parameter.put("allergy_others",patient.getAllergy_others());
            parameter.put("created_at",format.format(new Date()));
            result=jdbcTemplate.update(insertPateientSql,parameter);


        }catch (Exception e){
            e.printStackTrace();
            platformTransactionManager.rollback(status);
        }
       if((result>0)? true :false){

           try {

               String insertEmergencySql="INSERT INTO emergency_master(patient_pid,name,relation,address1,address2,city,state,country,pincode,contact_no,mobile_no,email_id,created_at,updated_at) VALUES (:patient_pid,:name,:relation,:address1,:address2,:city,:state,:country,:pincode,:contact_no,:mobile_no,:email_id,:created_at,:created_at)";
               Map<String,Object> parameter1=new HashMap<String, Object>();
               parameter1.put("name",patient.getEmergency_name());
               parameter1.put("patient_pid",patient.getPatient_pId());
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
               platformTransactionManager.commit(status);

           }catch (Exception e){
               e.printStackTrace();
               platformTransactionManager.rollback(status);
           }
       }


       /* if((result_emergency >0) ? true :false){

            try {

                String insertMapperSql="INSERT INTO emergency_mapper(patient_id,emergency_id,created_at,updated_at) VALUES ((SELECT patient_id FROM patient_master WHERE patient_pid=:patient_pid),(SELECT emergency_id FROM emergency_master WHERE contact_no=:phone_no),:created_at,:created_at)";
                Map<String ,Object> maperParameter=new HashMap<String, Object>();
                maperParameter.put("contact_no",patient.getContact_no());
                maperParameter.put("phone_no",patient.getEmergency_contact_no());
                maperParameter.put("patient_pid",patient.getPatient_pId());
                maperParameter.put("created_at",format.format(new Date()));
                result_mapper=jdbcTemplate.update(insertMapperSql,maperParameter);
                platformTransactionManager.commit(status);

            }catch (Exception e){
                e.printStackTrace();
                platformTransactionManager.rollback(status);
            }

        }*/

        return result_emergency >0 ? true :false;
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
        try{String validatePhone="SELECT first_name,last_name,patient_id FROM patient_master WHERE  contact_no=:contact_no";
            Map<String,Object> parameter=new HashMap<String, Object>();
            parameter.put("contact_no",contact_no);
            PatientDetails=jdbcTemplate.query(validatePhone,parameter,new PatientMapper());
        }catch (Exception e){
            e.printStackTrace();
        }
        return PatientDetails;
    }

    @Override
    public List<Patient> viewPatient(String branch_id) {
        List<Patient> PatientDetail=null;
        try {
            String getPatientSql="SELECT * FROM clinic.patient_master WHERE branch_id=:branch_id";
            Map<String,Object>parameter=new HashMap<String, Object>();
            parameter.put("branch_id",branch_id);
            PatientDetail=jdbcTemplate.query(getPatientSql,parameter,new PatientMapper());

        }catch (Exception e){
            e.printStackTrace();
        }

        return PatientDetail;
    }

    @Override
    public Patient patientdetails(Integer patient_id) {

        Patient patient=new Patient();
        try {

            String patientdetailsSql="SELECT p.patient_pid,p.first_name,p.last_name,p.address1,p.address2,p.city,p.state,p.country,p.pincode,p.blood_group_code,p.contact_no,p.mobile_no,p.email_id,p.sex,p.dob,p.mstatus,p.refered_by,p.allergy_food,p.allergy_others,e.name,e.relation,e.address1 emr_address1,e.address2 emr_address2,e.city emr_city,e.state emr_state,e.country emr_country,e.pincode emr_pincode,e.contact_no emr_contact_no,e.mobile_no emr_mobile_no,e.email_id emr_email_id FROM patient_master p INNER JOIN emergency_master e ON p.patient_pid=e.patient_pid AND p.patient_id=:patient_id";
            Map<String,Object> parameter=new HashMap<String, Object>();
            parameter.put("patient_id",patient_id);
             patient= (Patient) jdbcTemplate.queryForObject(patientdetailsSql,parameter,new PatientDetailMapper());

        }catch (Exception e){
            e.printStackTrace();
        }


        return patient;
    }

    @Override
    public boolean editPatient(Patient patient) {

       int result=0;
        int result_emergency=0;
        DefaultTransactionDefinition paramTransactionDefinition = new DefaultTransactionDefinition();
        TransactionStatus status = platformTransactionManager.getTransaction(paramTransactionDefinition);
        try{
            String editPatient="UPDATE patient_master SET first_name=:first_name,last_name=:last_name,address1=:address1,address2=:address2,city=:city,state=:state,country=:country,pincode=:pincode,contact_no=:contact_no,mobile_no=:mobile_no,email_id=:email,dob=:dob,sex=:gender,mstatus=:mstatus,blood_group_code=:blood_group WHERE patient_master.patient_pid=:patient_pid";
            Map<String,Object> parameter=new HashMap<String, Object>();
            parameter.put("first_name",patient.getFullName());
            parameter.put("last_name",patient.getLastName());
            parameter.put("address1",patient.getAddress1());
            parameter.put("address2",patient.getAddress2());
            parameter.put("city",patient.getCity());
            parameter.put("state",patient.getState());
            parameter.put("country",patient.getCountry());
            parameter.put("pincode",patient.getPincode());
            parameter.put("contact_no",patient.getContact_no());
            parameter.put("mobile_no",patient.getResidental_no());
            parameter.put("email",patient.getEmail());
            parameter.put("dob",patient.getDob());
            parameter.put("mstatus",patient.getmStatus());
            parameter.put("gender",patient.getGender());
            parameter.put("blood_group",patient.getBloodGroup());
            parameter.put("patient_pid",patient.getPatient_pId());


            result=jdbcTemplate.update(editPatient,parameter);
        }catch (Exception e){
            e.printStackTrace();
            platformTransactionManager.rollback(status);
        }

if((result >0 )? true :false){

    try {

        String editEmergencySql="UPDATE emergency_master SET name=:name,relation=:relation,address1=:address1,address2=:address2,city=:city,state=:state,country=:country,pincode=:pincode,contact_no=:contact_no,mobile_no=:mobile_no,email_id=:email WHERE emergency_master.patient_pid=:patient_pid";
        Map<String ,Object> parameters=new HashMap<String, Object>();
        parameters.put("name",patient.getEmergency_name());
        parameters.put("relation",patient.getRelation());
        parameters.put("address1",patient.getEmergency_address1());
        parameters.put("address2",patient.getEmergency_address2());
        parameters.put("city",patient.getEmergency_city());
        parameters.put("state",patient.getEmergency_state());
        parameters.put("country",patient.getEmergency_country());
        parameters.put("pincode",patient.getEmergency_pincode());
        parameters.put("contact_no",patient.getEmergency_contact_no());
        parameters.put("mobile_no",patient.getEmergency_residental_no());
        parameters.put("email",patient.getEmergency_email());
        parameters.put("patient_pid",patient.getPatient_pId());
        result_emergency=jdbcTemplate.update(editEmergencySql,parameters);

    platformTransactionManager.commit(status);

    }catch (Exception e){
        e.printStackTrace();
        platformTransactionManager.rollback(status);
    }


}
        return result_emergency >0 ? true :false;
    }

    @Override
    public boolean patientEntry(PatientVisit visit) {

        int result=0;

        try{

            String insertVistSql="INSERT INTO patient_visit(patient_id,branch_id,weight,type,pressure,visit_type,status,entry_time,doctor_detail_id,refereal_details,created_at,updated_at) VALUES(:patient_pid,:branch_id,:weight,:type,:pressure,:vtype,1,:entryTime,:doctor_id,:referal_details,:created_at,:created_at)";
            Map<String ,Object> parameter=new HashMap<String, Object>();
            parameter.put("patient_pid",visit.getPatient_pid());
            parameter.put("branch_id",visit.getBranch_id());
            parameter.put("type",visit.getHeight());
            parameter.put("weight",visit.getWeight());
            parameter.put("vtype",visit.getType());
            parameter.put("entryTime",visit.getTime());
            parameter.put("pressure",visit.getPressure());
            parameter.put("doctor_id",visit.getDoctor_id());
            parameter.put("referal_details",visit.getReferal_details());
            parameter.put("created_at",dateFormat.format(new Date()));



            result=jdbcTemplate.update(insertVistSql,parameter);
        }catch (Exception e){
            e.printStackTrace();
        }
        return result >0 ?true :false;
    }

    @Override
    public List<PatientVisit> patientEntryAll(String branch_id) {

        List<PatientVisit> patientVisit=null;
        try {
            String getPatientVisitSql="SELECT  pm.visit_id,p.first_name,p.last_name,pm.branch_id,p.patient_pid,pm.doctor_detail_id,pm.entry_time,pm.visit_type,pm.refereal_details,pm.type FROM patient_master p INNER JOIN patient_visit pm ON p.patient_id=pm.patient_id AND pm.status=1 AND pm.branch_id=:branch_id AND pm.created_at=:date";
            Map<String,Object> parameter=new HashMap<String, Object>();
            parameter.put("branch_id",branch_id);
            parameter.put("date",dateFormat.format(new Date()));
            patientVisit=jdbcTemplate.query(getPatientVisitSql,parameter,new PatientVisitMapper());
        }catch (Exception e) {
            e.printStackTrace();
        }
        return patientVisit;
    }

    @Override
    public List<PatientVisit> patientEntry(String doctor_id,String branch_id) {

        List<PatientVisit> patientVisit=null;
        try {
            String getPatientVisitSql="SELECT pm.visit_id,p.first_name,p.last_name,pm.branch_id,p.patient_pid,pm.doctor_detail_id,pm.entry_time,pm.visit_type,pm.refereal_details,pm.type FROM patient_master p INNER JOIN patient_visit pm ON p.patient_id=pm.patient_id AND pm.status=1 AND pm.branch_id=:branch_id AND pm.doctor_detail_id=:doctor_id  AND pm.created_at=:date AND pm.status=1";
            Map<String,Object> parameter=new HashMap<String, Object>();
            parameter.put("doctor_id",doctor_id);
            parameter.put("branch_id",branch_id);
            parameter.put("date",dateFormat.format(new Date()));
            patientVisit=jdbcTemplate.query(getPatientVisitSql,parameter,new PatientVisitMapper());


        }catch (Exception e){
            e.printStackTrace();
        }



        return patientVisit;
    }

    @Override
    public List<PatientVisit> getEntryNew(String patient_pid, Integer type,Integer doctor_id) {

       List<PatientVisit> patientVisit=null;
        try {

            String visitentrySql="SELECT p.patient_id patient_pid   FROM patient_visit p  WHERE p.patient_id=:patient_id AND p.type=:type  AND p.created_at=:created_at AND p.doctor_detail_id=:doctor_id";
            Map<String,Object> params=new HashMap<String, Object>();
            params.put("patient_id",patient_pid);
            params.put("type",type);
            params.put("created_at",format.format(new Date()));
            Calendar c = Calendar.getInstance();
            c.add(Calendar.DATE, 7);
            params.put("datebetween",format.format(c.getTime()));


            params.put("doctor_id",doctor_id);
            patientVisit= jdbcTemplate.query(visitentrySql, params, new PatientVisitEntryMapper());

        }catch (Exception e){
            e.printStackTrace();
        }

        return patientVisit;
    }

    @Override
    public List<PatientVisit> getEntryFollowup(String patient_pid, Integer type, Integer doctor_id) {

        List<PatientVisit> patientVisits=null;
        try {
            String visitSql="SELECT  p.patient_id  patient_pid FROM patient_visit p  WHERE p.patient_id=:patient_id AND p.type=:type  AND p.created_at=:created_at AND p.doctor_detail_id=:doctor_id";
            Map<String,Object> paramater=new HashMap<String, Object>();
            paramater.put("doctor_id",doctor_id);
            paramater.put("type",type);
            paramater.put("patient_id",patient_pid);
            paramater.put("created_at",format.format(new Date()));
            patientVisits=jdbcTemplate.query(visitSql,paramater,new PatientVisitEntryMapper());

        }catch (Exception e){
            e.printStackTrace();
        }

        return patientVisits;
    }
}
