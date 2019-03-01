package com.lingjuan.app.mvp.functiona.view;

import com.lingjuan.app.entity.FunctionalCommodityRzy;
import com.lingjuan.app.customview.DataHashMap;
import com.lingjuan.app.mvp.base.BaseViw;

import java.util.List;

/**
 * 商品分类功能页面
 * Created by TaoHui on 2018/11/3.
 */

public class FunctionCommodi {
  public   interface View extends BaseViw{
        //获取数据成功
        void dataSuccess(List<FunctionalCommodityRzy.DataBean.ListBean> functionComm);
        //失败的提示
        void onFaiMes(String msg);
    }

    public interface MView{
        //开始获取数据
        void getData(DataHashMap spicyhotMap);
    }

    public interface PView {
        //获取数据成功
        void dataSuccess(FunctionalCommodityRzy.DataBean functionComm);
        //获取失败
        void onError(String error);
        //开始获取数据
        void startData(DataHashMap spicyhotMap, int isType);
    }
}
