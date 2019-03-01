package com.lingjuan.app.utils;

import java.util.List;
import java.util.concurrent.TimeUnit;

import com.lingjuan.app.api.ApiService;
import com.lingjuan.app.entity.AdvertisingData;
import com.lingjuan.app.entity.Commodity;
import com.lingjuan.app.entity.FunctionalCommodityRzy;
import com.lingjuan.app.entity.HookLopKey;
import com.lingjuan.app.entity.LotterytRzy;
import com.lingjuan.app.entity.OutHheNewsRzy;
import com.lingjuan.app.entity.ProducRzy;
import com.lingjuan.app.entity.PruchaseDetails;
import com.lingjuan.app.entity.PurchaseRzy;
import com.lingjuan.app.entity.Rusheeny;
import com.lingjuan.app.customview.DataHashMap;
import com.lingjuan.app.entity.SupclassLeft;
import com.lingjuan.app.entity.TResponse;
import com.lingjuan.app.entity.UpAppRzy;
import com.lingjuan.app.entity.UptoData;
import com.lingjuan.app.entity.UserTResponse;
import com.lingjuan.app.entity.WelldoneVideo;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * 请求基类
 * Created by TaoHui on 2018/10/5.
 */

public class HttpManage {
    public static String BASE_URL = "http://api.tkjidi.com/";
    private static final int DEFAULT_TIMEOUT = 10;
    private Retrofit retrofit;
    private ApiService apiService;

    private HttpManage() {
        //手动创建一个OkHttpClient并设置超时时间
        OkHttpClient.Builder httpClientBuilder = new OkHttpClient.Builder();
        httpClientBuilder.connectTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS);
        httpClientBuilder.connectTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS);
        httpClientBuilder.readTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS);
        httpClientBuilder.writeTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS);
        // 日志显示级别
        HttpLoggingInterceptor.Level level = HttpLoggingInterceptor.Level.BASIC;
        //新建log拦截器
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor(message -> LogManage.e("OkHttp====Message:" + message));
        loggingInterceptor.setLevel(level);
        //OkHttp进行添加拦截器loggingInterceptor
        httpClientBuilder.addInterceptor(loggingInterceptor);
        retrofit = new Retrofit.Builder()
                .client(httpClientBuilder.build())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .baseUrl(BASE_URL)
                .build();
        apiService = retrofit.create(ApiService.class);

    }


    //在访问HttpMethods时创建单例
    private static class SingletonHolder {
        private static final HttpManage INSTANCE = new HttpManage();
    }

    //获取单例
    public static HttpManage getInstance() {
        return SingletonHolder.INSTANCE;
    }

    /**
     * 获取首页最爱商品
     *
     * @param subscriber  回调接口
     * @param spicyhotMap 数据集合
     */
    public void getCommodityData(DataHashMap spicyhotMap, Subscriber<Commodity> subscriber) {
        apiService.getCommodityData(spicyhotMap).subscribeOn(Schedulers.io()).unsubscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(subscriber);
    }

    /**
     * 获取超级分类数据
     *
     * @param subscriber  回调接口
     * @param spicyhotMap 数据集合
     */
    public void getSuperClassLifeData(DataHashMap spicyhotMap, Subscriber<SupclassLeft> subscriber) {
        apiService.getSuperClassLifeData(spicyhotMap).subscribeOn(Schedulers.io()).unsubscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(subscriber);
    }

    /**
     * 获取抢购商品
     *
     * @param subscriber  回调接口
     * @param spicyhotMap 数据集合
     */
    public void getRushbuy(DataHashMap spicyhotMap, Subscriber<Rusheeny> subscriber) {
        apiService.getRushbuy(spicyhotMap).subscribeOn(Schedulers.io()).unsubscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(subscriber);
    }

    /**
     * 从淘客基地获取TOp100的商品
     *
     * @param subscriber 回调接口
     */
    public void getUptoTop100(int page, String type, Subscriber<UptoData> subscriber) {
        apiService.getUptoTop100(page, type).subscribeOn(Schedulers.io()).unsubscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(subscriber);
    }

    /**
     * 获取最新的视频推举
     *
     * @param subscriber 回调接口
     */
    public void getVideoData(Subscriber<WelldoneVideo> subscriber,int min_id) {
        apiService.getVideoData(min_id).subscribeOn(Schedulers.io()).unsubscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(subscriber);
    }

    /**
     * 获取最新的视频推举
     *
     * @param subscriber 回调接口
     */
    public void getHotKeyData(Subscriber<HookLopKey> subscriber) {
        apiService.getHotKeyData().subscribeOn(Schedulers.io()).unsubscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(subscriber);
    }

    /**
     * 获取最新的视频推举
     *
     * @param subscriber 回调接口
     */
    public void getProducData(Subscriber<ProducRzy> subscriber, @QueryMap DataHashMap spicyhotMap) {
        apiService.getProducData(spicyhotMap).subscribeOn(Schedulers.io()).unsubscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(subscriber);
    }

    /**
     * 获取单品详情
     *
     * @param spicyhotMap 数据map
     */
    public void getItemDetal(Subscriber<PurchaseRzy> subscriber, @QueryMap DataHashMap spicyhotMap) {
        apiService.getItemDetal(spicyhotMap).subscribeOn(Schedulers.io()).unsubscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(subscriber);
    }

    /**
     * 获取单品详情的图文介绍
     *
     * @param id 数据map
     */
    public void getItemDetails(Subscriber<PruchaseDetails> subscriber, @Query("id") String id) {
        apiService.getItemDetails(id).subscribeOn(Schedulers.io()).unsubscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(subscriber);
    }

    /**
     * 升级App
     */
    public void getUpdaApp(Subscriber<UpAppRzy> subscriber) {
        apiService.getUpdaApp().subscribeOn(Schedulers.io()).unsubscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(subscriber);
    }

    /**
     * 获取首页分类淘抢购数据
     */
    public void getRushtoBuy(Subscriber<FunctionalCommodityRzy> subscriber, @QueryMap DataHashMap spicyhotMap) {
        apiService.getRushtoBuy(spicyhotMap).subscribeOn(Schedulers.io()).unsubscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(subscriber);
    }

    /**
     * 用户注册
     */
    public void getRegUser(Subscriber<UserTResponse> subscriber, @QueryMap DataHashMap spicyhotMap) {
        apiService.getRegUser(spicyhotMap).subscribeOn(Schedulers.io()).unsubscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(subscriber);
    }

    /**
     * 用户登录
     */
    public void getUserLogin(Subscriber<TResponse> subscriber, @QueryMap DataHashMap spicyhotMap) {
        apiService.getUserLogin(spicyhotMap).subscribeOn(Schedulers.io()).unsubscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(subscriber);
    }
    /**
     * 获取积分够商品
     */
    public void getGambling(Subscriber<List<LotterytRzy>> subscriber, @QueryMap DataHashMap spicyhotMap) {
        apiService.getGambling(spicyhotMap).subscribeOn(Schedulers.io()).unsubscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(subscriber);
    }
    /**
     * 获取首页轮播
     */
    public void getAdvertising(Subscriber<AdvertisingData> subscriber, @QueryMap DataHashMap spicyhotMap) {
        apiService.getAdvertising(spicyhotMap).subscribeOn(Schedulers.io()).unsubscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(subscriber);
    }

    /**
     * 获取首页滚蛋消息
     */
    public void getGunDanData(Subscriber<OutHheNewsRzy> subscriber) {
        apiService.getGunDanData().subscribeOn(Schedulers.io()).unsubscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(subscriber);
    }
}
