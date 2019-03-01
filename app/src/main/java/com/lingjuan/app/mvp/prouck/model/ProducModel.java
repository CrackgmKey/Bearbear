package com.lingjuan.app.mvp.prouck.model;

import com.lingjuan.app.entity.ProducRzy;
import com.lingjuan.app.customview.DataHashMap;
import com.lingjuan.app.mvp.prouck.view.ProducContract;
import com.lingjuan.app.utils.HttpManage;

import rx.Subscriber;

/**
 * Created by TaoHui on 2018/10/18.
 */

public class ProducModel implements ProducContract.Model {
    private ProducContract.Presenter presenter;

    public ProducModel(ProducContract.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void getData(String msg,int sort,int is_tmall,int min_id) {
        DataHashMap spicyhotMap = DataHashMap.getInstance()
                .appParam("is_tmall",String.valueOf(is_tmall))
                .appParam("sort",String.valueOf(sort))
                .appParam("back","20")
                .appParam("min_id",String.valueOf(min_id))
                .appParam("keyword",msg).Builder();
        HttpManage.getInstance().getProducData(new Subscriber<ProducRzy>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                presenter.onFailedMsg(e.toString());
            }

            @Override
            public void onNext(ProducRzy producRzy) {
                presenter.onSuccess(producRzy);
            }
        },spicyhotMap);
    }
}
