package com.lissomsoft.clinic.dao;

import com.lissomsoft.clinic.domain.Branch;
import com.lissomsoft.clinic.rowmapper.BranchMapper;
import com.lissomsoft.clinic.service.BranchService;
import com.lissomsoft.clinic.vo.ClinicUser;
import org.omg.PortableServer.LIFESPAN_POLICY_ID;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Stream;

/**
 * Created by Lissomsoft on 3/15/2017.
 */


public class BranchDaoImpl implements BranchDao {
    private static final Logger logger = LoggerFactory.getLogger(UserDaoImpl.class);
    DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
    @Autowired(required = false)
    private NamedParameterJdbcTemplate jdbcTemplate;
    @Autowired(required = false)
    private PlatformTransactionManager platformTransactionManager;



    @Override
    public boolean addBranch(ClinicUser branch) {
        int result=0;
        int result_branch = 0;
        int result_profile = 0;
        int result_user = 0;
        int result_member = 0;
        int result_role = 0;

        DefaultTransactionDefinition paramTransactionDefinition = new DefaultTransactionDefinition();
        TransactionStatus status = platformTransactionManager.getTransaction(paramTransactionDefinition);

        try {

            String insertUserSql="INSERT INTO user(username,password,email,status,created_at,updated_at) VALUES (:branch_name,:password,:email,1,:created_at,:created_at)";
            Map<String, Object> parameters = new HashMap<String, Object>();
            parameters.put("branch_name",branch.getBranch_name());
            parameters.put("email",branch.getEmail_id());
            parameters.put("password",branch.getPassword());
            parameters.put("created_at", format.format(new Date()));
            result_user = jdbcTemplate.update(insertUserSql, parameters);



        }catch (Exception e){
            e.printStackTrace();
            platformTransactionManager.rollback(status);

        }
        if((result_user > 0) ? true : false) {

            try{

                String insertRoleSql="INSERT INTO role_mapper(user_id,role_id,created_at,updated_at) VALUES((SELECT u.user_id FROM user u WHERE u.email=:email),3,:created_at,:created_at)";

                Map<String,Object> roleParameters=new HashMap<String, Object>();
                roleParameters.put("email",branch.getEmail_id());
                roleParameters.put("created_at", format.format(new Date()));
                result_role=jdbcTemplate.update(insertRoleSql,roleParameters);

            }
            catch (Exception e){
                e.printStackTrace();
                platformTransactionManager.rollback(status);
            }
        }if((result_role >0) ? true :false){

            try {

                String insertProfileSql="INSERT INTO profile_master(name,address1,address2,city,state,country,phone,email,pincode,gender,created_at,updated_at) VALUES(:name,:address1,:address2,:city,:state,:country,:phone,:email,:pincode,:gender,:created_at,:created_at)";


                Map<String,Object> profileParamaters=new HashMap<String, Object>();
                profileParamaters.put("name",branch.getChief_name());
                profileParamaters.put("address1",branch.getChief_address1());
                profileParamaters.put("address2",branch.getChief_address2());
                profileParamaters.put("city",branch.getChief_city());
                profileParamaters.put("state",branch.getChief_state());
                profileParamaters.put("country",branch.getCountry());
                profileParamaters.put("phone",branch.getChief_contact_no());
                profileParamaters.put("email",branch.getChief_email_id());
                profileParamaters.put("pincode",branch.getChief_pin_code());
                profileParamaters.put("gender",branch.getGender());
                profileParamaters.put("created_at",format.format(new Date()));
                result_profile=jdbcTemplate.update(insertProfileSql,profileParamaters);

            }catch (Exception e){
                e.printStackTrace();
                platformTransactionManager.rollback(status);
            }


        }if((result_profile >0) ? true :false){

            try{

                String insertMemberSql="INSERT INTO member_master (user_id,profile_id,created_at,updated_at) VALUES ((SELECT u.user_id FROM user u WHERE u.email=:email),(SELECT p.profile_id FROM profile_master p INNER JOIN member_master m  ON m.profile_id=p.profile_id INNER JOIN user u ON u.user_id=m.user_id  AND u.email=:email),:created_at,:created_at)";

                Map<String,Object> memberparameters=new HashMap<String, Object>();
                memberparameters.put("email",branch.getEmail_id());
                memberparameters.put("created_at",format.format(new Date()));
                result_member=jdbcTemplate.update(insertMemberSql,memberparameters);

            }catch (Exception e){
                e.printStackTrace();
                platformTransactionManager.rollback(status);

            }
        }if((result_member >0) ? true :false){

            try {
                String insertBranchSql="INSERT INTO branch_master(branch_name,clinic_id,ho,user_id,address1,address2,city,state,country,pin_code,contact_no,email,status,description,created_at,updated_at) VALUES (:branch_name,:clinic_id,0,(SELECT u.user_id FROM user u WHERE u.email=:email),:address1,:address2,:city,:state,:country,:pin_code,:contact_no,:email,1,:description,:created_at,:created_at)";
                Map<String,Object> branchParameters=new HashMap<String, Object>();
                branchParameters.put("branch_name",branch.getBranch_name());
                branchParameters.put("clinic_id",branch.getClinic_id());
                branchParameters.put("address1",branch.getAddress1());
                branchParameters.put("address2",branch.getAddress2());
                branchParameters.put("city",branch.getCity());
                branchParameters.put("state",branch.getState());
                branchParameters.put("country",branch.getCountry());
                branchParameters.put("pin_code",branch.getPin_code());
                branchParameters.put("contact_no",branch.getContact_no());
                branchParameters.put("email",branch.getEmail_id());
                branchParameters.put("description",branch.getDescription());
                branchParameters.put("created_at",format.format(new Date()));
                result_branch=jdbcTemplate.update(insertBranchSql,branchParameters);
                platformTransactionManager.commit(status);
            }catch (Exception e){
                e.printStackTrace();
                platformTransactionManager.rollback(status);
            }

        }

        return (result_member >0 ) ? true :false;
    }

    @Override
    public List<Branch> getBranch(Integer clinic_id) {
        List<Branch> getBranchDetails=null;
           try {

               String BranchDetails="SELECT * FROM clinic.branch_master b WHERE b.clinic_id=:clinic_id AND b.ho=0";

               Map<String,Object> parameter=new HashMap<String, Object>();
               parameter.put("clinic_id",clinic_id);
               getBranchDetails=jdbcTemplate.query(BranchDetails,parameter,new BranchMapper());

           }catch (Exception e){
               e.printStackTrace();
           }



        return getBranchDetails;
    }
}
