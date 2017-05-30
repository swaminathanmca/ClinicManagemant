package com.lissomsoft.clinic.rowmapper;

import com.lissomsoft.clinic.domain.PatientInfo;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Lissomsoft on 05/17/17.
 */
public class PatientInfoFollowMapper implements RowMapper {
    @Override
    public Object mapRow(ResultSet rs, int i) throws SQLException {

        PatientInfo patientInfo=new PatientInfo();
        patientInfo.setProcedures(rs.getString("procedures"));
        patientInfo.setDiagnosis(rs.getString("diagnosis"));
        patientInfo.setPatient_info_id(rs.getInt("patient_info_id"));
        patientInfo.setObservation(rs.getString("observation"));
        patientInfo.setInvestigation(rs.getString("investigation"));

        return patientInfo;
    }
}
