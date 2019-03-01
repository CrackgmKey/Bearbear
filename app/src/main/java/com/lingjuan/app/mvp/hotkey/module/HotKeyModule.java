package com.lingjuan.app.mvp.hotkey.module;

import com.lingjuan.app.entity.HookLopKey;
import com.lingjuan.app.mvp.hotkey.view.IhotKey;
import com.lingjuan.app.utils.HttpManage;

import rx.Subscriber;

/**
 * 超级搜索
 * Created by TaoHui on 2018/10/17.
 */

public class HotKeyModule {
    private IhotKey.M mView;

    public void setmView(IhotKey.M mView) {
        this.mView = mView;
    }

    public void getHotData(){
        HttpManage.getInstance().getHotKeyData(new Subscriber<HookLopKey>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                mView.error(e.toString());
            }

            @Override
            public void onNext(HookLopKey hookLopKey) {
                mView.getData(hookLopKey);
            }
        });
    }
}
