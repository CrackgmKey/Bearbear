package com.lingjuan.app.adapter;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.lingjuan.app.R;
import com.lingjuan.app.entity.HookLopKey;

import java.util.List;

/**
 * Created by TaoHui on 2018/10/17.
 */

public class HotKeyAdapter extends BaseQuickAdapter<HookLopKey.DataBean,BaseViewHolder> {
    public HotKeyAdapter(@Nullable List<HookLopKey.DataBean> data) {
        super(R.layout.item_hotkey, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, HookLopKey.DataBean item) {
        helper.setText(R.id.tv_msg,item.getKeyword())
                .addOnClickListener(R.id.tv_msg);
    }
}
