package com.lingjuan.app.mvp.updata;

import java.io.File;

/**
 * Created by TaoHui on 2018/10/28.
 */

public class Contract {
    public interface View {
        //下载进度5
        void downLoading(int i);
        //下载完成6
        void downSuccess(File file, String apkName);
        //下载失败
        void downFial();
        //设置最大值4
        void setMax(int l);
        //发现新版本2
        void downShow(String title,String message,boolean updata);
        //开始下载3
        void downApp();
    }

    public interface Presenter {
        void getApkInfo();

        void downFile(String url);
    }
}
