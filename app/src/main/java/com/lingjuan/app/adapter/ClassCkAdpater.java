package com.lingjuan.app.adapter;

import android.content.Context;
import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

import com.lingjuan.app.R;
import com.lingjuan.app.entity.SupclassLeft;
import com.lingjuan.app.ui.activity.ProductActivity;
import com.lingjuan.app.utils.ActivityUtils;
import com.lingjuan.app.utils.PicassomageUtils;

/**
 * Created by TaoHui on 2018/10/6.
 */

public class ClassCkAdpater extends BaseQuickAdapter<SupclassLeft.GeneralClassifyBean.DataBean.InfoBean,BaseViewHolder>  {
    private Context context;
    List<SupclassLeft.GeneralClassifyBean.DataBean.InfoBean> datas;
    public ClassCkAdpater(int layoutResId, @Nullable List<SupclassLeft.GeneralClassifyBean.DataBean.InfoBean> data) {
        super(layoutResId, data);
        datas = data;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    @Override
    protected void convert(BaseViewHolder helper, SupclassLeft.GeneralClassifyBean.DataBean.InfoBean item) {
        helper.setVisible(R.id.erjiName,true);
        helper.setText(R.id.erjiName,String.valueOf(item.getSon_name()));
        helper.setOnClickListener(R.id.baceonclcik,(v) -> ActivityUtils.goActivity(item.getSon_name(),"content","type", context, ProductActivity.class));
        PicassomageUtils.loadSzie(context,item.getImgurl(),helper.getView(R.id.imageId),300);
    }


}
