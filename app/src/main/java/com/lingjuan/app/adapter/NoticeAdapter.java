package com.lingjuan.app.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.LayoutHelper;
import com.taobao.library.VerticalBannerView;

import java.util.List;

import com.lingjuan.app.R;
import com.lingjuan.app.constant.Constant;
import com.lingjuan.app.customview.DataHashMap;

/**
 * Created by OneX on 2018/1/2:11:21.
 * des: 创建相关LayoutHelper的使用
 */

public class NoticeAdapter extends DelegateAdapter.Adapter<RecyclerView.ViewHolder> {

    private Context mContext;
    private LayoutHelper mHelper;
    private List<DataHashMap> mDatas;
    private NoticeDataAdapter dataAdapter;
    public NoticeAdapter(Context mContext, LayoutHelper mHelper, List<DataHashMap> mDatas) {
        this.mContext = mContext;
        this.mHelper = mHelper;
        this.mDatas = mDatas;
    }


    public void setmDatas(List<DataHashMap> mDatas) {
        this.mDatas = mDatas;
        notifyDataSetChanged();
    }

    @Override
    public LayoutHelper onCreateLayoutHelper() {
        return mHelper;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_addnotice, parent, false);
        return new NoticeHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        if(mDatas.size() == 1 || mDatas.size() == 0){
            return;
        }
        NoticeHolder noticeHolder = (NoticeHolder) holder;
        dataAdapter = new NoticeDataAdapter(mDatas);
        if(Constant.CK_SWITCH){
            try{
                noticeHolder.verticalBannerView.setAdapter(dataAdapter);
            }catch (Exception e){

            }
            Constant.CK_SWITCH = false;
        }
        try {
            noticeHolder.verticalBannerView.start();
        }catch (RuntimeException e){
            noticeHolder.verticalBannerView.setAdapter(dataAdapter);
            noticeHolder.verticalBannerView.start();
        }
    }

    @Override
    public int getItemCount() {
        return 1;
    }

    /**
     * 正常条目的item的ViewHolder
     */
    private class NoticeHolder extends RecyclerView.ViewHolder {

        public VerticalBannerView verticalBannerView;

        public NoticeHolder(View itemView) {
            super(itemView);
            verticalBannerView = itemView.findViewById(R.id.banner_01);
        }
    }
}
