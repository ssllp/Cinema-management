package com.comic.controller;


import com.comic.model.Hall;
import com.comic.model.User;
import com.comic.service.HallService;
import com.comic.util.JsonResult;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class hallController {
    @Autowired
    HallService hallService;
    List<Hall> hallArrayList=new ArrayList<>();
    @RequestMapping("/admin/halllist")
    public PageInfo<Hall> showFilmlist(String page,String search){
        int pageSize = 5;
        if (search.equals("nothing")) {
            hallArrayList = hallService.selectHallByPage(Integer.parseInt(page), pageSize);
        }else {
            hallArrayList=hallService.searchHall(search, Integer.parseInt(page),pageSize);
        }
        PageInfo<Hall> pageInfo=new PageInfo<>(hallArrayList);
        return pageInfo;
    }

    @RequestMapping("/admin/updateHall")
    public JsonResult<Void> update(Hall hall){
        if (hallService.updateHall(hall)){
            return new JsonResult<>(1);
        }
        return new JsonResult<>(2);
    }
    @RequestMapping("/admin/selectHall")
    public JsonResult<Hall> selectUser(String hall_id){
        if (hallService.selectHall(hall_id)!=null){
            return new JsonResult<>(1,hallService.selectHall(hall_id));
        }
        return new JsonResult<>(2);
    }

}
