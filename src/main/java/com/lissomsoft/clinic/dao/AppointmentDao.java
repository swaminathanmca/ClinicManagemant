package com.lissomsoft.clinic.dao;

import com.lissomsoft.clinic.domain.Appointment;
import com.lissomsoft.clinic.domain.NewAppointment;
import com.lissomsoft.clinic.domain.Patient;

import java.util.List;

/**
 * Created by Admin on 6/16/2017.
 */
public interface AppointmentDao {

    boolean addAppointment(Appointment appointment);

    List<Patient> appInfo(Integer branch_id,String dob,String contact_no);

    List<NewAppointment> newappInfo(Integer branch_id,String dob,String mobile_no);

}
