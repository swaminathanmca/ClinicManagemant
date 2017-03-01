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

        return  branch;
    }
}
