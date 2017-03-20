package com.lissomsoft.clinic.service;

import com.lissomsoft.clinic.dao.DoctorDaoImpl;
import com.lissomsoft.clinic.vo.DoctorUser;
import com.lissomsoft.clinic.dao.DoctorDao;
import com.lissomsoft.clinic.dao.DoctorDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Lissomsoft on 3/20/2017.
 */
public class DoctorServiceImpl implements  DoctorService {
    @Autowired(required = true)
    private DoctorDaoImpl doctorDao;


    @Override
    public boolean addDoctor(DoctorUser doctorUser) {
        return doctorDao.addDoctor(doctorUser);
    }
}
