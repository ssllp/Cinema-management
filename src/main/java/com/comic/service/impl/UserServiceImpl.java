package com.comic.service.impl;

import com.comic.dao.CinemaDao;
import com.comic.dao.FilmDao;
import com.comic.dao.OrderDao;
import com.comic.dao.UserDao;

import com.comic.model.Info;
import com.comic.model.Order;
import com.comic.model.User;
import com.comic.service.CinemaService;
import com.comic.service.FilmService;
import com.comic.service.OrderService;
import com.comic.service.UserService;
import com.comic.service.ex.UserRegistered;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserDao userDao;
    @Autowired
    FilmDao filmDao;
    @Autowired
    OrderDao orderDao;
    @Autowired
    CinemaDao cinemaDao;
    @Override
    public User logincheck(String username, String password, String is_admin) {
        return userDao.logincheck(username,password,is_admin);
    }

    @Override
    public List<User> selectUserByPage(int start, int size) {
        PageHelper.startPage(start,size);
        return userDao.selectUserByPage();
    }

    @Override
    public boolean updateUser(String username, String password, String tell, String is_admin, String user_id) {
        return userDao.updateUser(username,password,tell,is_admin,user_id)==1?true:false;
    }

    @Override
    public User selectUser(String user_id) {
        return userDao.selectUser(user_id);
    }

    @Override
    public boolean addUser(String username, String password, String tell) {
        User user=userDao.findByUsername(username);
        if(user!=null){
            throw new UserRegistered("您尝试注" +
                    "册的用户名"+username+"已被注册,请重试!");
        }else {
            return userDao.addUser(username,password,tell)==1?true:false;
        }
    }

    @Override
    public boolean deleteUser(String user_id) {
        return userDao.deleteUser(user_id)==1?true:false;
    }

    @Override
    public List<User> searchUser(String search,int start, int size) {
        search='%'+search+'%';
        PageHelper.startPage(start,size);
        return userDao.searchUser(search);
    }


    @Override
    public int register(User user) {
        String username = user.getUsername();
        User result = userDao.findByUsername(username);
        if(result!=null){
            throw new UserRegistered("用户名"+username+"已存在，无法注册该用户名！");
        }
        User regUser = new User();
        regUser.setUsername(username);
        regUser.setPassword(user.getPassword());
        regUser.setTell(user.getTell());
        regUser.setIs_admin("否");
        regUser.setIs_member("否");
        Integer rows = userDao.addUser(regUser.getUsername(),regUser.getPassword(),regUser.getTell());
        if(rows!=1){
            System.err.println("用户注册失败，请查找原因！");
            throw new UserRegistered("服务器异常，请等待维护！");
        }
        return rows;
    }

    @Override
    public Info showInfo() {
        Info info=new Info();
        info.setCinemaCount(cinemaDao.count());
        info.setFilmCount(filmDao.count());
        info.setUserCount(userDao.count());
        info.setOrderCount(orderDao.count());
        info.setFilmList(filmDao.selectorderby());
        return info;
    }
}
