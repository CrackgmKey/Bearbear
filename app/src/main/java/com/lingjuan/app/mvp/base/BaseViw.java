package com.lingjuan.app.mvp.base;

/**
 * Created by TaoHui on 2018/10/9.
 */

public  interface BaseViw {

    //开启加载
    void showDialog();
    //结束加载
    void dissDialog();
    //提示内容
    void showMessage(String msg);

}
