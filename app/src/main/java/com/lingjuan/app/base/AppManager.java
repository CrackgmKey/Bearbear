package com.lingjuan.app.base;

import android.content.Context;
import android.graphics.Bitmap;
import android.widget.Toast;

import com.alibaba.baichuan.android.trade.AlibcTradeSDK;
import com.alibaba.baichuan.android.trade.callback.AlibcTradeInitCallback;
import com.lingjuan.app.utils.AlibcTradeSDKUtils;
import com.lingjuan.app.utils.GreenDaoUtils;
import com.lingjuan.app.utils.LogManage;
import com.mob.MobSDK;
import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.Logger;

import java.util.HashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.lingjuan.app.constant.Constant;
import com.squareup.picasso.LruCache;
import com.squareup.picasso.Picasso;
import com.tencent.bugly.crashreport.CrashReport;

/**
 * 管理Applica t i o n
 * Created by TaoHui on 2018/10/6.
 */

public class AppManager extends com.mob.MobApplication {
    public static Context context;
    @Override
    public void onCreate() {
        super.onCreate();
        //打印日志
        Logger.addLogAdapter(new AndroidLogAdapter());
        //分享排序
        Constant.MAP = new HashMap<>(16);
        //初始化数据库操作
        GreenDaoUtils.init(this);
        //初始化比目SDK
        MobSDK.init(this);
        context = this;
        //电商工具类初始化
        AlibcTradeSDKUtils.init();
        //电商SDK初始化
        AlibcTradeSDK.asyncInit(this, new AlibcTradeInitCallback() {
            @Override
            public void onSuccess() {
                Toast.makeText(AppManager.this, "初始化成功", Toast.LENGTH_SHORT).show();
                LogManage.d("初始化成功");
            }

            @Override
            public void onFailure(int code, String msg) {
                Toast.makeText(AppManager.this, "初始化失败,错误码="+code+" / 错误消息="+msg, Toast.LENGTH_SHORT).show();
                LogManage.d("初始化失败,错误码="+code+" / 错误消息="+msg);
            }
        });

        Picasso.Builder builder = new Picasso.Builder(this);
        //配置缓存
        LruCache cache = new LruCache(5*1024*1024);// 设置缓存大小
        builder.memoryCache(cache);
        //配置线程池
        ExecutorService executorService = Executors.newFixedThreadPool(8);
        builder.executor(executorService);
        //构造一个Picasso
        Picasso picasso = new Picasso.Builder(this)
                .defaultBitmapConfig(Bitmap.Config.RGB_565) // 设置全局的图片样式
                .loggingEnabled(true)
                .build();
        // 设置全局单列instance
        Picasso.setSingletonInstance(picasso);
        CrashReport.initCrashReport(getApplicationContext(), "f75f6ba801", true);
    }


    public static Context getContext() {
        return context;
    }
}
