package com.lingjuan.app.mvp.lotteryt.view;

import com.lingjuan.app.entity.LotterytRzy;
import com.lingjuan.app.mvp.base.BaseViw;

import java.util.List;

/**
 * 一元购商品
 * Created by TaoHui on 2018/11/29.
 */

public interface LotterytInterface {

     interface View extends BaseViw{
         //失败时候
        void onFailMsg(String msg);
        //成功时候
        void onSuccessData(List<LotterytRzy> lotterytRzyList);
         //错误的时候
         void onErrorMsg(String msg);
    }



    interface Presenter extends BaseViw{
        //失败时候
        void onFailMsg(String msg);
        //成功时候
        void onSuccessData(List<LotterytRzy> lotterytRzyList);
        //开启的时候
        void onStartCrazy();
        //错误的时候
        void onErrorMsg(String msg);
    }



    interface Module{
        //开启的时候
        void onStartCrazy();
    }
}
