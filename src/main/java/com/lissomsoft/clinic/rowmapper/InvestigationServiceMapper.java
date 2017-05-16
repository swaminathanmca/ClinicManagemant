package com.lissomsoft.clinic.rowmapper;

import com.lissomsoft.clinic.domain.InvestServices;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Lissomsoft on 05/16/17.
 */
public class InvestigationServiceMapper implements RowMapper{

    @Override
    public Object mapRow(ResultSet resultSet, int i) throws SQLException {

        InvestServices investServices=new InvestServices();
        investServices.setCharges(resultSet.getInt("charges"));
        investServices.setDiscount(resultSet.getInt("discount"));
        investServices.setService_name(resultSet.getString("service_name"));





        return investServices;
    }
}
