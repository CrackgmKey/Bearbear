package com.lingjuan.app.ui.activity;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.LinearLayout;

import com.lingjuan.app.R;
import com.lingjuan.app.base.BaseActivity;
import com.lingjuan.app.customview.TasksCompletedView;
import com.lingjuan.app.entity.FootprintRzy;
import com.lingjuan.app.greendao.FootprintRzyDao;
import com.lingjuan.app.ui.MainActivity;
import com.lingjuan.app.utils.DialogUtil;
import com.lingjuan.app.utils.GreenDaoUtils;
import com.lingjuan.app.utils.LogManage;
import com.lingjuan.app.utils.ToastManage;
import com.tbruyelle.rxpermissions.RxPermissions;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import rx.functions.Action1;

/**
 * @author: TaoHui
 * @date: 2019/2/15
 * 开屏广告
 */
public class SplashActivity extends BaseActivity implements TasksCompletedView.CallBack {
    @BindView(R.id.mTasksView)
    TasksCompletedView mTasksView;
    @BindView(R.id.lvSkip)
    LinearLayout lvSkip;
    private int mCurrentProgress;

    @Override
    protected void initView() {
        mTasksView.setCallBack(this);
        mTasksView.setTotalProgress(3 + 1);
    }

    @Override
    protected void initData() {

        new CountDownTimer(5000, 1000) {

            public void onTick(long millisUntilFinished) {
                mCurrentProgress += 1;
                mTasksView.setProgress(mCurrentProgress);
                LogManage.d("=======当前时间：" + mCurrentProgress);
            }

            public void onFinish() {
                finish();
            }
        }.start();


        //判断安卓版本
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            requestPermission();
        } else {
            //判断是否有存储权限
            if (!CheckPermission(getActivity(), Manifest.permission.WRITE_EXTERNAL_STORAGE)) {
                LogManage.d("====不具备存储权限："+Build.VERSION.SDK_INT);
                requestPermission();
            }
        }
        toast(getActivity(),"小熊优品需要存储权限,请您同意,拒绝后软件将不能自动更新");
        LogManage.d("====本机安卓版本："+Build.VERSION.SDK_INT);
    }


    public boolean CheckPermission(Context context, String permission) {
        if (ContextCompat.checkSelfPermission(context, permission) == PackageManager.PERMISSION_GRANTED) {
            return true;
        } else {
            return false;
        }
    }


    private void requestPermission() {
        if (ContextCompat.checkSelfPermission(SplashActivity.this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            //没有权限则申请权限
            RxPermissions.getInstance(getActivity()).request(Manifest.permission.WRITE_EXTERNAL_STORAGE)
                    .subscribe(aBoolean -> {
                        if (aBoolean) {
                            ToastManage.showText(getActivity(), "成功");
                        } else {
                            ToastManage.showText(getActivity(), "没有存储权限,小熊优品则无法在线更新");
                        }
                    });
        }
    }



    @Override
    protected int getLayout() {
        return R.layout.activity_splash;
    }

    @Override
    protected Activity getActivity() {
        return this;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
        initView();
        initData();
    }

    @OnClick(R.id.lvSkip)
    public void onViewClicked() {
        finish();
    }

    @Override
    public void stopAd() {
        finish();
    }


}
