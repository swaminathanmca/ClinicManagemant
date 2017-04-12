package com.lissomsoft.clinic.service;

import com.lissomsoft.clinic.dao.DoctorDaoImpl;
import com.lissomsoft.clinic.domain.Doctor;
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
    public List<Profile> viewDoctor(String branch_id) {
        return doctorDao.viewDoctor(branch_id);
    }

    @Override
    public List<Profile> viewAllDoctor(String clinic_id) {
        return doctorDao.viewAllDoctor(clinic_id);
    }

    @Override
    public DoctorUser doctorDetails(Integer profile_id) {


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
    public List<Profile> viewFrontDesk(String branch_id) {
        return doctorDao.viewFrontDesk(branch_id);
    }

    @Override
    public List<Profile> viewFrontDeskAll(Integer clinic_id) {
        return doctorDao.viewFrontDeskAll(clinic_id);
    }

    @Override
    public List<Doctor> trackSeason(String email) {
        return doctorDao.trackSeason(email);
    }

    @Override
    public DoctorUser frontdeskDetails(Integer profile_id) {


        return doctorDao.frontdeskDetails(profile_id);
    }

    @Override
    public List<DoctorUser> doctorspecailities(String speciallity_id, String branch_id) {
        return doctorDao.doctorspecailities(speciallity_id,branch_id);
    }

    @Override
    public List<DoctorUser> getDoctor(String branch_id) {
        return doctorDao.getDoctor(branch_id);
    }
}
