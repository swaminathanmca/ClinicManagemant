package com.lissomsoft.clinic.service;

import com.lissomsoft.clinic.dao.DoctorDaoImpl;
import com.lissomsoft.clinic.domain.Profile;
import com.lissomsoft.clinic.vo.DoctorUser;
import com.lissomsoft.clinic.dao.DoctorDao;
import com.lissomsoft.clinic.dao.DoctorDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

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

    @Override
    public List<Profile> viewDoctor(Integer branch_id) {
        return doctorDao.viewDoctor(branch_id);
    }

    @Override
    public List<DoctorUser> doctorDetails(Integer profile_id) {


        return doctorDao.doctorDetails(profile_id);
    }

    @Override
    public boolean editDoctor(DoctorUser doctorUser) {
        return doctorDao.editDoctor(doctorUser);
    }

    @Override
    public boolean addFrontdesk(DoctorUser frontdesk) {
        return doctorDao.addFrontdesk(frontdesk);
    }

    @Override
    public List<Profile> viewFrontDesk(Integer branch_id) {
        return doctorDao.viewFrontDesk(branch_id);
    }
}
