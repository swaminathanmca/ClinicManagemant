package com.lissomsoft.clinic.service;

import com.lissomsoft.clinic.dao.PatientInfoDao;
import com.lissomsoft.clinic.domain.PatientInfo;
import com.lissomsoft.clinic.vo.PatientReport;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by Admin on 4/19/2017.
 */
public class PatientInfoServiceImpl implements PatientInfoService {

    @Autowired(required = true)
    private PatientInfoDao patientDao;

    @Override
    public boolean addpatientinfo(PatientInfo patientInfo) {
        return patientDao.addpatientinfo(patientInfo);
    }

    @Override
    public List<PatientInfo> getPatientInfo(Integer doctor_id,Integer branch_id){
        return patientDao.getPatientInfo(doctor_id,branch_id);
    }

    @Override
    public PatientInfo getPatientInfoId(String patient_pid,String created_at,String type) {
        return patientDao.getPatientInfoId(patient_pid,created_at,type);
    }

    @Override
    public PatientInfo getPatientFollow(String patient_pid,Integer doctor_id,Integer branch_id){
        return patientDao.getPatientFollow(patient_pid,doctor_id,branch_id);
    }

    @Override
    public Boolean editPatientInfo(PatientInfo patientInfo) {
        return patientDao.editPatientInfo(patientInfo);
    }

    @Override
    public List<PatientReport> getPatientReport(String patient_pid, String from_date, String to_date,Integer doctor_id,Integer branch_id) {
        return patientDao.getPatientReport(patient_pid,from_date,to_date,doctor_id,branch_id);
    }

    @Override
    public List<PatientReport> getPatientReportByMonths(String patient_pid, String date, Integer doctor_id, Integer branch_id) {
        return patientDao.getPatientReportByMonths(patient_pid,date,doctor_id,branch_id);
    }
    @Override
    public PatientReport getInfoDetails(Integer patient_info_id) {
        return patientDao.getInfoDetails(patient_info_id);
    }
}
