package com.lissomsoft.clinic.service;

import com.lissomsoft.clinic.dao.PatientDao;
import com.lissomsoft.clinic.domain.Blood;
import com.lissomsoft.clinic.domain.InvestServices;
import com.lissomsoft.clinic.domain.Patient;
import com.lissomsoft.clinic.domain.PatientVisit;
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

    @Override
    public boolean editPatient(Patient patient) {
        return patientDao.editPatient(patient);
    }

    @Override
    public boolean patientEntry(PatientVisit visit) {
        return patientDao.patientEntry(visit);
    }

    @Override
    public List<PatientVisit> patientEntryAll(String branch_id) {

        return patientDao.patientEntryAll(branch_id);
    }

    @Override
    public List<PatientVisit> patientEntry(String doctor_id,String branch_id) {
        return patientDao.patientEntry(doctor_id,branch_id);
    }

    @Override
    public List<PatientVisit> getEntryNew(String patient_pid, Integer type,Integer doctor_id) {
        return patientDao.getEntryNew(patient_pid,type,doctor_id);
    }

    @Override
    public List<PatientVisit> getEntryFollowup(String patient_pid, Integer doctor_id, Integer type) {
        return patientDao.getEntryFollowup(patient_pid,doctor_id,type);
    }

    @Override
    public List<PatientVisit> getFollowUp(String patient_pid, Integer type, Integer doctor_id, String date) {
        return patientDao.getFollowUp(patient_pid,type,doctor_id,date);
    }

    @Override
    public List<PatientVisit> getAllEntry(String patient_pid, Integer doctor_id) {
        return patientDao.getAllEntry(patient_pid,doctor_id);
    }
}
