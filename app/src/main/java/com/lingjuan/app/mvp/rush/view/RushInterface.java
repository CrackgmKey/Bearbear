package com.lingjuan.app.mvp.rush.view;

import com.lingjuan.app.mvp.base.BaseViw;

/**
 * Created by TaoHui on 2018/10/9.
 */

public interface RushInterface {

     interface iView<T>{
        void RushCallback(T t);
        void RushError(String s);
    }

    interface Pview<T> extends BaseViw{
        void RushCallback(T t);
        void RushError(String s);
    }


    interface Dview{
        void getQequestData(String hour_type,int min_id);
    }
}
