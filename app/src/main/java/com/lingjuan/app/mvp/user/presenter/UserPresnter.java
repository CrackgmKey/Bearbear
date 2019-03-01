package com.lingjuan.app.mvp.user.presenter;

import com.lingjuan.app.entity.EventBusRzy;
import com.lingjuan.app.entity.UserInfo;
import com.lingjuan.app.mvp.user.model.UserMoule;
import com.lingjuan.app.mvp.user.view.UserView;

import org.greenrobot.eventbus.EventBus;

/**
 *
 * Created by TaoHui on 2018/11/27.
 */

public class UserPresnter implements UserView.P{
    private UserMoule moule;
    private UserView.V vView;

    public UserPresnter(UserView.V vView) {
        this.vView = vView;
        moule = new UserMoule(this);
    }

    @Override
    public void onSuccess(String msg,String phone) {
        vView.onSuccess(msg,phone);
    }

    @Override
    public void onSuccess(String msg, UserInfo user) {
        UserInfo.saveUser(user);
        vView.onSuccess(msg,"");
        EventBus.getDefault().post(new EventBusRzy<>(EventBusRzy.USER_LOGIIN,""));
    }

    @Override
    public void onFail(String msg) {
        vView.onFail(msg);
    }

    @Override
    public void onError(String error) {
        vView.onError(error);
    }

    @Override
    public void showDialog() {
        vView.showDialog();

    }

    @Override
    public void dissDialog() {
        vView.dissDialog();
    }

    @Override
    public void userReg(String phone, String code, String password) {
        moule.userRegName(phone,code,password);
    }

    @Override
    public void userLogin(String phone, String password) {
        moule.userLogin(phone,password);
    }
}
