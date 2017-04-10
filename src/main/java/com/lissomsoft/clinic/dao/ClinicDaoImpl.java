package com.lissomsoft.clinic.dao;

import com.lissomsoft.clinic.domain.Branch;
import com.lissomsoft.clinic.domain.Clinic;
import com.lissomsoft.clinic.rowmapper.BranchMapper;
import com.lissomsoft.clinic.rowmapper.ClinicBranchMapper;
import com.lissomsoft.clinic.rowmapper.ClinicMapper;
import com.lissomsoft.clinic.rowmapper.TrackMapper;
import com.lissomsoft.clinic.vo.ClinicUser;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;



import java.lang.ref.SoftReference;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;


/**
 * Created by Admin on 2/20/2017.
 */
public class ClinicDaoImpl implements ClinicDao {

    private static final Logger logger = LoggerFactory.getLogger(UserDaoImpl.class);
    DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
    @Autowired(required = false)
    private NamedParameterJdbcTemplate jdbcTemplate;
    @Autowired(required = false)
    private PlatformTransactionManager platformTransactionManager;



    @Override
    public boolean addClinic(ClinicUser clinic) {
        int result = 0;
        int result_branch = 0;
        int result_profile = 0;
        int result_user = 0;
        int result_member = 0;
        int result_role = 0;


        DefaultTransactionDefinition paramTransactionDefinition = new DefaultTransactionDefinition();
        TransactionStatus status = platformTransactionManager.getTransaction(paramTransactionDefinition);




        try {

            String insertClinicSql = "INSERT INTO clinic_master (clinic_name,reg_no,status,chief,created_at,updated_at) VALUES (:clinic_name,:reg_no,:status,:chief,:created_at,:created_at)";

            System.out.println(insertClinicSql);
            Map<String, Object> parameters = new HashMap<String, Object>();
            parameters.put("clinic_name", clinic.getClinic_name());
            parameters.put("reg_no", clinic.getRegister_no());
            parameters.put("status", 1);
            parameters.put("chief", clinic.getChief_name());
            parameters.put("created_at", format.format(new Date()));
            parameters.put("updated_at", format.format(new Date()));
            result = jdbcTemplate.update(insertClinicSql, parameters);

        } catch (Exception e) {
            e.printStackTrace();
            platformTransactionManager.rollback(status);

        }
        if ((result > 0) ? true : false) {
            try {

                String insertUserSql = "INSERT INTO user (username,password,email,status,created_at,updated_at) VALUES (:user_name,:password,:email,1,:created_at,:created_at)";
                Map<String, Object> parameters1 = new HashMap<String, Object>();
                parameters1.put("user_name", clinic.getClinic_name());
                parameters1.put("password", clinic.getPassword());
                parameters1.put("email", clinic.getEmail_id());
                parameters1.put("created_at", format.format(new Date()));
                parameters1.put("updated_at", format.format(new Date()));

                result_user = jdbcTemplate.update(insertUserSql, parameters1);

            } catch (Exception e) {
                e.printStackTrace();
                platformTransactionManager.rollback(status);
            }
        }
        if ((result_user > 0) ? true : false) {

            try {
                String insertProfileSql = "INSERT INTO profile_master(name,address1,address2,city,state,country,phone,email,pincode,gender,created_at,updated_at)VALUES(:name,:address1,:address2,:city,:state,:country,:phone,:email,:pincode,:gender,:created_at,:created_at)";
                Map<String, Object> parameters2 = new HashMap<String, Object>();
                parameters2.put("name", clinic.getChief_name());
                parameters2.put("address1", clinic.getChief_address1());
                parameters2.put("address2", clinic.getChief_address2());
                parameters2.put("city", clinic.getChief_city());
                parameters2.put("state", clinic.getChief_state());
                parameters2.put("country", clinic.getChief_country());
                parameters2.put("phone", clinic.getChief_contact_no());
                parameters2.put("email", clinic.getChief_email_id());
                parameters2.put("pincode", clinic.getChief_pin_code());
                parameters2.put("gender", clinic.getGender());
                parameters2.put("created_at", format.format(new Date()));
                parameters2.put("updated_at", format.format(new Date()));
                result_profile = jdbcTemplate.update(insertProfileSql, parameters2);

            } catch (Exception e) {
                e.printStackTrace();
                platformTransactionManager.rollback(status);

            }
        }
        if ((result_profile > 0) ? true : false) {
            try {
                String insertMemberSql = "INSERT INTO member_master(user_id,profile_id,created_at,updated_at) VALUES((SELECT  user.user_id FROM user WHERE user.email=:email),(SELECT profile_master.profile_id FROM profile_master WHERE profile_master.email=:email_id),:created_at,:created_at) ";
                Map<String, Object> member = new HashMap<String, Object>();
                member.put("email", clinic.getEmail_id());
                member.put("email_id",clinic.getChief_email_id());
                member.put("created_at", format.format(new Date()));
                result_member = jdbcTemplate.update(insertMemberSql, member);

            } catch (Exception e) {
                e.printStackTrace();
                platformTransactionManager.rollback(status);
            }
        }
        if ((result_member > 0) ? true : false) {
            try {

                String insertBranchSql = "INSERT INTO branch_master(branch_name,clinic_id,ho,user_id,address1,address2,city,state,country,pin_code,email,contact_no,status,description,created_at,updated_at) VALUES ('MainBranch',(SELECT  clinic_master.clinic_id FROM clinic_master where clinic_master.clinic_name=:clinic_name),1,(SELECT  user.user_id FROM user where user.email=:email),:address1,:address2,:city,:state,:country,:pin_code,:email,:contact_no,1,:description,:created_at,:created_at)";
                Map<String, Object> branch = new HashMap<String, Object>();
                branch.put("branch_name", clinic.getBranch_name());
                branch.put("address1", clinic.getAddress1());
                branch.put("address2", clinic.getAddress2());
                branch.put("city", clinic.getCity());
                branch.put("state", clinic.getState());
                branch.put("country", clinic.getCountry());
                branch.put("contact_no", clinic.getContact_no());
                branch.put("email", clinic.getEmail_id());
                branch.put("pin_code", clinic.getPin_code());
                branch.put("description",clinic.getDescription());
                branch.put("chief_email", clinic.getChief_email_id());
                branch.put("clinic_name", clinic.getClinic_name());
                branch.put("created_at", format.format(new Date()));
                branch.put("updated_at", format.format(new Date()));
                result_branch = jdbcTemplate.update(insertBranchSql, branch);

            } catch (Exception e) {
                e.printStackTrace();
                platformTransactionManager.rollback(status);
            }
        }
        if ((result_branch > 0) ? true : false) {
            try {
                String insertRoleSql = "INSERT INTO role_mapper(user_id,role_id,created_at,updated_at) VALUES((SELECT user.user_id FROM user WHERE email=:email),2,:created_at,:created_at)";

                Map<String, Object> role = new HashMap<String, Object>();
                role.put("email", clinic.getEmail_id());
                role.put("clinic_name", clinic.getClinic_name());
                role.put("email_id", clinic.getEmail_id());
                role.put("created_at", format.format(new Date()));
                result_role = jdbcTemplate.update(insertRoleSql, role);

                platformTransactionManager.commit(status);
            } catch (Exception e) {
                e.printStackTrace();
                platformTransactionManager.rollback(status);
            }
        }



        return (result_role > 0) ? true : false;

    }

