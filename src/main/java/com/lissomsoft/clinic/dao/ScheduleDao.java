package com.lissomsoft.clinic.dao;

import com.lissomsoft.clinic.domain.Schedule;

import java.util.List;

/**
 * Created by Lissomsoft on 06/23/17.
 */
public interface ScheduleDao {
    Boolean addSchedule(Schedule schedule,StringBuilder sb);
    public List<Schedule> getSchedule(int doctor_id,String start_date);
}
