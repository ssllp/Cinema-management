package com.comic.model;


import java.awt.*;
import java.util.ArrayList;

public class User {
    private String user_id;
    private String username;
    private String password;
    private String tell;
    private String is_admin;
    private String is_member;
    public User() {
    }

    public User(String username, String password, String tell) {
        this.username = username;
        this.password = password;
        this.tell = tell;
    }

    public User(String user_id, String username, String password, String tell, String is_admin) {
        this.user_id = user_id;
        this.username = username;
        this.password = password;
        this.tell = tell;
        this.is_admin = is_admin;
    }

    public User(String user_id, String username, String password, String tell, String is_admin, String is_member) {
        this.user_id = user_id;
        this.username = username;
        this.password = password;
        this.tell = tell;
        this.is_admin = is_admin;
        this.is_member = is_member;
    }

    @Override
    public String toString() {
        return "User{" +
                "user_id='" + user_id + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", tell='" + tell + '\'' +
                ", is_admin='" + is_admin + '\'' +
                ", is_member='" + is_member + '\'' +
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTell() {
        return tell;
    }

    public void setTell(String tell) {
        this.tell = tell;
    }

    public String getIs_admin() {
        return is_admin;
    }

    public void setIs_admin(String is_admin) {
        this.is_admin = is_admin;
    }

    public String getIs_member() {
        return is_member;
    }

    public void setIs_member(String is_member) {
        this.is_member = is_member;
    }
}

