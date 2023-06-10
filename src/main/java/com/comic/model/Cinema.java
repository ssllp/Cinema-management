package com.comic.model;

public class Cinema {
    private String cinema_id;
    private String cinemaname;
    private String address;
    private String hot;
    private String status;

    public Cinema(String cinemaname, String address, String hot, String status) {
        this.cinemaname = cinemaname;
        this.address = address;
        this.hot = hot;
        this.status = status;
    }

    public Cinema() {
    }

    public Cinema(String cinema_id, String cinemaname, String address, String hot, String status) {
        this.cinema_id = cinema_id;
        this.cinemaname = cinemaname;
        this.address = address;
        this.hot = hot;
        this.status = status;
    }

    @Override
    public String toString() {
        return "Cinema{" +
                "cinema_id='" + cinema_id + '\'' +
                ", cinemaname='" + cinemaname + '\'' +
                ", address='" + address + '\'' +
                ", hot='" + hot + '\'' +
                ", status='" + status + '\'' +
                '}';
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getHot() {
        return hot;
    }

    public void setHot(String hot) {
        this.hot = hot;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
