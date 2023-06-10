package com.comic.service.impl;

import com.comic.dao.OrderDao;
import com.comic.model.Order;
import com.comic.service.OrderService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    OrderDao orderDao;
    @Override
    public List<Order> selectbypage(int start, int size) {

        PageHelper.startPage(start,size);
        return orderDao.selectbypage();
    }

    @Override
    public List<Order> selectbyuser(String user_id, int start, int size) {
        PageHelper.startPage(start,size);
        return orderDao.selectbyuser(user_id);
    }

    @Override
    public Order selectbyorder(int order_id) {
        return orderDao.selectbyorder(order_id);
    }

    @Override
    public List<Order> sellectbyschid(int schedule_id) {
        System.out.println(schedule_id);
        return orderDao.sellectbyschid(schedule_id);
    }

    @Override
    public boolean addorder(Order order) {
        return orderDao.addorder(order)==1?true:false;
    }

    @Override
    public boolean updateorder(String status, int order_id) {
        return orderDao.updateorder(status,order_id)==1?true:false;
    }
}
