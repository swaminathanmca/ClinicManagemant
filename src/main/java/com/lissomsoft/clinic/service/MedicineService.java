package com.lissomsoft.clinic.service;

import com.lissomsoft.clinic.domain.Medicine;

import java.util.List;

/**
 * Created by Lissomsoft on 04/27/17.
 */
public interface MedicineService {

    boolean addMedicine(Medicine medicine);
    List<Medicine> getMedicine();
}
