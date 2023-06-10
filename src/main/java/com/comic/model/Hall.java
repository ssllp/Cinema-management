package com.comic.model;

public class Hall {
    private String hall_id;
    private String hallname;
    private String cinema_id;
    private String cinemaname;
    private String capacity;

    public Hall(String hall_id, String hallname, String cinemaname, String capacity) {
        this.hall_id = hall_id;
        this.hallname = hallname;
        this.cinemaname = cinemaname;
        this.capacity = capacity;
    }

    @Override
    public String toString() {
        return "Hall{" +
                "hall_id='" + hall_id + '\'' +
                ", hallname='" + hallname + '\'' +
                ", cinema_id='" + cinema_id + '\'' +
                ", cinemaname='" + cinemaname + '\'' +
                ", capacity='" + capacity + '\'' +
                '}';
    }

    public String getHall_id() {
        return hall_id;
    }

    public void setHall_id(String hall_id) {
        this.hall_id = hall_id;
    }

    public String getHallname() {
        return hallname;
    }

    public void setHallname(String hallname) {
        this.hallname = hallname;
    }

    public String getCinema_id() {
        return cinema_id;
    }

    public void setCinema_id(String cinema_id) {
        this.cinema_id = cinema_id;
    }

    public String getCinemaname() {
        return cinemaname;
    }

    public void setCinemaname(String cinemaname) {
        this.cinemaname = cinemaname;
    }

    public String getCapacity() {
        return capacity;
    }

    public void setCapacity(String capacity) {
        this.capacity = capacity;
    }

    public Hall(String hall_id, String hallname, String cinema_id, String cinemaname, String capacity) {
        this.hall_id = hall_id;
        this.hallname = hallname;
        this.cinema_id = cinema_id;
        this.cinemaname = cinemaname;
        this.capacity = capacity;
    }

    public Hall() {
    }
}
