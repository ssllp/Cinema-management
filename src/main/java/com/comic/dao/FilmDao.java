package com.comic.dao;

import com.comic.model.Film;
import org.apache.ibatis.annotations.*;

import java.util.Date;
import java.util.List;
@Mapper
public interface FilmDao {
    @Select("SELECT * FROM filminfo")
    List<Film> selectFilmByPage();
    @Select("SELECT * FROM filminfo ORDER BY sentiment desc limit 0,6")
    List<Film> selectorderby();
    @Insert("insert into filminfo (filmname,back,area,ticai,filmtype,fare,sentiment,filmdate) values (#{filmname},#{back},#{area},#{ticai},#{filmtype},#{fare},#{sentiment},#{filmdate})")
    int addFilm(Film film);
    @Update("UPDATE filminfo SET filmname = #{filmname} , back = #{back} , area = #{area},ticai=#{ticai},filmtype=#{filmtype},fare=#{fare},sentiment=#{sentiment},filmdate=#{filmdate} WHERE film_id=#{film_id}")
    int updateFilm(Film film);
    @Select("select * from filminfo where film_id=#{film_id}")
    Film selectFilm(String film_id);
    @Delete("delete from filminfo where film_id=#{film_id};")
    int deleteFilm(String film_id);
    @Select("select * from filminfo where filmname like #{search} or area like #{search} or ticai like #{search} or filmtype like #{search} ")
    List<Film> searchFilm(String search);
    @Select("select count(*) from filminfo")
    int count();
}
