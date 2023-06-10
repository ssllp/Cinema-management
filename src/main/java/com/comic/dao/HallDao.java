package com.comic.dao;

import com.comic.model.Hall;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;
@Mapper
public interface HallDao {
    @Select("SELECT * FROM hall")
    List<Hall> selectHallByPage();
    @Update("UPDATE hall SET capacity=#{capacity} WHERE hall_id=#{hall_id}")
    int updateHall(Hall hall);
    @Select("select * from hall where hall_id=#{hall_id}")
    Hall selectHall(String hall_id);
    @Select("select * from hall where  cinemaname like #{search} or hallname like #{search} or capacity like #{search} ORDER BY capacity asc ")
    List<Hall> searchHall(String search);
}
