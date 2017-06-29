package com.lissomsoft.clinic.service;

import com.lissomsoft.clinic.domain.Appointment;
import com.lissomsoft.clinic.domain.Patient;

import java.util.List;

/**
 * Created by Admin on 6/16/2017.
 */
public interface AppointmentService {

    boolean addAppointment(Appointment appointment);

   List<Patient> appoinmentInfo(Integer branch_id,String dob,String contact_no);

}
