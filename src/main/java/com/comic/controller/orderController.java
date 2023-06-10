package com.comic.controller;

import com.comic.model.Order;
import com.comic.model.User;
import com.comic.service.OrderService;
import com.comic.util.JsonResult;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class orderController {
    @Autowired
    OrderService orderService;
    List<Order> orderArrayList=new ArrayList<>();
    @RequestMapping("/admin/orderlist")
    public PageInfo<Order> showevaluationlist(String page){

        int pageSize = 5;
        int count;
        int pageCount;
        orderArrayList =orderService.selectbypage(Integer.parseInt(page),pageSize);
        PageInfo<Order> pageInfo=new PageInfo<>(orderArrayList);
        return pageInfo;
    }
    @RequestMapping("/admin/updateOrder")
    public JsonResult<Void> update(String user_id,String status){
        if (orderService.updateorder(user_id, Integer.parseInt(status))){
            return new JsonResult<>(1);
        }
        return new JsonResult<>(2);
    }
    @RequestMapping("/admin/selectOrder")
    public JsonResult<Order> selectOrder(int order_id){

        if (orderService.selectbyorder(order_id)!=null){
            return new JsonResult<>(1,orderService.selectbyorder(order_id));
        }
        return new JsonResult<>(2);
    }
}
