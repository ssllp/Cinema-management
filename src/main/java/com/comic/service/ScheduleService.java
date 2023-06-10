package com.comic.service;

import com.comic.model.Schedule;

import java.util.List;

public interface ScheduleService {
    List<Schedule> selectbypage(int start, int size);
    List<Schedule> selectbyfilm(String film_id);
    Schedule selectbyid(int schedule_id);
    boolean addsch(Schedule schedule);
    boolean updatesche(Schedule schedule);
}
