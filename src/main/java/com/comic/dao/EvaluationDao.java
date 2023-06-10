package com.comic.dao;

import com.comic.model.Evaluation;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.Date;
import java.util.List;
@Mapper
public interface EvaluationDao {
    @Select("SELECT * FROM evaluation")
    List<Evaluation> selectEvaByPage();
    @Select("SELECT a.user_id,a.username,b.picture,a.film_id,a.filmname,a.text,a.starlevel,a.winpraise,a.evaluatedate" +
            " FROM evaluation a,userinfo b where a.film_id=#{film_id} and a.user_id=b.user_id order by evaluatedate desc")
    List<Evaluation> selecteva(String film_id);
    @Insert("insert into evaluation (film_id,filmname,user_id,username,text,starlevel,winpraise,evaluatedate) " +
            "values (#{film_id},#{filmname},#{user_id},#{username},#{text},#{starlevel},#{winpraise},#{evaluatedate})")
    int addeva(Evaluation evaluation);
    @Delete("delete from evaluation where film_id=#{film_id} and user_id=#{user_id};")
    int deleteEva(String film_id, String user_id);
    @Select("select * from evaluation where  filmname like #{filmname} or username like #{username} or starlevel like #{starlevel} ORDER BY film_id asc ")
    List<Evaluation> searchEva(String search);
}
