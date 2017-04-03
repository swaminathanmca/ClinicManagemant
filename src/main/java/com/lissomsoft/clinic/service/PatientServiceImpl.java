package com.lissomsoft.clinic.service;

import com.lissomsoft.clinic.dao.PatientDao;
import com.lissomsoft.clinic.domain.Blood;
import com.lissomsoft.clinic.domain.Patient;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by Lissomsoft on 3/24/2017.
 */
public class PatientServiceImpl implements PatientService {
    @Autowired(required = true)
    private PatientDao patientDao;

    @Override
    public boolean addPatient(Patient patient,Integer clinic_id) {
        return patientDao.addPatient(patient,clinic_id);
    }

    @Override
    public List<Blood> bloodtypeDetails() {

        return patientDao.bloodtypeDetails();
    }

    @Override
    public List<Patient> validatePatient(String contact_no) {
        return patientDao.validatePatient(contact_no);
    }

    @Override
    public List<Patient> viewPatient(String branch_id) {
        return patientDao.viewPatient(branch_id);
    }

    @Override
    public Patient patientdetails(Integer patient_id) {

        return patientDao.patientdetails(patient_id);
    }
}
