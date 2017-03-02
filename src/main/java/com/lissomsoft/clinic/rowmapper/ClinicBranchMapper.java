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
        clinicUser.setStatus(resultSet.getString("status"));
        clinicUser.setEmail_id(resultSet.getString("email"));
        clinicUser.setAddress1(resultSet.getString("address1"));
        clinicUser.setAddress2(resultSet.getString("address2"));
        clinicUser.setCity(resultSet.getString("city"));
        clinicUser.setState(resultSet.getString("state"));
        clinicUser.setCountry(resultSet.getString("country"));
        clinicUser.setPin_code(resultSet.getInt("pin_code"));
        clinicUser.setChief_name(resultSet.getString("chief"));
        clinicUser.setDescription(resultSet.getString("description"));


        return clinicUser;
    }
}
