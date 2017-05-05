package com.lissomsoft.clinic.service;

import com.lissomsoft.clinic.dao.PrescriptionDaoImpl;
import com.lissomsoft.clinic.domain.Prescripe;
import org.springframework.beans.factory.annotation.Autowired;

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
}
