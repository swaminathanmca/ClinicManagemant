package com.lissomsoft.clinic.dao;

import com.lissomsoft.clinic.domain.Appointment;
import com.lissomsoft.clinic.domain.NewAppointment;
import com.lissomsoft.clinic.domain.Patient;
import com.lissomsoft.clinic.rowmapper.AppoinmentDetMapper;
import com.lissomsoft.clinic.rowmapper.AppointmentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
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

            String insertSql="INSERT INTO appointment(patient_pid,name,branch_id,doctor_id,schedule_time,dov,phone_no,created_at,updated_at) values(:patient_pid,:name,:branch_id,:doctor_id,:time,:dov,:contact_no,:created_at,:created_at)";
            Map<String,Object> parameters =new HashMap<String, Object>();
            parameters.put("patient_pid",appointment.getPatient_pid());
            parameters.put("name",appointment.getName());
            parameters.put("branch_id",appointment.getBranch_id());
            parameters.put("doctor_id",appointment.getDoctor_id());
            parameters.put("dov",appointment.getDov());
            parameters.put("time",appointment.getTime());
            parameters.put("contact_no",appointment.getContact_no());
            parameters.put("created_at",format.format(new Date()));

            result = jdbcTemplate.update(insertSql,parameters);

        }catch (Exception e){
            e.printStackTrace();
        }

        return result >0 ? true :false;
    }

    @Override
    public List<Patient> appInfo(Integer branch_id,String dob, String contact_no) {

        List<Patient> patientappinfo=null;

        try{
            String patientInfo="SELECT first_name,last_name,address1,address2,patient_pid,patient_id,mobile_no FROM patient_master where branch_id=:branch_id AND dob=:dob OR mobile_no=:contact_no ";
            Map<String,Object> para = new HashMap<String, Object>();
            para.put("branch_id",branch_id);
            para.put("dob",dob);
            para.put("contact_no",contact_no);
            patientappinfo= jdbcTemplate.query(patientInfo,para,new AppointmentMapper());

        }catch(Exception e){
            e.printStackTrace();
        }

        return patientappinfo;
    }

    @Override
    public List<NewAppointment> newappInfo(Integer branch_id, String dob, String mobile_no) {


        List<NewAppointment> newpatientappinfo=null;

        try{

            String newpatient="SELECT first_name,last_name,address1,address2,new_appointment_id,new_appointment_pid from new_appointment where  branch_id=:branch_id AND dob=:dob OR mobile_no=:mobile_no";
                Map<String,Object> para = new HashMap<String, Object>();
            para.put("branch_id",branch_id);
            para.put("dob",dob);
            para.put("mobile_no",mobile_no);
            newpatientappinfo=jdbcTemplate.query(newpatient,para,new AppointmentMapper());

        }catch(Exception e){
            e.printStackTrace();
        }

        return newpatientappinfo;
    }

    @Override
    public List<Appointment> appoinmentDetails(Integer doctor_id, Integer branch_id,String date) {

        List<Appointment> appointments=null;
        try {

                String appoinmentInfo=" SELECT * FROM appointment WHERE doctor_id=:doctor_id AND branch_id=:branch_id AND dov=:date";
                    Map<String,Object> parameter=new HashMap<String, Object>();
                    parameter.put("doctor_id",doctor_id);
                    parameter.put("branch_id",branch_id);
                    parameter.put("date",date);
                    appointments=jdbcTemplate.query(appoinmentInfo,parameter,new AppoinmentDetMapper());




        }catch (Exception e){
            e.printStackTrace();
        }



        return appointments;
    }

}
