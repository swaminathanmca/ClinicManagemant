package com.lissomsoft.clinic.rowmapper;

import com.lissomsoft.clinic.domain.PatientInfo;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Lissomsoft on 05/04/17.
 */
public class PatinetInfoIdMapper implements RowMapper{
    @Override
    public Object mapRow(ResultSet resultSet, int i) throws SQLException {
        PatientInfo patientInfo=new PatientInfo();
        patientInfo.setPatient_pid(resultSet.getString("patient_pid"));
        patientInfo.setPatient_info_id(resultSet.getInt("patient_info_id"));

        return patientInfo;
    }
}
