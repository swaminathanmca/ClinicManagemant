package com.lissomsoft.clinic.rowmapper;

import com.lissomsoft.clinic.domain.Schedule;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Lissomsoft on 06/26/17.
 */
public class ScheduleMapper implements RowMapper{
    @Override
    public Object mapRow(ResultSet resultSet, int i) throws SQLException {

        Schedule schedule=new Schedule();
        schedule.setStart_date(resultSet.getString("start_date"));
        schedule.setEnd_date(resultSet.getString("end_date"));
        schedule.setEnd_type(resultSet.getInt("end_type"));
        schedule.setStart_time(resultSet.getString("start_time"));
        schedule.setEnd_time(resultSet.getString("end_time"));
        schedule.setDay_flags(resultSet.getString("day_flag"));


        return schedule;
    }
}
