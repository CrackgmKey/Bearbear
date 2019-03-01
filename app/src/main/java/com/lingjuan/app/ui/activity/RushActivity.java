package com.lingjuan.app.ui.activity;

import android.app.Activity;
import android.os.Bundle;

import com.jaeger.library.StatusBarUtil;
import com.lingjuan.app.R;
import com.lingjuan.app.base.BaseActivity;

/**
 * @author: TaoHui
 * @date: 2019/2/21
 */
public class RushActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        StatusBarUtil.setColorNoTranslucent(this,getResources().getColor(R.color.error_color_material_dark));
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {

    }

    @Override
    protected int getLayout() {
        return R.layout.activity_rush;
    }

    @Override
    protected Activity getActivity() {
        return null;
    }
}
