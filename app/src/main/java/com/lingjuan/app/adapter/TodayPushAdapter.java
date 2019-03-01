package com.lingjuan.app.adapter;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.lingjuan.app.R;
import com.lingjuan.app.entity.Commodity;
import com.lingjuan.app.utils.PicassomageUtils;

import java.util.List;

/**
 * Created by TaoHui on 2018/10/22.
 */

public class TodayPushAdapter extends BaseQuickAdapter<Commodity.CommodityData,BaseViewHolder> {
    public TodayPushAdapter(@Nullable List<Commodity.CommodityData> data) {
        super(R.layout.item_cove_tiem, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, Commodity.CommodityData item) {
        //加载图片
        PicassomageUtils.load(mContext,item.getItempic(),helper.getView(R.id.imageTu));
        helper.setText(R.id.tv_title,item.getItemtitle())
                .setText(R.id.tv_juanhou,item.getItemendprice())
                .setText(R.id.tv_xiao,String.valueOf(item.getItemsale()))
                .setText(R.id.sp_juan,String.valueOf(item.getCouponmoney()));
    }
}
