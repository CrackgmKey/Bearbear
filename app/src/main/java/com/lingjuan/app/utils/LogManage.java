package com.lingjuan.app.utils;

import com.orhanobut.logger.Logger;

import com.lingjuan.app.constant.Constant;

/**
 * Created by TaoHui on 2018/10/6.
 */

public class LogManage{
    public static  void  d(String message){
        if(Constant.DEBUG){
            Logger.d(message);
        }
    }
    public static void e(String message){
        if(Constant.DEBUG){
            Logger.e(message);
        }
    }

    public static void v(String message){
        if(Constant.DEBUG){
            Logger.v(message);
        }
    }

    public static void w(String message){
        if(Constant.DEBUG){
           // Logger.w(message);
            System.out.println("日志："+message);
        }
    }
}
