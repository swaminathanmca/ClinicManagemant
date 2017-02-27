package com.lissomsoft.clinic.rowmapper;

import com.lissomsoft.clinic.domain.Clinic;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Admin on 2/20/2017.
 */
public class ClinicMapper implements RowMapper<Clinic> {

    @Override
    public Clinic mapRow(ResultSet resultSet, int i) throws SQLException {

        Clinic clinic=new Clinic();
        clinic.setClinic_id(resultSet.getInt("clinic_id"));
        clinic.setClinic_name(resultSet.getString("clinic_name"));
        clinic.setAddress(resultSet.getString("address"));
        clinic.setDescription(resultSet.getString("description"));
        clinic.setContact_no(resultSet.getString("contact_number"));
        clinic.setEmail_id(resultSet.getString("email"));
        clinic.setCity(resultSet.getString("city"));
        clinic.setState(resultSet.getString("state"));
        clinic.setPincode(resultSet.getInt("zip"));
        clinic.setLocation(resultSet.getString("location"));
        clinic.setCountry(resultSet.getString("country"));

        return clinic;
    }
}
