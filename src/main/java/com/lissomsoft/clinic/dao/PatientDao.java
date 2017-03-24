package com.lissomsoft.clinic.dao;

import com.lissomsoft.clinic.domain.Patient;

/**
 * Created by Lissomsoft on 3/24/2017.
 */
public interface PatientDao {
    boolean addPatient(Patient patient,String email);
}
