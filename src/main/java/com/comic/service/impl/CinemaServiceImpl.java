package com.comic.service.impl;

import com.comic.dao.CinemaDao;
import com.comic.model.Cinema;
import com.comic.service.CinemaService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CinemaServiceImpl implements CinemaService {
    @Autowired
    CinemaDao cinemaDao;
    @Override
    public List<Cinema> selectCinemaByPage(int start, int size) {
        PageHelper.startPage(start,size);
        return cinemaDao.selectCinemaByPage();
    }

    @Override
    public boolean addCinema(Cinema cinema) {
        return cinemaDao.addCinema(cinema)==1?true:false;
    }


    @Override
    public boolean updateCinema(Cinema cinema) {
        System.out.println(cinema);
        return cinemaDao.updateCinema(cinema)==1?true:false;
    }

    @Override
    public Cinema selectCinema(String Cinema_id) {
        return cinemaDao.selectCinema(Cinema_id);
    }

    @Override
    public boolean deleteCinema(String Cinema_id) {
        return cinemaDao.deleteCinema(Cinema_id)==1?true:false;
    }

    @Override
    public List<Cinema> searchCinema(String search, int start, int size) {
        search='%'+search+'%';
        PageHelper.startPage(start,size);
        return cinemaDao.searchCinema(search);
    }
}
