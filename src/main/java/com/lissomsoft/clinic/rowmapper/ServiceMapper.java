package com.lissomsoft.clinic.rowmapper;

import com.lissomsoft.clinic.domain.Service;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Lissomsoft on 05/06/17.
 */
public class ServiceMapper implements RowMapper {
    @Override
    public Object mapRow(ResultSet resultSet, int i) throws SQLException {

        Service service=new Service();
        service.setService_id(resultSet.getInt("service_id"));
        service.setService_name(resultSet.getString("service_name"));
        service.setDescription(resultSet.getString("description"));
        service.setCharges(resultSet.getInt("charges"));
        service.setBranch_id(resultSet.getInt("branch_id"));


        return service;
    }
}
