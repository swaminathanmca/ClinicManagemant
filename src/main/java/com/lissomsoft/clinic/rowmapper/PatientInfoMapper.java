package com.lissomsoft.clinic.rowmapper;

import com.lissomsoft.clinic.domain.PatientInfo;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Admin on 4/20/2017.
 */
public class PatientInfoMapper implements RowMapper {
    @Override
    public Object mapRow(ResultSet resultSet, int i) throws SQLException {

        PatientInfo patientinfo = new PatientInfo();
        patientinfo.setPatient_pid(resultSet.getString("patient_pid"));
        patientinfo.setFirst_name(resultSet.getString("first_name"));
        patientinfo.setLast_name(resultSet.getString("last_name"));
        patientinfo.setDate(resultSet.getString("created_at"));
        patientinfo.setRefereal_details(resultSet.getString("referal_details"));


        return patientinfo;
    }
}