    @Override
    public boolean editClinic(ClinicUser clinicUser) {
        int result = 0;
        int result_branch = 0;
        int result_profile = 0;
        int result_user = 0;
        int result_member = 0;
        int result_role = 0;


        DefaultTransactionDefinition paramTransactionDefinition = new DefaultTransactionDefinition();
        TransactionStatus status = platformTransactionManager.getTransaction(paramTransactionDefinition);

        try {

            String editClinicSql = "UPDATE clinic_master SET  clinic_name=:clinic_name,reg_no=:reg_no,chief=:Chief_name,updated_at=:updated_at WHERE clinic_id=:clinic_id";
            Map<String, Object> parameters = new HashMap<String, Object>();
            parameters.put("clinic_id", clinicUser.getClinic_id());
            parameters.put("clinic_name", clinicUser.getClinic_name());
            parameters.put("reg_no",clinicUser.getRegister_no());
            parameters.put("Chief_name",clinicUser.getChief_name());

            parameters.put("updated_at", format.format(new Date()));

            result = jdbcTemplate.update(editClinicSql, parameters);

        } catch (Exception e) {

            e.printStackTrace();
            platformTransactionManager.rollback(status);
        }

        if((result > 0) ? true : false) {

            try{
                String editBranchSql="UPDATE branch_master SET branch_name='MainBranch',address1=:address1,address2=:address2,city=:city,state=:state,country=:country,pin_code=:pincode,contact_no=:contact_no,email=:email,description=:description WHERE clinic_id=:clinic_id AND ho=1";
                Map<String,Object> branch=new HashMap<String, Object>();
                branch.put("branch_name",clinicUser.getClinic_name());
                branch.put("clinic_id",clinicUser.getClinic_id());
                branch.put("address1",clinicUser.getAddress1());
                branch.put("address2",clinicUser.getAddress2());
                branch.put("city",clinicUser.getCity());
                branch.put("state",clinicUser.getState());
                branch.put("country",clinicUser.getCountry());
                branch.put("pincode",clinicUser.getPin_code());
                branch.put("contact_no",clinicUser.getContact_no());
                branch.put("email",clinicUser.getEmail_id());
                branch.put("description",clinicUser.getDescription());
                branch.put("updated_at",format.format(new Date()));
                result_branch=jdbcTemplate.update(editBranchSql, branch);

            }catch (Exception e){
                e.printStackTrace();
                platformTransactionManager.rollback(status);
            }
        }
        if((result_branch>0) ? true :false){
            try
            {
            String edituserSql="UPDATE user SET username=:username,email=:email,password=:password,updated_at=:updated_at WHERE user_id=(SELECT member_master.user_id FROM member_master where member_master.profile_id=:profile_id)";
                Map<String, Object> user = new HashMap<String, Object>();
                user.put("username",clinicUser.getClinic_name());
                user.put("email",clinicUser.getEmail_id());
                user.put("password",clinicUser.getPassword());


                user.put("profile_id",clinicUser.getChief_id());
                user.put("updated_at",format.format(new Date()));
                result_user=jdbcTemplate.update(edituserSql,user);


            }catch (Exception e){
                e.printStackTrace();
                platformTransactionManager.rollback(status);
            }
        }
        if((result_user>0) ? true :false){
            try {
                String editProfileSql="UPDATE profile_master SET name=:name,address1=:address1,address2=:address2,city=:city,state=:state,country=:country,pincode=:pincode,phone=:contact_no,email=:email,gender=:gender,updated_at=:updated_at  WHERE  profile_id=:profile_id";

                Map<String,Object> profile=new HashMap<String, Object>();
                profile.put("name",clinicUser.getChief_name());
                profile.put("profile_id",clinicUser.getChief_id());
                profile.put("address1",clinicUser.getChief_address1());
                profile.put("address2",clinicUser.getChief_address2());
                profile.put("city",clinicUser.getChief_city());
                profile.put("state",clinicUser.getChief_state());
                profile.put("country",clinicUser.getChief_country());
                profile.put("pincode",clinicUser.getChief_pin_code());
                profile.put("contact_no",clinicUser.getChief_contact_no());
                profile.put("email",clinicUser.getChief_email_id());
                profile.put("gender",clinicUser.getGender());
                profile.put("updated_at",format.format(new Date()));
                result_profile=jdbcTemplate.update(editProfileSql,profile);

                platformTransactionManager.commit(status);
            }catch (Exception e){
                e.printStackTrace();
                platformTransactionManager.rollback(status);
            }
        }

        return (result_profile > 0) ? true : false;
    }

