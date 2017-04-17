package com.lissomsoft.clinic.rowmapper;

import com.lissomsoft.clinic.domain.Doctor;
import com.lissomsoft.clinic.domain.User;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Lissomsoft on 3/24/2017.
 */
public class UserTrackMapper implements RowMapper<Doctor> {
    @Override
    public Doctor mapRow(ResultSet resultSet, int i) throws SQLException {

        Doctor doctor=new Doctor();
        doctor.setBranch_id(resultSet.getInt("branch_id"));
        doctor.setClinic_id(resultSet.getInt("clinic_id"));
        doctor.setDoctor_id(resultSet.getInt("doctor_detail_id"));

        return doctor;
    }
}
