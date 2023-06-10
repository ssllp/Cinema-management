package com.comic.model;

import java.util.List;

public class FilmInfo {
    private Film film;
    private List<Evaluation> evaluationList;
    private Userinfo userinfo;
    private List<Order> orderList;
    private List<Schedule> scheduleList;

    public FilmInfo(Film film, List<Evaluation> evaluationList, Userinfo userinfo, List<Order> orderList, List<Schedule> scheduleList) {
        this.film = film;
        this.evaluationList = evaluationList;
        this.userinfo = userinfo;
        this.orderList = orderList;
        this.scheduleList = scheduleList;
    }

    @Override
    public String toString() {
        return "FilmInfo{" +
                "film=" + film +
                ", evaluationList=" + evaluationList +
                ", userinfo=" + userinfo +
                ", orderList=" + orderList +
                ", scheduleList=" + scheduleList +
                '}';
    }

    public Film getFilm() {
        return film;
    }

    public void setFilm(Film film) {
        this.film = film;
    }

    public List<Evaluation> getEvaluationList() {
        return evaluationList;
    }

    public void setEvaluationList(List<Evaluation> evaluationList) {
        this.evaluationList = evaluationList;
    }

    public Userinfo getUserinfo() {
        return userinfo;
    }

    public void setUserinfo(Userinfo userinfo) {
        this.userinfo = userinfo;
    }

    public List<Order> getOrderList() {
        return orderList;
    }

    public void setOrderList(List<Order> orderList) {
        this.orderList = orderList;
    }

    public List<Schedule> getScheduleList() {
        return scheduleList;
    }

    public void setScheduleList(List<Schedule> scheduleList) {
        this.scheduleList = scheduleList;
    }

    public FilmInfo() {
    }


}
