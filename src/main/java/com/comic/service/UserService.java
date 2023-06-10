package com.comic.service;

import com.comic.model.Info;
import com.comic.model.User;

import java.util.List;

public interface UserService {
    User logincheck(String username, String password, String is_admin);
    List<User> selectUserByPage(int start, int size);
    boolean updateUser(String username, String password, String tell, String is_admin, String user_id);
    User selectUser(String user_id);
    boolean addUser(String username, String password, String tell);
    boolean deleteUser(String user_id);
    List<User> searchUser(String search,int start, int size);
    int register(User user);
    Info showInfo();
}
