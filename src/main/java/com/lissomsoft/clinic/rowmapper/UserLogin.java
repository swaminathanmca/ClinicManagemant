package com.lissomsoft.clinic.rowmapper;

import com.lissomsoft.clinic.domain.User;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Lissomsoft on 06/16/17.
 */
public class UserLogin implements RowMapper {
    @Override
    public Object mapRow(ResultSet resultSet, int i) throws SQLException {

        User user=new User();
        user.setEmail_id(resultSet.getString("email"));


        return user;
    }
}
