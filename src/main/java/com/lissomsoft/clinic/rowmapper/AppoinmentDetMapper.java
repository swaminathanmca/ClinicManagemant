package com.lissomsoft.clinic.rowmapper;

import com.lissomsoft.clinic.domain.Appointment;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Lissomsoft on 07/01/17.
 */
public class AppoinmentDetMapper implements RowMapper {
    @Override
    public Object mapRow(ResultSet resultSet, int i) throws SQLException {

        Appointment appointment=new Appointment();
        appointment.setAppointment_id(resultSet.getInt("appointment_id"));
        appointment.setDoctor_id(resultSet.getInt("doctor_id"));
        appointment.setBranch_id(resultSet.getInt("branch_id"));
        appointment.setDov(resultSet.getString("dov"));
        appointment.setTime(resultSet.getString("schedule_time"));



        return appointment;
    }
}
