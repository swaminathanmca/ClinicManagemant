package com.lissomsoft.clinic.service;

import com.lissomsoft.clinic.domain.Blood;
import com.lissomsoft.clinic.domain.Patient;
import com.lissomsoft.clinic.domain.PatientVisit;

import java.util.List;

/**
 * Created by Lissomsoft on 3/24/2017.
 */
public interface PatientService {

    boolean addPatient(Patient patient,Integer clinic_id);

    List<Blood> bloodtypeDetails();
    List<Patient> validatePatient(String contact_no);
    List<Patient> viewPatient(String branch_id);
    Patient patientdetails(Integer patient_id);
    boolean editPatient(Patient patient);
    boolean patientEntry(PatientVisit visit);
    List<PatientVisit> patientEntryAll(String branch_id);
    List<PatientVisit> patientEntry(String doctor_id,String branch_id);
    List<PatientVisit> getEntryNew(String patient_pid,Integer type,Integer doctor_id);
}
