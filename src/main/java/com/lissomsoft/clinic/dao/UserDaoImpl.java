package com.lissomsoft.clinic.dao;

import com.lissomsoft.clinic.domain.User;
import com.lissomsoft.clinic.rowmapper.UserMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Admin on 2/17/2017.
 */
public class UserDaoImpl implements  UserDao {

    private static final Logger logger = LoggerFactory.getLogger(UserDaoImpl.class);
    @Autowired(required = false)
    private NamedParameterJdbcTemplate jdbcTemplate;

    public List<User> authenticateUser(String email_id,String password){

        List<User> userList = null;
        User userDetails = null;
        try{


            String authenticateSQL="SELECT r.role_name,u.username,r.branch_id,u.email FROM clinic.role_master r JOIN clinic.user u on r.user_id=u.user_id and u.email=:email and u.password=:password";

            Map<String, Object> parameters = new HashMap<String, Object>();
            parameters.put("email", email_id);
            parameters.put("password", password);

            userList = jdbcTemplate.query(authenticateSQL, parameters, new UserMapper());

            if(userList == null){

            }


        }catch (Exception ex){
            logger.debug(String.valueOf(ex));
        }


        return userList;
    }
}
