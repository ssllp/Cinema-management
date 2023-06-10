package com.comic.service.impl;

import com.comic.dao.UserDao;
import com.comic.dao.UserinfoDao;
import com.comic.model.User;
import com.comic.model.Userinfo;
import com.comic.service.UserinfoService;
import com.comic.service.ex.UserRegistered;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserinfoServiceImpl implements UserinfoService {
    @Autowired
    UserinfoDao userinfoDao;
    @Autowired
    UserDao userDao;
    @Override
    public Userinfo selectuser(String user_id) {
        return userinfoDao.selectuser(user_id);
    }

    @Override
    public boolean updateuserinfo(Userinfo userinfo,User user) {
        User result = userDao.findByUsername(user.getUsername());
        if(result==null){
            throw new UserRegistered("用户不存在");
        }
        userinfo.setUser_id(result.getUser_id());
//        System.err.println(resultUser);
        if(result!=null&&!(result.getUsername().equals(userinfo.getUsername()))){
            throw new UserRegistered("用户名("+userinfo.getUsername()+")已存在，无法修改为该用户名");
        }
        return userinfoDao.updateuserinfo(userinfo)==1?true:false;
    }
    public void updateUserPwd(String username, String oldPassword, String newPassword) {
        User result = userDao.findByUsername(username);
        if(result==null){
            throw new UserRegistered("用户不存在或用户名有误");
        }
        if(!(result.getPassword().equals(oldPassword))){
            throw new UserRegistered("原始密码有误，请重新输入");
        }
        System.out.println(newPassword);
        Integer rows = userDao.updateUserPassword(newPassword,result.getUser_id());
        if(rows!=1){
            throw new UserRegistered("系统错误，暂时无法修改");
        }
    }
    @Override
    public void changePhoto(String username,String photo) {
        User result =userDao.findByUsername(username);
        if(result==null){
            throw new UserRegistered("用户不存在");
        }
        int rows = userinfoDao.updateUserPhoto(username,photo);
        if(rows!=1){
            throw new UserRegistered("系统错误，暂时无法修改");
        }
    }
}
