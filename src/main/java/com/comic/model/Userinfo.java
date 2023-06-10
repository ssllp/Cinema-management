package com.comic.model;

public class Userinfo {
    private String user_id;
    private String username;
    private String picture;
    private int level;
    private int experience;
    private String email;
    private String sex;
    private String signature;

    public Userinfo() {
    }

    @Override
    public String toString() {
        return "Userinfo{" +
                "user_id='" + user_id + '\'' +
                ", username='" + username + '\'' +
                ", picture='" + picture + '\'' +
                ", level=" + level +
                ", experience=" + experience +
                ", email='" + email + '\'' +
                ", sex='" + sex + '\'' +
                ", signature='" + signature + '\'' +
                '}';
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

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public Userinfo(String user_id, String username, String picture, int level, int experience, String email, String sex, String signature) {
        this.user_id = user_id;
        this.username = username;
        this.picture = picture;
        this.level = level;
        this.experience = experience;
        this.email = email;
        this.sex = sex;
        this.signature = signature;
    }
}
