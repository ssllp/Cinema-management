package com.comic.controller;

import com.comic.model.Info;
import com.comic.model.Schedule;
import com.comic.model.User;
import com.comic.service.UserService;
import com.comic.util.JsonResult;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@RestController
public class userController {
    @Autowired
    UserService userService;
    @RequestMapping("/admin/login")
    public JsonResult<User> adminlogin(String username, String password, HttpSession session){

        User user=userService.logincheck(username,password,"是");
        if (user!=null){
            session.setAttribute("user",user);
            return new JsonResult<User>(1,user);
        }
        return new JsonResult<>(2);
    }
    List<User> userArrayList=new ArrayList<>();
    @RequestMapping("/admin/userlist")
    public PageInfo<User> showUserlist(String page,String search){
        int pageSize = 6;
        if (search.equals("nothing")){
            userArrayList =userService.selectUserByPage(Integer.parseInt(page),pageSize);
        }else{
            userArrayList =userService.searchUser(search,Integer.parseInt(page),pageSize);
        }
        PageInfo<User> pageInfo=new PageInfo<>(userArrayList);
        return pageInfo;
    }
    @RequestMapping("/admin/showusername")
    public User showusername(HttpSession session){
        User user= (User) session.getAttribute("user");
        if (user!=null){
            User newuser=new User();
            newuser.setUser_id(user.getUser_id());
            newuser.setUsername(user.getUsername());
            return newuser;
        }
        return null;
    }
    //增加用户
    @RequestMapping("/admin/addUser")
    public JsonResult<Void> add(String username,String password,String tell){
        if (userService.addUser(username,password,tell)){
            return new JsonResult<>(1);
        }
        return new JsonResult<>(2);
    }

    @RequestMapping("/admin/updateUser")
    public JsonResult<Void> update(String user_id,String username,String password,String tell,String is_admin){
        if (userService.updateUser(username,password,tell,is_admin,user_id)){
            return new JsonResult<>(1);
        }
        return new JsonResult<>(2);
    }
    @RequestMapping("/admin/selectUser")
    public JsonResult<User> selectUser(String user_id){

        if (userService.selectUser(user_id)!=null){
            return new JsonResult<>(1,userService.selectUser(user_id));
        }
        return new JsonResult<>(2);
    }
    @RequestMapping("/admin/deleteUser")
    public JsonResult<Void> update(String user_id){
        if (userService.selectUser(user_id).getUsername().equals("admin")){
            if (userService.deleteUser(user_id)){
                return new JsonResult<>(1);
            }
            else {
                return new JsonResult<>(2,"删除异常");
            }
        }

        return new JsonResult<>(2,"您是普通管理员，只有超级管理员有此权限！！！");
    }
    @RequestMapping("/admin/showInfo")
    public Info showInfo(){
        Info info=userService.showInfo();
        return info;
    }
    //用户登录
    @RequestMapping("/user/userLogin")
    public JsonResult<User> userLogin(String username, String password, HttpSession session){
        User user=userService.logincheck(username,password,"否");
        if (user!=null){
            session.setAttribute("user1",user);
            return new JsonResult<User>(1,user);
        }
        return new JsonResult<>(2,"登陆失败！用户名或密码有误");
    }

    //用户注册
    @RequestMapping("/user/userReg")
    public JsonResult<Void> userReg(String username,String tell,String password){
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setTell(tell);
        System.out.println(user);
        userService.register(user);
        return new JsonResult<>(1,username);
    }

}
