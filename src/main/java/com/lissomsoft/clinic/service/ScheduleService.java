package com.lissomsoft.clinic.service;

import com.lissomsoft.clinic.domain.Schedule;

import java.security.PublicKey;
import java.util.List;

/**
 * Created by Lissomsoft on 06/23/17.
 */
public interface ScheduleService {

    Boolean addSchedule(Schedule schedule,StringBuilder sb);

    public List<Schedule> getSchedule (int docor_id,String start_date,Integer branch_id);

    public List<Schedule> getScheduleTime(Integer doctor_id,Integer branch_id);

    public List<Schedule> getScheduleDoctor(Integer doctor_id,String start_date);

}
