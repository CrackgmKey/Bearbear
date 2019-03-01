package com.lingjuan.app.mvp.video.model;

import com.lingjuan.app.customview.DataHashMap;
import com.lingjuan.app.entity.WelldoneVideo;
import com.lingjuan.app.mvp.video.view.iVideo;
import com.lingjuan.app.utils.HttpManage;

import retrofit2.http.QueryMap;
import rx.Subscriber;

/**
 * Created by TaoHui on 2018/10/13.
 */

public class VideoModel {
    private iVideo.Data dataview;


    public void setDataview(iVideo.Data dataview) {
        this.dataview = dataview;
    }


    public void getVideom(int mid){
        dataview.showDialog();
        HttpManage.getInstance().getVideoData(new Subscriber<WelldoneVideo>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                dataview.dissDialog();
                dataview.onError(e.toString());
            }

            @Override
            public void onNext(WelldoneVideo dataBean) {
                dataview.dissDialog();
                dataview.onSoucces(dataBean.getData(),dataBean.getMin_id());
            }
        },mid);
    }



}
