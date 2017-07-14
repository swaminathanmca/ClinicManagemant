package com.lissomsoft.clinic.rowmapper;


import com.lissomsoft.clinic.domain.Complaint;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Admin on 4/17/2017.
 */
public class ComplaintMapper implements RowMapper {


    @Override
    public Object mapRow(ResultSet resultSet, int i) throws SQLException {

        Complaint complaint=new Complaint();
        complaint.setComplaint_id(resultSet.getInt("complaint_id"));
        complaint.setComplaint_name(resultSet.getString("complaint_name"));
        complaint.setComplaint_description(resultSet.getString("complaint_description"));

        return complaint;
    }
}
