package com.comic.model;

import java.util.Date;

public class Evaluation {
    private String film_id;
    private String filmname;
    private String user_id;
    private String username;
    private String text;
    private String starlevel;
    private String winpraise;
    private Date evaluatedate;
    private String picture;

    public Evaluation(String film_id, String filmname, String user_id, String username, String text, String starlevel, String winpraise, Date evaluatedate, String picture) {
        this.film_id = film_id;
        this.filmname = filmname;
        this.user_id = user_id;
        this.username = username;
        this.text = text;
        this.starlevel = starlevel;
        this.winpraise = winpraise;
        this.evaluatedate = evaluatedate;
        this.picture = picture;
    }

    public Evaluation() {
    }

    public Evaluation(String film_id, String filmname, String user_id, String username, String text, String starlevel, String winpraise, Date evaluatedate) {
        this.film_id = film_id;
        this.filmname = filmname;
        this.user_id = user_id;
        this.username = username;
        this.text = text;
        this.starlevel = starlevel;
        this.winpraise = winpraise;
        this.evaluatedate = evaluatedate;
    }

    @Override
    public String toString() {
        return "Evaluation{" +
                "film_id='" + film_id + '\'' +
                ", filmname='" + filmname + '\'' +
                ", user_id='" + user_id + '\'' +
                ", username='" + username + '\'' +
                ", text='" + text + '\'' +
                ", starlevel='" + starlevel + '\'' +
                ", winpraise='" + winpraise + '\'' +
                ", evaluatedate=" + evaluatedate +
                ", picture='" + picture + '\'' +
                '}';
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

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getStarlevel() {
        return starlevel;
    }

    public void setStarlevel(String starlevel) {
        this.starlevel = starlevel;
    }

    public String getWinpraise() {
        return winpraise;
    }

    public void setWinpraise(String winpraise) {
        this.winpraise = winpraise;
    }

    public Date getEvaluatedate() {
        return evaluatedate;
    }

    public void setEvaluatedate(Date evaluatedate) {
        this.evaluatedate = evaluatedate;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }
}
