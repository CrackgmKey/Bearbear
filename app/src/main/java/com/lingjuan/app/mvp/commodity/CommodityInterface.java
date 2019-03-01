package com.lingjuan.app.mvp.commodity;

import com.lingjuan.app.entity.Commodity;

/**
 * Created by TaoHui on 2018/10/5.
 */

public class CommodityInterface {
    public interface ObtainView{
        //获取数据状态回调的接口
        void LoadSuccess(Commodity commodity,int mid);
        //失败的接口
        void LoadFailed(String e);
    }

    public interface PreseView  {
        void showLoading();
        void hideLoading();
        void callbackData(Commodity commodity,int mid);
        void failed(String message);
        void showMessage(String message);
    }

    public static class CommodityPresenter implements CommodityInterface.ObtainView{
        private CommodityInterface.PreseView preseView;
        private CommodityModule commodityModule;

        public CommodityPresenter(PreseView preseView) {
            commodityModule = new CommodityModule(this);
            this.preseView = preseView;
        }

        @Override
        public void LoadSuccess(Commodity commodity,int mid) {
            preseView.hideLoading();
            preseView.callbackData(commodity,mid);

        }

        @Override
        public void LoadFailed(String e) {
            preseView.failed("出现不可抗力因素："+e);
        }

        //开始执行逻辑
        public void handledata(int mid) {
            preseView.showLoading();
            commodityModule.getData(mid);
        }
    }

}
