package com.lissomsoft.clinic.rowmapper;

import com.lissomsoft.clinic.vo.PatientReport;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Lissomsoft on 05/19/17.
 */
public class PatientReportMapper implements RowMapper {


    @Override
    public Object mapRow(ResultSet resultSet, int i) throws SQLException {


        PatientReport patientReport=new PatientReport();
        patientReport.setPatient_info_id(resultSet.getInt("patient_info_id"));
        patientReport.setPatient_pid(resultSet.getString("patient_pid"));
        patientReport.setFirst_name(resultSet.getString("first_name"));
        patientReport.setLast_name(resultSet.getString("last_name"));
        patientReport.setReferal_details(resultSet.getString("referal_details"));
        patientReport.setDate(resultSet.getString("created_at"));



        return patientReport;
    }
}
