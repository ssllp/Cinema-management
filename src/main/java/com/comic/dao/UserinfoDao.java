package com.comic.dao;

import com.comic.model.Userinfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface UserinfoDao {
    @Select("select * from userinfo where user_id=#{user_id}")
    Userinfo selectuser(String user_id);
    @Update("update userinfo set username=#{username},picture=#{picture},email=#{email},sex=#{sex},signature=#{signature} " +
            "where user_id=#{user_id}")
    int updateuserinfo(Userinfo userinfo);
    @Update("update userinfo set picture=#{picture} where username=#{username}")
    int updateUserPhoto(String username,String picture);
}
