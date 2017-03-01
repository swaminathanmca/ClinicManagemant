package com.lissomsoft.clinic.service;

import com.lissomsoft.clinic.dao.ClinicDaoImpl;
import com.lissomsoft.clinic.domain.Clinic;
import com.lissomsoft.clinic.dao.ClinicDao;
import com.lissomsoft.clinic.vo.ClinicUser;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by Admin on 2/20/2017.
 */
public class ClinicServiceImpl implements ClinicService {

    @Autowired(required = true)
    private ClinicDaoImpl clinicDao;


    @Override
    public boolean addClinic(ClinicUser clinic) {
        return clinicDao.addClinic(clinic);
    }

    @Override
    public List<Clinic> validateno(String contact_no) {
        return clinicDao.validateno(contact_no);
    }

    @Override
    public List<Clinic> email(String email_id) {
        return clinicDao.email(email_id);
    }

    @Override
    public List<Clinic> getClinic() {
        return clinicDao.getClinic();
    }

    public  List<Clinic> getClinicById(Integer id){
        return clinicDao.getClinicById(id);
    }

    @Override
    public boolean editClinic(Clinic clinic) {
        return clinicDao.editClinic(clinic);
    }

    @Override
    public boolean deleteclinic(Integer clinicID) {
        return clinicDao.deleteClinic(clinicID);
    }
}
