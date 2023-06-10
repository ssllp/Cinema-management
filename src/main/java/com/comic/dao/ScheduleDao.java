package com.comic.dao;

import com.comic.model.Schedule;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;
@Mapper
public interface ScheduleDao {
    @Select("SELECT a.schedule_id,a.film_id,b.filmname,a.hall_id," +
            "c.hallname,c.cinema_id,c.cinemaname,a.starttime,a.leaveticket from " +
            "schedule a,filminfo b,hall c where a.film_id=b.film_id and a.hall_id=c.hall_id")
    List<Schedule> selectbypage();
    @Select("SELECT a.schedule_id,a.film_id,b.filmname,a.hall_id,c.hallname,c.cinema_id,c.cinemaname,a.starttime,a.leaveticket " +
            "from schedule a,filminfo b,hall c " +
            "where a.film_id=b.film_id and a.hall_id=c.hall_id and a.film_id=#{film_id} order by schedule_id desc")
    List<Schedule> selectbyfilm(String film_id);

    @Select("SELECT a.schedule_id,a.film_id,b.filmname,a.hall_id,c.hallname,c.cinema_id,c.cinemaname,a.starttime,a.leaveticket " +
            "from schedule a,filminfo b,hall c " +
            "where a.film_id=b.film_id and a.hall_id=c.hall_id and a.schedule_id=#{schedule_id};")
    Schedule selectbyid(int schedule_id);

    @Insert("insert into schedule (film_id,hall_id,starttime,leaveticket) " +
            "values ((select film_id from filminfo where filmname=#{filmname})," +
            "(select hall_id from hall where hallname=#{hallname} and cinemaname=#{cinemaname}),#{starttime},36)")
    int addsch(Schedule schedule);
    @Update("update schedule set film_id=(select film_id from filminfo where filmname=#{filmname}),hall_id=(select hall_id from hall where cinemaname=#{cinemaname} and hallname=#{hallname}),starttime=#{starttime} where schedule_id=#{schedule_id}")
    int updatesche(Schedule schedule);
}
