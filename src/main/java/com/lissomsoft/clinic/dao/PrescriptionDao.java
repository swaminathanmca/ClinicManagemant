package com.lissomsoft.clinic.dao;

import com.lissomsoft.clinic.domain.Prescripe;
import com.lissomsoft.clinic.domain.Prescription;

import java.util.List;

/**
 * Created by Lissomsoft on 05/05/17.
 */
public interface PrescriptionDao {

    boolean addPrescription(Prescripe prescriptions);
    List<Prescription> getPrescription(Integer patient_info_id);
    boolean removeprescription(Prescripe prescripe);

    boolean editPrescription(Prescription prescription);

    Prescription getPrescriptionById(Integer prescription_id);
}
