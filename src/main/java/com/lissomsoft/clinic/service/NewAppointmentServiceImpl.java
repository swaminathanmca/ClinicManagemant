package com.lissomsoft.clinic.service;

import com.lissomsoft.clinic.dao.NewAppointmentDao;
import com.lissomsoft.clinic.domain.NewAppointment;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Admin on 6/27/2017.
 */
public class NewAppointmentServiceImpl implements NewAppointmentService {

    @Autowired(required = true)
    private NewAppointmentDao newAppointmentDao;

    @Override
    public boolean addnewappointment(NewAppointment newappointment,String uId) {
        return newAppointmentDao.addnewappointment(newappointment,uId);
    }

    @Override
    public NewAppointment newapp() {

        return newAppointmentDao.addnewapp();
    }
}
