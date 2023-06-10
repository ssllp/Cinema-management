package com.comic.controller;

import com.comic.model.Cinema;
import com.comic.model.User;
import com.comic.service.CinemaService;
import com.comic.util.JsonResult;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@RestController
public class cinemaController {
    @Autowired
    CinemaService cinemaService;
    List<Cinema> cinemaArrayList=new ArrayList<>();
    @RequestMapping("/admin/cinemalist")
    public PageInfo<Cinema> showCinemalist(String page,String search){
        int pageSize = 4;
        if (search.equals("nothing")) {
            cinemaArrayList = cinemaService.selectCinemaByPage(Integer.parseInt(page), pageSize);
        }else {
            cinemaArrayList=cinemaService.searchCinema(search, Integer.parseInt(page),pageSize);
        }
        PageInfo<Cinema> pageInfo=new PageInfo<>(cinemaArrayList);
        return pageInfo;
    }

    @RequestMapping("/admin/addCinema")
    public JsonResult<Void> add(String cinemaname, String address, String hot,String status){
        Cinema cinema=new Cinema();
        cinema.setCinemaname(cinemaname);
        cinema.setAddress(address);
        cinema.setHot(hot);
        cinema.setStatus(status);
        if (cinemaService.addCinema(cinema)){
            return new JsonResult<>(1);
        }
        return new JsonResult<>(2);
    }

    @RequestMapping("/admin/updateCinema")
    public JsonResult<Void> update(String cinema_id,String cinemaname, String address, String hot,String status){
        Cinema cinema=new Cinema();
        cinema.setCinema_id(cinema_id);
        cinema.setCinemaname(cinemaname);
        cinema.setAddress(address);
        cinema.setHot(hot);
        cinema.setStatus(status);
        System.out.println(cinema);
        if (cinemaService.updateCinema(cinema)){
            return new JsonResult<>(1);
        }
        return new JsonResult<>(2);
    }
    @RequestMapping("/admin/selectCinema")
    public JsonResult<Cinema> selectCinema(String cinema_id){

        if (cinemaService.selectCinema(cinema_id)!=null){
            return new JsonResult<Cinema>(1,cinemaService.selectCinema(cinema_id));
        }
        return new JsonResult<>(2);
    }
    @RequestMapping("/admin/deleteCinema")
    public JsonResult<Void> update(String cinema_id, HttpSession session){
        User user= (User) session.getAttribute("user");
        if (user.getUsername().equals("admin")){
            if (cinemaService.deleteCinema(cinema_id)){
                return new JsonResult<>(1);
            }
            else {
                return new JsonResult<>(2,"删除异常");
            }
        }

        return new JsonResult<>(2,"您是普通管理员，只有超级管理员有此权限！！！");
    }
}
