package com.lissomsoft.clinic.rowmapper;

import com.lissomsoft.clinic.vo.DoctorUser;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Lissomsoft on 3/31/2017.
 */
public class FrontdeskMapper implements RowMapper {
    @Override
    public Object mapRow(ResultSet resultSet, int i) throws SQLException {
        DoctorUser doctorUser=new DoctorUser();
        doctorUser.setProfile_id(resultSet.getInt("profile_id"));
        doctorUser.setFirstname(resultSet.getString("name"));
        doctorUser.setAddress1(resultSet.getString("address1"));
        doctorUser.setAddress2(resultSet.getString("address2"));
        doctorUser.setCity(resultSet.getString("city"));
        doctorUser.setState(resultSet.getString("state"));
        doctorUser.setCountry(resultSet.getString("country"));
        doctorUser.setGender(resultSet.getInt("gender"));
        doctorUser.setPincode(resultSet.getString("pincode"));
        doctorUser.setEmail_id(resultSet.getString("email"));
        doctorUser.setContact_no(resultSet.getString("phone"));
        doctorUser.setClinic_id(resultSet.getInt("clinic_id"));
        doctorUser.setClinic_name(resultSet.getString("clinic_name"));
        doctorUser.setBranch_id(resultSet.getInt("branch_id"));
        doctorUser.setBranch_name(resultSet.getString("branch_name"));
        doctorUser.setDoctor_id(resultSet.getInt("doctor_detail_id"));
        doctorUser.setQualification(resultSet.getString("qualification"));

        return doctorUser;
    }
}
