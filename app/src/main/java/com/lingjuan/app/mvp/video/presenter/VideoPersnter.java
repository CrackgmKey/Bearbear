package com.lingjuan.app.mvp.video.presenter;

import com.lingjuan.app.entity.WelldoneVideo;
import com.lingjuan.app.mvp.video.model.VideoModel;
import com.lingjuan.app.mvp.video.view.iVideo;

import java.util.List;

/**
 * Created by TaoHui on 2018/10/13.
 */

public class VideoPersnter implements iVideo.Data{
    private VideoModel videoModel;
    private iVideo.Pview pview;

    public VideoPersnter(iVideo.Pview pview) {
        this.pview = pview;
        videoModel = new VideoModel();
        videoModel.setDataview(this);
    }

    public void startVideo(int min_id){
        videoModel.getVideom(min_id);
    }

    @Override
    public void onSoucces(List<WelldoneVideo.DataBean> dataBean,int mid) {
        pview.onSoucces(dataBean,mid);
    }

    @Override
    public void onError(String msg) {
        pview.onError(msg);
    }

    @Override
    public void showDialog() {
        pview.showDialog();
    }

    @Override
    public void dissDialog() {
        pview.dissDialog();
    }

    @Override
    public void showMessage(String msg) {
        pview.showMessage(msg);
    }
}
