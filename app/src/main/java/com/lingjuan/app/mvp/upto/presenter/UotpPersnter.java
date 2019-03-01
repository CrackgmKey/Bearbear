package com.lingjuan.app.mvp.upto.presenter;

import com.lingjuan.app.entity.Commodity;
import com.lingjuan.app.mvp.upto.model.UptoMoule;
import com.lingjuan.app.mvp.upto.view.UptoView;

import java.util.List;

/**
 * Created by TaoHui on 2018/10/10.
 */

public class UotpPersnter implements UptoView.pview {
    private UptoView.uptoview view;
    private UptoMoule moule;

    public UotpPersnter(UptoView.uptoview view) {
        this.view = view;
        moule = new UptoMoule(this);
    }

    @Override
    public void uptoSucceed(List<Commodity.CommodityData> dataBean) {
        view.dissDialog();
        view.uptoSucceed(dataBean);
        view.showMessage("加载成功");
    }

    @Override
    public void error(String e) {
        view.dissDialog();
        view.error(e);
    }


    public void SuccedGo(int page,String type,int mid){
        view.showDialog();
        moule.OpenUpsuccess(page,type,mid);
    }
}
