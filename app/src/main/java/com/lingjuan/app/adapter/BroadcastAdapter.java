package com.lingjuan.app.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.LayoutHelper;
import com.lingjuan.app.R;
import com.youth.banner.Banner;
import com.youth.banner.Transformer;

import java.util.List;

import com.lingjuan.app.utils.GlideImageLoader;

/**
 * 轮播实体类
 * Created by TaoHui on 2018/10/3.
 */

public class BroadcastAdapter extends DelegateAdapter.Adapter<BroadcastAdapter.BroadcastViewHodel> {
    /**
     * 图片地址集合
     */
    private List<String> picList;
    /**
     * 辅助类
     */
    private LayoutHelper layoutHelper;
    /**
     * 上下文
     */
    private Context context;

    public BroadcastAdapter(List<String> picList, LayoutHelper layoutHelper, Context context) {
        this.picList = picList;
        this.layoutHelper = layoutHelper;
        this.context = context;
    }

    @Override
    public LayoutHelper onCreateLayoutHelper() {
        return layoutHelper;
    }


    @Override
    public BroadcastViewHodel onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.broadcast_layout,parent,false);
        return new BroadcastViewHodel(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BroadcastViewHodel holder, int position) {
        //设置加载源
        holder.banner.setImageLoader(new GlideImageLoader());
        //设置动画
        holder.banner.setBannerAnimation(Transformer.Default);
        holder.banner.setImages(picList);
        holder.banner.setDelayTime(3000);
        holder.banner.start();
    }

    @Override
    public int getItemCount() {
        return 1;
    }


    class BroadcastViewHodel extends RecyclerView.ViewHolder{
        Banner banner;
        BroadcastViewHodel(View itemView) {
            super(itemView);
            banner = itemView.findViewById(R.id.banner);
        }
    }
}
