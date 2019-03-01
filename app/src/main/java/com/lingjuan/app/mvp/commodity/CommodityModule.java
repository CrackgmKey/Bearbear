package com.lingjuan.app.mvp.commodity;

import com.lingjuan.app.entity.Commodity;
import com.lingjuan.app.customview.DataHashMap;
import com.lingjuan.app.utils.HttpManage;
import com.lingjuan.app.utils.LogManage;

import rx.Subscriber;

/**
 * 拯救世界
 * Created by TaoHui on 2018/10/5.
 */

public class CommodityModule {
    public  CommodityInterface.ObtainView commodityInterface;

    public CommodityModule(CommodityInterface.ObtainView commodityInterface) {
        this.commodityInterface = commodityInterface;
    }

    public void getData(int mid){
        DataHashMap spicyhotMap = DataHashMap.getInstance()
                .appParam("apikey","crackgmkey")
                .appParam("nav","3")
                .appParam("cid","11")
                .appParam("back","50")
                .appParam("sort","4")
                .appParam("min_id",String.valueOf(mid))
                .Builder();

        HttpManage.getInstance().getCommodityData(spicyhotMap, new Subscriber<Commodity>() {
            @Override
            public void onCompleted() {
            }
            @Override
            public void onError(Throwable e) {
                LogManage.e("请求首页最新数据错误："+e.toString());
                commodityInterface.LoadFailed(e.toString());
            }
            @Override
            public void onNext(Commodity commodity) {
                LogManage.e("首页最新商品数据："+commodity.getData().toString());
                commodityInterface.LoadSuccess(commodity,mid);
            }
        });
    }
}