    @Override
    public boolean deleteClinic(Integer clinicID) {
        int result = 0;
        try {
            String deleteClinic = "DELETE FROM clinic WHERE clinic_id=:clinic_id";
            Map<String, Object> parameters = new HashMap<String, Object>();
            parameters.put("clinic_id", clinicID);
            result = jdbcTemplate.update(deleteClinic, parameters);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return (result > 0) ? true : false;
    }

    @Override
    public List<Branch> validateno(String contact_no) {


        List<Branch> branchiList = null;

        try {
            String validateno = "SELECT * FROM branch_master WHERE contact_no=:contact_no";

            Map<String, Object> parameters = new HashMap<String, Object>();
            parameters.put("contact_no", contact_no);


            branchiList = jdbcTemplate.query(validateno, parameters, new BranchMapper());

        } catch (Exception e) {
            e.printStackTrace();
        }

        return branchiList;
    }

    @Override
    public List<Clinic> validateName(String clinic_name) {

        List<Clinic> clincList=null;
        try {
            String clinicName="SELECT * FROM clinic_master WHERE clinic_name=:clinic_name";
            Map<String, Object> parameters = new HashMap<String, Object>();
            parameters.put("clinic_name", clinic_name);
            clincList=jdbcTemplate.query(clinicName,parameters,new ClinicMapper());
        }catch (Exception e){
            e.printStackTrace();
        }
        return clincList;
    }

    @Override
    public List<Branch> email(String email_id) {
        List<Branch> clinciListEmail = null;

        try {
            String validateemail = "SELECT * FROM branch_master WHERE email=:email_id";
            Map<String, Object> parameter = new HashMap<String, Object>();
            parameter.put("email_id", email_id);

            clinciListEmail = jdbcTemplate.query(validateemail, parameter, new BranchMapper());


        } catch (Exception e) {
            e.printStackTrace();
        }

        return clinciListEmail;
    }


    @Override
    public List<ClinicUser> getClinic() {
        List<ClinicUser> getClinicDetails = null;
        try {
           /* String clinicDetails ="SELECT c.clinic_id,c.clinic_name,c.chief,c.reg_no,c.status,b.address1,b.address2,b.city,b.state,b.country,b.pin_code,b.contact_no,b.email,b.description FROM branch_master b JOIN clinic_master c ON c.clinic_id=b.clinic_id and ho=1";*/
            String clinicDetails="SELECT c.clinic_id,c.clinic_name,b.branch_id,b.branch_name,c.reg_no,c.status,u.password,c.chief,b.address1,b.address2,b.city,b.state,b.country,b.pin_code,b.contact_no,b.email,b.description,p.profile_id,p.name,p.address1 ch_addrs1, p.address2 ch_addrs2,p.city ch_city,p.state ch_state,p.country ch_country,p.phone,p.email ch_email,p.pincode,p.gender FROM clinic.clinic_master c INNER JOIN clinic.branch_master b ON c.clinic_id = b.clinic_id INNER JOIN clinic.member_master m ON b.user_id = m.user_id INNER JOIN   clinic.user u ON u.user_id=b.user_id INNER JOIN clinic.profile_master p ON p.profile_id = m.profile_id  AND b.ho = 1";

            getClinicDetails = jdbcTemplate.query(clinicDetails, new ClinicBranchMapper());

        } catch (Exception e) {
            e.printStackTrace();
        }
        return getClinicDetails;
    }
    /*@Override
    public List<Clinic> getClinicById(Integer id) {
        List<Clinic> getClinicId = null;
        try {
            String clinicDetails = "SELECT * FROM clinic_master where clinic_id=:clinicId";
            Map<String, Object> parameter = new HashMap<String, Object>();
            parameter.put("clinicId", id);
            getClinicId = jdbcTemplate.query(clinicDetails, parameter, new ClinicMapper());
            System.out.println("dataWrong"  +getClinicId);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return getClinicId;
    }*/

    @Override
    public List<ClinicUser> viewDetails(Integer clinic_id) {
        List<ClinicUser> getClinicDetails=null;
        try{
            String viewClinic="SELECT c.clinic_id,c.clinic_name,b.branch_id,b.branch_name,c.reg_no,u.password,c.status,c.chief,b.address1,b.address2,b.city,b.state,b.country,b.pin_code,b.contact_no,b.email,b.description,p.profile_id,p.name,p.address1 ch_addrs1, p.address2 ch_addrs2,p.city ch_city,p.state ch_state,p.country ch_country,p.phone,p.email ch_email,p.pincode,p.gender FROM clinic.clinic_master c INNER JOIN clinic.branch_master b ON c.clinic_id = b.clinic_id INNER JOIN\n clinic.member_master m ON b.user_id = m.user_id INNER JOIN clinic.user u ON u.user_id=b.user_id   INNER JOIN  clinic.profile_master p ON p.profile_id = m.profile_id  AND c.clinic_id = :clinic_id AND b.ho=1" ;
            Map<String, Object> parameter = new HashMap<String, Object>();
            parameter.put("clinic_id", clinic_id);
            getClinicDetails=jdbcTemplate.query(viewClinic,parameter,new ClinicBranchMapper());


        }catch (Exception e){
            e.printStackTrace();
        }


        return getClinicDetails;
    }

    @Override
    public List<ClinicUser> track_id(String email) {

       List<ClinicUser> getTrack_id=null;
        try {
           /* String trackSql="SELECT c.clinic_id, b.branch_id,c.clinic_name,b.ho,b.branch_name FROM clinic.clinic_master c, clinic.branch_master b, clinic.role_master r,clinic.member_master m, clinic.profile_master p WHERE c.clinic_id = b.clinic_id  AND b.branch_id = r.branch_id AND r.user_id = m.user_id AND m.profile_id = p.profile_id AND p.email = :email_id";*/
            String trackSql="SELECT c.clinic_id,b.branch_id,c.clinic_name,b.ho,b.branch_name FROM clinic.clinic_master c INNER JOIN clinic.branch_master b  ON c.clinic_id=b.clinic_id AND b.email=:email_id ";
            Map<String,Object> tracking=new HashMap<String, Object>();
            tracking.put("email_id",email);
            getTrack_id=jdbcTemplate.query(trackSql,tracking,new TrackMapper());



        }catch (Exception e){
            e.printStackTrace();
        }





        return getTrack_id;
    }
}