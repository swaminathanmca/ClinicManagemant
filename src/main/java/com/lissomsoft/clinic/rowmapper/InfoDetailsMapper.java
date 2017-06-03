package com.lissomsoft.clinic.rowmapper;

import com.lissomsoft.clinic.vo.PatientReport;
import org.apache.poi.ss.usermodel.Row;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Lissomsoft on 05/19/17.
 */
public class InfoDetailsMapper implements RowMapper{
    @Override
    public Object mapRow(ResultSet resultSet, int i) throws SQLException {
        PatientReport patientReport=new PatientReport();
        patientReport.setFirst_name(resultSet.getString("first_name"));
        patientReport.setLast_name(resultSet.getString("last_name"));
        patientReport.setPatient_pid(resultSet.getString("patient_pid"));
        patientReport.setProcedures(resultSet.getString("procedures"));
        patientReport.setDiagonics(resultSet.getString("diagnosis"));
        patientReport.setInvestigation(resultSet.getString("investigation"));
        patientReport.setObservation(resultSet.getString("observation"));
        patientReport.setType(resultSet.getInt("type"));
        patientReport.setBp(resultSet.getInt("bp"));
        patientReport.setDate(resultSet.getString("created_at"));


        return patientReport;
    }
}
