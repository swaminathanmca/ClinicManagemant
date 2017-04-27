package com.lissomsoft.clinic.service;

import com.lissomsoft.clinic.dao.MedicineDao;
import com.lissomsoft.clinic.dao.MedicineDaoImpl;
import com.lissomsoft.clinic.domain.Medicine;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Lissomsoft on 04/27/17.
 */
public class MedicineServiceImpl implements MedicineService {
    @Autowired(required = true)
    MedicineDaoImpl medicineDao;

    @Override
    public boolean addMedicine(Medicine medicine) {

        return medicineDao.addMedicine(medicine);
    }
}
