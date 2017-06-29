package com.lissomsoft.clinic.service;

import com.lissomsoft.clinic.domain.Schedule;

import java.util.List;

/**
 * Created by Lissomsoft on 06/23/17.
 */
public interface ScheduleService {

    Boolean addSchedule(Schedule schedule,StringBuilder sb);

    public List<Schedule> getSchedule (int docor_id,String start_date);

}
