package com.lingjuan.app.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.taobao.library.BaseBannerAdapter;
import com.taobao.library.VerticalBannerView;

import java.util.List;

import com.lingjuan.app.R;
import com.lingjuan.app.customview.DataHashMap;

/**
 * Created by TaoHui on 2018/10/5.
 */

public class NoticeDataAdapter extends BaseBannerAdapter<DataHashMap> {
    public NoticeDataAdapter(List<DataHashMap> datas) {
        super(datas);
    }

    @Override
    public View getView(VerticalBannerView verticalBannerView) {
        return LayoutInflater.from(verticalBannerView.getContext()).inflate(R.layout.item_notice,null);
    }

    @Override
    public void setItem(View view, DataHashMap spicyhotMap) {
        TextView tv = (TextView) view.findViewById(R.id.title);
        tv.setText(spicyhotMap.get("Notitle"));
    }
}
