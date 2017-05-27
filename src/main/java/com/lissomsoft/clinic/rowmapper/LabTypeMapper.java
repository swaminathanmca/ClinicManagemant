package com.lissomsoft.clinic.rowmapper;

import com.lissomsoft.clinic.domain.Laboratory;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Lissomsoft on 05/27/17.
 */
public class LabTypeMapper implements RowMapper{

    @Override
    public Object mapRow(ResultSet resultSet, int i) throws SQLException {
        Laboratory laboratory=new Laboratory();

        laboratory.setTest_type(resultSet.getString("test_type"));

        return laboratory;
    }
}
