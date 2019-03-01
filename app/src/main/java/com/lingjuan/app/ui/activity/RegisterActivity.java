package com.lingjuan.app.ui.activity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.lingjuan.app.R;
import com.lingjuan.app.base.BaseActivity;
import com.lingjuan.app.mvp.user.presenter.UserPresnter;
import com.lingjuan.app.mvp.user.view.UserView;
import com.lingjuan.app.utils.ActivityUtils;
import com.lingjuan.app.utils.DialogUtil;
import com.lingjuan.app.utils.Md5;
import com.lingjuan.app.utils.ToastManage;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.smssdk.EventHandler;
import cn.smssdk.SMSSDK;


/**
 * 注册页面
 * Created by TaoHui on 2018/10/28.
 */
public class RegisterActivity extends BaseActivity implements UserView.V {

    @BindView(R.id.imge_back)
    ImageView imgeBack;
    @BindView(R.id.back)
    LinearLayout back;
    @BindView(R.id.register_code_btn_text)
    TextView registerCodeBtnText;
    @BindView(R.id.register_code_btn)
    LinearLayout registerCodeBtn;
    @BindView(R.id.register_code)
    EditText registerCode;//验证码
    @BindView(R.id.register_btn)
    LinearLayout registerBtn;
    @BindView(R.id.register_phone)
    EditText registerPhone;//手机号
    @BindView(R.id.register_password)
    EditText registerPassword;//设置密码
    @BindView(R.id.register_confirm)
    EditText registerConfirm;//确定密码
    private UserPresnter persnter;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        ButterKnife.bind(this);
        context = this;
        initView();
    }

    @Override
    protected void initView() {
        persnter = new UserPresnter(this);
        initData();
    }


    @Override
    protected void initData() {
        SMSSDK.registerEventHandler(eventHandler);
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_register;
    }

    @Override
    protected Activity getActivity() {
        return this;
    }

    @OnClick({R.id.imge_back, R.id.back, R.id.register_code_btn, R.id.register_btn})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.imge_back:
                break;
            case R.id.back:
                finish();
                break;
            case R.id.register_code_btn:
                String phone = registerPhone.getText().toString().trim();
                if (TextUtils.isEmpty(phone)) {
                    ToastManage.showText(getContext(), "请输入手机号码");
                    return;
                } else if (!Md5.isMobileNO(phone)) {
                    ToastManage.showText(getContext(), "您请输入手机号码不正确");
                    return;
                }
                getSmsData(registerPhone.getText().toString());
                break;
            case R.id.register_btn:
                //手机号
                String Phone = registerPhone.getText().toString().trim();
                //验证码
                String Code = registerCode.getText().toString();
                //输入密码
                String Password = registerPassword.getText().toString();
                //确定密码
                String Confirm = registerConfirm.getText().toString();
                if (TextUtils.isEmpty(Phone)) {
                    ToastManage.showText(getContext(), "请输入手机号码");
                    return;
                } else if (!Md5.isMobileNO(Phone)) {
                    ToastManage.showText(getContext(), "您请输入手机号码不正确");
                    return;
                } else if (TextUtils.isEmpty(Code)) {
                    ToastManage.showText(getContext(), "验证码不能为空");
                    return;
                } else if (TextUtils.isEmpty(Password)) {
                    ToastManage.showText(getContext(), "密码1不能为空");
                    return;
                } else if (TextUtils.isEmpty(Confirm)) {
                    ToastManage.showText(getContext(), "密码2不能为空");
                    return;
                } else if (!Confirm.equals(Password)) {
                    ToastManage.showText(getContext(), "两次输入的密码不一致");
                    return;
                }
                sunmitCode(Phone, Code);
                break;
            default:break;
        }
    }

    /**
     * 发送验证码
     *
     * @param phone 手机号
     */
    private void getSmsData(String phone) {
        if(registerCodeBtnText.getText().toString().equals("获取验证码")){
            SMSSDK.getVerificationCode("86", phone);
        }

    }


    /**
     * 验证验证码
     *
     * @param photo 手机号
     * @param code  验证码
     */
    private void sunmitCode(String photo, String code) {
        SMSSDK.submitVerificationCode("86", photo, code);
    }

    /**
     * 短信回调
     */
    private EventHandler eventHandler = new EventHandler() {
        @Override
        public void afterEvent(int i, int i1, Object o) {
            super.afterEvent(i, i1, o);
            if (i == SMSSDK.EVENT_GET_VERIFICATION_CODE) {
                if (i1 == SMSSDK.RESULT_COMPLETE) {
                    handler.sendEmptyMessage(1);//发送验证码成功
                } else {
                    handler.sendEmptyMessage(2);//发送验证码失败
                }
            } else if (i == SMSSDK.EVENT_SUBMIT_VERIFICATION_CODE) {
                if (i1 == SMSSDK.RESULT_COMPLETE) {
                    handler.sendEmptyMessage(3);//验证验证码成功
                } else {
                    handler.sendEmptyMessage(4);//验证验证码失败
                }
            }
        }
    };

    @SuppressLint("HandlerLeak")
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 1:
                    ToastManage.showText(RegisterActivity.this, "发送验证码成功");
                    countDownTimer.start();
                    break;
                case 2:
                    ToastManage.showText(RegisterActivity.this, "发送验证码失败");
                    break;
                case 3:
                    //ToastManage.showText(RegisterActivity.this, "验证码验证成功");
                    getUserInfo();
                    break;
                case 4:
                    ToastManage.showText(RegisterActivity.this, "验证码验证失败");
                    break;
                default:break;
            }
        }
    };

    public Context getContext() {
        return context;
    }

    /**
     * 提交用户数据
     */
    private void getUserInfo() {
        //手机号
        String phone = registerPhone.getText().toString().trim();
        //验证码
        String code = registerCode.getText().toString();
        //确定密码
        String confirm = registerConfirm.getText().toString();
        //发起注册
        persnter.userReg(phone,code,confirm);
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
    public void onSuccess(String msg,String phone) {
        DialogUtil.showComfirmDialog(getActivity(), msg, (dialog, which) -> {
            dialog.dismiss();
            ActivityUtils.goActivity(phone,"phone",getActivity(),LoginActivity.class);
            finish();
        });
    }

    @Override
    public void onFail(String msg) {
        ToastManage.showText(getActivity(), msg);
    }

    @Override
    public void onError(String error) {
        ToastManage.showText(getActivity(), error);
    }



    public CountDownTimer countDownTimer = new CountDownTimer(60000,1000) {
        @Override
        public void onTick(long millisUntilFinished) {
            registerCodeBtnText.setEnabled(false);
            registerCodeBtnText.setText((Math.round((double) millisUntilFinished / 1000) - 1) + "秒");
        }

        @Override
        public void onFinish() {
            registerCodeBtnText.setEnabled(true);
            registerCodeBtnText.setText("获取验证码");
        }
    };

    @Override
    protected void onDestroy() {
        countDownTimer.cancel();
        super.onDestroy();
    }
}
