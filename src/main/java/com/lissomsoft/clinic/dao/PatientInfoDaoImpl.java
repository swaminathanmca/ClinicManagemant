package com.lissomsoft.clinic.dao;

import com.lissomsoft.clinic.domain.Complaint;
import com.lissomsoft.clinic.domain.PatientInfo;
import com.lissomsoft.clinic.rowmapper.ComplaintMapper;
import com.lissomsoft.clinic.rowmapper.PatientInfoMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by Admin on 4/19/2017.
 */
public class PatientInfoDaoImpl implements PatientInfoDao {

    private static final Logger logger = LoggerFactory.getLogger(UserDaoImpl.class);
    DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
    @Autowired(required = false)
    private NamedParameterJdbcTemplate jdbcTemplate;
    @Autowired(required = false)
    private PlatformTransactionManager platformTransactionManager;


    @Override
    public boolean addpatientinfo(PatientInfo patientInfo) {
        int result=0;
        int result_complaint=0;
        DefaultTransactionDefinition paramTransactionDefinition = new DefaultTransactionDefinition();
        TransactionStatus status = platformTransactionManager.getTransaction(paramTransactionDefinition);

        try{
            String addpatientInfo="insert into patient_info_master(patient_pid,weight,type,bp,referal_details,procedures,diagnosis,doctor_detail_id,branch_id,created_at,updated_at) values(:patient_pid,:weight,:vtype,:bp,:referal_details,:procedures,:diagnosis,:doctor_id,:branch_id,:created_at,:created_at)";
            Map<String,Object> parameter=new HashMap<String, Object>();
            parameter.put("patient_pid",patientInfo.getPatient_pid());
            parameter.put("weight",patientInfo.getWeight());
            parameter.put("vtype",patientInfo.getHeight());
            parameter.put("bp",patientInfo.getPressure());
            parameter.put("referal_details",patientInfo.getRefereal_details());
            parameter.put("procedures",patientInfo.getProcedures());
            parameter.put("diagnosis",patientInfo.getDiagnosis());
            parameter.put("doctor_id",patientInfo.getDoctor_id());
            parameter.put("branch_id",patientInfo.getBranch_id());
            parameter.put("created_at",format.format(new Date()));

            result=jdbcTemplate.update(addpatientInfo,parameter);

        }catch(Exception e){
            e.printStackTrace();
            platformTransactionManager.rollback(status);
        }

        if((result>0)? true :false){

            try {
                List<Complaint> complaints;
                complaints=patientInfo.getComplaint();
                Iterator<Complaint>it=complaints.iterator();
                while (it.hasNext()){
                    Complaint cp=it.next();
                    String insertComplaintSql="INSERT INTO patient_complaints(patient_info_id,patient_complaints,created_at,updated_at) VALUES ((SELECT p.patient_info_id FROM patient_info_master p WHERE created_at=:created_at),:complaint_id,:created_at,:created_at)";
                    Map<String,Object> params=new HashMap<String, Object>();
                    params.put("complaint_id",cp.getComplaint_id());
                    params.put("created_at",format.format(new Date()));
                    result_complaint=jdbcTemplate.update(insertComplaintSql,params);

                }

                 platformTransactionManager.commit(status);
            }catch (Exception e){
                e.printStackTrace();
                platformTransactionManager.rollback(status);
            }
        }



        return result > 0 ? true:false;
    }

    @Override
    public List<PatientInfo> getPatientInfo(Integer doctor_id,Integer branch_id){

        List<PatientInfo> patientInfoList=null;
        String patientInfos="SELECT p.patient_pid,p.created_at,p.referal_details,pm.first_name,pm.last_name FROM patient_info_master p INNER JOIN patient_master pm ON p.patient_pid=pm.patient_pid AND p.doctor_detail_id=:doctor_id AND p.branch_id=:branch_id";
        Map<String,Object> params=new HashMap<String, Object>();
        params.put("doctor_id",doctor_id);
        params.put("branch_id",branch_id);

        patientInfoList=jdbcTemplate.query(patientInfos,params,new PatientInfoMapper());

        return patientInfoList;
    }


    @Override
    public PatientInfo patientInfo(Integer patient_info_id) {
        return null;
    }


}
