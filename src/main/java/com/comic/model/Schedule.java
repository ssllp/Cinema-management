package com.comic.model;


import java.sql.Timestamp;
import java.util.Date;

public class Schedule {
    private int schedule_id;
    private String film_id;
    private String filmname;
    private String hall_id;
    private String hallname;
    private String cinema_id;
    private String cinemaname;
    private Date starttime;
    private String leaveticket;

    public Schedule() {
    }

    public Schedule(int schedule_id, String film_id, String filmname, String hall_id, String hallname, String cinema_id, String cinemaname, Date starttime, String leaveticket) {
        this.schedule_id = schedule_id;
        this.film_id = film_id;
        this.filmname = filmname;
        this.hall_id = hall_id;
        this.hallname = hallname;
        this.cinema_id = cinema_id;
        this.cinemaname = cinemaname;
        this.starttime = starttime;
        this.leaveticket = leaveticket;
    }

    @Override
    public String toString() {
        return "Schedule{" +
                "schedule_id=" + schedule_id +
                ", film_id='" + film_id + '\'' +
                ", filmname='" + filmname + '\'' +
                ", hall_id='" + hall_id + '\'' +
                ", hallname='" + hallname + '\'' +
                ", cinema_id='" + cinema_id + '\'' +
                ", cinemaname='" + cinemaname + '\'' +
                ", starttime=" + starttime +
                ", leaveticket='" + leaveticket + '\'' +
                '}';
    }

    public int getSchedule_id() {
        return schedule_id;
    }

    public void setSchedule_id(int schedule_id) {
        this.schedule_id = schedule_id;
    }

    public String getFilm_id() {
        return film_id;
    }

    public void setFilm_id(String film_id) {
        this.film_id = film_id;
    }

    public String getFilmname() {
        return filmname;
    }

    public void setFilmname(String filmname) {
        this.filmname = filmname;
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

    public Date getStarttime() {
        return starttime;
    }

    public void setStarttime(Date starttime) {
        this.starttime = starttime;
    }

    public String getLeaveticket() {
        return leaveticket;
    }

    public void setLeaveticket(String leaveticket) {
        this.leaveticket = leaveticket;
    }
}
