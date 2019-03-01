package com.lingjuan.app.mvp.pruchase.persenter;

import com.lingjuan.app.entity.PruchaseDetails;
import com.lingjuan.app.entity.PurchaseRzy;
import com.lingjuan.app.mvp.pruchase.model.PurchaseModel;
import com.lingjuan.app.mvp.pruchase.view.PurchaseView;
import com.lingjuan.app.utils.LogManage;
import com.lingjuan.app.utils.WebImageUtils;

import java.util.ArrayList;
import java.util.List;

import rx.Observable;

/**
 * Created by TaoHui on 2018/10/25.
 */

public class PruchasePersnter implements PurchaseView.P {
    private PurchaseModel purchaseModel;
    private PurchaseView.V pview;

    public PruchasePersnter(PurchaseView.V pview) {
        this.pview = pview;
        purchaseModel = new PurchaseModel(this);
    }

    @Override
    public void feedbackData(PurchaseRzy.DataBean dataBean) {
        pview.SuccessfuData(dataBean);
    }

    @Override
    public void errorfeedback(String error) {
        pview.ErrorFeedback(error);
    }

    @Override
    public void successfufeedback(String successfu) {
        pview.showMessage(successfu);
    }

    @Override
    public void showLoad() {
        pview.showDialog();
    }

    @Override
    public void dissLoad() {
        pview.dissDialog();
    }

    @Override
    public void forTheglory(String tiemId) {
        purchaseModel.getData(tiemId);
    }

    @Override
    public void SuccessfuDataDetails(PruchaseDetails.WdescContentBean picdata) {
        List<String> picStr = new ArrayList<>();
        Observable.from(picdata.getPages()).subscribe(s -> {
            //"<img size=750x409>//img.alicdn.com/imgextra/i4/57027934/TB2WzvrXOMnBKNjSZFCXXX0KFXa_!!57027934.jpg</img>"
            //第一个角标位置
            int mark = s.indexOf(">") + 1;
            //第二个角标位置
            int endmark = s.indexOf("</img>");
            LogManage.e("=====开始截取详情字符串：" + s + "====第一角标在：" + mark + "====最后一个在：" + endmark);
            if(mark != -1 && endmark != -1){
                String src = s.substring(mark, endmark);
                picStr.add(src);
            }
        });
        StringBuilder stringBuffer = new StringBuilder();
        for (String pic : picStr) {
            String picxiugai = WebImageUtils.NAME.replace("*", pic);
            //  LogManage.e("=====匹配之后的字符串："+picxiugai);
            stringBuffer.append(picxiugai).append("\n");
        }
        pview.SuccessfuDataDetails(stringBuffer.toString());
    }
}
