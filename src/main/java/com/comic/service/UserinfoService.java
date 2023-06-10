package com.comic.service;

import com.comic.model.User;
import com.comic.model.Userinfo;

public interface UserinfoService {
    Userinfo selectuser(String user_id);
    boolean updateuserinfo(Userinfo userinfo, User user);
    void updateUserPwd(String username, String oldPassword, String newPassword);
    void changePhoto(String username,String photo);
}
