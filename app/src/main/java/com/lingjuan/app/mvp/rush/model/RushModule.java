package com.lingjuan.app.mvp.rush.model;

import com.lingjuan.app.entity.Rusheeny;
import com.lingjuan.app.customview.DataHashMap;
import com.lingjuan.app.mvp.rush.view.RushInterface;
import com.lingjuan.app.utils.HttpManage;
import rx.Subscriber;

/**
 * Created by TaoHui on 2018/10/9.
 */

public class RushModule implements RushInterface.Dview {
    private RushInterface.iView iView;

    public void setiView(RushInterface.iView iView) {
        this.iView = iView;
    }

    @Override
    public void getQequestData(String hour_type, int min_id) {
        DataHashMap spicyhotMap = DataHashMap.getInstance()
                .appParam("hour_type",hour_type)
                .appParam("min_id",String.valueOf(min_id))
                .Builder();
        HttpManage.getInstance().getRushbuy(spicyhotMap, new Subscriber<Rusheeny>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                iView.RushError(e.toString());
            }

            @Override
            public void onNext(Rusheeny rusheeny) {
                iView.RushCallback(rusheeny);
            }

        });
    }
}
