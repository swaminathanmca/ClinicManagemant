package com.lissomsoft.clinic.dao;

import com.lissomsoft.clinic.domain.Schedule;
import com.lissomsoft.clinic.rowmapper.ScheduleMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Lissomsoft on 06/23/17.
 */
public class ScheduleDaoImpl implements ScheduleDao {
    private static final Logger logger = LoggerFactory.getLogger(UserDaoImpl.class);
    DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
    @Autowired(required = false)
    private NamedParameterJdbcTemplate jdbcTemplate;
    @Autowired(required = false)
    private PlatformTransactionManager platformTransactionManager;

    @Override
    public Boolean addSchedule(Schedule schedule,StringBuilder sb) {

        int result=0;


        try {

            String insertScheduleSql=" INSERT INTO doctor_schedule(doctor_id,branch_id,start_date,end_date,start_time,end_time,end_type,no_of_occurences,time,scount,day_flag,created_at,updated_at) VALUES(:doctor_id,:branch_id,:start_date,:end_date,:start_time,:end_time,:end_type,:occurences,:time,:scount,:days,:created_at,:created_at)";

            Map<String,Object> parameter=new HashMap<String, Object>();
            parameter.put("doctor_id",schedule.getDoctor_id());
            parameter.put("branch_id",schedule.getBranch_id());
            parameter.put("start_date",schedule.getStart_date());
            parameter.put("end_date",schedule.getEnd_date());
            parameter.put("start_time",schedule.getStart_time());
            parameter.put("end_time",schedule.getEnd_time());
            parameter.put("end_type",schedule.getEnd_type());
            parameter.put("occurences",schedule.getNo_of_occurenes());
            parameter.put("time",schedule.getTime());
            parameter.put("scount",schedule.getScount());
            parameter.put("created_at",format.format(new Date()));
            parameter.put("days",sb);
            result=jdbcTemplate.update(insertScheduleSql,parameter);


        }catch (Exception e){
            e.printStackTrace();
        }
        return result>0 ?true:false;
    }

    @Override
    public List<Schedule> getSchedule(int doctor_id,String start_date) {

        List<Schedule> scheduleList=null;
        try {

            String getScheduleSql="SELECT * FROM clinic.doctor_schedule where doctor_id=:doctor_id";
            Map<String,Object> parameter=new HashMap<String, Object>();
            parameter.put("doctor_id",doctor_id);
            parameter.put("start_date",start_date);
            scheduleList=jdbcTemplate.query(getScheduleSql,parameter,new ScheduleMapper());

        }catch (Exception e){
            e.printStackTrace();
        }


        return scheduleList;
    }
}
