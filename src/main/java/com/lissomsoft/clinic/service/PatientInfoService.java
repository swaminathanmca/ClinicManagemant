package com.lissomsoft.clinic.service;

import com.lissomsoft.clinic.domain.PatientInfo;
import com.lissomsoft.clinic.vo.PatientReport;

import java.util.List;

/**
 * Created by Admin on 4/19/2017.
 */
public interface PatientInfoService {

    boolean addpatientinfo(PatientInfo patientInfo);

    List<PatientInfo> getPatientInfo(Integer  doctor_id,Integer branch_id);

    PatientInfo getPatientInfoId(String patient_pid,String created_at,String type);

    PatientInfo getPatientFollow(String patient_pid,Integer doctor_id,Integer branch_id);

    Boolean editPatientInfo(PatientInfo patientInfo);

    List<PatientReport> getPatientReport(String patient_pid,String from_date,String to_date,Integer doctor_id,Integer branch_id);

    List<PatientReport> getPatientReportByMonths(String patient_pid,String date,Integer doctor_id,Integer branch_id);


    PatientReport getInfoDetails(Integer patient_info_id);

}
