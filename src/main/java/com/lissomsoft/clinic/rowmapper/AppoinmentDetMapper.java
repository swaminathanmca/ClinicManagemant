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
        appointment.setName(resultSet.getString("name"));
        appointment.setTime(resultSet.getString("schedule_time"));
        appointment.setContact_no(resultSet.getString("phone_no"));
        appointment.setPatient_pid(resultSet.getString("patient_pid"));
        appointment.setDoctor_name(resultSet.getString("created_at"));
        appointment.setStatus(resultSet.getInt("status"));
        appointment.setType(resultSet.getInt("type"));




        return appointment;
    }
}
