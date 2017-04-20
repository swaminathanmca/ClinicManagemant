package com.lissomsoft.clinic.dao;

import com.lissomsoft.clinic.domain.PatientInfo;

import java.util.List;

/**
 * Created by Admin on 4/19/2017.
 */
public interface PatientInfoDao {

    boolean addpatientinfo (PatientInfo patientInfo);

    List<PatientInfo> getPatientInfo(Integer doctor_id,Integer branch_id);

    PatientInfo patientInfo(Integer patient_info_id);

}
