package com.lissomsoft.clinic.rowmapper;

import com.lissomsoft.clinic.domain.NewAppointment;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Lissomsoft on 06/29/17.
 */
public class NewAppoinmentProfile implements RowMapper {
    @Override
    public Object mapRow(ResultSet resultSet, int i) throws SQLException {
        NewAppointment newAppointment=new NewAppointment();
        newAppointment.setFirst_name(resultSet.getString("first_name"));
        newAppointment.setLast_name(resultSet.getString("last_name"));
        newAppointment.setNew_appointment_id(resultSet.getInt("new_appointment_id"));
        newAppointment.setNew_appointment_pid(resultSet.getString("new_appointment_pid"));
        newAppointment.setMobile_no(resultSet.getString("mobile_no"));
        newAppointment.setAddress1(resultSet.getString("address1"));
        newAppointment.setAddress2(resultSet.getString("address2"));





        return newAppointment;
    }
}
