package com.lissomsoft.clinic.dao;

import com.lissomsoft.clinic.domain.NewAppointment;
import com.lissomsoft.clinic.rowmapper.AppointmentMapper;
import com.lissomsoft.clinic.rowmapper.NewAppoinmentProfile;
import com.lissomsoft.clinic.rowmapper.NewAppointmentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Admin on 6/27/2017.
 */
public class NewAppointmentDaoImpl implements NewAppointmentDao {

    DateFormat format = new SimpleDateFormat("yyyy-MM-dd");

    @Autowired(required = false)
    private NamedParameterJdbcTemplate jdbcTemplate;

    @Override
    public boolean addnewappointment(NewAppointment newappointment,String uId) {

        int result=0;

        try{

            newappointment.setNew_appointment_pid(uId);

            String insertsql="INSERT INTO new_appointment(new_appointment_pid,branch_id,first_name,last_name,doctor_id,dob,mobile_no,res_no,email,address1,address2,city,state,country,pin_code,created_at) values(:new_appointment_pid,:branch_id,:first_name,:last_name,:doctor_id,:dob,:mobile_no,:res_no,:email,:address1,:address2,:city,:state,:country,:pin_code,:created_at)";
            Map<String,Object> parameters=new HashMap<String, Object>();
            parameters.put("new_appointment_pid",newappointment.getNew_appointment_pid());
            parameters.put("branch_id",newappointment.getBranch_id());
            parameters.put("first_name",newappointment.getFirst_name());
            parameters.put("last_name",newappointment.getLast_name());
            parameters.put("doctor_id",newappointment.getDoctor_id());
            parameters.put("dob",newappointment.getDob());
            parameters.put("mobile_no",newappointment.getMobile_no());
            parameters.put("res_no",newappointment.getRes_no());
            parameters.put("email",newappointment.getEmail());
            parameters.put("address1",newappointment.getAddress1());
            parameters.put("address2",newappointment.getAddress2());
            parameters.put("city",newappointment.getCity());
            parameters.put("state",newappointment.getState());
            parameters.put("country",newappointment.getCountry());
            parameters.put("pin_code",newappointment.getPin_code());
            parameters.put("created_at",format.format(new Date()));

            result=jdbcTemplate.update(insertsql,parameters);

        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return  result >0 ? true :false;
    }

    @Override

    public NewAppointment addnewapp() {

        NewAppointment addnewappinfo=null;

        try{
            String preuId="select new_appointment_pid from new_appointment order by new_appointment_id desc limit 1";
            Map<String,Object> para = new HashMap<String, Object>();
            addnewappinfo= (NewAppointment) jdbcTemplate.queryForObject(preuId, para, new NewAppointmentMapper());

        }catch(EmptyResultDataAccessException e){
           return  null;
        }catch (Exception e){
            e.printStackTrace();
        }

        return addnewappinfo;
    }

    @Override
    public List<NewAppointment> appoinmentInfo(Integer branch_id, String dob, String contact_no) {


        List<NewAppointment> newAppointments=null;
        try {
            String appInoSql="SELECT first_name,last_name,address1,address2,new_appointment_pid ,new_appointment_id,mobile_no FROM new_appointment where branch_id=:branch_id AND dob=:dob OR mobile_no=:contact_no";
            Map<String,Object> para = new HashMap<String, Object>();
            para.put("branch_id",branch_id);
            para.put("dob",dob);
            para.put("contact_no",contact_no);
            newAppointments= jdbcTemplate.query(appInoSql,para,new NewAppoinmentProfile());


        }catch (Exception e){
            e.printStackTrace();
        }

        return newAppointments;
    }

    @Override
    public NewAppointment patientdetailsById(String patient_pid) {

        NewAppointment newAppointment=new NewAppointment();
        try {
            String appInoSql="SELECT first_name,last_name,address1,address2,new_appointment_pid ,new_appointment_id,mobile_no FROM new_appointment where new_appointment_pid=:patient_pid";
            Map<String,Object> params= new HashMap<String, Object>();
            params.put("patient_pid",patient_pid);
            newAppointment= (NewAppointment) jdbcTemplate.queryForObject(appInoSql,params,new NewAppoinmentProfile());

        }catch (EmptyResultDataAccessException e){
            return null;
        }catch (Exception e){
            e.printStackTrace();
        }

        return newAppointment;
    }
}
