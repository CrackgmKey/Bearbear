package com.lingjuan.app.mvp.data.persenter;

import com.lingjuan.app.constant.Constant;
import com.lingjuan.app.customview.DataHashMap;
import com.lingjuan.app.entity.AdvertisingData;
import com.lingjuan.app.entity.OutHheNewsRzy;
import com.lingjuan.app.mvp.data.module.DataModule;
import com.lingjuan.app.mvp.data.view.DataView;
import com.lingjuan.app.utils.LogManage;

import java.util.ArrayList;
import java.util.List;

import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

/**
 * Created by TaoHui on 2018/12/21.
 */

public class DataPersenter implements DataView.Persenter {
    //当前层次
    private DataView.View view;
    //M层次
    private DataModule dataModule;

    public DataPersenter(DataView.View view) {
        this.view = view;
        dataModule = new DataModule(this);
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
    public void onSuccess(List<AdvertisingData.ResultBean> resultBeanList) {
        List<String> nameList = new ArrayList<String>();
        rx.Observable.just(resultBeanList).flatMap(resultBeans -> {
            List<String> picList = new ArrayList<>();
            for (AdvertisingData.ResultBean resultBean : resultBeanList) {
                picList.add(Constant.HTTP_PIC + resultBean.getPic());
                nameList.add(String.valueOf(resultBean.getName()));
            }
            return rx.Observable.just(picList);
        }).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(strings -> {

                    view.onSuccess(strings,nameList,resultBeanList);
                });
    }

    @Override
    public void getGoNewData(String acid) {
        dataModule.getData(acid);
        dataModule.getGunDOngData();
    }

    @Override
    public void onErrorMsg(String msg) {
        view.onErrorMsg(msg);
        LogManage.w(msg);
    }

    @Override
    public void onRollSuccess(List<OutHheNewsRzy.ResultBean> resultBeanList) {
        view.onRollSuccess(resultBeanList);
    }
}
