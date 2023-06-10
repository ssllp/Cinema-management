package com.comic.controller;

import com.comic.controller.ex.sessionisnullException;
import com.comic.util.JsonResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
/*
 * 将所有类的全局配置放在同一个位置*/
public class GlobalExceptionHandler {
    /*用于指定异常的处理方法，当和@RestControllerAdvice搭配使用是会触发全局异常处理，只要带有该注解的方法，就是处理
     * 异常的方法*/
    @ExceptionHandler
    public JsonResult<Void> handlerException(Throwable ex){
        JsonResult<Void> jsonResult=new JsonResult<>(ex);
        if (ex instanceof sessionisnullException){
            jsonResult.setState(4001);
        }
        return jsonResult;
    }
}