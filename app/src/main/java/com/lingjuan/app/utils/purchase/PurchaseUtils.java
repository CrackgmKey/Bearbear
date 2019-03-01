package com.lingjuan.app.utils.purchase;

import android.content.Context;
import android.widget.ImageView;
import android.widget.TextView;

import com.lingjuan.app.R;
import com.lingjuan.app.entity.AdvertisingData;
import com.lingjuan.app.entity.Commodity;
import com.lingjuan.app.entity.FootprintRzy;
import com.lingjuan.app.entity.FunctionalCommodityRzy;
import com.lingjuan.app.entity.ProducRzy;
import com.lingjuan.app.entity.PurchaseRzy;
import com.lingjuan.app.entity.Rusheeny;
import com.lingjuan.app.entity.WelldoneVideo;
import com.lingjuan.app.utils.DateUtils;
import com.lingjuan.app.utils.GlideImageLoader;
import com.lingjuan.app.utils.GsonUtil;
import com.youth.banner.Banner;
import com.youth.banner.Transformer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 商品详情页复杂View工具了你
 * Created by TaoHui on 2018/10/25.
 */

public class PurchaseUtils {
    /**
     * 设置轮播图
     * @param picList
     * @param banner
     */
    public static   void setUpThecast(List<String> picList, Banner banner) {
        //设置加载源
        banner.setImageLoader(new GlideImageLoader());
        //设置动画
        banner.setBannerAnimation(Transformer.Default);
        banner.setImages(picList);
        banner.setDelayTime(3000);
        banner.start();
    }

    /**
     * 转成商品详情类
     * @param json 数据
     * @return
     */
    public static PurchaseRzy.DataBean getJsonBean(FunctionalCommodityRzy.DataBean.ListBean json){
        PurchaseRzy.DataBean dataBean = GsonUtil.GsonToBean(GsonUtil.GsonString(json),PurchaseRzy.DataBean.class);
        //商品ID
        dataBean.setItemid(json.getGoods_id());
        //设置时间
        dataBean.setCouponendtime(DateUtils.dateToStamp(json.getCoupon_end_time()));
        //名字
        dataBean.setItemtitle(json.getGoods_short_title());
        //导购
        dataBean.setItemdesc(json.getGoods_introduce());
        //设置销量
        dataBean.setItemsale(json.getGoods_sales());
        //设置优惠价价格
        dataBean.setCouponmoney(String.valueOf(json.getCoupon_price()));
        dataBean.setSellernick("精品小店");

        //设置店铺
        dataBean.setShoptype(json.getIs_tmall().equals("1") ? "C":"B");
        return dataBean;
    }

    /**
     * 转成商品详情类
     * @param json 数据
     * @return
     */
    public static PurchaseRzy.DataBean getJsonBean(ProducRzy.DataBean json){
        return GsonUtil.GsonToBean(GsonUtil.GsonString(json),PurchaseRzy.DataBean.class);
    }

    /**
     * 转成商品详情类
     * @param json 数据
     * @return
     */
    public static PurchaseRzy.DataBean getJsonBean(AdvertisingData.ResultBean json){
        PurchaseRzy.DataBean dataBean = GsonUtil.GsonToBean(GsonUtil.GsonString(json),PurchaseRzy.DataBean.class);
        dataBean.setItemid(json.getUrl());
        return dataBean;
    }


    /**
     * 转成商品详情类
     * @param json 数据
     * @return
     */
    public static PurchaseRzy.DataBean getJsonBean(FootprintRzy json){
        return GsonUtil.GsonToBean(GsonUtil.GsonString(json),PurchaseRzy.DataBean.class);
    }


    /**
     * 转成商品详情类
     * @param json 数据
     * @return
     */
    public static PurchaseRzy.DataBean getJsonBean(Commodity.CommodityData json){
        return GsonUtil.GsonToBean(GsonUtil.GsonString(json),PurchaseRzy.DataBean.class);
    }

    /**
     * 转成商品详情类
     * @param json 数据
     * @return
     */
    public static PurchaseRzy.DataBean getJsonBean(WelldoneVideo.DataBean json){
        return GsonUtil.GsonToBean(GsonUtil.GsonString(json),PurchaseRzy.DataBean.class);
    }

    /**
     * 转成商品详情类
     * @param json 数据
     * @return
     */
    public static PurchaseRzy.DataBean getJsonBean(Rusheeny.DataBean json){
        return GsonUtil.GsonToBean(GsonUtil.GsonString(json),PurchaseRzy.DataBean.class);
    }

    /**
     * 设置商品详情数据
     * @param context
     * @param purchaseRzy
     * @param icons
     * @param banner
     * @param text
     */
    public static void assignmentText(Context context,PurchaseRzy.DataBean purchaseRzy,ImageView businesstype,ImageView icons,Banner banner,TextView... text){
        //设置标题
        text[0].setText(String.valueOf(purchaseRzy.getItemtitle()));
        //设置导购
        text[1].setText(String.valueOf(purchaseRzy.getItemdesc()));
        //设置卷后价
        text[2].setText(String.valueOf(purchaseRzy.getItemendprice())+"元");
        //设置销量
        text[3].setText(String.valueOf(context.getResources().getString(R.string.monthlysales,purchaseRzy.getItemsale())));
        //设置优惠券价格
        text[4].setText(String.valueOf(purchaseRzy.getCouponmoney())+"元");
        //设置使用时间
        text[5].setText(String.valueOf(context.getResources().getString(R.string.couponstarttime,DateUtils.time(purchaseRzy.getCouponendtime()))));
        //设置可以状态
        if(DateUtils.isDataTime(purchaseRzy.getCouponendtime())){
            text[6].setText(String.valueOf(context.getResources().getString(R.string.keyong)));
        }else {
            text[6].setText(String.valueOf(context.getResources().getString(R.string.bukekeyong)));
        }
        //设置店铺名称
        text[7].setText(String.valueOf(purchaseRzy.getSellernick()));
        //设置店铺类型
        int iamgeId = purchaseRzy.getShoptype().equals("B") ? R.mipmap.commodity_shop_info_tmall:R.mipmap.commodity_shop_info_taobao;
        businesstype.setBackgroundResource(iamgeId);
        //设置图标
        int iconsId =  purchaseRzy.getShoptype().equals("B") ? R.mipmap.commodity_shop_tmall:R.mipmap.commodity_shop_taobao;
        icons.setBackgroundResource(iconsId);
        //设置轮播图
        List<String> picList = new ArrayList<>();
        if(purchaseRzy.getTaobao_image() != null){
            picList.addAll(Arrays.asList(purchaseRzy.getTaobao_image().split(",")));
        }else {
            picList.add(purchaseRzy.getItempic());
        }
        setUpThecast(picList,banner);
    }


}
