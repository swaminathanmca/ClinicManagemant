package com.lissomsoft.clinic.dao;

import com.lissomsoft.clinic.domain.Appointment;
import com.lissomsoft.clinic.domain.NewAppointment;
import com.lissomsoft.clinic.domain.Patient;
import com.lissomsoft.clinic.rowmapper.AppoinmentDetMapper;
import com.lissomsoft.clinic.rowmapper.AppointmentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by Admin on 6/16/2017.
 */

public class AppointmentDaoImpl implements AppointmentDao {

    DateFormat format = new SimpleDateFormat("yyyy/MM/dd");
    DateFormat dateFormat=new SimpleDateFormat("MM/dd/YYYY");

    @Autowired(required = false)
    private NamedParameterJdbcTemplate jdbcTemplate;
    @Autowired(required = false)
    private PlatformTransactionManager platformTransactionManager;
    @Override
    public boolean addAppointment(Appointment appointment) {

        int result=0;
        try{

            String insertSql="INSERT INTO appointment(patient_pid,name,branch_id,doctor_id,schedule_time,type,dov,phone_no,status,created_at,updated_at) values(:patient_pid,:name,:branch_id,:doctor_id,:time,:type,:dov,:contact_no,0,:created_at,:created_at)";
            Map<String,Object> parameters =new HashMap<String, Object>();
            parameters.put("patient_pid",appointment.getPatient_pid());
            parameters.put("name",appointment.getName());
            parameters.put("branch_id",appointment.getBranch_id());
            parameters.put("doctor_id",appointment.getDoctor_id());
            parameters.put("dov",appointment.getDov());
            parameters.put("time",appointment.getTime());
            parameters.put("contact_no",appointment.getContact_no());
            parameters.put("created_at",format.format(new Date()));
            parameters.put("type",appointment.getType());
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
            String patientInfo="SELECT first_name,last_name,address1,address2,patient_pid,patient_id,mobile_no FROM patient_master where branch_id=:branch_id  AND contact_no=:contact_no ";
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

            String newpatient="SELECT first_name,last_name,address1,address2,new_appointment_id,new_appointment_pid from new_appointment where  branch_id=:branch_id  AND mobile_no=:mobile_no";
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

    @Override
    public List<Appointment> viewAppoinment(Integer branch_id, String date) {

            List<Appointment> appointments=null;
        try {
            String appoinmentInfo="SELECT a.schedule_time,a.appointment_id,a.doctor_id,a.name,a.phone_no,a.type,a.dov,p.name created_at,a.doctor_id,a.branch_id,a.patient_pid,a.status FROM appointment a  INNER JOIN doctor_detail d ON a.doctor_id=d.doctor_detail_id INNER JOIN member_master m ON m.user_id=d.user_id INNER JOIN profile_master p ON m.profile_id=p.profile_id AND a.branch_id=:branch_id AND a.dov=:date";
            Map<String,Object> parameter=new HashMap<String, Object>();
            parameter.put("branch_id",branch_id);
            parameter.put("date",date);
            appointments=jdbcTemplate.query(appoinmentInfo,parameter,new AppoinmentDetMapper());


        }catch (Exception e){
            e.printStackTrace();
        }


        return appointments;
    }

    @Override
    public Boolean updateAppoinment(Integer status,Integer appoinment_id) {

        int result=0;
        try {

            String update="UPDATE appointment SET status=:status WHERE appointment_id=:appoinment_id";
            Map<String,Object> parameter=new HashMap<String, Object>();
            parameter.put("status",status);
            parameter.put("appoinment_id",appoinment_id);
            result=jdbcTemplate.update(update,parameter);
        }catch (Exception e){
            e.printStackTrace();
        }

        return result>0 ?true:false;
    }

    @Override
    public List<Appointment> getAppoinment() {
        List<Appointment> appointments=null;
        try {

            String getAppoinment="SELECT * FROM appointment WHERE dov=:date";
            Map<String,Object> parameter=new HashMap<String, Object>();
            parameter.put("date",new SimpleDateFormat("MM/dd/YYYY").format(new Date()));
            appointments=jdbcTemplate.query(getAppoinment,parameter,new AppoinmentDetMapper());

        }catch (Exception e){
            e.printStackTrace();

        }




        return appointments;
    }

    @Override
    public boolean setStatus(HashSet appoimentId) {

        int result=0;
        DefaultTransactionDefinition paramTransactionDefinition = new DefaultTransactionDefinition();
        TransactionStatus status = platformTransactionManager.getTransaction(paramTransactionDefinition);
        try {
           Iterator itr=appoimentId.iterator();
            while (itr.hasNext()){
                Integer id= (Integer) itr.next();
                String changeStatus="UPDATE appointment SET status=1 WHERE appointment_id=:appoinment_id";
                Map<String,Object> params=new HashMap<String, Object>();
                params.put("appoinment_id",id);
                result=jdbcTemplate.update(changeStatus,params);
            }

            platformTransactionManager.commit(status);



        }catch (Exception e){
            e.printStackTrace();
            platformTransactionManager.rollback(status);
        }



        return result>0?true:false;
    }

    @Override
    public List<Appointment> viewAppoinmentDoctor(Integer branch_id, String date, String doctor_id) {
        List<Appointment> appointments=null;

        try {

            String appoinmentInfo="SELECT a.schedule_time,a.appointment_id,a.doctor_id,a.type,a.name,a.phone_no,a.dov,p.name created_at,a.doctor_id,a.branch_id,a.patient_pid,a.status FROM appointment a  INNER JOIN doctor_detail d ON a.doctor_id=d.doctor_detail_id INNER JOIN member_master m ON m.user_id=d.user_id INNER JOIN profile_master p ON m.profile_id=p.profile_id AND a.branch_id=:branch_id AND a.dov=:date AND a.doctor_id=:doctor_id";
            Map<String,Object> parameter=new HashMap<String, Object>();
            parameter.put("branch_id",branch_id);
            parameter.put("date",date);
            parameter.put("doctor_id",doctor_id);
            appointments=jdbcTemplate.query(appoinmentInfo,parameter,new AppoinmentDetMapper());

        }catch (Exception e){
            e.printStackTrace();
        }

        return appointments;
    }

    public Appointment getAppoinmentDetails(Integer appoinment_id){
        Appointment appoinment = null;
        try {

            String getSqlById="SELECT a.schedule_time,a.appointment_id,a.type,a.name,a.phone_no,a.dov,p.name created_at,a.doctor_id,a.branch_id,a.patient_pid,a.status FROM appointment a  INNER JOIN doctor_detail d ON a.doctor_id=d.doctor_detail_id INNER JOIN member_master m ON m.user_id=d.user_id INNER JOIN profile_master p ON m.profile_id=p.profile_id AND appointment_id=:appoinment_id";
            Map<String,Object> parameter=new HashMap<String, Object>();
            parameter.put("appoinment_id",appoinment_id);
            appoinment= (Appointment) jdbcTemplate.queryForObject(getSqlById,parameter,new AppoinmentDetMapper());


        }catch (Exception e){
            e.printStackTrace();
        }



        return appoinment;
    }

}
