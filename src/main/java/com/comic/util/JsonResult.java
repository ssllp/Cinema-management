package com.comic.util;

public class JsonResult<T> {
    private Integer state;//请求状态码
    private String message;//返回到前端的消息
    private T data;//返回到前端的数据

    public JsonResult() {
        super();
    }

    public JsonResult(Integer state) {
        this.state = state;
    }

    public JsonResult(String message) {
        this.message = message;
    }
    public JsonResult(Throwable ex) {
        this.message = ex.getMessage();
    }

    public JsonResult(Integer state, T data) {
        this.state = state;
        this.data = data;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public JsonResult(Integer state, String message) {
        this.state = state;
        this.message = message;
    }

    public JsonResult(Integer state, String message, T data) {
        this.state = state;
        this.message = message;
        this.data = data;
    }
}


