package com.lissomsoft.clinic.rowmapper;

import com.lissomsoft.clinic.domain.Patient;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Lissomsoft on 3/27/2017.
 */
public class PatientMapper implements RowMapper {
    @Override
    public Object mapRow(ResultSet resultSet, int i) throws SQLException {
        Patient patient=new Patient();

        patient.setFullName(resultSet.getString("first_name"));
        patient.setLastName(resultSet.getString("last_name"));
        patient.setPatientId(resultSet.getInt("patient_id"));

        return patient;
    }
}