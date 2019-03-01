package com.lingjuan.app.mvp.reg.model;

import com.lingjuan.app.mvp.reg.view.Reg;

/**
 * Created by TaoHui on 2018/11/8.
 */

public class RegModule implements Reg.M {
    public Reg.P p;

    public RegModule(Reg.P p) {
        this.p = p;
    }

    @Override
    public void regUser(String user, String photo) {
        new android.os.Handler().postDelayed(() -> p.onSuccess("注册成功"),2000);
    }
}
