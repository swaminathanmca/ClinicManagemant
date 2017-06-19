package com.lissomsoft.clinic.dao;

import com.lissomsoft.clinic.domain.User;
import com.lissomsoft.clinic.rowmapper.UserLogin;
import com.lissomsoft.clinic.rowmapper.UserMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;
import javax.mail.MessagingException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by Admin on 2/17/2017.
 */
public class UserDaoImpl implements  UserDao {

    private static final Logger logger = LoggerFactory.getLogger(UserDaoImpl.class);
    DateFormat format = new SimpleDateFormat("yyyy.MM.dd G 'at' HH:mm:ss z");
    @Autowired(required = false)
    private NamedParameterJdbcTemplate jdbcTemplate;
    @Autowired(required = false)
    private PlatformTransactionManager platformTransactionManager;


    public List<User> authenticateUser(String email_id,String password){

        List<User> userList = null;
        User userDetails = null;
        try{


            String authenticateSQL="SELECT rm.role_name,u.username,u.email FROM role_mapper r INNER JOIN user u ON u.user_id=r.user_id INNER JOIN role_mastr rm ON r.role_id=rm.role_id AND u.email=:email AND u.password=:password";

            Map<String, Object> parameters = new HashMap<String, Object>();
            parameters.put("email", email_id);
            parameters.put("password", password);

            userList = jdbcTemplate.query(authenticateSQL, parameters, new UserMapper());




        }catch (Exception ex){
            logger.debug(String.valueOf(ex));
        }


        return userList;
    }

    @Override
    public Boolean getPassword(String email_id)
    {

        final String username = "devteam@lissomsoft.com";
        final String password = "code@123";
        int result=0;
        int res=0;
        DefaultTransactionDefinition paramTransactionDefinition = new DefaultTransactionDefinition();
        TransactionStatus status = platformTransactionManager.getTransaction(paramTransactionDefinition);
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        Session session = Session.getDefaultInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username,password);
                    }
                });
        try {
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(username));
            message.addRecipient(Message.RecipientType.TO,new InternetAddress(email_id));
            String uniqueID = UUID.randomUUID().toString();
            String link="http://localhost:8080/Clinic/cpassword?token="+uniqueID;
            message.setSubject("Forgot Password");
            String msg = "<h4>You're receiving this e-mail because you requested to reset the password of your account.</h4><br><a  href="+link   +" >Click Here</a><br><p>If you didn't request this change, you can disregard this email - we have not yet reset your password.</p>";
            message.setContent(msg, "text/html; charset=utf-8");
            Transport.send(message);



            try
            {
                String validateSql="INSERT INTO login_audit (password_token,status,user_id,created_at,updated_at) VALUES(:token,0,(SELECT u.user_id FROM user u WHERE u.email=:email_id),:created_at,:created_at)";
                Map<String,Object> parameter=new HashMap<String, Object>();
                parameter.put("email_id",email_id);
                parameter.put("token",uniqueID);
                parameter.put("created_at",format.format(new Date()));
                res=jdbcTemplate.update(validateSql,parameter);

            } catch (Exception e){
                e.printStackTrace();
                platformTransactionManager.rollback(status);
            }

            if((res > 0)? true :false) {
                try {
                    String insUser = "UPDATE user SET password_reset=1 WHERE email=:email_id";
                    Map<String, Object> params = new HashMap<String, Object>();
                    params.put("email_id", email_id);

                    result = jdbcTemplate.update(insUser, params);
                    platformTransactionManager.commit(status);
                } catch (Exception e) {
                    e.printStackTrace();
                    platformTransactionManager.rollback(status);
                }
            }

        } catch (MessagingException e) {
            e.printStackTrace();
        }
        return result>0 ?true:false;
    }

    @Override
    public List<User> validateEmail(String email_id) {

        List<User> users=null;
        try {

            String validateSql="SELECT * FROM user WHERE email=:email_id";
            Map<String,Object> parameter=new HashMap<String, Object>();
            parameter.put("email_id",email_id);
            users=jdbcTemplate.query(validateSql,parameter,new UserLogin());

        }catch (Exception e){
            e.printStackTrace();
        }



        return users;
    }

    @Override
    public Boolean resetPassword(String token, String password) {

        int result=0;
        int result_user=0;
        DefaultTransactionDefinition paramTransactionDefinition = new DefaultTransactionDefinition();
        TransactionStatus status = platformTransactionManager.getTransaction(paramTransactionDefinition);

        try {

            String resetSql="UPDATE user SET password=:password WHERE user_id=(SELECT l.user_id from login_audit l WHERE l.password_token=:token)";
            Map<String,Object> parameter=new HashMap<String, Object>();
            parameter.put("token",token);
            parameter.put("password",password);

            result_user =jdbcTemplate.update(resetSql, parameter);

        }catch (Exception e){
            e.printStackTrace();
            platformTransactionManager.rollback(status);
        }
        if((result_user > 0)? true :false){

            try {

                String resetUserSql="UPDATE login_audit SET status=1,updated_at=:updated_at WHERE password_token=:token";

                Map<String,Object> params=new HashMap<String, Object>();
                params.put("token",token);
                params.put("updated_at",format.format(new Date()));
                result=jdbcTemplate.update(resetUserSql,params);
                platformTransactionManager.commit(status);

            }catch (Exception e){
                e.printStackTrace();
                platformTransactionManager.rollback(status);
            }

        }


        return result>0?true:false;
    }

    @Override
    public List<User> validateToken(String token) {
        List<User> users=null;

        String validateSql="SELECT * FROM user WHERE user_id=(SELECT l.user_id from login_audit l WHERE l.password_token=:token AND status=1)";
        Map<String,Object> parameter=new HashMap<String, Object>();
        parameter.put("token",token);
        users=jdbcTemplate.query(validateSql,parameter,new UserLogin());


        return users;
    }
}
