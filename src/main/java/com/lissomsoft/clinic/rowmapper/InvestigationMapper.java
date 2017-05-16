package com.lissomsoft.clinic.rowmapper;

import com.lissomsoft.clinic.domain.Investigation;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Lissomsoft on 05/16/17.
 */
public class InvestigationMapper implements RowMapper {




    @Override
    public Object mapRow(ResultSet resultSet, int i) throws SQLException {
        Investigation investigation=new Investigation();
        investigation.setTotal_amount(resultSet.getInt("total_amount"));
        investigation.setVisit_id(resultSet.getInt("visit_id"));

        return investigation;
    }
}
