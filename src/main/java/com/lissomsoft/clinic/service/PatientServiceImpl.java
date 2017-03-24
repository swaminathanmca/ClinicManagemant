package com.lissomsoft.clinic.service;

import com.lissomsoft.clinic.dao.PatientDao;
import com.lissomsoft.clinic.domain.Patient;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Lissomsoft on 3/24/2017.
 */
public class PatientServiceImpl implements PatientService {
    @Autowired(required = true)
    private PatientDao patientDao;

    @Override
    public boolean addPatient(Patient patient,String email) {
        return patientDao.addPatient(patient,email);
    }
}
