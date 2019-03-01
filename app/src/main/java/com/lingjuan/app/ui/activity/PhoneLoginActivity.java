package com.lingjuan.app.ui.activity;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.lingjuan.app.R;
import com.lingjuan.app.base.BaseActivity;
import com.lingjuan.app.mvp.user.presenter.UserPresnter;
import com.lingjuan.app.mvp.user.view.UserView;
import com.lingjuan.app.utils.ToastManage;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 用户手机号登录
 */
public class PhoneLoginActivity extends BaseActivity implements UserView.V {
    @BindView(R.id.username)
    EditText username;
    @BindView(R.id.password)
    EditText password;
    @BindView(R.id.user_login)
    Button userLogin;
    @BindView(R.id.image_return)
    ImageView imageReturn;
    private String phone;
    private UserPresnter userPresnter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phone_login);
        ButterKnife.bind(this);
        initView();
        initData();
    }

    @Override
    protected void initView() {
        userPresnter = new UserPresnter(this);
        phone = getIntent().getStringExtra("phone");
    }

    @Override
    protected void initData() {

    }

    @Override
    protected int getLayout() {
        return R.layout.activity_phone_login;
    }

    @Override
    protected Activity getActivity() {
        return this;
    }

    @OnClick({R.id.username, R.id.password, R.id.user_login,R.id.image_return})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.image_return:
                finish();
                break;
            case R.id.username:
                break;
            case R.id.password:
                break;
            case R.id.user_login:
                //手机号
                String phone = username.getText().toString().trim();
                //密码
                String pass = password.getText().toString().trim();
                //判断是否正确
                if (TextUtils.isEmpty(phone) || TextUtils.isEmpty(pass)) {
                    ToastManage.showText(getActivity(), "请输入内容");
                    return;
                }
                userPresnter.userLogin(phone, pass);
                break;
            default:
                break;
        }
    }

    @Override
    public void showDialog() {
        showLoading();
    }

    @Override
    public void dissDialog() {
        dismissLoading();
    }

    @Override
    public void showMessage(String msg) {
        ToastManage.showText(getActivity(), msg);
    }

    @Override
    public void onSuccess(String msg, String phone) {
        ToastManage.showText(getActivity(), msg);
        finish();
    }

    @Override
    public void onFail(String msg) {
        ToastManage.showText(getActivity(), msg);
    }

    @Override
    public void onError(String error) {
        ToastManage.showText(getActivity(), error);
    }


}
