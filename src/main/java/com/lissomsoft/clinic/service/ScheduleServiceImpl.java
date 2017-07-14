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
    public List<Schedule> getSchedule(String docor_id,String start_date,Integer branch_id) {
        return scheduleDao.getSchedule(docor_id,start_date,branch_id);
    }

    @Override
    public List<Schedule> getScheduleTime(Integer doctor_id, Integer branch_id) {
        return scheduleDao.getScheduleTime(doctor_id,branch_id);
    }

    @Override
    public List<Schedule> getScheduleDoctor(Integer doctor_id, String start_date) {
        return scheduleDao.getScheduleDoctor(doctor_id,start_date);
    }

    @Override
    public Schedule getSchedulById(Integer schedule_id) {
        return scheduleDao.getSchedulById(schedule_id);
    }
}
