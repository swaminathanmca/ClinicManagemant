package com.lissomsoft.clinic.rowmapper;

import com.lissomsoft.clinic.vo.DoctorUser;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
/**
 * Created by Lissomsoft on 3/21/2017.
 */
public class DoctorMapper implements RowMapper<DoctorUser> {


    @Override
    public DoctorUser mapRow(ResultSet resultSet, int i) throws SQLException {

        DoctorUser user=new DoctorUser();
        user.setFirstname(resultSet.getString("name"));
        user.setAddress1(resultSet.getString("address1"));
        user.setAddress2(resultSet.getString("address2"));
        user.setCity(resultSet.getString("city"));
        user.setState(resultSet.getString("state"));
        user.setCountry(resultSet.getString("country"));
        user.setPincode(resultSet.getString("pincode"));
        user.setGender(resultSet.getInt("gender"));
        user.setContact_no(resultSet.getString("phone"));
        user.setEmail_id(resultSet.getString("email"));
        user.setClinic_id(resultSet.getInt("clinic_id"));
        user.setProfile_id(resultSet.getInt("profile_id"));
        user.setClinic_name(resultSet.getString("clinic_name"));
       /* user.setBranch_id(resultSet.getInt("branch_id"));
        user.setBranch_name(resultSet.getString("branch_name"));*/
        user.setDoctor_id(resultSet.getInt("doctor_detail_id"));
        user.setQualification(resultSet.getString("qualification"));
       /* user.setSpecialization(resultSet.getString("specialization"));*/
        user.setReg_no(resultSet.getString("reg_id"));
        user.setPassword(resultSet.getString("password"));
        user.setCharge(resultSet.getInt("charge"));

        return user;
    }
}
