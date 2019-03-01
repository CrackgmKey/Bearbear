package com.lingjuan.app.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.LayoutHelper;
import com.alibaba.android.vlayout.layout.GridLayoutHelper;
import com.lingjuan.app.R;
import com.lingjuan.app.entity.Commodity;
import com.lingjuan.app.utils.PicassomageUtils;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by OneX on 2018/1/2:11:21.
 * des: 创建相关LayoutHelper的使用
 */

public class CommoditDataAdapter extends DelegateAdapter.Adapter<CommoditDataAdapter.CommoditDataHolder> {


    private Context mContext;
    private GridLayoutHelper mHelper;
    private List<Commodity.CommodityData> commodityDataList;

    public CommoditDataAdapter(Context mContext, List<Commodity.CommodityData> commodityDataList) {
        this.mContext = mContext;
        this.commodityDataList = commodityDataList;
        mHelper = new GridLayoutHelper(2);
        mHelper.setMarginTop(10);
        mHelper.setVGap(11);
        //设置水平方向条目的间隔
        mHelper.setHGap(10);
        mHelper.setPadding(10, 5, 10, 5);
        mHelper.setBgColor(mContext.getResources().getColor(R.color.sbc_list_item));
    }


    public void setCommodityDataList(List<Commodity.CommodityData> commodityDataList) {
        this.commodityDataList = commodityDataList;
        notifyDataSetChanged();
    }

    @Override
    public LayoutHelper onCreateLayoutHelper() {
        return mHelper;
    }

    @Override
    public CommoditDataHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_commodity, parent, false);
        return new CommoditDataHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CommoditDataHolder holder, final int position) {
        Commodity.CommodityData commodityData = commodityDataList.get(position);
        //加载图片
        PicassomageUtils.qtkLoad(mContext, commodityData.getItempic(), holder.imageItem);
        //设置标题
        holder.spTitle.setText(String.valueOf(commodityData.getItemtitle()));
        //设置原价
        holder.spYuanjia.setText(String.valueOf(commodityData.getItemprice()));
        //设置销量
        holder.spXiaoliang.setText(String.valueOf(commodityData.getItemsale()));
        //设置卷后价
        holder.spXianjia.setText(String.valueOf(commodityData.getItemendprice()));
        //设置优惠券价格
        holder.spJuan.setText(String.valueOf(commodityData.getCouponmoney()));
        holder.baseview.setOnClickListener((v) -> recyclerListeners.onClick(position));
    }

    public RecyclerListeners recyclerListeners;

    public void setRecyclerListeners(RecyclerListeners recyclerListeners) {
        this.recyclerListeners = recyclerListeners;
    }

    public abstract static class RecyclerListeners {
        protected abstract void onClick(int position);
    }

    @Override
    public int getItemCount() {
        return commodityDataList.size();
    }

    /**
     * 正常条目的item的ViewHolder
     */
    public class CommoditDataHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.image_item)
        ImageView imageItem;
        @BindView(R.id.sp_title)
        TextView spTitle;
        @BindView(R.id.buju1)
        LinearLayout buju1;
        @BindView(R.id.sp_juan2)
        TextView spJuan2;
        @BindView(R.id.sp_yuanjia)
        TextView spYuanjia;
        @BindView(R.id.sp_xianjia)
        TextView spXianjia;
        @BindView(R.id.bju2)
        LinearLayout bju2;
        @BindView(R.id.sp_xiaoliang)
        TextView spXiaoliang;
        @BindView(R.id.sp_juan)
        TextView spJuan;
        @BindView(R.id.baseview)
        LinearLayout baseview;
        public CommoditDataHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
