package com.lingjuan.app.ui.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.lingjuan.app.R;
import com.lingjuan.app.base.BaseActivity;
import com.lingjuan.app.entity.EventBusRzy;
import com.lingjuan.app.utils.ActivityUtils;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 登录页面
 * Created by TaoHui on 2018/10/28.
 */
public class LoginActivity extends BaseActivity {

    @BindView(R.id.back)
    ImageView back;
    @BindView(R.id.login_register)
    LinearLayout loginRegister;
    @BindView(R.id.login_phone)
    LinearLayout loginPhone;
    @BindView(R.id.login_wechat)
    LinearLayout loginWechat;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        EventBus.getDefault().register(this);
        ButterKnife.bind(this);
        initView();
        initData();
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {

    }

    @Override
    protected int getLayout() {
        return R.layout.activity_login;
    }

    @OnClick({R.id.back, R.id.login_register, R.id.login_phone, R.id.login_wechat})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.back:
                finish();
                break;
            case R.id.login_register:
                ActivityUtils.goActivity(this,RegisterActivity.class);
                break;
            case R.id.login_phone:
                ActivityUtils.goActivity(this,PhoneLoginActivity.class);
                break;
            case R.id.login_wechat:
                break;
            default:break;
        }
    }

    @Override
    protected Activity getActivity() {
        return this;
    }

    @Subscribe(threadMode = ThreadMode.MAIN, sticky = true)
    public void getEventData(EventBusRzy eventBusRzy) {
        switch (eventBusRzy.getCode()) {
            case EventBusRzy.USER_LOGIIN:
                finish();
                break;
            default:break;
        }
    }


}
