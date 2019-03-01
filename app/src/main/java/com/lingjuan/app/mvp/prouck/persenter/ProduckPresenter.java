package com.lingjuan.app.mvp.prouck.persenter;

import com.lingjuan.app.entity.ProducRzy;
import com.lingjuan.app.mvp.prouck.model.ProducModel;
import com.lingjuan.app.mvp.prouck.view.ProducContract;

/**
 * Created by TaoHui on 2018/10/18.
 */

public class ProduckPresenter implements ProducContract.Presenter {
    private ProducModel producModel;
    private ProducContract.View view;

    public ProduckPresenter(ProducContract.View view) {
        this.view = view;
        producModel = new ProducModel(this);
    }

    @Override
    public void onFailedMsg(String error) {
        view.onFailedMsg(error);
    }

    @Override
    public void onSuccess(ProducRzy userBean) {
        view.dissDialog();
        view.onSuccess(userBean.getData(),userBean.getMin_id());
    }

    @Override
    public void getData(String msg,int sort,int is_tmall,int min_id) {
        view.showDialog();
        producModel.getData(msg,sort,is_tmall,min_id);
    }
}
