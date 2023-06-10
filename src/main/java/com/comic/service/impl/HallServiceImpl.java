package com.comic.service.impl;

import com.comic.dao.HallDao;
import com.comic.model.Hall;
import com.comic.service.HallService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class HallServiceImpl implements HallService {
    @Autowired
    HallDao hallDao;
    @Override
    public List<Hall> selectHallByPage(int start, int size) {

        PageHelper.startPage(start,size);
        return hallDao.selectHallByPage();
    }


    @Override
    public boolean updateHall(Hall hall) {
        return hallDao.updateHall(hall)==1?true:false;
    }

    @Override
    public Hall selectHall(String hall_id) {
        return hallDao.selectHall(hall_id);
    }

    @Override
    public List<Hall> searchHall(String search, int start, int size) {
        search='%'+search+'%';
        PageHelper.startPage(start,size);
        return hallDao.searchHall(search);
    }
}
