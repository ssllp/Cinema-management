package com.comic.dao;

import com.comic.model.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Mapper
public interface UserDao{
    @Select("select * from users where username=#{username}")
    User findByUsername(String username);
    @Select("select * from users where username=#{username} and password=#{password} and is_admin=#{is_admin}")
    User logincheck(String username, String password, String is_admin);
    @Select("SELECT * FROM users ")
    List<User> selectUserByPage();
    @Update("UPDATE users SET username = #{username} , password = #{password} , tell = #{tell} ,is_admin=#{is_admin} WHERE user_id=#{user_id};")
    int updateUser(String username, String password, String tell, String is_admin, String user_id);
    @Select("select * from users where user_id=#{user_id}")
    User selectUser(String user_id);
    @Insert("insert into users (username,password,tell) values (#{username},#{password},#{tell})")
    int addUser(String username, String password, String tell);
    @Delete("delete from users where user_id=#{user_id}")
    int deleteUser(String user_id);
    @Select("select * from users where username like #{search} or user_id like #{search} or tell like #{search} ")
    List<User> searchUser(String search);
    @Select("select count(*) from users")
    int count();//获取记录数量
    @Update("update users set password=#{password} where user_id=#{user_id}")
    int updateUserPassword(String password,String user_id);
}
