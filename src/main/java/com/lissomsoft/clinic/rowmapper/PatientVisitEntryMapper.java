package com.lissomsoft.clinic.rowmapper;

import com.lissomsoft.clinic.domain.PatientVisit;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Lissomsoft on 05/16/17.
 */
public class PatientVisitEntryMapper  implements RowMapper{

    @Override
    public Object mapRow(ResultSet resultSet, int i) throws SQLException {
        PatientVisit patientVisit=new PatientVisit();
        patientVisit.setPatient_pid(resultSet.getString("patient_pid"));
        return patientVisit;
    }
}
