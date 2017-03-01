package com.lissomsoft.clinic.rowmapper;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import com.lissomsoft.clinic.domain.User;

/**
 * Created by Admin on 2/17/2017.
 */
public class UserMapper implements RowMapper<User> {

    @Override
    public User mapRow(ResultSet rs, int i) throws SQLException {

        User user = new User();

        user.setUserName(rs.getString("username"));
        user.setEmail_id(rs.getString("email"));
        user.setRole_name(rs.getString("role_name"));


        return user;
    }
}
