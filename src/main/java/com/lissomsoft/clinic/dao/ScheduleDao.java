package com.lissomsoft.clinic.dao;

import com.lissomsoft.clinic.domain.Schedule;

import java.util.List;

/**
 * Created by Lissomsoft on 06/23/17.
 */
public interface ScheduleDao {
    Boolean addSchedule(Schedule schedule,StringBuilder sb);
    public List<Schedule> getSchedule(String doctor_id,String start_date,Integer branch_id);
    public List<Schedule> getScheduleTime(Integer doctor_id,Integer branch_id);
    public List<Schedule> getScheduleDoctor(Integer doctor_id,String start_date);
}
