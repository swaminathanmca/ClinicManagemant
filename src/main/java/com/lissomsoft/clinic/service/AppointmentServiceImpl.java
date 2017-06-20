package com.lissomsoft.clinic.service;

import com.lissomsoft.clinic.dao.AppointmentDao;
import com.lissomsoft.clinic.domain.Appointment;
import org.springframework.beans.factory.annotation.Autowired;

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
}
