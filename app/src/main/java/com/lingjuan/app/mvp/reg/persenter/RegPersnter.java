package com.lingjuan.app.mvp.reg.persenter;

import com.lingjuan.app.mvp.reg.model.RegModule;
import com.lingjuan.app.mvp.reg.view.Reg;

/**
 * Created by TaoHui on 2018/11/8.
 */

public class RegPersnter implements Reg.P {
    public Reg.V view;
    public RegModule regModule;

    public RegPersnter(Reg.V view) {
        this.view = view;
        regModule = new RegModule(this);
    }

    @Override
    public void onFailMsg(String errormsg) {
        view.onFailMsg(errormsg);
    }

    @Override
    public void onSuccess(String msg) {
        view.onSuccess(msg);
    }

    @Override
    public void startReg(String photo) {
        regModule.regUser("hui666",photo);
    }
}
