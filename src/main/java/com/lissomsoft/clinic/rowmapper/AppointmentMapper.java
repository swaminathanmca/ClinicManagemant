package com.lissomsoft.clinic.rowmapper;

import com.lissomsoft.clinic.domain.Patient;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Admin on 6/20/2017.
 */
public class AppointmentMapper implements RowMapper {


    @Override
    public Object mapRow(ResultSet resultSet, int i) throws SQLException {

        Patient patient=new Patient();
        patient.setFullName(resultSet.getString("first_name"));
        patient.setLastName(resultSet.getString("last_name"));
        patient.setAddress1(resultSet.getString("address1"));
        patient.setAddress2(resultSet.getString("address2"));
        patient.setPatient_pId(resultSet.getString("patient_pId"));
        patient.setPatientId(resultSet.getInt("patient_id"));
        patient.setContact_no(resultSet.getString("mobile_no"));

        return patient;
    }
}
