package com.lingjuan.app.adapter;

import android.graphics.Color;
import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

import com.lingjuan.app.R;
import com.lingjuan.app.entity.SupclassLeft;

/**
 * Created by TaoHui on 2018/10/6.
 */

public class SuperClassLeftAdapter extends BaseQuickAdapter<SupclassLeft.GeneralClassifyBean,BaseViewHolder> {
    private int selectedPosition = 999;
    public SuperClassLeftAdapter(int layoutResId, @Nullable List<SupclassLeft.GeneralClassifyBean> data) {
        super(layoutResId, data);
    }


    public void setSelectedPosition(int selectedPosition) {
        this.selectedPosition = selectedPosition;
        notifyDataSetChanged();
    }
    @Override
    protected void convert(final BaseViewHolder helper, SupclassLeft.GeneralClassifyBean item) {
        helper.setText(R.id.titleleft,item.getMain_name()).addOnClickListener(R.id.titleleft);
            helper.setBackgroundColor(R.id.titleleft, Color.parseColor("#ffd6d7d7"));
            if(selectedPosition == helper.getAdapterPosition()){
                helper.setBackgroundColor(R.id.titleleft, Color.parseColor("#ffebebed"));
            }else {
                helper.setBackgroundColor(R.id.titleleft, Color.parseColor("#ffd6d7d7"));
            }
    }
}
