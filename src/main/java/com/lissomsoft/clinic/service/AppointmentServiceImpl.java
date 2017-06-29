package com.lissomsoft.clinic.service;

import com.lissomsoft.clinic.dao.AppointmentDao;
import com.lissomsoft.clinic.domain.Appointment;
import com.lissomsoft.clinic.domain.Patient;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by Admin on 6/16/2017.
 */
public class AppointmentServiceImpl implements AppointmentService{

    @Autowired(required = true)
    private AppointmentDao appointmentDao;

    @Override
    public boolean addAppointment(Appointment appointment) {
        return appointmentDao.addAppointment(appointment);
    }

    @Override
    public List<Patient> appoinmentInfo(Integer branch_id,String dob, String contact_no) {
        return appointmentDao.appInfo(branch_id,dob,contact_no);
    }

}
