package com.lissomsoft.clinic.service;

import com.lissomsoft.clinic.domain.Appointment;
import com.lissomsoft.clinic.domain.Patient;

import java.util.HashSet;
import java.util.List;

/**
 * Created by Admin on 6/16/2017.
 */
public interface AppointmentService {

    boolean addAppointment(Appointment appointment);

     List<Patient> appoinmentInfo(Integer branch_id,String dob,String contact_no);

     List<Appointment> appoinmentDetails(Integer doctor_id,Integer branch_id,String date);

     List<Appointment> viewAppoinment(Integer branch_id,String date);

    Boolean updateAppoinment(Integer status,Integer appoinment_id);
    List<Appointment> getAppoinment();

    boolean setStatus(HashSet appoimentId);
    List<Appointment> viewAppoinmentDoctor(Integer branch_id,String date,String doctor_id);
    Appointment getAppoinmentDetails(Integer appoinment_id);

}
