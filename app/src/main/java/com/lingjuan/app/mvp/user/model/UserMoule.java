package com.lingjuan.app.mvp.user.model;

import com.lingjuan.app.constant.Constant;
import com.lingjuan.app.customview.DataHashMap;
import com.lingjuan.app.entity.TResponse;
import com.lingjuan.app.entity.UserTResponse;
import com.lingjuan.app.mvp.user.view.UserView;
import com.lingjuan.app.utils.HttpManage;
import com.lingjuan.app.utils.Md5;

import rx.Subscriber;

/**
 * 用户注册以及用户登录
 * Created by TaoHui on 2018/11/27.
 */

public class UserMoule implements UserView.M {
    private UserView.P pView;

    public UserMoule(UserView.P pView) {
        this.pView = pView;
    }

    @Override
    public void userRegName(String phone, String code, String password) {
        pView.showDialog();
        //填充数据集合
        DataHashMap dataHashMap = DataHashMap.getInstance()
                .appParam("password", Md5.getMD5(password))
                .appParam("phone", phone)
                .appParam("code", code);
        HttpManage.getInstance().getRegUser(new Subscriber<UserTResponse>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                pView.dissDialog();
                pView.onError(e.toString());
            }

            @Override
            public void onNext(UserTResponse tResponse) {
                pView.dissDialog();
                switch (tResponse.getStatus()) {
                    case Constant.User.USER_SUCCESS://注册成功
                        pView.onSuccess(tResponse.getResult(),phone);
                        break;
                    case Constant.User.USER_REG_EXISTENCE://手机号被注册
                        pView.onFail(tResponse.getResult());
                        break;
                    case Constant.User.USER_REG_FAIL://注册失败
                        pView.onFail(tResponse.getResult());
                        break;
                    default:break;
                }
            }
        }, dataHashMap);
    }

    @Override
    public void userLogin(String phone, String password) {
        pView.showDialog();
        //填充数据集合
        DataHashMap dataHashMap = DataHashMap.getInstance()
                .appParam("password", Md5.getMD5(password))
                .appParam("phone", phone);
        HttpManage.getInstance().getUserLogin(new Subscriber<TResponse>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                pView.dissDialog();
                pView.onError(e.toString());
            }

            @Override
            public void onNext(TResponse tResponse) {
                pView.dissDialog();
                switch (tResponse.getStatus()) {
                    case Constant.User.USER_SUCCESS://登录成功
                        pView.onSuccess(tResponse.getResult(),tResponse.getData());
                        break;
                    case Constant.User.USER_LONGIN_FAIL://用户密码错误
                        pView.onFail(tResponse.getResult());
                        break;
                    default:break;
                }
            }
        }, dataHashMap);
    }
}
