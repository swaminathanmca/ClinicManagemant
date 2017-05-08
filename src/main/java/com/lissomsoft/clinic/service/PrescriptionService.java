package com.lissomsoft.clinic.service;

import com.lissomsoft.clinic.domain.Prescripe;
import com.lissomsoft.clinic.domain.Prescription;

import java.util.List;

/**
 * Created by Lissomsoft on 05/05/17.
 */
public interface PrescriptionService {

    boolean addPrescription(Prescripe prescriptions);
    List<Prescription> getPrescription(Integer patient_info_id);
    boolean removeprescription(Prescripe prescripe);
}
