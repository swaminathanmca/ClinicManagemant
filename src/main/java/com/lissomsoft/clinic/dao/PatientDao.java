package com.lissomsoft.clinic.dao;

import com.lissomsoft.clinic.domain.Blood;
import com.lissomsoft.clinic.domain.Patient;

import java.util.List;

/**
 * Created by Lissomsoft on 3/24/2017.
 */
public interface PatientDao {
    boolean addPatient(Patient patient,Integer clinic_id);
    List<Blood> bloodtypeDetails();
    List<Patient> validatePatient(String contact_no);
    List<Patient> viewPatient(String branch_id);
}
