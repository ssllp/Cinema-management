package com.comic.model;

import com.github.pagehelper.PageInfo;

import java.util.List;

public class ShowUserInfo {
    private Userinfo userinfo;
    private PageInfo<Order> orderList;

    public ShowUserInfo(Userinfo userinfo, PageInfo<Order> orderList) {
        this.userinfo = userinfo;
        this.orderList = orderList;
    }

    @Override
    public String toString() {
        return "shoUserInfo{" +
                "userinfo=" + userinfo +
                ", orderList=" + orderList +
                '}';
    }

    public Userinfo getUserinfo() {
        return userinfo;
    }

    public void setUserinfo(Userinfo userinfo) {
        this.userinfo = userinfo;
    }

    public PageInfo<Order> getOrderList() {
        return orderList;
    }

    public void setOrderList(PageInfo<Order> orderList) {
        this.orderList = orderList;
    }

    public ShowUserInfo() {
    }
}
