package com.lissomsoft.clinic.rowmapper;

import com.lissomsoft.clinic.domain.Clinic;
import com.lissomsoft.clinic.vo.ClinicUser;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;



/**
 * Created by Admin on 3/7/2017.
 */
public class TrackMapper implements RowMapper<ClinicUser> {


    @Override
    public ClinicUser mapRow(ResultSet resultSet, int i) throws SQLException {

        ClinicUser cuser=new ClinicUser();
        cuser.setClinic_id(resultSet.getInt("clinic_id"));
        cuser.setBranch_id(resultSet.getInt("branch_id"));
        cuser.setClinic_name(resultSet.getString("clinic_name"));
        cuser.setBranch_name(resultSet.getString("branch_name"));
        cuser.setHo(resultSet.getString("ho"));




        return cuser;
    }
}
