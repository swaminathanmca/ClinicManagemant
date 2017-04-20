package com.lissomsoft.clinic.service;

import com.lissomsoft.clinic.dao.PatientInfoDao;
import com.lissomsoft.clinic.domain.PatientInfo;
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
    public List<PatientInfo> addPatientInfo(String patient_pid) {
        return null;
    }
}
