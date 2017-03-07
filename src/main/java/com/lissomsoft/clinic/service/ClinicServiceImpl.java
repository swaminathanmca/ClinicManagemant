package com.lissomsoft.clinic.service;

import com.lissomsoft.clinic.dao.ClinicDaoImpl;
import com.lissomsoft.clinic.domain.Branch;
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
    public List<Branch> validateno(String contact_no) {
        return clinicDao.validateno(contact_no);
    }

    @Override
    public List<Clinic> validateName(String clinic_name) {
        return clinicDao.validateName(clinic_name);
    }

    @Override
    public List<ClinicUser> clinicDetails(Integer clinic_id) {
        return clinicDao.viewDetails(clinic_id);
    }

    @Override
    public List<Branch> email(String email_id) {
        return clinicDao.email(email_id);
    }

    @Override
    public List<ClinicUser> getClinic() {
        return clinicDao.getClinic();
    }

   /* public  List<Clinic> getClinicById(Integer id){
        return clinicDao.getClinicById(id);
    }*/

    @Override
    public boolean editClinic(ClinicUser clinicUser) {
        return clinicDao.editClinic(clinicUser);
    }

    @Override
    public boolean deleteclinic(Integer clinicID) {
        return clinicDao.deleteClinic(clinicID);
    }

    @Override
    public List<ClinicUser> track_id(String email) {
        return clinicDao.track_id(email);
    }
}
