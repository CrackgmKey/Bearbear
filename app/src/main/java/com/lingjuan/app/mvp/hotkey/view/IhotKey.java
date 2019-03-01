package com.lingjuan.app.mvp.hotkey.view;

import com.lingjuan.app.entity.HookLopKey;
import com.lingjuan.app.mvp.base.BaseViw;

import java.util.List;

/**
 * Created by TaoHui on 2018/10/17.
 */

public interface IhotKey {
     interface M{
        void getData(HookLopKey dataBean);
        void error(String s);
    }

    interface P extends BaseViw{
         void getData(List<HookLopKey.DataBean> dataBean);
         void onErrorMsg(String mgs);
    }

}
