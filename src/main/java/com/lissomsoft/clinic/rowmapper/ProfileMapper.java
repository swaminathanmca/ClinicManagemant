package com.lissomsoft.clinic.rowmapper;

import com.lissomsoft.clinic.domain.Profile;


import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Admin on 3/1/2017.
 */
public class ProfileMapper implements RowMapper<Profile> {

    public Profile mapRow(ResultSet resultSet, int i) throws SQLException {

        Profile profile=new Profile();
        profile.setProfile_id(resultSet.getInt("profile_id"));
        profile.setName(resultSet.getString("name"));
        profile.setEmail(resultSet.getString("email"));
        profile.setAddress1(resultSet.getString("address1"));
        profile.setAddress2(resultSet.getString("address2"));
        profile.setContact_no(resultSet.getString("phone"));
        return profile;
    }
}
