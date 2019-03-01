package com.lingjuan.app.mvp.upto.model;

import com.lingjuan.app.entity.Commodity;
import com.lingjuan.app.customview.DataHashMap;
import com.lingjuan.app.mvp.upto.view.UptoView;
import com.lingjuan.app.utils.LogManage;
import com.lingjuan.app.utils.HttpManage;

import rx.Subscriber;

/**
 * Created by TaoHui on 2018/10/10.
 */

public class UptoMoule {
    private UptoView.pview pview;

    public UptoMoule(UptoView.pview pview) {
        this.pview = pview;
    }

    public void OpenUpsuccess(int nav, String type,int min_id) {


        DataHashMap spicyhotMap = DataHashMap.getInstance()
                .appParam("apikey", "crackgmkey")
                .appParam("cid", "0")
                .appParam("back", "20")
                .appParam("min_id", String.valueOf(min_id))
                .appParam("back", "100")
                .appParam("sort", "11")
                .appParam("nav", String.valueOf(nav))
                .Builder();
        if (nav == 5) {
            spicyhotMap.appParam("nav", String.valueOf(3))
                    .appParam("price_max", String.valueOf(9.9))
                    .appParam("sort", "9");
        }

        HttpManage.getInstance().getCommodityData(spicyhotMap, new Subscriber<Commodity>() {
            @Override
            public void onCompleted() {
            }

            @Override
            public void onError(Throwable e) {
                LogManage.e("请求首页最新数据错误：" + e.toString());
                pview.error(e.toString());
            }

            @Override
            public void onNext(Commodity commodity) {
                LogManage.e("首页最新商品数据：" + commodity.getData().toString());
                pview.uptoSucceed(commodity.getData());
            }
        });

    }


}
