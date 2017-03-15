package com.lissomsoft.clinic.rowmapper;


import com.lissomsoft.clinic.vo.ClinicUser;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Admin on 3/2/2017.
 */
public class ClinicBranchMapper implements RowMapper<ClinicUser> {


    @Override
    public ClinicUser mapRow(ResultSet resultSet, int i) throws SQLException {

        ClinicUser clinicUser=new ClinicUser();
        clinicUser.setClinic_id(resultSet.getInt("clinic_id"));
        clinicUser.setClinic_name(resultSet.getString("clinic_name"));
        clinicUser.setRegister_no(resultSet.getString("reg_no"));
        clinicUser.setPassword(resultSet.getString("password"));
        clinicUser.setStatus(resultSet.getString("status"));
        clinicUser.setContact_no(resultSet.getString("contact_no"));
        clinicUser.setEmail_id(resultSet.getString("email"));
        clinicUser.setAddress1(resultSet.getString("address1"));
        clinicUser.setAddress2(resultSet.getString("address2"));
        clinicUser.setCity(resultSet.getString("city"));
        clinicUser.setState(resultSet.getString("state"));
        clinicUser.setCountry(resultSet.getString("country"));
        clinicUser.setPin_code(resultSet.getInt("pin_code"));
        clinicUser.setChief_name(resultSet.getString("chief"));
        clinicUser.setDescription(resultSet.getString("description"));
        clinicUser.setChief_address1(resultSet.getString("ch_addrs1"));
        clinicUser.setChief_address2(resultSet.getString("ch_addrs2"));
        clinicUser.setChief_city(resultSet.getString("ch_city"));
        clinicUser.setChief_state(resultSet.getString("ch_state"));
        clinicUser.setChief_country(resultSet.getString("ch_country"));
        clinicUser.setChief_id(resultSet.getInt("profile_id"));
        clinicUser.setChief_pin_code(resultSet.getString("pincode"));
        clinicUser.setChief_contact_no(resultSet.getString("phone"));
        clinicUser.setChief_email_id(resultSet.getString("ch_email"));
        clinicUser.setGender(resultSet.getString("gender"));



        return clinicUser;
    }
}
