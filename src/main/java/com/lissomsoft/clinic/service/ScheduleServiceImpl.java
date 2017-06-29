package com.lissomsoft.clinic.service;

import com.lissomsoft.clinic.dao.ScheduleDao;
import com.lissomsoft.clinic.domain.Schedule;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by Lissomsoft on 06/23/17.
 */
public class ScheduleServiceImpl implements ScheduleService{

    @Autowired(required = true)
    private ScheduleDao scheduleDao;


    @Override
    public Boolean addSchedule(Schedule schedule,StringBuilder sb) {
        return scheduleDao.addSchedule(schedule,sb);
    }

    @Override
    public List<Schedule> getSchedule(int docor_id,String start_date) {
        return scheduleDao.getSchedule(docor_id,start_date);
    }
}
