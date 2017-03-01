package com.lissomsoft.clinic.dao;
import com.lissomsoft.clinic.domain.Clinic;
import com.lissomsoft.clinic.rowmapper.ClinicMapper;
import com.lissomsoft.clinic.vo.ClinicUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * Created by Admin on 2/20/2017.
 */
public class ClinicDaoImpl implements ClinicDao {

    private static final Logger logger = LoggerFactory.getLogger(UserDaoImpl.class);
    DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
    @Autowired(required = false)
    private NamedParameterJdbcTemplate jdbcTemplate;
    @Autowired (required = false)
    private PlatformTransactionManager platformTransactionManager;


    @Override
    public boolean addClinic(ClinicUser clinic) {
        int result = 0;
        int result_branch=0;
        int result_profile=0;
        int result_user=0;
        int result_member=0;
        DefaultTransactionDefinition paramTransactionDefinition = new DefaultTransactionDefinition();
        TransactionStatus status=platformTransactionManager.getTransaction(paramTransactionDefinition );

        try {

            String insertClinicSql = "INSERT INTO clinic_master (clinic_name,reg_no,status,chief,created_at,updated_at) VALUES (:clinic_name,:reg_no,:status,:chief,:created_at,:updated_at)";

            System.out.println(insertClinicSql);
            Map<String, Object> parameters = new HashMap<String, Object>();
            parameters.put("clinic_name",clinic.getClinic_name());
            parameters.put("reg_no",clinic.getRegister_no());
            parameters.put("status",1);
            parameters.put("chief",clinic.getChief_name());
            parameters.put("created_at", format.format(new Date()));
            parameters.put("updated_at", format.format(new Date()));
            result = jdbcTemplate.update(insertClinicSql, parameters);
            platformTransactionManager.commit(status);

        } catch (Exception e) {
            e.printStackTrace();
            platformTransactionManager.rollback(status);


        }
            if((result > 0) ? true : false){
                try {
                    String insertUserSql = "INSERT INTO user (username,password,email,status,created_at,updated_at) VALUES (:user_name,:password,:email,:1)";
                    Map<String, Object> parameters1 = new HashMap<String, Object>();
                    parameters1.put("user_name", clinic.getClinic_name());
                    parameters1.put("password", clinic.getPassword());
                    parameters1.put("email", clinic.getEmail_id());
                    parameters1.put("created_at", format.format(new Date()));
                    parameters1.put("updated_at", format.format(new Date()));

                    result_user = jdbcTemplate.update(insertUserSql, parameters1);
                    platformTransactionManager.commit(status);
                }catch (Exception e){
                    e.printStackTrace();
                    platformTransactionManager.rollback(status);
                }
            }else{
                platformTransactionManager.rollback(status);
            }
        if((result_user > 0) ? true : false){

            try{
                String insertProfileSql="INSERT INTO profile_master(name,address1,address2,city,state,country,phone,email,pincode,gender,created_at,updated_at)VALUES(:name,:address1,:address2,:city,:state,:country,:phone,:email,:pincode,:gender,:created_at,:updated_at)";
                Map<String,Object> parameters2=new HashMap<String, Object>();
                parameters2.put("name",clinic.getChief_name());
                parameters2.put("address1",clinic.getChief_address1());
                parameters2.put("address2",clinic.getChief_address2());
                parameters2.put("city",clinic.getChief_city());
                parameters2.put("state",clinic.getChief_state());
                parameters2.put("country",clinic.getChief_country());
                parameters2.put("phone",clinic.getChief_contact_no());
                parameters2.put("email",clinic.getChief_email_id());
                parameters2.put("pincode",clinic.getChief_pin_code());
                parameters2.put("gender",clinic.getGender());
                parameters2.put("created_at", format.format(new Date()));
                parameters2.put("updated_at", format.format(new Date()));
                result_profile=jdbcTemplate.update(insertProfileSql,parameters2);
                platformTransactionManager.commit(status);
            }catch (Exception e){
                e.printStackTrace();
                platformTransactionManager.rollback(status);
            }
        }else{
            platformTransactionManager.rollback(status);
        }
        if((result_profile >0)? true :false){
            try{
                String insertMemberSql="INSERT INTO member_master(user_id,profile_id) SELECT user.user_id,profile_master.profile_id FROM user INNER JOIN profile_master ON user.email=profile_master.email and user.email=:email; ";
                Map<String,Object> member=new HashMap<String, Object>();
                member.put("email",clinic.getChief_email_id());
                result_member=jdbcTemplate.update(insertMemberSql,member);
            }catch (Exception e){
                e.printStackTrace();
            }
        }else{
            platformTransactionManager.rollback(status);
        }
    if((result_member>0)?true :false){
        try{

            String insertBranchSql="INSERT INTO branch_master(branch_name,clinic_id,ho,chief_id,address1,address2,city,state,country,pin_code,email,contact_no,status,created_at,updated_at) VALUES ()";
            Map<String,Object> branch=new HashMap<String, Object>();
            branch.put("branch_name",clinic.getBranch_name());
            branch.put("address1",clinic.getAddress1());
            branch.put("address2",clinic.getAddress2());
            branch.put("city",clinic.getCity());
            branch.put("state",clinic.getState());
            branch.put("country",clinic.getCountry());
            branch.put("contact_no",clinic.getContact_no());
            branch.put("email",clinic.getEmail_id());
            branch.put("pin_code",clinic.getPin_code());
            branch.put("chief_email",clinic.getChief_email_id());
        }catch (Exception e){
            e.printStackTrace();
        }
    }

        return (result > 0) ? true : false;

    }

