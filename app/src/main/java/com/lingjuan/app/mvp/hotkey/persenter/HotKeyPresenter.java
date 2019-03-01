package com.lingjuan.app.mvp.hotkey.persenter;

import android.content.Context;

import com.lingjuan.app.R;
import com.lingjuan.app.entity.HookLopKey;
import com.lingjuan.app.mvp.hotkey.module.HotKeyModule;
import com.lingjuan.app.mvp.hotkey.view.IhotKey;

/**
 * Created by TaoHui on 2018/10/17.
 */

public class HotKeyPresenter implements IhotKey.M {
    private IhotKey.P pView;
    private HotKeyModule hotKeyModule;
    private Context context;
    public HotKeyPresenter(IhotKey.P pView,Context context) {
        this.pView = pView;
        this.context = context;
        hotKeyModule = new HotKeyModule();
        hotKeyModule.setmView(this);
    }

    @Override
    public void getData(HookLopKey dataBean) {
        pView.dissDialog();
        pView.getData(dataBean.getData());
        pView.showMessage(context.getResources().getString(R.string.jiazai));
    }

    @Override
    public void error(String s) {
        pView.onErrorMsg(s);
    }

    public void getHotData(){
        pView.showDialog();
        hotKeyModule.getHotData();
    }
}
