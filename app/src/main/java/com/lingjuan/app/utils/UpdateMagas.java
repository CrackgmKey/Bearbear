package com.lingjuan.app.utils;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Environment;
import android.util.Log;

import com.lingjuan.app.constant.Constant;
import com.lingjuan.app.entity.UpAppRzy;
import com.lingjuan.app.entity.UserInfo;
import com.lingjuan.app.mvp.updata.Contract;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import rx.Subscriber;

/**
 * Created by TaoHui on 2018/10/28.
 */

public class UpdateMagas implements Contract.Presenter {
    private Contract.View contract;
    private Context context;
    public String url;
    public String appVersion = "0.0.0.0";
    public void setContract(Contract.View contract, Context context) {
        this.contract = contract;
        this.context = context;
    }


    public String getVersion(Context context) throws PackageManager.NameNotFoundException {
        return  appVersion = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
    }


    @Override
    public void getApkInfo() {
        try {
            appVersion = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
            HttpManage.getInstance().getUpdaApp(new Subscriber<UpAppRzy>() {
                @Override
                public void onCompleted() {

                }

                @Override
                public void onError(Throwable e) {

                }

                @Override
                public void onNext(UpAppRzy upAppRzy) {
                    if (!upAppRzy.getNew_version().equals(appVersion)) {
                        if(upAppRzy.getApk_file_url().startsWith("http")){
                            url =  upAppRzy.getApk_file_url();
                        }else {
                            url = Constant.HTTP_UPDATA + upAppRzy.getApk_file_url();
                        }
                        //更新客服QQ
                        Constant.USER_QQ_NUM = upAppRzy.getQq_num();
                        contract.downShow("最新版本："+upAppRzy.getNew_version(), upAppRzy.getUpdate_log(),upAppRzy.getUpdate());
                    }else {
                        LogManage.d("=====不需要更新");
                    }
                }
            });
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            contract.downFial();
        }
//        if (Build.VERSION.SDK_INT >= 23) {//如果是6.0以上的
//            int REQUEST_CODE_CONTACT = 101;
//            String[] permissions = {Manifest.permission.WRITE_EXTERNAL_STORAGE};
//            //验证是否许可权限
//            for (String str : permissions) {
//                if (MainActivity.this.checkSelfPermission(str) != PackageManager.PERMISSION_GRANTED) {
//                    //申请权限
//                    MainActivity.this.requestPermissions(permissions, REQUEST_CODE_CONTACT);
//                    return;
//                }
//            }
//        }

    }

    public void startApp() {
        new Thread(()-> getURL(url,contract)).start();
    }

    @Override
    public void downFile(String url) {

    }

    /**
     * 启动更新
     * @param apkurl
     */
    public void getURL(String apkurl,Contract.View callback) {
        try {
            //构建URL地址
            URL url = new URL(apkurl);
            try {
                //打开打开打开
                HttpURLConnection hcont = (HttpURLConnection) url.openConnection();
                //建立实际链接
                hcont.connect();
                //获取输入流内容
                InputStream is = hcont.getInputStream();
                //获取文件长度
                int max = hcont.getContentLength();
                //为进度条赋值
                callback.setMax(max);
                Log.d("---Main--","回调中的最大值===="+max);
                //手机存储地址
                File file  = new File(Environment.getExternalStorageDirectory(), "xiaxiong.apk");// 设置路径
                //写入文件
                OutputStream os = new FileOutputStream(file);
                int length;
                int lengtsh = 0;
                byte[] bytes = new byte[1024];
                while ((length = is.read(bytes)) != -1) {
                    os.write(bytes, 0, length);
                    //获取当前进度值
                    lengtsh += length;
                    //把值传给handler
                    callback.downLoading(lengtsh);
                    Log.d("---Main--","回调中的进度===="+max);
                }
                //关闭流
                is.close();
                os.close();
                os.flush();
                callback.downSuccess(file,"xiaxiong.apk");
            } catch (IOException e) {
                e.printStackTrace();
                LogManage.e("===============error"+e.toString());
            }

        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

}
