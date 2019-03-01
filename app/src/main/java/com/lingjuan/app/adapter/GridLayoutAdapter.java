package com.lingjuan.app.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.LayoutHelper;

import java.util.List;

import com.lingjuan.app.R;
import com.lingjuan.app.customview.DataHashMap;

/**
 * 网格布局
 * Created by TaoHui on 2018/10/3.
 */

public class GridLayoutAdapter  extends DelegateAdapter.Adapter<GridLayoutAdapter.GridViewHodle>{
    private List<DataHashMap> mDataList;
    private LayoutHelper helper;
    private OnClickListener clickListener;
    public GridLayoutAdapter(List<DataHashMap> mDataList, LayoutHelper helper) {
        this.mDataList = mDataList;
        this.helper = helper;
    }

    @Override
    public LayoutHelper onCreateLayoutHelper() {
        return helper;
    }

    @Override
    public GridViewHodle onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_grid_layout,parent,false);
        return new GridViewHodle(view);
    }

    @Override
    public void onBindViewHolder(GridViewHodle holder, int position) {
        holder.imageView.setBackgroundResource(Integer.parseInt(mDataList.get(position).get("iamge")));
        holder.textView.setText(mDataList.get(position).get("title"));
        holder.baseView.setOnClickListener((v) ->{
            clickListener.onGridItemClick(holder.baseView,position);
        });
    }

    @Override
    public int getItemCount() {
        return mDataList.size();
    }

    class GridViewHodle extends RecyclerView.ViewHolder{
        ImageView imageView;
        TextView textView;
        LinearLayout baseView;
        public GridViewHodle(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.iv_grid);
            textView = itemView.findViewById(R.id.tv_title);
            baseView = itemView.findViewById(R.id.baseview);
        }
    }

    public interface OnClickListener{
        void onGridItemClick(View view,int position);
    }

    public void setClickListener(OnClickListener clickListener) {
        this.clickListener = clickListener;
    }
}
