package com.lissomsoft.clinic.service;

import com.lissomsoft.clinic.dao.MedicineDao;
import com.lissomsoft.clinic.dao.MedicineDaoImpl;
import com.lissomsoft.clinic.domain.Medicine;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

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

    @Override
    public List<Medicine> getMedicine() {
        return medicineDao.getMedicine();
    }

    @Override
    public Medicine medicineDetails(Integer medicine_id) {
        return medicineDao.medicineDetails(medicine_id);
    }

    @Override
    public boolean editMedicine(Medicine medicine) {
        return medicineDao.editMedicine(medicine);
    }
}
