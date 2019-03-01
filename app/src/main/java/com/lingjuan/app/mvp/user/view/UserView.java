package com.lingjuan.app.mvp.user.view;

import com.lingjuan.app.entity.UserInfo;
import com.lingjuan.app.mvp.base.BaseViw;

/**
 * Created by TaoHui on 2018/11/27.
 */

public class UserView {



    public interface M{
        //注册用户
        void userRegName(String phone,String code,String password);
        //登录用户
        void userLogin(String phone,String password);
    }

    public interface P{
        //成功操作
       void onSuccess(String msg,String phone);
        //成功操作
        void onSuccess(String msg,UserInfo phone);
       //失败了
       void onFail(String msg);
        //出现未知错误
        void onError(String error);
        //开启加载
        void showDialog();
        //结束加载
        void dissDialog();
        //注册
        void userReg(String phone,String code,String password);
        //登录
        void userLogin(String phone, String password);
    }


    public interface V extends BaseViw{
        //成功操作
        void onSuccess(String msg,String phone);
        //失败了
        void onFail(String msg);
        //出现未知错误
        void onError(String error);

    }
}
