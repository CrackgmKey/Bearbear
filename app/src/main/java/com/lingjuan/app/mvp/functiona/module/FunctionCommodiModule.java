package com.lingjuan.app.mvp.functiona.module;

import com.lingjuan.app.entity.FunctionalCommodityRzy;
import com.lingjuan.app.customview.DataHashMap;
import com.lingjuan.app.mvp.functiona.view.FunctionCommodi;
import com.lingjuan.app.utils.HttpManage;

import rx.Subscriber;

/**
 * Created by TaoHui on 2018/11/3.
 */

public class FunctionCommodiModule implements FunctionCommodi.MView{
    private FunctionCommodi.PView view;
    @Override
    public void getData(DataHashMap spicyhotMap) {
        HttpManage.getInstance().getRushtoBuy(new Subscriber<FunctionalCommodityRzy>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                view.onError(e.toString());
            }

            @Override
            public void onNext(FunctionalCommodityRzy functionComm) {
                view.dataSuccess(functionComm.getData());
            }
        },spicyhotMap);
    }


    public FunctionCommodiModule(FunctionCommodi.PView view) {
        this.view = view;
    }
}
