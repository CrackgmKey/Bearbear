package com.lingjuan.app.mvp.functiona.presenter;

import com.lingjuan.app.entity.FunctionalCommodityRzy;
import com.lingjuan.app.customview.DataHashMap;
import com.lingjuan.app.mvp.functiona.view.FunctionCommodi;
import com.lingjuan.app.mvp.functiona.module.FunctionCommodiModule;

/**
 * Created by TaoHui on 2018/11/3.
 */

public class FunctionCommodiPersenter implements FunctionCommodi.PView {
    private FunctionCommodiModule functionCommodiModule;
    private FunctionCommodi.View view;

    public FunctionCommodiPersenter(FunctionCommodi.View view) {
        this.view = view;
        functionCommodiModule = new FunctionCommodiModule(this);
    }

    @Override
    public void dataSuccess(FunctionalCommodityRzy.DataBean functionComm) {
        view.dissDialog();
        view.dataSuccess(functionComm.getList());
    }

    @Override
    public void onError(String error) {
        view.dissDialog();
        view.onFaiMes(error);
    }

    @Override
    public void startData(DataHashMap spicyhotMap, int isType){
        view.showDialog();
        functionCommodiModule.getData(spicyhotMap);
    }
}
