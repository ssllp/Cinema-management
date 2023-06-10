package com.comic.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// TODO: 2023/2/22 这个包

//登录拦截器
public class LoginInterceptor implements HandlerInterceptor {
    //添加判定规则
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if(request.getSession().getAttribute("user1")==null&&request.getServletPath().substring(1,5).equals("user")){
            //response.sendRedirect("/index.html");
            response.sendRedirect("/user/login.html");
            return false;
        }
        if(request.getSession().getAttribute("user")==null&&request.getServletPath().substring(1,6).equals("admin")){
            //response.sendRedirect("/index.html");
            response.sendRedirect("/admin/login.html");
            return false;
        }
        return true;
    }
}
