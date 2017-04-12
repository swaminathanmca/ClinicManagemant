package com.lissomsoft.clinic.rowmapper;

import com.lissomsoft.clinic.domain.PatientVisit;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Lissomsoft on 12-Apr-17.
 */
public class PatientVisitMapper implements RowMapper {
    @Override
    public Object mapRow(ResultSet resultSet, int i) throws SQLException {

        PatientVisit visit=new PatientVisit();
        visit.setFirst_name(resultSet.getString("first_name"));
        visit.setLast_name(resultSet.getString("last_name"));
        visit.setBranch_id(resultSet.getInt("branch_id"));
        visit.setPatient_pid(resultSet.getString("patient_pid"));
        visit.setDoctor_id(resultSet.getInt("doctor_detail_id"));
        visit.setTime(resultSet.getString("entry_time"));
        visit.setType(resultSet.getInt("visit_type"));
        visit.setReferal_details(resultSet.getString("refereal_details"));

        return visit;
    }
}
