package com.lissomsoft.clinic.rowmapper;

import com.lissomsoft.clinic.vo.DoctorUser;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Lissomsoft on 05/23/17.
 */
public class DoctorMapperProfile implements RowMapper {
    @Override
    public Object mapRow(ResultSet resultSet, int i) throws SQLException {

        DoctorUser user=new DoctorUser();
        user.setFirstname(resultSet.getString("name"));
        user.setContact_no(resultSet.getString("phone"));
        user.setEmail_id(resultSet.getString("email"));
        user.setProfile_id(resultSet.getInt("profile_id"));
        user.setAddress1(resultSet.getString("address1"));
        user.setAddress2(resultSet.getString("address2"));
        user.setQualification(resultSet.getString("qualification"));
        return user;
    }
}
