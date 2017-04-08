package com.lissomsoft.clinic.rowmapper;

import com.lissomsoft.clinic.domain.Speciality;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Lissomsoft on 08-Apr-17.
 */
public class SpecialityMapper implements RowMapper {


    @Override
    public Object mapRow(ResultSet resultSet, int i) throws SQLException {


        Speciality speciality=new Speciality();
        speciality.setSpeciallity_id(resultSet.getInt("speciality_id"));
        speciality.setSpeciality_name(resultSet.getString("speciality_name"));
        speciality.setDescription(resultSet.getString("description"));
        return speciality;
    }
}
