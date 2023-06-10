package com.comic.controller;

import com.comic.model.Film;
import com.comic.model.Schedule;
import com.comic.service.ScheduleService;
import com.comic.util.JsonResult;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
public class scheduleController {
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
    @Autowired
    ScheduleService scheduleService;
    List<Schedule> scheduleArrayList=new ArrayList<>();
    @RequestMapping("/admin/schedulelist")
    public PageInfo<Schedule> showFilmlist(String page){

        int pageSize = 4;
        scheduleArrayList =scheduleService.selectbypage(Integer.parseInt(page),pageSize);
        PageInfo<Schedule> pageInfo=new PageInfo<>(scheduleArrayList);
        return pageInfo;
    }
    @RequestMapping("/admin/addSchedule")
    public JsonResult<Void> addSchedule(String filmname, String cinemaname, String hallname, String starttime){
        Schedule schedule=new Schedule();
        schedule.setFilmname(filmname);
        schedule.setCinemaname(cinemaname);
        schedule.setHallname(hallname);
        String a=starttime.replace("T"," ");
        Date date=null;
        try {
            date=sdf.parse(a);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        schedule.setStarttime(date);
        if (scheduleService.addsch(schedule)){
            return new JsonResult<>(1);
        }
        return new JsonResult<>(2);
    }
    @RequestMapping("/admin/updateSchedule")
    public JsonResult<Void> update(String schedule_id, String filmname, String cinemaname, String hallname, String starttime){
        Schedule schedule=new Schedule();
        schedule.setSchedule_id(Integer.parseInt(schedule_id));
        schedule.setFilmname(filmname);
        schedule.setCinemaname(cinemaname);
        schedule.setHallname(hallname);
        String a=starttime.replace("T"," ");
        Date date=null;
        try {
            date=sdf.parse(a);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        schedule.setStarttime(date);
        if (scheduleService.updatesche(schedule)){
            return new JsonResult<>(1);
        }
        return new JsonResult<>(2);
    }
    @RequestMapping("/admin/selectSchedule")
    public JsonResult<Schedule> selectFilm(String schedule_id){

        if (scheduleService.selectbyid(Integer.parseInt(schedule_id))!=null){
            return new JsonResult<>(1,scheduleService.selectbyid(Integer.parseInt(schedule_id)));
        }
        return new JsonResult<>(2);
    }
}
