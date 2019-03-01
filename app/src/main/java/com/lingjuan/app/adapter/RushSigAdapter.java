package com.lingjuan.app.adapter;

import android.content.Context;
import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

import com.lingjuan.app.R;
import com.lingjuan.app.entity.Rusheeny;
import com.lingjuan.app.utils.DateUtils;
import com.lingjuan.app.utils.PicassomageUtils;

/**
 * 抢购适配器
 * Created by TaoHui on 2018/10/9.
 */

public class RushSigAdapter extends BaseQuickAdapter<Rusheeny.DataBean, BaseViewHolder> {
    private Context context;

    public RushSigAdapter(@Nullable List<Rusheeny.DataBean> data, Context context) {
        super(R.layout.huit_item, data);
        this.context = context;
    }


    @Override
    protected void convert(BaseViewHolder helper, Rusheeny.DataBean item) {
        helper.setText(R.id.sp_title,item.getItemshorttitle())
                .setText(R.id.sp_yuanjia,String.valueOf(item.getItemprice()))
                .setText(R.id.sp_xiaoliang,"已抢:"+String.valueOf(item.getItemsale()))
                .setText(R.id.sp_juan,String.valueOf(item.getCouponmoney()))
                .setText(R.id.sp_xianjia,String.valueOf(item.getItemendprice()))
                .setText(R.id.run_time, DateUtils.times(item.getStart_time()))
                .addOnClickListener(R.id.baseview);
        //加载图片
        PicassomageUtils.load(mContext,item.getItempic(), (ImageView) helper.getView(R.id.image_item));
    }
}
