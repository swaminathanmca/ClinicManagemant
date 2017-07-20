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
    public List<Schedule> getSchedule(String doctor_id,String start_date,Integer branch_id) {

        List<Schedule> scheduleList=null;
        try {

            String getScheduleSql="SELECT * FROM doctor_schedule where doctor_id=:doctor_id AND branch_id=:branch_id";
            Map<String,Object> parameter=new HashMap<String, Object>();
            parameter.put("doctor_id",doctor_id);
            parameter.put("start_date",start_date);
            parameter.put("branch_id",branch_id);
            scheduleList=jdbcTemplate.query(getScheduleSql,parameter,new ScheduleMapper());

        }catch (Exception e){
            e.printStackTrace();
        }


        return scheduleList;
    }

    @Override
    public List<Schedule> getScheduleTime(Integer doctor_id, Integer branch_id) {

        List<Schedule> scheduleList=null;

        try{
            String getTimeSql = "SELECT * FROM doctor_schedule where doctor_id=:doctor_id and branch_id=:branch_id";
            Map<String,Object> parameters=new HashMap<String, Object>();
            parameters.put("doctor_id",doctor_id);
            parameters.put("branch_id",branch_id);
            scheduleList=jdbcTemplate.query(getTimeSql,parameters,new ScheduleMapper());


        }catch (Exception e){
            e.printStackTrace();
        }


        return scheduleList;
    }

    @Override
    public List<Schedule> getScheduleDoctor(Integer doctor_id, String start_date) {
        List<Schedule> scheduleList=null;
        try {

            String getScheduleSql="SELECT * FROM doctor_schedule where doctor_id=:doctor_id ";
            Map<String,Object> parameter=new HashMap<String, Object>();
            parameter.put("doctor_id",doctor_id);
            parameter.put("start_date",start_date);

            scheduleList=jdbcTemplate.query(getScheduleSql,parameter,new ScheduleMapper());

        }catch (Exception e){
            e.printStackTrace();
        }

        return scheduleList;
    }

    @Override
    public Schedule getSchedulById(Integer schedule_id) {
        Schedule schedule=null;
        try {

            String scheduleSql="SELECT * FROM doctor_schedule where schedule_id=:schedule_id";
            Map<String,Object> paramter=new HashMap<String, Object>();
            paramter.put("schedule_id",schedule_id);
            schedule= (Schedule) jdbcTemplate.queryForObject(scheduleSql,paramter,new ScheduleMapper());
        }catch (Exception e){
            e.printStackTrace();
        }

        return schedule;
    }

    @Override
    public List<Schedule> getScheduleDoctorId(Integer doctor_id, String start_date, Integer schedule_id) {
        List<Schedule> scheduleList=null;
        try {
            String scheduleSql="SELECT * FROM doctor_schedule where doctor_id=:doctor_id AND schedule_id <> :schedule_id";
            Map<String,Object> paramter=new HashMap<String, Object>();
            paramter.put("schedule_id",schedule_id);
            paramter.put("doctor_id",doctor_id);
            scheduleList= jdbcTemplate.query(scheduleSql,paramter,new ScheduleMapper());


        }catch (Exception e){
            e.printStackTrace();
        }


        return scheduleList;
    }

    @Override
    public Boolean editSchedule(Schedule schedule, StringBuilder sb) {
        int result=0;
        try {

            String editScheduleSql="UPDATE doctor_schedule SET doctor_id=:doctor_id,branch_id=:branch_id,start_date=:start_date,end_date=:end_date,start_time=:start_time,end_time=:end_time,end_type=:end_type,no_of_occurences=:occurences,time=:time,scount=:scount,day_flag=:days,updated_at=:created_at WHERE schedule_id=:schedule_id ";

            Map<String,Object> parameter=new HashMap<String, Object>();
            parameter.put("schedule_id",schedule.getSchedule_id());
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

            result=jdbcTemplate.update(editScheduleSql,parameter);

        }catch (Exception e){
            e.printStackTrace();
        }


        return result>0 ?true:false;
    }
}
