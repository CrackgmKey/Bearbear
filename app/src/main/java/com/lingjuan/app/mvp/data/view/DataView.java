package com.lingjuan.app.mvp.data.view;

import com.lingjuan.app.customview.DataHashMap;
import com.lingjuan.app.entity.AdvertisingData;
import com.lingjuan.app.entity.OutHheNewsRzy;
import com.lingjuan.app.mvp.base.BaseViw;

import java.util.List;

/**
 * Created by TaoHui on 2018/12/21.
 */

public class DataView {

    public interface View extends BaseViw{
        void onSuccess(List<String> stringList,List<String> nameList,List<AdvertisingData.ResultBean> resultBeanList);
        //错误情况
        void onErrorMsg(String msg);
        //接收回调结果
        void onRollSuccess(List<OutHheNewsRzy.ResultBean> resultBeanList);
    }

    public interface Persenter extends BaseViw{
        //接收回调结果
        void onSuccess(List<AdvertisingData.ResultBean> resultBeanList);
        //开始网络请求
        void getGoNewData(String cid);
        //错误情况
        void onErrorMsg(String msg);
        //接收回调结果
        void onRollSuccess(List<OutHheNewsRzy.ResultBean> resultBeanList);
    }

    public interface Module{
        //请求轮播图片
        void getData(String cid);
        //获取滚动消息
        void getGunDOngData();
    }
}
