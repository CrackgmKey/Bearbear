package com.lingjuan.app.adapter;

import android.content.Context;
import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.lingjuan.app.R;
import com.lingjuan.app.entity.LotterytRzy;

import java.util.List;

/**
 * 抽奖适配器
 * Created by TaoHui on 2018/11/29.
 */

public class LotterytAdapter extends BaseQuickAdapter<LotterytRzy,BaseViewHolder> {
    private Context context;

    public LotterytAdapter(Context context,@Nullable List<LotterytRzy> data) {
        super(R.layout.gambling_item, data);
        this.context = context;
    }

    @Override
    protected void convert(BaseViewHolder helper, LotterytRzy item) {
     /*   //设置名字
        helper.setText(R.id.tv_sccname,String.valueOf(item.getName()));
        //是否有Null
        if(!TextUtils.isEmpty(item.getCurrenttimes()) || !TextUtils.isEmpty(item.getMaxsize()) || !TextUtils.isEmpty(item.getIslotteryt())){
            //设置剩余
            int shengyu = Integer.parseInt(item.getMaxsize()) - Integer.parseInt(item.getCurrenttimes());
            //设置当前参与和总参与
            helper.setText(R.id.tv_already,String.valueOf(item.getCurrenttimes()))
                    .setText(R.id.tv_total,String.valueOf(item.getMaxsize()))
                    .setText(R.id.tv_surplus,String.valueOf(shengyu));
        }

        if(item.getIsstart().equals("0")){
            helper.setVisible(R.id.tv_duobao,true);
        }else {
            helper.setVisible(R.id.tv_duobao,false);
        }

        PicassomageUtils.load(context,Constant.HTTP_PIC+item.getImg(),helper.getView(R.id.img_zhu));*/
    }
}


