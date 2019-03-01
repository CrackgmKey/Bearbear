package com.lingjuan.app.customview;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.lingjuan.app.R;
import com.lingjuan.app.mvp.updata.Contract;
import com.lingjuan.app.utils.LogManage;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 升级弹窗
 * Created by TaoHui on 2018/10/28.
 */

public class UpgradeDialog extends Dialog implements View.OnClickListener {
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.tv_msg)
    TextView tvMsg;
    @BindView(R.id.btn_update)
    Button btnUpdate;
    @BindView(R.id.end)
    ImageView end;
    //标题
    private String Title;
    //更新内容
    private String msg;
    //接口回调
    public Contract.View view;
    //是否强制升级
    public boolean updata;

    public void setView(Contract.View view) {
        this.view = view;
    }

    public UpgradeDialog(@NonNull Context context, boolean updata) {
        super(context, R.style.UpdataDialogStyle);
        this.updata = updata;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.custom_dialog_two_layout);
        ButterKnife.bind(this);
        setCancelable(false);
        btnUpdate.setOnClickListener(this);
    }

    public void setTitle(String title) {
        Title = title;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }


    @Override
    public void show() {
        try {
            super.show();
        } catch (Exception e) {
            LogManage.e("s=============升级出现错误:" + e.toString());
        }
        if(updata){
            end.setVisibility(View.GONE);
        }else {
            end.setVisibility(View.VISIBLE);
        }
        tvTitle.setText(Title);
        tvMsg.setText(msg);
    }

    @Override
    public void onClick(View v) {
        //更新app
        view.downApp();
    }

    @OnClick(R.id.end)
    public void onViewClicked() {
        dismiss();
    }
}
