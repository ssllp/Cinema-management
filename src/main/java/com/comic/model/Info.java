package com.comic.model;

import java.util.List;

public class Info {
    private Integer userCount;
    private Integer filmCount;
    private Integer cinemaCount;
    private Integer orderCount;
    private List<Film> filmList;

    public Info() {
    }

    public Info(Integer userCount, Integer filmCount, Integer cinemaCount, Integer orderCount, List<Film> filmList) {
        this.userCount = userCount;
        this.filmCount = filmCount;
        this.cinemaCount = cinemaCount;
        this.orderCount = orderCount;
        this.filmList = filmList;
    }

    @Override
    public String toString() {
        return "Info{" +
                "userCount=" + userCount +
                ", filmCount=" + filmCount +
                ", cinemaCount=" + cinemaCount +
                ", orderCount=" + orderCount +
                ", filmList=" + filmList +
                '}';
    }

    public Integer getUserCount() {
        return userCount;
    }

    public void setUserCount(Integer userCount) {
        this.userCount = userCount;
    }

    public Integer getFilmCount() {
        return filmCount;
    }

    public void setFilmCount(Integer filmCount) {
        this.filmCount = filmCount;
    }

    public Integer getCinemaCount() {
        return cinemaCount;
    }

    public void setCinemaCount(Integer cinemaCount) {
        this.cinemaCount = cinemaCount;
    }

    public Integer getOrderCount() {
        return orderCount;
    }

    public void setOrderCount(Integer orderCount) {
        this.orderCount = orderCount;
    }

    public List<Film> getFilmList() {
        return filmList;
    }

    public void setFilmList(List<Film> filmList) {
        this.filmList = filmList;
    }
}
