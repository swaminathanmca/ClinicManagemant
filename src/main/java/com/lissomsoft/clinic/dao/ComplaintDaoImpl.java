package com.lissomsoft.clinic.dao;

import com.lissomsoft.clinic.domain.Complaint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

/**
 * Created by Admin on 4/17/2017.
 */
public class ComplaintDaoImpl implements ComplaintDao {


    private static final Logger logger = LoggerFactory.getLogger(UserDaoImpl.class);
    DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
    @Autowired(required = false)
    private NamedParameterJdbcTemplate jdbcTemplate;

    @Override
    public boolean addcomplaint(Complaint complaint) {

        int result=0;

        try {


            String insertComplaintSql="insert into complaint_master (complaint_name,complaint_description,created_at,updated_at) values(:complaint_name,:description,:created_at,:created_at)";
            Map<String,Object> parameter=new HashMap<String, Object>();
            parameter.put("complaint_name",complaint.getComplaint_name());
            parameter.put("description",complaint.getComplaint_description());
            parameter.put("created_at",format.format(new Date()));
           result=jdbcTemplate.update(insertComplaintSql, parameter);


        }catch (Exception e){
            e.printStackTrace();

        }


        return result > 0 ? true : false;
    }
}
