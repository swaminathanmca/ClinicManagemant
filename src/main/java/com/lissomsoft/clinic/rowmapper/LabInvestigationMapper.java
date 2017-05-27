package com.lissomsoft.clinic.rowmapper;

import com.lissomsoft.clinic.domain.LabInvestigation;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.KeyHolder;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Lissomsoft on 05/26/17.
 */
public class LabInvestigationMapper  implements RowMapper {
    @Override
    public Object mapRow(ResultSet resultSet, int i) throws SQLException {

        LabInvestigation labInvestigation=new LabInvestigation();
        labInvestigation.setLabinvestigation_id(resultSet.getInt("labinvestigation_id"));
        labInvestigation.setTest_name(resultSet.getString("test_name"));
        labInvestigation.setPatient_info_id(resultSet.getInt("patient_info_id"));
        labInvestigation.setRemarks(resultSet.getString("remarks"));



        return labInvestigation;
    }
}
