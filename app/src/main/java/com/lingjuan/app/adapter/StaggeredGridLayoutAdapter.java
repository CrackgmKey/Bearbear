package com.lingjuan.app.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.LayoutHelper;

import java.util.List;

import com.lingjuan.app.R;

/**
 * Created by Linsa on 2018/1/2:11:21.
 * des: 创建相关LayoutHelper的使用
 */

public class StaggeredGridLayoutAdapter extends DelegateAdapter.Adapter<RecyclerView.ViewHolder> {

    private Context mContext;
    private LayoutHelper mHelper;
    private List<Integer> mData;

    public StaggeredGridLayoutAdapter(Context context, List<Integer> mData, LayoutHelper helper) {
        this.mContext=context;
        this.mData = mData;
        this.mHelper=helper;
    }

    @Override
    public LayoutHelper onCreateLayoutHelper() {
        return mHelper;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_stag_layout, parent, false);
        return new RecyclerViewItemHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        RecyclerViewItemHolder recyclerViewHolder = (RecyclerViewItemHolder) holder;
        recyclerViewHolder.iv_head.setImageResource(mData.get(position) );
        recyclerViewHolder.iv_head.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext, "position:" +position, Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    /**
     * 正常条目的item的ViewHolder
     */
    private class RecyclerViewItemHolder extends RecyclerView.ViewHolder {

        public ImageView iv_head;

        public RecyclerViewItemHolder(View itemView) {
            super(itemView);
            iv_head = itemView.findViewById(R.id.iv_head);
        }
    }
}
