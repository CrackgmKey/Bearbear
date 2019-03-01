package com.lingjuan.app.mvp.reg.view;

import com.lingjuan.app.mvp.base.BaseViw;

/**
 *
 * Created by TaoHui on 2018/11/8.
 */

public class Reg {
  public   interface P{
        //失败的时候
        void onFailMsg(String errormsg);
        //成功的时候
        void onSuccess(String msg);
        //开始注册
        void startReg(String photo);
    }
    public  interface V extends BaseViw{
        //失败的时候
        void onFailMsg(String errormsg);
        //成功的时候
        void onSuccess(String msg);
        //获取文本
        void getText();
    }
    public interface M{
        //注册用户名
        void regUser(String user,String photo);

    }
}
