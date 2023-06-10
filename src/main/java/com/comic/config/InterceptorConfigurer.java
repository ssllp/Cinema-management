package com.comic.config;

import com.comic.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.ArrayList;

// TODO: 2023/2/22 这个包

@Configuration //系统配置注解
public class InterceptorConfigurer implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        HandlerInterceptor hi = new LoginInterceptor();
        //加白名单，某些资源不做拦截
        ArrayList<String> list = new ArrayList<>();
        list.add("/user/login.html");
        list.add("/index.html");
        list.add("/user/userLogin");
        list.add("/user/userReg");
        list.add("/admin/login.html");
        list.add("/admin/login");
        list.add("/bootstrap3.3.7/*");
        list.add("/css/*");
        list.add("/font-awesome-4.7.0/*");
        list.add("/img/*");
        list.add("/film/*");
        list.add("/js/*");
        list.add("/my/*");

//        list.add("/user/*");
//        list.add("/admin/*");


        //添加拦截器，并在此基础上添加不被拦截的白名单集合
        registry.addInterceptor(hi).excludePathPatterns(list);
    }

}
