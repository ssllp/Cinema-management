package com.comic.service;

import com.comic.model.Film;

import java.util.Date;
import java.util.List;

public interface FilmService {
    List<Film> selectFilmByPage(int start, int size);
    List<Film> selectorderby();
    boolean updateFilm(Film film);
    Film selectFilm(String film_id);
    boolean deleteFilm(String film_id);
    List<Film> searchFilm(String search, int start, int size);
//    List<Film> searchFilm(String search);
    boolean addFilm(Film film);
}
