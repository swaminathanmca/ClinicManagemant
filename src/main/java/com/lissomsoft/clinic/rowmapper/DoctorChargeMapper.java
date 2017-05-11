package com.lissomsoft.clinic.rowmapper;

import com.lissomsoft.clinic.vo.DoctorUser;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Lissomsoft on 05/09/17.
 */
public class DoctorChargeMapper implements RowMapper {
    @Override
    public Object mapRow(ResultSet resultSet, int i) throws SQLException {

        DoctorUser doctorUser=new DoctorUser();
        doctorUser.setCharge(resultSet.getInt("charge"));



        return doctorUser;
    }
}
