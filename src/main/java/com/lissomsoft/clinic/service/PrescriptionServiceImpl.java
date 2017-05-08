package com.lissomsoft.clinic.service;

import com.lissomsoft.clinic.dao.PrescriptionDao;
import com.lissomsoft.clinic.dao.PrescriptionDaoImpl;
import com.lissomsoft.clinic.domain.Prescripe;
import com.lissomsoft.clinic.domain.Prescription;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by Lissomsoft on 05/05/17.
 */
public class PrescriptionServiceImpl implements PrescriptionService {

    @Autowired(required = true)
    private PrescriptionDaoImpl prescriptionDao;

    @Override
    public boolean addPrescription(Prescripe prescriptions) {
        return prescriptionDao.addPrescription(prescriptions);
    }

    @Override
    public List<Prescription> getPrescription(Integer patient_info_id) {
        return prescriptionDao.getPrescription(patient_info_id);
    }

    @Override
    public boolean removeprescription(Prescripe prescripe) {
        return prescriptionDao.removeprescription(prescripe);
    }

    @Override
    public boolean editPrescription(Prescription prescription) {
        return prescriptionDao.editPrescription(prescription);
    }

    @Override
    public Prescription getPrescriptionById(Integer prescription_id) {


        return prescriptionDao.getPrescriptionById(prescription_id);
    }
}
