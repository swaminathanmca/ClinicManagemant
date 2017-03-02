package com.lissomsoft.clinic.dao;

import com.lissomsoft.clinic.domain.Profile;
import com.lissomsoft.clinic.rowmapper.ProfileMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Admin on 3/1/2017.
 */
public class ProfileDaoImpl implements ProfileDao {
    private static final Logger logger = LoggerFactory.getLogger(UserDaoImpl.class);
    DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
    @Autowired(required = false)
    private NamedParameterJdbcTemplate jdbcTemplate;



    @Override
    public List<Profile> validateno(String contact_no) {

        List<Profile> profileDetails=null;
        try {
            String validatenumber="SELECT * FROM profile_master WHERE phone=:contact_no";

            Map<String, Object> parameters = new HashMap<String, Object>();
            parameters.put("contact_no", contact_no);
            profileDetails= jdbcTemplate.query(validatenumber,parameters,new ProfileMapper());
        }catch (Exception e){
            e.printStackTrace();
        }

        return profileDetails;
    }

    @Override
    public List<Profile> validateEmail(String email) {
        List<Profile> profileEmail=null;
        try {

            String validateemail="SELECT * FROM profile_master WHERE email=:email";
            Map<String, Object> parameters1 = new HashMap<String, Object>();
            parameters1.put("email", email);
            profileEmail=jdbcTemplate.query(validateemail,parameters1,new ProfileMapper());
            System.out.println(profileEmail);
        }catch (Exception e){
            e.printStackTrace();
        }

        return profileEmail;
    }
}
