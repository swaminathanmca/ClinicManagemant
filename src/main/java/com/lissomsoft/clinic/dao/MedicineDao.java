package com.lissomsoft.clinic.dao;

import com.lissomsoft.clinic.domain.Medicine;

import java.util.List;

/**
 * Created by Lissomsoft on 04/27/17.
 */
public interface MedicineDao {

    boolean addMedicine(Medicine medicine);
    List<Medicine> getMedicine();
    Medicine medicineDetails(Integer medicine_id);
    boolean editMedicine(Medicine medicine);
}
