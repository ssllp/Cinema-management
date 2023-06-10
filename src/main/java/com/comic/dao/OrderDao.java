package com.comic.dao;

import com.comic.model.Order;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;
@Mapper
public interface OrderDao {
    @Select("select a.order_id,a.schedule_id,b.username,c.filmname,c.cinemaname," +
            "c.hallname,a.seat,a.status,a.ordertime from `order` a,users b," +
            "(SELECT a.schedule_id,a.film_id,b.filmname,a.hall_id,c.hallname,c.cinema_id,c.cinemaname from schedule a,filminfo b," +
            "hall c where a.film_id=b.film_id and a.hall_id=c.hall_id) c where a.user_id=b.user_id and a.schedule_id=c.schedule_id " +
            "order by order_id")
    List<Order> selectbypage();
    @Select("select a.order_id,a.schedule_id,b.username,c.filmname," +
            "c.cinemaname,c.hallname,a.seat,a.status,a.ordertime " +
            "from `order` a,users b,(SELECT a.schedule_id,a.film_id,b.filmname," +
            "a.hall_id,c.hallname,c.cinema_id,c.cinemaname from schedule a,filminfo b," +
            "hall c where a.film_id=b.film_id and a.hall_id=c.hall_id) c " +
            "where a.user_id=b.user_id and a.schedule_id=c.schedule_id " +
            "and a.user_id=#{user_id} order by order_id ")
    List<Order> selectbyuser(String user_id);
    @Select("select * from `order` where schedule_id=#{schedule_id} and status='已完成'")
    List<Order> sellectbyschid(int schedule_id);
    @Select("select a.order_id,a.schedule_id,b.username,c.filmname,c.cinemaname," +
            "c.hallname,a.seat,a.status,a.ordertime from `order` a,users b," +
            "(SELECT a.schedule_id,a.film_id,b.filmname,a.hall_id," +
            "c.hallname,c.cinema_id,c.cinemaname from schedule a,filminfo b,hall c " +
            "where a.film_id=b.film_id and a.hall_id=c.hall_id) c " +
            "where a.user_id=b.user_id and a.schedule_id=c.schedule_id and a.order_id=#{order_id}")
    Order selectbyorder(int order_id);
    @Insert("insert into `order` (user_id,film_id,ordertime," +
            "status,schedule_id,seat) values " +
            "((select user_id from users where username=#{username})," +
            "(select film_id from filminfo where filmname=#{filmname}),#{ordertime},'已完成',#{schedule_id},#{seat})")
    int addorder(Order order);

    @Update("update `order` set status=#{status} where order_id=#{order_id}")
    int updateorder(String status, int order_id);
    @Select("select count(*) from `order`")
    int count();
}
