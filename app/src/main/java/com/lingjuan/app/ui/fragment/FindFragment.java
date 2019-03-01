package com.lingjuan.app.ui.fragment;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;

import com.lingjuan.app.R;
import com.lingjuan.app.adapter.UptoAdapter;
import com.lingjuan.app.base.BaseFragment;
import com.lingjuan.app.constant.Constant;
import com.lingjuan.app.entity.Commodity;
import com.lingjuan.app.mvp.upto.presenter.UotpPersnter;
import com.lingjuan.app.mvp.upto.view.UptoView;
import com.lingjuan.app.ui.activity.PurchaseActivity;
import com.lingjuan.app.utils.ActivityUtils;
import com.lingjuan.app.utils.ToastManage;
import com.lingjuan.app.utils.purchase.PurchaseUtils;
import com.lingjuan.app.wigth.RushRadioButton;
import com.yanzhenjie.recyclerview.SwipeRecyclerView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * 抢购页面
 * Created by TaoHui on 2018/10/5.
 */

public class FindFragment extends BaseFragment implements CompoundButton.OnCheckedChangeListener, UptoView.uptoview {
    Unbinder unbinder;
    @BindView(R.id.rushbutton1)
    RushRadioButton rushbutton1;
    @BindView(R.id.rushbutton2)
    RushRadioButton rushbutton2;
    @BindView(R.id.rushbutton3)
    RushRadioButton rushbutton3;
    @BindView(R.id.rushbutton4)
    RushRadioButton rushbutton4;
    @BindView(R.id.recyclview)
    SwipeRecyclerView recyclview;
    @BindView(R.id.refresh_layout)
    SwipeRefreshLayout refreshLayout;
    Unbinder unbinder1;
    private UotpPersnter uotpPersnter;
    private int page = 1;//页数
    private String type = "top100";
    private UptoAdapter uptoAdapter;
    private List<Commodity.CommodityData> data;
    private int mid;
    @Override
    protected void initview(View view) {
        unbinder = ButterKnife.bind(this, view);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclview.setLayoutManager(layoutManager);
    }

    @Override
    protected void initData() {
        data = new ArrayList<>();
        uptoAdapter = new UptoAdapter(data);
        uptoAdapter.setContext(getContext());
        uptoAdapter.setOnItemChildClickListener((adapter, view, position) -> {
            Commodity.CommodityData dataBean = data.get(position);
            ActivityUtils.goBeanActivity(PurchaseUtils.getJsonBean(dataBean), Constant.COMMODITY, getContext(), PurchaseActivity.class);
        });
        uotpPersnter = new UotpPersnter(this);
        rushbutton1.setOnCheckedChangeListener(this);
        rushbutton2.setOnCheckedChangeListener(this);
        rushbutton3.setOnCheckedChangeListener(this);
        rushbutton4.setOnCheckedChangeListener(this);
        rushbutton2.defaultText();
        rushbutton3.defaultText();
        rushbutton4.defaultText();
        rushbutton1.initTrueText();
        rushbutton1.setChecked(true);
        uotpPersnter.SuccedGo(page, type,mid);
        refreshLayout.setOnRefreshListener(refreshListener);
        recyclview.useDefaultLoadMore();
        recyclview.setLoadMoreListener(loadMoreListener);

    }


    private SwipeRecyclerView.LoadMoreListener loadMoreListener = new SwipeRecyclerView.LoadMoreListener() {
        @Override
        public void onLoadMore() {
            uotpPersnter.SuccedGo(page, type,mid);
        }
    };

    private SwipeRefreshLayout.OnRefreshListener refreshListener = new SwipeRefreshLayout.OnRefreshListener() {
        @Override
        public void onRefresh() {
                recyclview.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        refreshLayout.setRefreshing(false);
                        ToastManage.showText(getActivity(),"刷新成功");
                    }
                },3000);
        }
    };


    @Override
    protected int getlayoutt() {
        return R.layout.find_frament;
    }

    @Override
    protected void onStopView() {
        unbinder.unbind();
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        if (isChecked)
            switch (buttonView.getId()) {
                case R.id.rushbutton1:
                    type = "top100";
                    page = 1;
                    mid = 0;
                    uotpPersnter.SuccedGo(page, type,mid);
                    rushbutton2.defaultText();
                    rushbutton3.defaultText();
                    rushbutton4.defaultText();
                    rushbutton1.initTrueText();
                    break;
                case R.id.rushbutton2:
                    type = "dapai";
                    page = 2;
                    mid = 0;
                    uotpPersnter.SuccedGo(page, type,mid);
                    rushbutton1.defaultText();
                    rushbutton3.defaultText();
                    rushbutton4.defaultText();
                    rushbutton2.initTrueText();
                    break;
                case R.id.rushbutton3:
                    type = "jhs";
                    page = 4;
                    mid = 0;
                    uotpPersnter.SuccedGo(page, type,mid);
                    rushbutton1.defaultText();
                    rushbutton2.defaultText();
                    rushbutton4.defaultText();
                    rushbutton3.initTrueText();
                    break;
                case R.id.rushbutton4:
                    type = "bipai";
                    page = 5;
                    mid = 0;
                    uotpPersnter.SuccedGo(page, type,mid);
                    rushbutton1.defaultText();
                    rushbutton2.defaultText();
                    rushbutton3.defaultText();
                    rushbutton4.initTrueText();
                    break;
                default:break;
            }
    }

    @Override
    public void showDialog() {
        ToastManage.showText(getContext(), "开始加载");
        showLoading();
    }

    @Override
    public void dissDialog() {
        dismissLoading();
        ToastManage.showText(getContext(), "加载结束");
    }

    @Override
    public void showMessage(String msg) {
        ToastManage.showText(getContext(), msg);
    }

    @Override
    public void uptoSucceed(List<Commodity.CommodityData> data) {
        this.data.addAll(data);
        uptoAdapter.replaceData(this.data);
        if(data.size() == 0){
            recyclview.loadMoreFinish(true, false);
            return;
        }
        recyclview.loadMoreFinish(false, true);
        recyclview.setAdapter(uptoAdapter);
    }

    @Override
    public void error(String e) {
        ToastManage.showText(getContext(), e);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        unbinder1 = ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder1.unbind();
    }

}
