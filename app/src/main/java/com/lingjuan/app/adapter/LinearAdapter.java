package com.lingjuan.app.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.LayoutHelper;

/**
 * Created by OneX on 2018/1/2:11:21.
 * des: 创建相关LayoutHelper的使用
 */

public class LinearAdapter extends DelegateAdapter.Adapter<RecyclerView.ViewHolder> {

    private Context mContext;
    private LayoutHelper mHelper;
    private int layoutId;

    public LinearAdapter(Context mContext, LayoutHelper mHelper, int layoutId) {
        this.mContext = mContext;
        this.mHelper = mHelper;
        this.layoutId = layoutId;
    }

    @Override
    public LayoutHelper onCreateLayoutHelper() {
        return mHelper;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(layoutId, parent, false);
        return new RecyclerViewItemHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        RecyclerViewItemHolder recyclerViewHolder = (RecyclerViewItemHolder) holder;
    }

    @Override
    public int getItemCount() {
        return 1;
    }

    /**
     * 正常条目的item的ViewHolder
     */
    private class RecyclerViewItemHolder extends RecyclerView.ViewHolder {

        public TextView tv_name;

        public RecyclerViewItemHolder(View itemView) {
            super(itemView);
           // tv_name = itemView.findViewById(R.id.tv_name);
        }
    }
}
