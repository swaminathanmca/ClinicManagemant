package com.lissomsoft.clinic.service;

import com.lissomsoft.clinic.domain.Patient;

/**
 * Created by Lissomsoft on 3/24/2017.
 */
public interface PatientService {

    boolean addPatient(Patient patient,Integer clinic_id);
}
