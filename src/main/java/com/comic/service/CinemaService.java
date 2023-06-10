package com.comic.service;

import com.comic.model.Cinema;

import java.util.List;

public interface CinemaService {
    List<Cinema> selectCinemaByPage(int start, int size);
    boolean addCinema(Cinema cinema);
    boolean updateCinema(Cinema cinema);
    Cinema selectCinema(String Cinema_id);
    boolean deleteCinema(String Cinema_id);
    List<Cinema> searchCinema(String search, int start, int size);
}
