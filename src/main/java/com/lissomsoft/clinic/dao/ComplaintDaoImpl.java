package com.lissomsoft.clinic.dao;

import com.lissomsoft.clinic.domain.Complaint;
import com.lissomsoft.clinic.rowmapper.ComplaintMapper;
import com.lissomsoft.clinic.rowmapper.PatientComplainMapper;
import com.lissomsoft.clinic.vo.PatientComplaint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;



import java.util.Date;
import java.util.HashMap;
import java.util.List;
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

    @Override
    public List<Complaint> ViewComplaint() {
        List<Complaint>getcomplaintAll=null;
        try {
            String GetComplaintSql="select*from complaint_master ";
            getcomplaintAll=jdbcTemplate.query(GetComplaintSql,new ComplaintMapper());

        }catch (Exception e){
            e.printStackTrace();
        }
        return getcomplaintAll;
    }

    @Override
    public Complaint ComplaintDetail(Integer complaint_id) {
        Complaint complaint=new Complaint();
        try {
            String complaintsql="select * from complaint_master where complaint_id=:complaint_id";
            Map<String,Object>params=new HashMap<String, Object>();
            params.put("complaint_id",complaint_id);
            complaint=(Complaint)jdbcTemplate.queryForObject(complaintsql,params,new ComplaintMapper());



        }catch (Exception e){
            e.printStackTrace();
        }
        return complaint;
    }

    @Override
    public boolean editcomplaint(Complaint complaint, Integer complaint_id) {
        int result=0;
        try {
            String editcomplaintSql="update complaint_master set complaint_name=:complaint_name , complaint_description=:complaint_description WHERE complaint_id=:complaint_id";
            Map<String,Object>para=new HashMap<String, Object>();
            para.put("complaint_id",complaint_id);
            para.put("complaint_name",complaint.getComplaint_name());
            para.put("complaint_description",complaint.getComplaint_description());
            result=jdbcTemplate.update(editcomplaintSql,para);

        }catch (Exception e){
            e.printStackTrace();
        }
        return result>0 ? true:false;
    }

    @Override
    public PatientComplaint patientcomplaint(String patient_pid) {
        PatientComplaint patientcomplaint=new PatientComplaint();
        try{

            String patientcomplaintSql="select pm.patient_pid,pm.patient_id,pm.first_name,pm.last_name,pv.weight,pv.height,pv.pressure,pv.refereal_details from patient_master pm,patient_visit pv where pm.patient_id=pv.patient_id and pm.patient_pid=:patient_pid";
            Map<String,Object> pcomplaint=new HashMap<String, Object>();
            pcomplaint.put("patient_pid",patient_pid);
            pcomplaint.put("patient_id",patientcomplaint.getPatient_id());
            pcomplaint.put("first_name",patientcomplaint.getFirst_name());
            pcomplaint.put("last_name",patientcomplaint.getLast_name());
            pcomplaint.put("weight",patientcomplaint.getWeight());
            pcomplaint.put("height",patientcomplaint.getHeight());
            pcomplaint.put("pressure",patientcomplaint.getPressure());
            pcomplaint.put("complaint_name",patientcomplaint.getComplaint_name());

            patientcomplaint=(PatientComplaint)jdbcTemplate.queryForObject(patientcomplaintSql,pcomplaint,new PatientComplainMapper());

        }catch(Exception e){
            e.printStackTrace();
        }
        return patientcomplaint;
    }
}