    @Override
    public boolean editClinic(Clinic clinic) {
        int result = 0;

        try {

            String editBranchSql = "UPDATE clinic SET  clinic_name=:clinic_name,address=:address,country=:country,location=:location,city=:city,state=:state,zip=:pincode,contact_number=:contact_number,email=:email,description=:description,updated_at=:updated_at WHERE clinic_id=:clinic_id";
            System.out.println(editBranchSql);
            Map<String, Object> parameters = new HashMap<String, Object>();
            parameters.put("clinic_id",clinic.getClinic_id());
            parameters.put("clinic_name", clinic.getClinic_name());

            parameters.put("updated_at", format.format(new Date()));

            result = jdbcTemplate.update(editBranchSql, parameters);
        } catch (Exception e) {

            e.printStackTrace();
        }
        return (result > 0) ? true : false;
    }

    @Override
    public boolean deleteClinic(Integer clinicID) {
        int result=0;
        try {
            String deleteClinic="DELETE FROM clinic WHERE clinic_id=:clinic_id";
            Map<String, Object> parameters = new HashMap<String, Object>();
            parameters.put("clinic_id", clinicID);
            result=jdbcTemplate.update(deleteClinic,parameters);

        }catch (Exception e){
            e.printStackTrace();
        }
        return (result > 0) ? true : false;
    }

    @Override
    public List<Clinic> validateno(String contact_no) {

        Clinic clinicDetails = null;
        List<Clinic> clinciList = null;

        try {
            String validateno = "SELECT * FROM branch_master WHERE phone_no=:contact_no";

            Map<String, Object> parameters = new HashMap<String, Object>();
            parameters.put("contact_no", contact_no);


            clinciList = jdbcTemplate.query(validateno, parameters, new ClinicMapper());

        } catch (Exception e) {
            e.printStackTrace();
        }

        return clinciList;
    }

    @Override
    public List<Clinic> email(String email_id) {
        List<Clinic> clinciListEmail = null;

        try {
            String validateemail = "SELECT * FROM branch_master WHERE email=:email_id";
            Map<String, Object> parameter = new HashMap<String, Object>();
            parameter.put("email_id", email_id);

            clinciListEmail = jdbcTemplate.query(validateemail, parameter, new ClinicMapper());


        } catch (Exception e) {
            e.printStackTrace();
        }

        return clinciListEmail;
    }



    @Override
    public List<Clinic> getClinic() {
        List<Clinic> getClinicDetails=null;
        try {
            String clinicDetails="SELECT * FROM clinic";
            getClinicDetails=jdbcTemplate.query(clinicDetails, new ClinicMapper());

        } catch (Exception e) {
            e.printStackTrace();
        }
        return getClinicDetails;
    }

    @Override
    public List<Clinic> getClinicById(Integer id) {
        List<Clinic> getClinicId=null;
        try {
            String clinicDetails="SELECT * FROM clinic where clinic_id=:clinicId";
            Map<String, Object> parameter = new HashMap<String, Object>();
            parameter.put("clinicId", id);
            getClinicId=jdbcTemplate.query(clinicDetails,parameter, new ClinicMapper());
        }catch (Exception e){
            e.printStackTrace();
        }

        return getClinicId;
    }
}