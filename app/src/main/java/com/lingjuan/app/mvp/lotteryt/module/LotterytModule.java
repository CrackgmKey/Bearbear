package com.lingjuan.app.mvp.lotteryt.module;

import com.lingjuan.app.customview.DataHashMap;
import com.lingjuan.app.entity.LotterytRzy;
import com.lingjuan.app.mvp.lotteryt.view.LotterytInterface;
import com.lingjuan.app.utils.HttpManage;

import java.util.List;

import rx.Subscriber;

/**
 * 积分购物
 * Created by TaoHui on 2018/11/30.
 */

public class LotterytModule implements LotterytInterface.Module {
    private LotterytInterface.Presenter presenter;

    public LotterytModule(LotterytInterface.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void onStartCrazy() {
        presenter.showDialog();
        DataHashMap dataHashMap = DataHashMap.getInstance().Builder();
        HttpManage.getInstance().getGambling(new Subscriber<List<LotterytRzy>>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                presenter.dissDialog();
                presenter.onErrorMsg(e.toString());
            }

            @Override
            public void onNext(List<LotterytRzy> lotterytRzyList) {
                presenter.dissDialog();
                if(lotterytRzyList.size() == 0){
                    presenter.onErrorMsg("暂无商品");
                }else {
                    presenter.onSuccessData(lotterytRzyList);
                }
            }
        },dataHashMap);
    }
}
