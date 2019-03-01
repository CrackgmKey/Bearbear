package com.lingjuan.app.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.LayoutHelper;

import java.util.List;

import com.lingjuan.app.R;
import com.lingjuan.app.utils.LogManage;
import com.lingjuan.app.utils.ToastManage;

/**
 * 一拖N布局
 * Created by TaoHui on 2018/10/3.
 */

public class OneLayoutAdapter extends DelegateAdapter.Adapter<OneLayoutAdapter.GridViewHodle> {
    private List<Integer> mDataList;
    private LayoutHelper helper;
    private Context context;
    private int[] intype = {1, 2};
    private CallbackInterface callbackInterface;

    public OneLayoutAdapter(List<Integer> mDataList, LayoutHelper helper, Context context, CallbackInterface callbackInterface) {
        this.mDataList = mDataList;
        this.helper = helper;
        this.context = context;
        this.callbackInterface = callbackInterface;
    }

    @Override
    public LayoutHelper onCreateLayoutHelper() {
        return helper;
    }

    @Override
    public GridViewHodle onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_one_to_n_layout, parent, false);
        return new GridViewHodle(view);
    }

    @Override
    public void onBindViewHolder(GridViewHodle holder, int position) {
        holder.imageView.setBackgroundResource(mDataList.get(position));
        holder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ToastManage.showText(context, "当前==" + position);
                LogManage.d("=======当前位置：" + position);
                if (position == 0) {
                    callbackInterface.onClickCallback(0);
                } else {
                    callbackInterface.onClickCallback(1);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mDataList.size();
    }

    class GridViewHodle extends RecyclerView.ViewHolder {
        ImageView imageView;

        public GridViewHodle(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.iv_image);
        }
    }


    public interface CallbackInterface {
        void onClickCallback(int position);
    }
}
