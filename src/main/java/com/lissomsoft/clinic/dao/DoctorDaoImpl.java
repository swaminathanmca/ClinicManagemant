package com.lissomsoft.clinic.dao;

import com.lissomsoft.clinic.vo.DoctorUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import java.security.spec.DSAGenParameterSpec;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Lissomsoft on 3/20/2017.
 */
public class DoctorDaoImpl implements DoctorDao {

    private static final Logger logger = LoggerFactory.getLogger(UserDaoImpl.class);
    DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
    @Autowired(required = false)
    private NamedParameterJdbcTemplate jdbcTemplate;
    @Autowired(required = false)
    private PlatformTransactionManager platformTransactionManager;


    @Override
    public boolean addDoctor(DoctorUser doctorUser) {
        int result = 0;
        int result_branch = 0;
        int result_profile = 0;
        int result_user = 0;
        int result_member = 0;
        int result_role = 0;

        DefaultTransactionDefinition paramTransactionDefinition = new DefaultTransactionDefinition();
        TransactionStatus status = platformTransactionManager.getTransaction(paramTransactionDefinition);
        System.out.println(doctorUser);

        try{
            String insertUserSql="INSERT INTO user (username,password,email,status,created_at,updated_at) VALUES (:user_name,:password,:email,1,:created_at,:created_at)";
            Map<String, Object> parameters1 = new HashMap<String, Object>();
            parameters1.put("user_name",doctorUser.getFirstname());
            parameters1.put("password",doctorUser.getPassword());
            parameters1.put("email",doctorUser.getEmail_id());
            parameters1.put("created_at",format.format(new Date()));

            result_user = jdbcTemplate.update(insertUserSql, parameters1);

        }catch (Exception e){
            e.printStackTrace();
            platformTransactionManager.rollback(status);
        }

        if((result_user >0) ? true :false){

            try{

                String insertProfileSql="INSERT INTO profile_master(name,address1,address2,city,state,country,phone,email,pincode,gender,created_at,updated_at) VALUES(:first_name,:address1,address2,:city,:state,:country,:phone,:email,:pincode,:gender,:created_at,:created_at)";

                Map<String, Object> parameters2 = new HashMap<String, Object>();
                parameters2.put("first_name",doctorUser.getFirstname());
                parameters2.put("address1",doctorUser.getAddress1());
                parameters2.put("address2",doctorUser.getAddress2());
                parameters2.put("city",doctorUser.getCity());
                parameters2.put("state",doctorUser.getState());
                parameters2.put("country",doctorUser.getCountry());
                parameters2.put("phone",doctorUser.getContact_no());
                parameters2.put("email",doctorUser.getEmail_id());
                parameters2.put("pincode",doctorUser.getPincode());
                parameters2.put("gender",doctorUser.getGender());
                parameters2.put("created_at",format.format(new Date()));
                result_profile=jdbcTemplate.update(insertProfileSql,parameters2);

            }catch (Exception e){
                e.printStackTrace();
                platformTransactionManager.rollback(status);
            }
        }
        if((result_profile > 0)? true :false ){

            try {
                String insertDoctorSql="INSERT INTO doctor_detail(user_id,clinic_id,branch_id,qualification,specialization,reg_id,created_at,updated_at)  VALUES ((SELECT u.user_id FROM user u WHERE u.email=:email),:clinic_id,:branch_id,:qualification,:specialization,:reg_id,:created_at,:created_at)";
                Map<String, Object> doctorParameter = new HashMap<String, Object>();
                doctorParameter.put("email",doctorUser.getEmail_id());
                doctorParameter.put("qualification",doctorUser.getQualification());
                doctorParameter.put("clinic_id",doctorUser.getClinic_id());
                doctorParameter.put("branch_id",doctorUser.getBranch_id());
                doctorParameter.put("specialization",doctorUser.getSpecialization());
                doctorParameter.put("reg_id",doctorUser.getReg_no());
                doctorParameter.put("created_at",format.format(new Date()));
                result=jdbcTemplate.update(insertDoctorSql,doctorParameter);
            }catch (Exception e){
                    e.printStackTrace();
                platformTransactionManager.rollback(status);
            }

        }
        if((result >0)? true :false){
            try {
                String insertMemberSql="INSERT INTO member_master(user_id,profile_id,created_at,updated_at) VALUES((SELECT  user.user_id FROM user WHERE user.email=:email),(SELECT profile_master.profile_id FROM profile_master WHERE profile_master.email=:email),:created_at,:created_at)";
                Map<String,Object> memberParameter=new HashMap<String, Object>();
                memberParameter.put("email",doctorUser.getEmail_id());
                memberParameter.put("created_at",format.format(new Date()));
                result_member=jdbcTemplate.update(insertMemberSql,memberParameter);

            }catch (Exception e){
                e.printStackTrace();
                platformTransactionManager.rollback(status);
            }
        }
        if((result_member >0) ? true :false){
            try {
                String insertRoleSql="INSERT INTO role_mapper(user_id,role_id,created_at,updated_at) VALUES((SELECT user.user_id FROM user WHERE email=:email),4,:created_at,:created_at)";
                Map<String,Object> roleParameter=new HashMap<String, Object>();
                roleParameter.put("email",doctorUser.getEmail_id());
                roleParameter.put("created_at",format.format(new Date()));
                result_role=jdbcTemplate.update(insertRoleSql,roleParameter);

                platformTransactionManager.commit(status);
            }catch (Exception e){
                e.printStackTrace();
                platformTransactionManager.rollback(status);
            }
        }

        return result_role > 0 ? true :false;
    }
}
