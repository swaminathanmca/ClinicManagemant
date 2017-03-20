package com.lissomsoft.clinic.dao;

import com.lissomsoft.clinic.vo.DoctorUser;

/**
 * Created by Lissomsoft on 3/20/2017.
 */
public interface DoctorDao {
    boolean addDoctor(DoctorUser doctorUser);
}
