package com.lingjuan.app.mvp.video.view;

import com.lingjuan.app.entity.WelldoneVideo;
import com.lingjuan.app.mvp.base.BaseViw;

import java.util.List;

/**
 * Created by TaoHui on 2018/10/13.
 */

public class iVideo {

    public interface Data extends BaseViw{
        void onSoucces(List<WelldoneVideo.DataBean> dataBean,int mid);
        void onError(String msg);
    }

    public interface Pview extends BaseViw{
        void onSoucces(List<WelldoneVideo.DataBean> dataBean,int mid);
        void onError(String msg);
    }

}
