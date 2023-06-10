package com.comic.service;

import com.comic.model.Hall;

import java.util.List;

public interface HallService {
    List<Hall> selectHallByPage(int start, int size);
    boolean updateHall(Hall hall);
    Hall selectHall(String hall_id);
    List<Hall> searchHall(String search, int start, int size);
}
