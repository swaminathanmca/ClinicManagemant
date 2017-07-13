package com.lissomsoft.clinic.service;

import com.lissomsoft.clinic.dao.AppointmentDao;
import com.lissomsoft.clinic.domain.Appointment;
import com.lissomsoft.clinic.domain.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;


import java.util.HashSet;
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

    @Override
    public List<Appointment> appoinmentDetails(Integer doctor_id, Integer branch_id,String date) {
        return appointmentDao.appoinmentDetails(doctor_id,branch_id,date);
    }

    @Override
    public List<Appointment> viewAppoinment(Integer branch_id, String date) {
        return appointmentDao.viewAppoinment(branch_id,date);
    }

    @Override
    public Boolean updateAppoinment(Integer status,Integer appoinment_id) {
        return appointmentDao.updateAppoinment(status,appoinment_id);
    }

    @Override
    public List<Appointment> getAppoinment() {
        return appointmentDao.getAppoinment();
    }

    @Override
    public boolean setStatus(HashSet appoimentId) {
        return appointmentDao.setStatus(appoimentId);
    }

    @Override
    public List<Appointment> viewAppoinmentDoctor(Integer branch_id, String date, String doctor_id) {
        return appointmentDao.viewAppoinmentDoctor(branch_id,date,doctor_id);
    }

    @Override
    public Appointment getAppoinmentDetails(Integer appoinment_id) {
        return appointmentDao.getAppoinmentDetails(appoinment_id);
    }


}
