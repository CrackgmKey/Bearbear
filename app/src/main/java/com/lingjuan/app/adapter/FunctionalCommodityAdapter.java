package com.lingjuan.app.adapter;

import android.content.Context;
import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.lingjuan.app.R;
import com.lingjuan.app.entity.FunctionalCommodityRzy;
import com.lingjuan.app.utils.LogManage;
import com.lingjuan.app.utils.PicassomageUtils;

import java.text.DecimalFormat;
import java.util.List;

/**
 * 商品淘抢购适配器
 * Created by TaoHui on 2018/11/3.
 */

public class FunctionalCommodityAdapter extends BaseQuickAdapter<FunctionalCommodityRzy.DataBean.ListBean,BaseViewHolder> {
    private Context context;

    public CommoditDataAdapter.RecyclerListeners recyclerListeners;

    public void setRecyclerListeners(CommoditDataAdapter.RecyclerListeners recyclerListeners) {
        this.recyclerListeners = recyclerListeners;
    }

    public abstract static class RecyclerListeners {
        protected abstract void onClick(int position);
    }
    public FunctionalCommodityAdapter(Context context, @Nullable List<FunctionalCommodityRzy.DataBean.ListBean> data) {
        super(R.layout.item_commodity, data);
        this.context = context;
    }

    @Override
    protected void convert(BaseViewHolder helper, FunctionalCommodityRzy.DataBean.ListBean item) {
        DecimalFormat df = new DecimalFormat("######0.00");
        String xianjia = df.format(item.getGoods_price() -item.getCoupon_price());
                helper.setText(R.id.sp_title, item.getGoods_short_title())
                .setVisible(R.id.iamge_play, false)
                .setText(R.id.sp_yuanjia, String.valueOf(item.getGoods_price()))
                .setText(R.id.sp_xiaoliang, String.valueOf(item.getGoods_sales()))
                .setText(R.id.sp_juan, String.valueOf(item.getCoupon_price()))
                .setText(R.id.sp_xianjia,xianjia);
        LogManage.d("=======当前现价->"+item.getGoods_price()+"当前价格->"+item.getCoupon_price());
        helper.addOnClickListener(R.id.baseview);
        //加载图片
        PicassomageUtils.qtkLoad(context, item.getGoods_pic(), helper.getView(R.id.image_item));
    }
}
