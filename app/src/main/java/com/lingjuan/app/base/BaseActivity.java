package com.lingjuan.app.base;
import android.app.Activity;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.android.tu.loadingdialog.LoadingDailog;
import com.lingjuan.app.utils.ToastManage;
import com.jaeger.library.StatusBarUtil;

import com.lingjuan.app.R;

import butterknife.ButterKnife;

/**
 * Created by TaoHui on 2018/10/5.
 */
public abstract class BaseActivity extends AppCompatActivity {
    private LoadingDailog.Builder loadBuilder;
    private LoadingDailog loadingDailog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayout());
        ButterKnife.bind(this);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        StatusBarUtil.setTranslucentForImageView(this, getResources().getColor(R.color.colorPrimary),null);
        loadBuilder=new LoadingDailog.Builder(this)
                .setCancelable(false)
                .setMessage("加载中...")
                .setCancelOutside(true);
        loadingDailog=loadBuilder.create();
    }

    /**
     * 初始化控件
     */
    protected abstract void initView();
    /**
     * 加载数据
     */
    protected abstract void initData();
    /**
     *  返回布局Id
     */
    protected abstract int getLayout();

    /**
     *  返回自身
     */
    protected abstract Activity getActivity();


    public void toast(Context context,String msg){
        ToastManage.showText(context,msg);

    }

    /**
     * 加载弹窗
     */
    public void showLoading(){
        if(!isFinishing()){
            loadingDailog.show();
        }
    }

    /**
     * 关闭加载
     */
    public void dismissLoading(){
        if(loadingDailog.isShowing() && !isFinishing()){
            loadingDailog.dismiss();
        }
    }

}
