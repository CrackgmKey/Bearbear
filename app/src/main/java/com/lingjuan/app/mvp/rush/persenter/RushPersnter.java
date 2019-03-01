package com.lingjuan.app.mvp.rush.persenter;

import com.lingjuan.app.entity.Rusheeny;
import com.lingjuan.app.mvp.rush.model.RushModule;
import com.lingjuan.app.mvp.rush.view.RushInterface;
import com.lingjuan.app.utils.LogManage;

/**
 * Created by TaoHui on 2018/10/9.
 */

public class RushPersnter implements RushInterface.iView<Rusheeny> {
    private RushInterface.Pview pview;
    private RushModule rushModule;

    public RushPersnter(RushInterface.Pview pview) {
        this.pview = pview;
        rushModule = new RushModule();
        rushModule.setiView(this);


    }

    @Override
    public void RushCallback(Rusheeny rusheeny) {
        pview.dissDialog();
        LogManage.d("加载抢购数据成功："+rusheeny.toString());
        pview.RushCallback(rusheeny);
    }

    @Override
    public void RushError(String s) {
        pview.dissDialog();
        pview.RushError(s);
    }


    public void startData(String a,int b){
        LogManage.d("开始加载抢购数据");
        pview.showDialog();
        rushModule.getQequestData(a,b);
    }


}
