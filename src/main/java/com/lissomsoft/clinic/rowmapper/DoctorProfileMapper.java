package com.lissomsoft.clinic.rowmapper;

import com.lissomsoft.clinic.domain.Profile;
import com.lissomsoft.clinic.vo.DoctorUser;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Lissomsoft on 11-Apr-17.
 */
public class DoctorProfileMapper implements RowMapper{


    @Override
    public Object mapRow(ResultSet resultSet, int i) throws SQLException {

        DoctorUser doctorUser=new DoctorUser();
        doctorUser.setProfile_id(resultSet.getInt("profile_id"));
        doctorUser.setFirstname(resultSet.getString("name"));
        doctorUser.setDoctor_id(resultSet.getInt("doctor_detail_id"));


        return doctorUser;
    }
}
