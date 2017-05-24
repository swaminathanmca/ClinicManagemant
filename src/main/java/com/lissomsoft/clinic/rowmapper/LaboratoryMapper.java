package com.lissomsoft.clinic.rowmapper;

import com.lissomsoft.clinic.domain.Laboratory;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Lissomsoft on 05/24/17.
 */
public class LaboratoryMapper implements RowMapper {
    @Override
    public Object mapRow(ResultSet resultSet, int i) throws SQLException {

        Laboratory laboratory=new Laboratory();
        laboratory.setTest_id(resultSet.getInt("test_id"));
        laboratory.setTest_type(resultSet.getString("test_type"));
        laboratory.setTest_name(resultSet.getString("test_name"));
        laboratory.setDescription(resultSet.getString("description"));

        return laboratory;
    }
}
