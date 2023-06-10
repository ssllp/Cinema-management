package com.comic.service.impl;

import com.comic.dao.ScheduleDao;
import com.comic.model.Schedule;
import com.comic.service.ScheduleService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ScheduleServiceImpl implements ScheduleService {
    @Autowired
    ScheduleDao scheduleDao;

    @Override
    public List<Schedule> selectbypage(int start, int size) {
        PageHelper.startPage(start,size);

        return scheduleDao.selectbypage();
    }

    @Override
    public List<Schedule> selectbyfilm(String film_id) {
        return scheduleDao.selectbyfilm(film_id);
    }

    @Override
    public Schedule selectbyid(int schedule_id) {
        return scheduleDao.selectbyid(schedule_id);
    }

    @Override
    public boolean addsch(Schedule schedule) {
        return scheduleDao.addsch(schedule)==1?true:false;
    }



    @Override
    public boolean updatesche(Schedule schedule) {
        return scheduleDao.updatesche(schedule)==1?true:false;
    }
}
