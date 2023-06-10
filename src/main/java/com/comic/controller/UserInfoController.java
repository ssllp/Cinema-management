package com.comic.controller;

import com.comic.controller.ex.sessionisnullException;
import com.comic.model.Order;
import com.comic.model.ShowUserInfo;
import com.comic.model.User;
import com.comic.model.Userinfo;
import com.comic.service.OrderService;
import com.comic.service.UserinfoService;
import com.comic.util.JsonResult;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
public class UserInfoController {
    @Autowired
    UserinfoService userinfoService;
    @Autowired
    OrderService orderService;
    @RequestMapping("/user/showuserinfo")
    public ShowUserInfo showUserInfo(String page,HttpSession session){
        User user= (User) session.getAttribute("user1");
        Userinfo userinfo=userinfoService.selectuser(user.getUser_id());
        List<Order> orderList= orderService.selectbyuser(user.getUser_id(), Integer.parseInt(page),6);
        PageInfo<Order> pageInfo=new PageInfo<>(orderList);
        ShowUserInfo showUserInfo=new ShowUserInfo();
        showUserInfo.setUserinfo(userinfo);
        showUserInfo.setOrderList(pageInfo);
        return showUserInfo;

    }


    //修改个人信息控制器
    @RequestMapping("/user/updateUserInfo")
    public JsonResult<Userinfo> changeUserInfo(String username, String email, String sex, String signature, String photo, HttpSession session){
        Userinfo userinfo = new Userinfo();
        userinfo.setUsername(username);
        userinfo.setEmail(email);
        if(!(sex.equals("男")||sex.equals("女"))){
            userinfo.setSex("未知");
        }else{
            userinfo.setSex(sex);
        }
        System.out.println(photo);
        userinfo.setSignature(signature);
        userinfo.setPicture(photo);
        User oldUser = (User) session.getAttribute("user1");

        boolean re = userinfoService.updateuserinfo(userinfo,oldUser);
        if(re==false){
            return new JsonResult<>(2);
        }
        User user = oldUser;
        user.setUsername(username);
        session.setAttribute("user",user);
        return new JsonResult<>(1);
    }

    //修改密码控制器
    @RequestMapping("/changeUserPwd")
    public JsonResult<User> changeUserPwd(String username,String old_password,String new_password){
        userinfoService.updateUserPwd(username,old_password,new_password);
        return new JsonResult<>(1);
    }

    //上传文件大小 1M
    private static final long PHOTO_MAX_SIZE = 1024 * 1024;

    //上传文件的类型 jpg gif png bmp jpeg
    private static final ArrayList<String> PHOTO_TYPE = new ArrayList<>();
    static {
        PHOTO_TYPE.add("image/jpg");
        PHOTO_TYPE.add("image/gif");
        PHOTO_TYPE.add("image/png");
        PHOTO_TYPE.add("image/bmp");
        PHOTO_TYPE.add("image/jpeg");
    }

    //上传头像
    @PostMapping("/changeUserPhoto")
    public JsonResult<String> changeUserPhoto(MultipartFile file, HttpSession session){
        //判断用户上传文件是否为空
        boolean isEmpty = file.isEmpty();
        //isEmpty默认为true，也就是null
        if(isEmpty){
            throw new sessionisnullException("请选择您要上传的文件！");
        }
        //获取文件大小
        long size = file.getSize();
        //输出查验
        System.err.println("上传的文件大小："+size/1024+"KB");
        //判定文件是否超过了规定的大小
        if(size>PHOTO_MAX_SIZE){
            //提醒用户文件过大
            throw new sessionisnullException("上传失败！不允许上传超过"+PHOTO_MAX_SIZE/1024+"KB的文件！");
        }
        //获取文件扩展名(后缀)
        String contentType = file.getContentType();
        //输出查看
        System.err.println("上传的文件后缀："+contentType);
        //判定是否符合文件类型
        if(!PHOTO_TYPE.contains(contentType)){
            throw new sessionisnullException("上传失败！仅允许上传以下类型的文件："+PHOTO_TYPE);
        }
        //获取原始文件名(客户端设备中的文件名) 文件名.后缀
        String filename = file.getOriginalFilename();
        //输出查验
        System.err.println("原始文件名："+filename);
        //指定存储的路径
        //通过Servlet容器对象获取目标路径
        String path = session.getServletContext().getRealPath("upload");
        File dir = new File(path);
        System.out.println(path);
        //判定该目录是否存在
        if(!dir.exists()){
            //若不存在则创建一个目录
            dir.mkdir();
        }
        //解决文件名有可能重复的问题，改名操作
        //System.currentTimeMillis() 获取系统毫秒数，从1970年1月1日至今
        String newFileName = ""+System.currentTimeMillis()+ UUID.randomUUID();
        //保留原有名字
        String suffix="";
        //先获取.最后出现的下标，subString截取文件名
        int index = filename.lastIndexOf(".");
        if(index>=1){
            suffix = filename.substring(index);
        }
        System.out.println("后缀名为："+suffix);
        //最终文件名
        String endName = newFileName+suffix;
        //将文件保存至服务端
        File save = new File(path,endName);
        try {
            //写入文件操作
            file.transferTo(save);
        }catch (IOException e){
            //抛出读写错误异常
            throw new sessionisnullException("上传失败！出现文件读写错误！请重新上传！");
        }catch (IllegalStateException e){
            //抛出文件状态异常
            throw new sessionisnullException("上传失败！您的文件状态出现异常！请重试！");
        }
        //将保存文件的路径记录到数据库中
        String avatar =endName;
        //输出查看文件路径
        System.err.println("文件保存路径："+avatar);
        //获取当前登录的用户名
        User user = (User) session.getAttribute("user1");
        String username = user.getUsername();
        userinfoService.changePhoto(username,avatar);

        return new JsonResult<>(1,avatar);
    }
    @RequestMapping("/tuipiao")
    public JsonResult<Void> tuipiao(String order_id){
        orderService.updateorder("已退票", Integer.parseInt(order_id));
        return new JsonResult<>(1);
    }
}
