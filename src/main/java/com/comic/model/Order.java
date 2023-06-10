package com.comic.model;

import java.sql.Timestamp;
import java.util.Date;

public class Order {
    private int order_id;
    private int schedule_id;
    private String username;
    private String filmname;
    private String cinemaname;
    private String hallname;
    private String seat;
    private String status;
    private Date ordertime;

    public Order() {
    }

    @Override
    public String toString() {
        return "Order{" +
                "order_id=" + order_id +
                ", schedule_id=" + schedule_id +
                ", username='" + username + '\'' +
                ", filmname='" + filmname + '\'' +
                ", cinemaname='" + cinemaname + '\'' +
                ", hallname='" + hallname + '\'' +
                ", seat='" + seat + '\'' +
                ", status='" + status + '\'' +
                ", ordertime=" + ordertime +
                '}';
    }

    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public int getSchedule_id() {
        return schedule_id;
    }

    public void setSchedule_id(int schedule_id) {
        this.schedule_id = schedule_id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFilmname() {
        return filmname;
    }

    public void setFilmname(String filmname) {
        this.filmname = filmname;
    }

    public String getCinemaname() {
        return cinemaname;
    }

    public void setCinemaname(String cinemaname) {
        this.cinemaname = cinemaname;
    }

    public String getHallname() {
        return hallname;
    }

    public void setHallname(String hallname) {
        this.hallname = hallname;
    }

    public String getSeat() {
        return seat;
    }

    public void setSeat(String seat) {
        this.seat = seat;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getOrdertime() {
        return ordertime;
    }

    public void setOrdertime(Date ordertime) {
        this.ordertime = ordertime;
    }

    public Order(int order_id, int schedule_id, String username, String filmname, String cinemaname, String hallname, String seat, String status, Date ordertime) {
        this.order_id = order_id;
        this.schedule_id = schedule_id;
        this.username = username;
        this.filmname = filmname;
        this.cinemaname = cinemaname;
        this.hallname = hallname;
        this.seat = seat;
        this.status = status;
        this.ordertime = ordertime;
    }
}
