package com.lissomsoft.clinic.dao;

import com.lissomsoft.clinic.domain.Doctor;
import com.lissomsoft.clinic.domain.Profile;
import com.lissomsoft.clinic.rowmapper.DoctorMapper;
import com.lissomsoft.clinic.rowmapper.ProfileMapper;
import com.lissomsoft.clinic.rowmapper.TrackMapper;
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
import java.util.List;
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

                String insertProfileSql="INSERT INTO profile_master(name,address1,address2,city,state,country,phone,email,pincode,gender,created_at,updated_at) VALUES(:first_name,:address1,:address2,:city,:state,:country,:phone,:email,:pincode,:gender,:created_at,:created_at)";

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
                String insertDoctorSql="INSERT INTO doctor_detail(user_id,clinic_id,branch_id,qualification,specialization,reg_id,type,created_at,updated_at)  VALUES ((SELECT u.user_id FROM user u WHERE u.email=:email),:clinic_id,:branch_id,:qualification,:specialization,:reg_id,1,:created_at,:created_at)";
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

    @Override
    public List<Profile> viewDoctor(Integer branch_id) {

            List<Profile> getDoctordetails=null;
        try {

            String viewdetails="SELECT p.profile_id,p.name,p.email,p.phone,p.address1,p.address2 FROM profile_master p INNER JOIN member_master m  ON m.profile_id=p.profile_id INNER JOIN user u ON u.user_id=m.user_id INNER JOIN doctor_detail d ON d.user_id=u.user_id AND d.branch_id=:branch_id AND d.type=1";

            Map<String ,Object> parameter=new HashMap<String, Object>();
            parameter.put("branch_id",branch_id);
            getDoctordetails= jdbcTemplate.query(viewdetails,parameter,new ProfileMapper());
        }catch (Exception e){
            e.printStackTrace();
        }
        return getDoctordetails;
    }

    @Override
    public List<DoctorUser> doctorDetails(Integer profile_id) {
       List<DoctorUser> doctordetails=null;
try {
    String doctorDetailsSql="SELECT p.profile_id,p.name,p.address1,p.address2,p.city,p.state,p.country,p.pincode,p.gender,p.email,p.phone,c.clinic_name,c.clinic_id,b.branch_name,b.branch_id,d.doctor_detail_id,d.qualification,d.specialization,d.reg_id,u.password FROM profile_master p INNER JOIN member_master m ON p.profile_id=m.profile_id INNER JOIN user u ON m.user_id=u.user_id INNER JOIN doctor_detail d ON u.user_id=d.user_id INNER JOIN branch_master b ON b.branch_id=d.branch_id INNER JOIN clinic_master c ON c.clinic_id=d.clinic_id AND p.profile_id=:profile_id";

    Map<String,Object> parameter=new HashMap<String, Object>();
    parameter.put("profile_id",profile_id);
    doctordetails=jdbcTemplate.query(doctorDetailsSql,parameter,new DoctorMapper());
        }
    catch (Exception e){
    e.printStackTrace();

    }



        return doctordetails;
    }

    @Override
    public boolean editDoctor(DoctorUser doctorUser) {

        int result_profile = 0;
        int result_user = 0;
        int result_doctor=0;
        DefaultTransactionDefinition paramTransactionDefinition = new DefaultTransactionDefinition();
        TransactionStatus status = platformTransactionManager.getTransaction(paramTransactionDefinition);

        try {

            String editDoctorSql  ="UPDATE doctor_detail SET branch_id=:branch_id,qualification=:qualification,specialization=:specialization,reg_id=:reg_id,updated_at=:updated_at WHERE doctor_detail_id=:doctor_id";
            Map<String,Object> parameter=new HashMap<String, Object>();
            parameter.put("doctor_id",doctorUser.getDoctor_id());
            parameter.put("branch_id",doctorUser.getBranch_id());
            parameter.put("qualification",doctorUser.getQualification());
            parameter.put("specialization",doctorUser.getSpecialization());
            parameter.put("reg_id",doctorUser.getReg_no());
            parameter.put("updated_at",format.format(new Date()));
            result_doctor=jdbcTemplate.update(editDoctorSql,parameter);




        }catch (Exception e){
            e.printStackTrace();
            platformTransactionManager.rollback(status);
        }
    if((result_doctor >0) ? true :false ){

        try {

            String editUserSql="UPDATE user SET username=:username,password=:password,email=:email,updated_at=:updated_at WHERE user_id=(SELECT d.user_id FROM doctor_detail d WHERE d.doctor_detail_id=:doctor_id)";
            Map<String,Object> userParameter=new HashMap<String, Object>();
            userParameter.put("doctor_id",doctorUser.getDoctor_id());
            userParameter.put("email",doctorUser.getEmail_id());
            userParameter.put("password",doctorUser.getPassword());
            userParameter.put("username",doctorUser.getFirstname());
            userParameter.put("updated_at",format.format(new Date()));
            result_user=jdbcTemplate.update(editUserSql,userParameter);

        }catch (Exception e){
            e.printStackTrace();
            platformTransactionManager.rollback(status);
        }

    }
        if((result_user >0) ? true :false){
            try {
                String editProfileSql="UPDATE profile_master SET name=:name,address1=:address1,address2=:address2,city=:city,state=:state,country=:country,phone=:phone,email=:email,pincode=:pincode,gender=:gender,updated_at=:updated_at WHERE profile_id=:profile_id";
                Map<String,Object> profileParameter=new HashMap<String, Object>();
                profileParameter.put("name",doctorUser.getFirstname());
                profileParameter.put("address1",doctorUser.getAddress1());
                profileParameter.put("address2",doctorUser.getAddress2());
                profileParameter.put("city",doctorUser.getCity());
                profileParameter.put("state",doctorUser.getState());
                profileParameter.put("country",doctorUser.getCountry());
                profileParameter.put("phone",doctorUser.getContact_no());
                profileParameter.put("email",doctorUser.getEmail_id());
                profileParameter.put("pincode",doctorUser.getPincode());
                profileParameter.put("gender",doctorUser.getGender());
                profileParameter.put("profile_id",doctorUser.getProfile_id());
                profileParameter.put("updated_at",format.format(new Date()));
                result_profile=jdbcTemplate.update(editProfileSql,profileParameter);
                platformTransactionManager.commit(status);
            }catch (Exception e){
                e.printStackTrace();
                platformTransactionManager.rollback(status);

            }
        }





        return result_profile >0 ? true :false;
    }

    @Override
    public boolean addFrontdesk(DoctorUser frontdesk) {
        int result = 0;
        int result_branch = 0;
        int result_profile = 0;
        int result_user = 0;
        int result_member = 0;
        int result_role = 0;

        DefaultTransactionDefinition paramTransactionDefinition = new DefaultTransactionDefinition();
        TransactionStatus status = platformTransactionManager.getTransaction(paramTransactionDefinition);


        try{
            String insertUserSql="INSERT INTO user (username,password,email,status,created_at,updated_at) VALUES (:user_name,:password,:email,1,:created_at,:created_at)";
            Map<String, Object> parameters1 = new HashMap<String, Object>();
            parameters1.put("user_name",frontdesk.getFirstname());
            parameters1.put("password",frontdesk.getPassword());
            parameters1.put("email",frontdesk.getEmail_id());
            parameters1.put("created_at",format.format(new Date()));

            result_user = jdbcTemplate.update(insertUserSql, parameters1);

        }catch (Exception e){
            e.printStackTrace();
            platformTransactionManager.rollback(status);
        }

        if((result_user >0) ? true :false){

            try{

                String insertProfileSql="INSERT INTO profile_master(name,address1,address2,city,state,country,phone,email,pincode,gender,created_at,updated_at) VALUES(:first_name,:address1,:address2,:city,:state,:country,:phone,:email,:pincode,:gender,:created_at,:created_at)";

                Map<String, Object> parameters2 = new HashMap<String, Object>();
                parameters2.put("first_name",frontdesk.getFirstname());
                parameters2.put("address1",frontdesk.getAddress1());
                parameters2.put("address2",frontdesk.getAddress2());
                parameters2.put("city",frontdesk.getCity());
                parameters2.put("state",frontdesk.getState());
                parameters2.put("country",frontdesk.getCountry());
                parameters2.put("phone",frontdesk.getContact_no());
                parameters2.put("email",frontdesk.getEmail_id());
                parameters2.put("pincode",frontdesk.getPincode());
                parameters2.put("gender",frontdesk.getGender());
                parameters2.put("created_at",format.format(new Date()));
                result_profile=jdbcTemplate.update(insertProfileSql,parameters2);

            }catch (Exception e){
                e.printStackTrace();
                platformTransactionManager.rollback(status);
            }
        }
        if((result_profile > 0)? true :false ){

            try {
                String insertDoctorSql="INSERT INTO doctor_detail(user_id,clinic_id,branch_id,qualification,type,created_at,updated_at)  VALUES ((SELECT u.user_id FROM user u WHERE u.email=:email),:clinic_id,:branch_id,:qualification,0,:created_at,:created_at)";
                Map<String, Object> doctorParameter = new HashMap<String, Object>();
                doctorParameter.put("email",frontdesk.getEmail_id());
                doctorParameter.put("qualification",frontdesk.getQualification());
                doctorParameter.put("clinic_id",frontdesk.getClinic_id());
                doctorParameter.put("branch_id",frontdesk.getBranch_id());

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
                memberParameter.put("email",frontdesk.getEmail_id());
                memberParameter.put("created_at",format.format(new Date()));
                result_member=jdbcTemplate.update(insertMemberSql,memberParameter);

            }catch (Exception e){
                e.printStackTrace();
                platformTransactionManager.rollback(status);
            }
        }
        if((result_member >0) ? true :false){
            try {
                String insertRoleSql="INSERT INTO role_mapper(user_id,role_id,created_at,updated_at) VALUES((SELECT user.user_id FROM user WHERE email=:email),5,:created_at,:created_at)";
                Map<String,Object> roleParameter=new HashMap<String, Object>();
                roleParameter.put("email",frontdesk.getEmail_id());
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

    @Override
    public List<Profile> viewFrontDesk(Integer branch_id) {

        List<Profile> getFrontdetails=null;
        try {

            String viewdetails="SELECT p.profile_id,p.name,p.email,p.phone,p.address1,p.address2 FROM profile_master p INNER JOIN member_master m  ON m.profile_id=p.profile_id INNER JOIN user u ON u.user_id=m.user_id INNER JOIN doctor_detail d ON d.user_id=u.user_id AND d.branch_id=:branch_id AND d.type=0";

            Map<String ,Object> parameter=new HashMap<String, Object>();
            parameter.put("branch_id",branch_id);
            getFrontdetails= jdbcTemplate.query(viewdetails,parameter,new ProfileMapper());
        }catch (Exception e){
            e.printStackTrace();
        }
        return getFrontdetails;
    }


}