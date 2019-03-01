package com.lingjuan.app.ui.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.lingjuan.app.R;
import com.lingjuan.app.adapter.LotterytAdapter;
import com.lingjuan.app.base.BaseActivity;
import com.lingjuan.app.entity.LotterytRzy;
import com.lingjuan.app.mvp.lotteryt.view.LotterytInterface;
import com.lingjuan.app.mvp.lotteryt.persenter.LotterytPresenter;
import com.lingjuan.app.utils.ToastManage;
import com.lingjuan.app.wigth.LoadLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 积分购页面
 * Created by TaoHui on 2018/10/18.
 */
public class GamblingSpActivity extends BaseActivity implements LotterytInterface.View {
    @BindView(R.id.reclcieviwe)
    RecyclerView reclcieviwe;
    @BindView(R.id.loading_layout)
    LoadLayout loadingLayout;
    private LotterytPresenter presenter;
    private LotterytAdapter lotterytAdapter;
    private List<LotterytRzy> lotterytRzyList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gambling);
        ButterKnife.bind(this);
        initView();
        initData();
    }

    @Override
    protected void initView() {
        presenter = new LotterytPresenter(this);
        lotterytRzyList = new ArrayList<>();
        lotterytAdapter = new LotterytAdapter(this, lotterytRzyList);
        GridLayoutManager layoutManager = new GridLayoutManager(this, 2);
        reclcieviwe.setLayoutManager(layoutManager);
        reclcieviwe.setAdapter(lotterytAdapter);
    }

    @Override
    protected void initData() {
        presenter.onStartCrazy();
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_gambling;
    }

    @Override
    protected Activity getActivity() {
        return this;
    }

    @Override
    public void showDialog() {
        loadingLayout.showLoading();
    }

    @Override
    public void dissDialog() {
        loadingLayout.LoadingSuccess();
    }

    @Override
    public void showMessage(String msg) {
        ToastManage.showText(getActivity(), msg);
    }

    @Override
    public void onFailMsg(String msg) {
       loadingLayout.LoadingFail();
        ToastManage.showText(getActivity(), msg);
    }

    @Override
    public void onSuccessData(List<LotterytRzy> lotterytRzyList) {
        this.lotterytRzyList.addAll(lotterytRzyList);
        lotterytAdapter.notifyDataSetChanged();
    }

    @Override
    public void onErrorMsg(String msg) {
        ToastManage.showText(getActivity(), msg);
    }
}
