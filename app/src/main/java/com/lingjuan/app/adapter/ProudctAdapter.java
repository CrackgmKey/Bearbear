package com.lingjuan.app.adapter;

import android.content.Context;
import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.lingjuan.app.R;
import com.lingjuan.app.entity.ProducRzy;
import com.lingjuan.app.entity.Screeningstrategy;
import com.lingjuan.app.utils.PicassomageUtils;
import com.lingjuan.app.wigth.SearchTypePopupWindow;
import com.orhanobut.logger.Logger;

import java.util.List;

/**
 * 搜索商品Adapter
 * Created by TaoHui on 2018/10/18.
 */

public class ProudctAdapter extends BaseQuickAdapter<ProducRzy.DataBean, BaseViewHolder> {
    private Context context;
    private Screeningstrategy screeningstrategy;
    private OnJieKou onJieKou;


    public void setOnJieKou(OnJieKou onJieKou) {
        this.onJieKou = onJieKou;
    }

    public void setScreeningstrategy(Screeningstrategy screeningstrategy) {
        this.screeningstrategy = screeningstrategy;
        notifyDataSetChanged();
    }

    public ProudctAdapter(@Nullable List<ProducRzy.DataBean> data, Context context, int layoutId, Screeningstrategy screeningstrategy) {
        super(layoutId, data);
        this.context = context;
        this.screeningstrategy = screeningstrategy;
    }

    @Override
    protected void convert(BaseViewHolder helper, ProducRzy.DataBean item) {
        //判断是否有筛选策略
        if (screeningstrategy == null) {
            helper.setText(R.id.sp_title, item.getItemshorttitle())
                    .setVisible(R.id.iamge_play, false)
                    .setText(R.id.sp_yuanjia, String.valueOf(item.getItemprice()))
                    .setText(R.id.sp_xiaoliang, String.valueOf(item.getItemsale()))
                    .setText(R.id.sp_juan, String.valueOf(item.getCouponmoney()))
                    .setText(R.id.sp_xianjia, String.valueOf(item.getItemendprice()));
            //加载图片
            PicassomageUtils.loads(context, item.getItempic(), helper.getView(R.id.image_item));
        } else {
            if (screeningstrategy.getSource().equals(SearchTypePopupWindow.Meaning.Tvideo)) {
                //判断是否为视频单
                if (screeningstrategy.getSource().equals(SearchTypePopupWindow.Meaning.Tvideo)) {
                    if (!item.getVideoid().equals("0")) {
                        helper.setVisible(R.id.iamge_play, true);
                    } else {
                        helper.setVisible(R.id.iamge_play, false);
                    }
                }
            } else {
                helper.setVisible(R.id.iamge_play, false);
            }
            helper.setText(R.id.sp_title, item.getItemshorttitle())
                    .setText(R.id.sp_yuanjia, String.valueOf(item.getItemprice()))
                    .setText(R.id.sp_xiaoliang, String.valueOf(item.getItemsale()))
                    .setText(R.id.sp_juan, String.valueOf(item.getCouponmoney()))
                    .setText(R.id.sp_xianjia, String.valueOf(item.getItemendprice()));
            Logger.d("=============当前图片地址："+item.getItempic());
            //加载图片
            PicassomageUtils.loads(context, item.getItempic(), helper.getView(R.id.image_item));
        }
    }


    public interface OnJieKou{
        void setOnItemClickListene(int position);
    }
}
