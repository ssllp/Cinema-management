package com.comic.service.impl;

import com.comic.dao.FilmDao;
import com.comic.model.Film;
import com.comic.service.FilmService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
@Service
public class FilmServiceImpl implements FilmService {
    @Autowired
    FilmDao filmDao;
    @Override
    public List<Film> selectFilmByPage(int start, int size) {
        PageHelper.startPage(start,size);
        return filmDao.selectFilmByPage();
    }

    @Override
    public List<Film> selectorderby() {
        return filmDao.selectorderby();
    }

//    @Override
//    public List<Film> searchFilm(String search) {
//
//        return filmDao.searchFilm(search,0,30);
//    }

    @Override
    public boolean updateFilm(Film film) {
        return filmDao.updateFilm(film)==1?true:false;
    }

    @Override
    public Film selectFilm(String film_id) {
        return filmDao.selectFilm(film_id);
    }

    @Override
    public boolean deleteFilm(String film_id) {
        return filmDao.deleteFilm(film_id)==1?true:false;
    }

    @Override
    public List<Film> searchFilm(String search, int start, int size) {
        search='%'+search+'%';
        PageHelper.startPage(start,size);
        return filmDao.searchFilm(search);
    }

    @Override
    public boolean addFilm(Film film) {
        return filmDao.addFilm(film)==1?true:false;
    }

}
