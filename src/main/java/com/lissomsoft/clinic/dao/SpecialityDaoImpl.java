package com.lissomsoft.clinic.dao;

import com.lissomsoft.clinic.domain.Speciality;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Lissomsoft on 08-Apr-17.
 */
public class SpecialityDaoImpl implements SpecialityDao {

    private static final Logger logger = LoggerFactory.getLogger(UserDaoImpl.class);
    DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
    @Autowired(required = false)
    private NamedParameterJdbcTemplate jdbcTemplate;
    @Override
    public boolean addSpeciality(Speciality speciality) {

        int result=0;
        try {

            String insertSql="INSERT INTO speciality (speciality_name,description,created_at,updated_at) VALUES (:speciality_name,:description,:created_at,:created_at)";
            Map<String, Object> parameters = new HashMap<String, Object>();

            parameters.put("speciality_name",speciality.getSpeciality_name());
            parameters.put("description",speciality.getDescription());
            parameters.put("created_at",format.format(new Date()));
            result=jdbcTemplate.update(insertSql,parameters);


        }catch (Exception e){
            e.printStackTrace();
        }



        return result >0 ? true :false;
    }
}
