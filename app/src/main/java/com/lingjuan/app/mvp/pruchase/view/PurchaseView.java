package com.lingjuan.app.mvp.pruchase.view;

import com.lingjuan.app.entity.PruchaseDetails;
import com.lingjuan.app.entity.PurchaseRzy;
import com.lingjuan.app.mvp.base.BaseViw;

/**
 * Created by TaoHui on 2018/10/25.
 */

public class PurchaseView {
    public interface M{
        void getData(String itemID);
        void getDataDetails(String itemID);
    }

    public interface P{
        //接收数据
        void feedbackData(PurchaseRzy.DataBean dataBean);
        //错误提示
        void errorfeedback(String error);
        //成功提示
        void successfufeedback(String successfu);
        //开始弹窗
        void showLoad();
        //开始弹窗
        void dissLoad();
        //开始请求
        void forTheglory(String tiemId);
        void SuccessfuDataDetails(PruchaseDetails.WdescContentBean picdata);
    }

    public interface V extends BaseViw{
        void SuccessfuData(PurchaseRzy.DataBean dataBean);
        void SuccessfuDataDetails(String picdata);
        void ErrorFeedback(String msgn);
    }
}
