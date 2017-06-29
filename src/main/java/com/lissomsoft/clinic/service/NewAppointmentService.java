package com.lissomsoft.clinic.service;

import com.lissomsoft.clinic.domain.NewAppointment;

import java.awt.*;
import java.util.List;

/**
 * Created by Admin on 6/27/2017.
 */
public interface NewAppointmentService {
    boolean addnewappointment(NewAppointment newappointment,String uId);

    NewAppointment newapp();

    List<NewAppointment> appoinmentInfo(Integer branch_id,String dob,String contact_no);

    NewAppointment patientdetailsById(String patient_pid);
}
