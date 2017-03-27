package com.lissomsoft.clinic.service;

import com.lissomsoft.clinic.domain.Blood;
import com.lissomsoft.clinic.domain.Patient;

import java.util.List;

/**
 * Created by Lissomsoft on 3/24/2017.
 */
public interface PatientService {

    boolean addPatient(Patient patient,Integer clinic_id);

    List<Blood> bloodtypeDetails();
    List<Patient> validatePatient(String contact_no);
}
