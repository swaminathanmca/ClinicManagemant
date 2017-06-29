package com.lissomsoft.clinic.rowmapper;

import com.lissomsoft.clinic.domain.NewAppointment;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Admin on 6/27/2017.
 */
public class NewAppointmentMapper implements RowMapper {
    @Override
    public Object mapRow(ResultSet resultSet, int i) throws SQLException {

        NewAppointment newappointment=new NewAppointment();
        newappointment.setNew_appointment_pid(resultSet.getString("new_appointment_pid"));

        return newappointment;
    }
}
