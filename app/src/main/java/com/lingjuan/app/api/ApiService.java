package com.lingjuan.app.api;


import com.lingjuan.app.constant.Constant;
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

import java.util.List;

import retrofit2.http.GET;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;
import rx.Observable;

/**
 * Created by TaoHui on 2018/10/5.
 */

public interface ApiService {
    //获取首页喜欢商品
    @GET(Constant.COMMODITY_LINK)
    Observable<Commodity> getCommodityData(@QueryMap DataHashMap spicyhotMap);

    //获取超级分类
    @GET(Constant.SUPER_CLASSIFICATION)
    Observable<SupclassLeft> getSuperClassLifeData(@QueryMap DataHashMap spicyhotMap);

    //获取超级分类
    @GET(Constant.RUSH_BUY_URL)
    Observable<Rusheeny> getRushbuy(@QueryMap DataHashMap spicyhotMap);

    //获取抢购数据
    @GET(Constant.TAOJD_TOP100)
    Observable<UptoData> getUptoTop100(@Query("page") int page, @Query("type") String type);

    //获取视频单数据
    @GET(Constant.DATA_VIDEO)
    Observable<WelldoneVideo> getVideoData(@Query("min_id") int min_id);

    //获取当前热搜记录
    @GET(Constant.HOT_KEY)
    Observable<HookLopKey> getHotKeyData();

    //获取搜索记录内容
    @GET(Constant.PRODCU_URL)
    Observable<ProducRzy> getProducData(@QueryMap DataHashMap spicyhotMap);

    //获取单品信息
    @GET(Constant.ITEM_DETAIL)
    Observable<PurchaseRzy> getItemDetal(@QueryMap DataHashMap spicyhotMap);

    //获取单品信息
    @GET(Constant.DATA_DETAIL)
    Observable<PruchaseDetails> getItemDetails(@Query("id") String id);
    //获取当前最新版本
    @GET(Constant.UPDATA_DETAIL)
    Observable<UpAppRzy> getUpdaApp();
    //获取分类模块的接口
    @GET(Constant.ACQUTIONOFPANIC_URL)
    Observable<FunctionalCommodityRzy> getRushtoBuy(@QueryMap DataHashMap spicyhotMap);
    //注册新用户
    @GET(Constant.APP_REG_USER)
    Observable<UserTResponse> getRegUser(@QueryMap DataHashMap spicyhotMap);
    //登录用户
    @GET(Constant.APP_LOGIN_USER)
    Observable<TResponse> getUserLogin(@QueryMap DataHashMap spicyhotMap);
    //获取0元购商品
    @GET(Constant.APP_GET_GAMBLING)
    Observable<List<LotterytRzy>> getGambling(@QueryMap DataHashMap spicyhotMap);
    //获取轮播图
    @GET(Constant.APP_GET_ADVERTISING)
    Observable<AdvertisingData> getAdvertising(@QueryMap  DataHashMap spicyhotMap);
    //获取滚动消息
    @GET(Constant.APP_GET_GUNDAN)
    Observable<OutHheNewsRzy> getGunDanData();
    //获取滚动消息
}
