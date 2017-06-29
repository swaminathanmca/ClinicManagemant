package com.lissomsoft.clinic.service;

import com.lissomsoft.clinic.domain.NewAppointment;

/**
 * Created by Admin on 6/27/2017.
 */
public interface NewAppointmentService {
    boolean addnewappointment(NewAppointment newappointment,String uId);

    NewAppointment newapp();
}
