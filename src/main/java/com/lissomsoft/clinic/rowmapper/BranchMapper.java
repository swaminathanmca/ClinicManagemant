package com.lissomsoft.clinic.rowmapper;
import com.lissomsoft.clinic.domain.Branch;
import com.lissomsoft.clinic.domain.Clinic;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
/**
 * Created by Admin on 3/1/2017.
 */
public class BranchMapper implements RowMapper<Branch>{


    public Branch mapRow(ResultSet resultSet, int i) throws SQLException {
     Branch branch=new Branch();



        branch.setBranch_id(resultSet.getInt("branch_id"));
        branch.setBranch_name(resultSet.getString("branch_name"));
        branch.setAddress1(resultSet.getString("address1"));
        branch.setAddress2(resultSet.getString("address2"));
        branch.setCity(resultSet.getString("city"));
        branch.setClinic_id(resultSet.getInt("clinic_id"));
        branch.setCountry(resultSet.getString("country"));
        branch.setPin_code(resultSet.getInt("pin_code"));
        branch.setContact_no(resultSet.getString("contact_no"));
        branch.setEmail(resultSet.getString("email"));
        branch.setHo(resultSet.getInt("ho"));


        return  branch;
    }
}
