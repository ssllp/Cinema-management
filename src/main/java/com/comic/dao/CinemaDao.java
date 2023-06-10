package com.comic.dao;

import com.comic.model.Cinema;
import org.apache.ibatis.annotations.*;

import java.util.List;
@Mapper
public interface CinemaDao {
    @Select("SELECT * FROM cinema")
    List<Cinema> selectCinemaByPage();
    @Insert("insert into cinema (cinemaname,address,hot,status) values (#{cinemaname},#{address},#{hot},#{status})")
    int addCinema(Cinema cinema);
    @Update("UPDATE `cinema` SET cinemaname= #{cinemaname},address = #{address} , hot = #{hot} ,status=#{status} WHERE cinema_id=#{cinema_id}")
    int updateCinema(Cinema cinema);
    @Select("select * from cinema where cinema_id= #{cinema_id}")
    Cinema selectCinema(String cinema_id);
    @Delete("delete from cinema where cinema_id=#{cinema_id};")
    int deleteCinema(String cinema_id);
    @Select("select * from cinema where  cinemaname like #{cinemaname} or address like #{address} or status like #{status} ORDER BY cinema_id asc ")
    List<Cinema> searchCinema(String search);
    @Select("select count(*) from cinema")
    int count();
}
