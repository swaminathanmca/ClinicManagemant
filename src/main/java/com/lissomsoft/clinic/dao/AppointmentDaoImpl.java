package com.lissomsoft.clinic.dao;

import com.lissomsoft.clinic.domain.Appointment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.Date;

/**
 * Created by Admin on 6/16/2017.
 */

public class AppointmentDaoImpl implements AppointmentDao {

    DateFormat format = new SimpleDateFormat("yyyy-MM-dd");


    @Autowired(required = false)
    private NamedParameterJdbcTemplate jdbcTemplate;
    @Override
    public boolean addAppointment(Appointment appointment) {

        int result=0;
        try{

            String insertSql="INSERT INTO appointment(name,doctor_id,dov,created_at) values(:name,:doctor_id,:dov,:created_at)";
            Map<String,Object> parameters =new HashMap<String, Object>();
            parameters.put("name",appointment.getName());
            parameters.put("doctor_id",appointment.getDoctor_id());
            parameters.put("dov",appointment.getDov());
            parameters.put("created_at",format.format(new Date()));

            result = jdbcTemplate.update(insertSql,parameters);

        }catch (Exception e){
            e.printStackTrace();
        }

        return result >0 ? true :false;
    }
}
