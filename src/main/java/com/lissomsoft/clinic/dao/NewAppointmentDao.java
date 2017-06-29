package com.lissomsoft.clinic.dao;

import com.lissomsoft.clinic.domain.NewAppointment;

import java.util.List;

/**
 * Created by Admin on 6/27/2017.
 */
public interface NewAppointmentDao {

    boolean addnewappointment(NewAppointment newappointment,String uId);

    NewAppointment addnewapp();

    List<NewAppointment> appoinmentInfo(Integer branch_id,String dob,String contact_no);

    NewAppointment patientdetailsById(String patient_pid);


}
