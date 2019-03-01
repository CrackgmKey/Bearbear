package com.lingjuan.app.adapter;

import android.content.Context;
import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.lingjuan.app.R;
import com.lingjuan.app.entity.FootprintRzy;
import com.lingjuan.app.utils.PicassomageUtils;

import java.util.List;

/**
 * 足迹适配器
 * @author: TaoHui
 * @date: 2019/1/17
 */
public class FootprinAdapter extends BaseQuickAdapter<FootprintRzy,BaseViewHolder> {
    private Context context;



    public FootprinAdapter(@Nullable List<FootprintRzy> data,Context context) {
        super(R.layout.item_commoditycolumn, data);
        this.context = context;
    }

    @Override
    protected void convert(BaseViewHolder helper, FootprintRzy item) {
        helper.setText(R.id.sp_title,item.getItemshorttitle())
                .setText(R.id.sp_yuanjia,String.valueOf(item.getItemprice()))
                .setText(R.id.sp_xianjia,String.valueOf(item.getItemendprice()))
                .setText(R.id.sp_xiaoliang,String.valueOf(item.getItemsale()))
                .setText(R.id.sp_juan,String.valueOf(item.getCouponmoney()));
        helper.addOnClickListener(R.id.baseview);
        helper.addOnLongClickListener(R.id.baseview);
        PicassomageUtils.load(context,item.getItempic(),helper.getView(R.id.image_item));
    }
}
