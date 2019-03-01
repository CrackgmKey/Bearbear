package com.lingjuan.app.mvp.data.module;

import com.lingjuan.app.constant.Constant;
import com.lingjuan.app.customview.DataHashMap;
import com.lingjuan.app.entity.AdvertisingData;
import com.lingjuan.app.entity.OutHheNewsRzy;
import com.lingjuan.app.mvp.data.view.DataView;
import com.lingjuan.app.utils.HttpManage;
import com.lingjuan.app.utils.LogManage;

import retrofit2.http.QueryMap;
import rx.Subscriber;

/**
 * 获取各种数据
 * Created by TaoHui on 2018/12/21.
 */

public class DataModule implements DataView.Module {
    private DataView.Persenter persenter;

    public DataModule(DataView.Persenter persenter) {
        this.persenter = persenter;
    }

    @Override
    public void getData(String cid) {
        persenter.showDialog();
        DataHashMap dataHashMap = new DataHashMap();
        dataHashMap.put("cid",cid);
        HttpManage.getInstance().getAdvertising(new Subscriber<AdvertisingData>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                persenter.dissDialog();
                persenter.onErrorMsg("=============发生错误："+e.toString());
            }

            @Override
            public void onNext(AdvertisingData resultBeans) {
                persenter.dissDialog();
                persenter.onSuccess(resultBeans.getResult());
            }
        },dataHashMap);
    }

    @Override
    public void getGunDOngData() {
        HttpManage.getInstance().getGunDanData(new Subscriber<OutHheNewsRzy>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(OutHheNewsRzy outHheNewsRzy) {
                persenter.onRollSuccess(outHheNewsRzy.getResult());
                persenter.dissDialog();
                LogManage.w("===打印内容："+outHheNewsRzy.toString());
            }
        });
    }
}
