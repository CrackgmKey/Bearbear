package com.lingjuan.app.mvp.pruchase.model;

import com.lingjuan.app.entity.PruchaseDetails;
import com.lingjuan.app.entity.PurchaseRzy;
import com.lingjuan.app.customview.DataHashMap;
import com.lingjuan.app.mvp.pruchase.view.PurchaseView;
import com.lingjuan.app.utils.HttpManage;

import rx.Subscriber;

/**
 * Created by TaoHui on 2018/10/25.
 */

public class PurchaseModel implements PurchaseView.M {
    PurchaseView.P p;

    public PurchaseModel(PurchaseView.P p) {
        this.p = p;
    }

    @Override
    public void getData(String itemID) {
        p.showLoad();
        DataHashMap spicyhotMap = new DataHashMap();
        spicyhotMap .put("itemid",itemID);
        spicyhotMap. put("apikey","crackgmkey");
        HttpManage.getInstance().getItemDetal(new Subscriber<PurchaseRzy>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                p.dissLoad();
                p.errorfeedback(e.toString());
            }

            @Override
            public void onNext(PurchaseRzy dataBean) {
                p.feedbackData(dataBean.getData());
                //获取商品图文接口
                getDataDetails(itemID);
            }
        },spicyhotMap);
    }

    @Override
    public void getDataDetails(String itemID) {
        HttpManage.getInstance().getItemDetails(new Subscriber<PruchaseDetails>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                p.dissLoad();
              /*  if(e instanceof HttpException){
                    ResponseBody body = ((HttpException) e).response().errorBody();
                    try {
                        p.errorfeedback(body.string());
                    } catch (IOException IOe) {
                        IOe.printStackTrace();
                    }
                }*/
               // getDataDetails(itemID);
            }

            @Override
            public void onNext(PruchaseDetails dataBean) {
                p.SuccessfuDataDetails(dataBean.getWdescContent());
                p.dissLoad();
            }
        },itemID);
    }
}
