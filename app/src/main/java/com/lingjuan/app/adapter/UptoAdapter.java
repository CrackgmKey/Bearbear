package com.lingjuan.app.adapter;

import android.content.Context;
import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.lingjuan.app.R;
import com.lingjuan.app.entity.Commodity;
import com.lingjuan.app.utils.PicassomageUtils;

import java.util.List;

/** 抢购
 * Created by TaoHui on 2018/10/10.
 */

public class UptoAdapter extends BaseQuickAdapter<Commodity.CommodityData,BaseViewHolder> {
    private Context context;

    public void setContext(Context context) {
        this.context = context;
    }

    public UptoAdapter(@Nullable List<Commodity.CommodityData> data) {
        super(R.layout.item_upto,data);
    }

    @Override
    protected void convert(BaseViewHolder helper, Commodity.CommodityData item) {
        helper.setText(R.id.upto_title,item.getItemshorttitle())
                .setText(R.id.juan_hou,""+String.valueOf(item.getItemendprice()))   //卷后价
                .setText(R.id.juan_jiag,String.valueOf(item.getCouponmoney()).replaceAll("[.]$","")+"元")
                .setText(R.id.jaun_xiao,String.valueOf(item.getItemsale())+"件");

        helper.addOnClickListener(R.id.basieviwe);

        PicassomageUtils.loads(context,item.getItempic(),  helper.getView(R.id.iamgeImd));
    }
}
