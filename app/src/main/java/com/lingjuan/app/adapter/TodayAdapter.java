package com.lingjuan.app.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.LayoutHelper;
import com.lingjuan.app.R;
import com.lingjuan.app.entity.Commodity;

import java.util.List;

/**
 * Created by TaoHui on 2018/10/22.
 */

public class TodayAdapter extends DelegateAdapter.Adapter<RecyclerView.ViewHolder> {

    private LayoutHelper mHelper;
    private List<Commodity.CommodityData> data;
    private Context context;
    public TodayAdapter(LayoutHelper mHelper, List<Commodity.CommodityData> data) {
        this.mHelper = mHelper;
        this.data = data;
    }

    public void setData(List<Commodity.CommodityData> data) {
        this.data = data;
        notifyDataSetChanged();
    }

    @Override
    public LayoutHelper onCreateLayoutHelper() {
        return mHelper;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recyitem_coverflow, parent, false);
        return new RecyclerViewItemHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        RecyclerViewItemHolder recyclerViewHolder = (RecyclerViewItemHolder) holder;
        TodayPushAdapter todayPushAdapter = new TodayPushAdapter(data);
        recyclerViewHolder.recyclerCoverFlow.setAdapter(todayPushAdapter);
    }

    @Override
    public int getItemCount() {
        return 1;
    }

    /**
     * 正常条目的item的ViewHolder
     */
    private class RecyclerViewItemHolder extends RecyclerView.ViewHolder {

        public RecyclerView recyclerCoverFlow;

        public RecyclerViewItemHolder(View itemView) {
            super(itemView);
            recyclerCoverFlow = itemView.findViewById(R.id.reclcover);
        }
    }
}
