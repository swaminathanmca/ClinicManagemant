package com.lissomsoft.clinic.rowmapper;

import com.lissomsoft.clinic.domain.Doctor;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Lissomsoft on 07/08/17.
 */
public class DoctorTrackMapper implements RowMapper {
    @Override
    public Object mapRow(ResultSet resultSet, int i) throws SQLException {
        Doctor doctor=new Doctor();
        doctor.setBranch_id(resultSet.getInt("branch_id"));
        doctor.setClinic_id(resultSet.getInt("clinic_id"));
        doctor.setDoctor_id(resultSet.getInt("doctor_detail_id"));
        doctor.setQualification(resultSet.getString("clinic_name"));
        return doctor;
    }
}
