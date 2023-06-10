package com.comic.model;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class Film {
    private String film_id;
    private String filmname;
    private String back;
    private String area;
    private String ticai;
    private String filmtype;
    private String fare;
    private int sentiment;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date filmdate;

    public Film() {
    }

    public Film(String film_id, String filmname, String back, String area, String ticai, String filmtype, String fare, int sentiment, Date filmdate) {
        this.film_id = film_id;
        this.filmname = filmname;
        this.back = back;
        this.area = area;
        this.ticai = ticai;
        this.filmtype = filmtype;
        this.fare = fare;
        this.sentiment = sentiment;
        this.filmdate = filmdate;
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

    public String getBack() {
        return back;
    }

    public void setBack(String back) {
        this.back = back;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getTicai() {
        return ticai;
    }

    public void setTicai(String ticai) {
        this.ticai = ticai;
    }

    public String getFilmtype() {
        return filmtype;
    }

    public void setFilmtype(String filmtype) {
        this.filmtype = filmtype;
    }

    public String getFare() {
        return fare;
    }

    public void setFare(String fare) {
        this.fare = fare;
    }

    public int getSentiment() {
        return sentiment;
    }

    public void setSentiment(int sentiment) {
        this.sentiment = sentiment;
    }

    public Date getFilmdate() {
        return filmdate;
    }

    public void setFilmdate(Date filmdate) {
        this.filmdate = filmdate;
    }

    @Override
    public String toString() {
        return "Film{" +
                "film_id='" + film_id + '\'' +
                ", filmname='" + filmname + '\'' +
                ", back='" + back + '\'' +
                ", area='" + area + '\'' +
                ", ticai='" + ticai + '\'' +
                ", filmtype='" + filmtype + '\'' +
                ", fare='" + fare + '\'' +
                ", sentiment=" + sentiment +
                ", filmdate=" + filmdate +
                '}';
    }
}
