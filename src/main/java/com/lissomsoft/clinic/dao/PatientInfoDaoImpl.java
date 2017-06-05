package com.lissomsoft.clinic.dao;

import com.lissomsoft.clinic.domain.Complaint;
import com.lissomsoft.clinic.domain.PatientInfo;
import com.lissomsoft.clinic.rowmapper.*;
import com.lissomsoft.clinic.vo.PatientReport;
import jdk.nashorn.internal.runtime.ECMAException;
import org.omg.DynamicAny._DynAnyFactoryStub;
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
    DateFormat format = new SimpleDateFormat("yyyy-MMM-dd");
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
            String addpatientInfo="insert into patient_info_master(patient_pid,weight,type,bp,referal_details,procedures,diagnosis,observation,investigation,doctor_detail_id,branch_id,created_at,updated_at) values(:patient_pid,:weight,:vtype,:bp,:referal_details,:procedures,:diagnosis,:observation,:investigation,:doctor_id,:branch_id,:created_at,:created_at)";
            Map<String,Object> parameter=new HashMap<String, Object>();
            parameter.put("patient_pid",patientInfo.getPatient_pid());
            parameter.put("weight",patientInfo.getWeight());
            parameter.put("vtype",patientInfo.getHeight());
            parameter.put("bp",patientInfo.getPressure());
            parameter.put("referal_details",patientInfo.getRefereal_details());
            parameter.put("procedures",patientInfo.getProcedures());
            parameter.put("diagnosis",patientInfo.getDiagnosis());
            parameter.put("observation",patientInfo.getObservation());
            parameter.put("investigation",patientInfo.getInvestigation());
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
                    String insertComplaintSql="INSERT INTO patient_complaints(patient_info_id,patient_complaints,created_at,updated_at) VALUES ((SELECT p.patient_info_id FROM patient_info_master p WHERE created_at=:created_at AND patient_pid=:patient_pid AND type=:vtype AND doctor_detail_id=:doctor_id ),:complaint_id,:created_at,:created_at)";
                    Map<String,Object> params=new HashMap<String, Object>();
                    params.put("complaint_id",cp.getComplaint_id());
                    params.put("patient_pid",patientInfo.getPatient_pid());
                    params.put("vtype",patientInfo.getHeight());
                    params.put("doctor_id",patientInfo.getDoctor_id());
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

    @Override
    public PatientInfo getPatientInfoId(String patient_pid,String created_at,String type,Integer doctor_id) {
        PatientInfo patientInfos=new PatientInfo();
        try {
            String getPatientInfo="SELECT patient_info_id,patient_pid FROM clinic.patient_info_master pi WHERE pi.patient_pid=:patient_pid AND created_at=:created_at AND type=:type AND doctor_detail_id=:doctor_id ";
            Map<String,Object> paramInfo=new HashMap<String, Object>();
            paramInfo.put("patient_pid",patient_pid);
            paramInfo.put("doctor_id",doctor_id);
            paramInfo.put("created_at",created_at);
            paramInfo.put("type",type);
            patientInfos= (PatientInfo) jdbcTemplate.queryForObject(getPatientInfo, paramInfo, new PatinetInfoIdMapper());

        }
        catch (Exception e){
            e.printStackTrace();
        }

        return patientInfos;
    }

    @Override
    public PatientInfo getPatientFollow(String patient_pid, Integer doctor_id, Integer branch_id) {

        PatientInfo patientInfo=new PatientInfo();
        List<Complaint>complaints=patientInfo.getComplaint();
        try {
            String getInfoSql="SELECT * FROM clinic.patient_info_master p WHERE p.patient_pid=:patient_pid AND p.created_at=:created_at AND p.doctor_detail_id=:doctor_id AND p.branch_id=:branch_id";
            String getInfocomplaints="SELECT c.patient_complaints complaint_id,cm.complaint_name, cm.complaint_description  FROM clinic.patient_complaints c INNER JOIN complaint_master cm ON cm.complaint_id=c.patient_complaints WHERE patient_info_id=(SELECT p.patient_info_id FROM clinic.patient_info_master p WHERE p.patient_pid=:patient_pid AND p.created_at=:created_at AND p.doctor_detail_id=:doctor_id AND p.branch_id=:branch_id);";
            Map<String,Object> parameter=new HashMap<String, Object>();
            parameter.put("patient_pid",patient_pid);
            parameter.put("doctor_id",doctor_id);
            parameter.put("branch_id",branch_id);
            parameter.put("created_at",format.format(new Date()));
            complaints=jdbcTemplate.query(getInfocomplaints,parameter,new ComplaintMapper());
            patientInfo= (PatientInfo) jdbcTemplate.queryForObject(getInfoSql,parameter,new PatientInfoFollowMapper());
            patientInfo.setComplaint(complaints);
        }catch (Exception e)
        {
            e.printStackTrace();
        }


        return patientInfo;
    }

    @Override
    public Boolean editPatientInfo(PatientInfo patientInfo) {

        int result=0;
        int result_complaint=0;
        int delete_result=0;
        DefaultTransactionDefinition paramTransactionDefinition = new DefaultTransactionDefinition();
        TransactionStatus status = platformTransactionManager.getTransaction(paramTransactionDefinition);

        try {

            String editPatientSql="UPDATE patient_info_master SET procedures=:procedures,diagnosis=:diagonics,investigation=:investigation,observation=:observation,updated_at=:created_at WHERE patient_info_id=:patient_info_id";
            Map<String,Object> parameter=new HashMap<String, Object>();
            parameter.put("patient_info_id",patientInfo.getPatient_info_id());
            parameter.put("diagonics",patientInfo.getDiagnosis());
            parameter.put("procedures",patientInfo.getProcedures());
            parameter.put("investigation",patientInfo.getInvestigation());
            parameter.put("observation",patientInfo.getObservation());
            parameter.put("bp",patientInfo.getPressure());
            parameter.put("created_at",format.format(new Date()));
            result=jdbcTemplate.update(editPatientSql,parameter);

        }catch (Exception e){
            e.printStackTrace();
            platformTransactionManager.rollback(status);
        }
        if((result>0)?true :false){

            try {
                String deleteComplaintSql="DELETE  FROM patient_complaints WHERE patient_info_id=:patient_info_id";
                Map<String,Object> delParams=new HashMap<String, Object>();
                delParams.put("patient_info_id",patientInfo.getPatient_info_id());

                delete_result=jdbcTemplate.update(deleteComplaintSql,delParams);

            }catch (Exception e){
                    e.printStackTrace();
                platformTransactionManager.rollback(status);
            }
        }if((delete_result>0)?true:false){
            try {
                List<Complaint> complaints=null;
                complaints=patientInfo.getComplaint();
                Iterator<Complaint> it=complaints.iterator();
                while (it.hasNext()){
                    Complaint cp=it.next();
                    String insertComplaintSql="INSERT INTO patient_complaints (patient_info_id,patient_complaints,created_at,updated_at) VALUES (:patient_info_id,:complaint_id,:created_at,:created_at)";
                    Map<String,Object> insComplaintSql=new HashMap<String, Object>();
                    insComplaintSql.put("patient_info_id",patientInfo.getPatient_info_id());
                    insComplaintSql.put("complaint_id",cp.getComplaint_id());
                    insComplaintSql.put("created_at",format.format(new Date()));
                    result_complaint=jdbcTemplate.update(insertComplaintSql,insComplaintSql);

                }
                platformTransactionManager.commit(status);


            }catch (Exception e){
                e.printStackTrace();
                platformTransactionManager.rollback(status);
            }
        }


        return result_complaint>0?true:false;
    }

    @Override
    public List<PatientReport> getPatientReport(String patient_pid, String from_date, String to_date,Integer doctor_id,Integer branch_id) {
        List<PatientReport> patientReports=null;

        try {

            String GetReportSql="Select m.first_name,m.last_name,i.created_at,i.referal_details,i.patient_pid,i.patient_info_id from clinic.patient_master m inner join clinic.patient_info_master i on m.patient_pid=i.patient_pid and i.doctor_detail_id=:doctor_id and i.branch_id=:branch_id and i.patient_pid=:patient_pid and i.created_at between :from_date and :to_date";
            Map<String,Object> parameter=new HashMap<String, Object>();
            parameter.put("patient_pid",patient_pid);
            parameter.put("from_date",from_date);
            parameter.put("to_date",to_date);
            parameter.put("doctor_id",doctor_id);
            parameter.put("branch_id",branch_id);
            patientReports=jdbcTemplate.query(GetReportSql,parameter,new PatientReportMapper());

        }catch (Exception e){
            e.printStackTrace();

        }


        return patientReports;
    }

    @Override
    public List<PatientReport> getPatientReportByMonths(String patient_pid, String date, Integer doctor_id, Integer branch_id) {
        List<PatientReport> patientReports=null;

        try {

            String GetReportSql="Select m.first_name,m.last_name,i.created_at,i.referal_details,i.patient_pid,i.patient_info_id from clinic.patient_master m inner join clinic.patient_info_master i on m.patient_pid=i.patient_pid and i.doctor_detail_id=:doctor_id and i.branch_id=:branch_id and i.patient_pid=:patient_pid and i.created_at >= :date ";
            Map<String,Object> parameter=new HashMap<String, Object>();
            parameter.put("patient_pid",patient_pid);
            parameter.put("date",date);
            parameter.put("doctor_id",doctor_id);
            parameter.put("branch_id",branch_id);
            patientReports=jdbcTemplate.query(GetReportSql,parameter,new PatientReportMapper());

        }catch (Exception e){
            e.printStackTrace();

        }



        return patientReports;
    }

    @Override
    public PatientReport getInfoDetails(Integer patient_info_id) {
       PatientReport patientReport=new PatientReport();
        List<Complaint> complaints=patientReport.getComplaints();

        try {
            String InfoDetailsSql="SELECT i.patient_pid,i.procedures,i.diagnosis,i.observation,i.investigation,i.bp,i.type,i.bp,p.first_name,p.last_name,i.created_at FROM clinic.patient_info_master i INNER JOIN patient_master p ON p.patient_pid=i.patient_pid AND i.patient_info_id=:patient_info_id";
            String InfoComplaintSql="SELECT c.complaint_name,c.complaint_id,c.complaint_description FROM clinic.patient_complaints p INNER JOIN complaint_master c ON p.patient_complaints=c.complaint_id AND p.patient_info_id=:patient_info_id";
            Map<String,Object> params=new HashMap<String, Object>();
            params.put("patient_info_id",patient_info_id);

            patientReport= (PatientReport) jdbcTemplate.queryForObject(InfoDetailsSql,params,new InfoDetailsMapper());
            complaints=jdbcTemplate.query(InfoComplaintSql,params,new ComplaintMapper());
            patientReport.setComplaints(complaints);
        }catch (Exception e){
            e.printStackTrace();
        }
        return patientReport;
    }

}
