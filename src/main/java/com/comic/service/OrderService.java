package com.comic.service;

import com.comic.model.Order;

import java.util.List;

public interface OrderService {
    List<Order> selectbypage(int start, int size);
    List<Order> selectbyuser(String user_id, int start, int size);
    List<Order> sellectbyschid(int schedule_id);
    Order selectbyorder(int order_id);
    boolean addorder(Order order);
    boolean updateorder(String status, int order_id);
}
