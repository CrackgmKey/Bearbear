package com.lingjuan.app.entity;

/**
 * 消息类
 * Created by TaoHui on 2018/11/27.
 */

public class EventBusRzy<T> {
    //状态码
    private int code;
    //数据
    private T data;
    //用户登录成功刷新个人中心
    public final static int USER_LOGIIN = 1;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public EventBusRzy(int code, T data) {
        this.code = code;
        this.data = data;
    }

}
