package com.lingjuan.app.utils;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;

import com.alibaba.baichuan.android.trade.AlibcTrade;
import com.alibaba.baichuan.android.trade.model.AlibcShowParams;
import com.alibaba.baichuan.android.trade.model.OpenType;
import com.alibaba.baichuan.android.trade.page.AlibcBasePage;
import com.alibaba.baichuan.android.trade.page.AlibcDetailPage;
import com.alibaba.baichuan.android.trade.page.AlibcMyOrdersPage;
import com.alibaba.baichuan.android.trade.page.AlibcPage;
import com.alibaba.baichuan.android.trade.page.AlibcShopPage;
import com.alibaba.baichuan.trade.biz.core.taoke.AlibcTaokeParams;
import com.lingjuan.app.customview.DemoTradeCallback;

import java.util.HashMap;
import java.util.Map;

/**
 * 阿里百川工具类
 * @author: TaoHui
 * @date: 2019/1/18
 */
public class AlibcTradeSDKUtils {
    //页面打开方式，默认，H5，Native
    private static AlibcShowParams alibcShowParams;
    //淘客参数，包括pid，unionid，subPid
    private  static AlibcTaokeParams alibcTaokeParams = null;
    //是否是淘客商品类型
    private static Boolean isTaoke = false;
    //默认商品id
    private static String itemId = "522166121586";
    //yhhpass参数
    private static Map<String, String> exParams;


    public static void init(){
        alibcShowParams = new AlibcShowParams(OpenType.Native, false);
        alibcShowParams.setClientType("taobao_scheme");
      //  alibcShowParams = new AlibcShowParams(OpenType.Auto, false);
        exParams = new HashMap<>(16);
        exParams.put("isv_code", "appisvcode");
        exParams.put("alibaba", "阿里巴巴");
    }

    /**
     * @param url
     * 打开指定链接
     */
    public static void showUrl(String url, Activity context) {
        if(TextUtils.isEmpty(url)) {
            Toast.makeText(context, "URL为空", Toast.LENGTH_SHORT).show();
            return;
        }
        AlibcTrade.show(context, new AlibcPage(url), alibcShowParams, null, exParams ,new DemoTradeCallback());
    }

    /**
     * @param itemId
     * 显示商品详情页
     */
    public static void showDetail(String itemId, Activity context) {
        AlibcBasePage  alibcBasePage = new AlibcDetailPage(itemId.trim());
        alibcTaokeParams = new AlibcTaokeParams();
        alibcTaokeParams.setPid("mm_26632322_6858406_23810104");
        AlibcTrade.show(context, alibcBasePage, alibcShowParams, alibcTaokeParams, exParams , new DemoTradeCallback());

    }

    /**
     * @param context
     * 分域显示我的订单，或者全部显示我的订单
     */
    public static void showOrder(Activity context) {
        AlibcShowParams alibcShowParams = new AlibcShowParams(OpenType.H5, false);
        AlibcBasePage alibcBasePage = new AlibcMyOrdersPage(0, true);
        AlibcTrade.show(context, alibcBasePage, alibcShowParams, null, exParams, new DemoTradeCallback());
    }

}
