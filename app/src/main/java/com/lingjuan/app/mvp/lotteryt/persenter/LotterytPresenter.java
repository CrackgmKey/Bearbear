package com.lingjuan.app.mvp.lotteryt.persenter;

import com.lingjuan.app.entity.LotterytRzy;
import com.lingjuan.app.mvp.lotteryt.module.LotterytModule;
import com.lingjuan.app.mvp.lotteryt.view.LotterytInterface;

import java.util.List;

/**
 * Created by TaoHui on 2018/11/30.
 */

public class LotterytPresenter implements LotterytInterface.Presenter {
    private LotterytModule lotterytModule;
    private LotterytInterface.View view;

    public LotterytPresenter(LotterytInterface.View view) {
        this.view = view;
        lotterytModule = new LotterytModule(this);
    }

    @Override
    public void showDialog() {
        view.showDialog();
    }

    @Override
    public void dissDialog() {
        view.dissDialog();
    }

    @Override
    public void showMessage(String msg) {
        view.showMessage(msg);
    }

    @Override
    public void onFailMsg(String msg) {
        view.onFailMsg(msg);
    }

    @Override
    public void onSuccessData(List<LotterytRzy> lotterytRzyList) {
        view.onSuccessData(lotterytRzyList);
    }

    @Override
    public void onStartCrazy() {
        lotterytModule.onStartCrazy();
    }

    @Override
    public void onErrorMsg(String msg) {
        view.onErrorMsg(msg);
    }
}
