package com.lingjuan.app.ui.fragment;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.lingjuan.app.R;
import com.lingjuan.app.adapter.RushSigAdapter;
import com.lingjuan.app.base.BaseFragment;
import com.lingjuan.app.constant.Constant;
import com.lingjuan.app.entity.Rusheeny;
import com.lingjuan.app.mvp.rush.view.RushInterface;
import com.lingjuan.app.mvp.rush.persenter.RushPersnter;
import com.lingjuan.app.ui.activity.PurchaseActivity;
import com.lingjuan.app.utils.ActivityUtils;
import com.lingjuan.app.utils.LogManage;
import com.lingjuan.app.utils.ToastManage;
import com.lingjuan.app.utils.purchase.PurchaseUtils;

import java.util.List;

/**
 * 抢购子页面
 * Created by TaoHui on 2018/10/9.
 */

public class SideFragment extends BaseFragment implements RushInterface.Pview<Rusheeny> {
    Unbinder unbinder;
    @BindView(R.id.recyclea)
    RecyclerView recyclea;
    private String hour_type;
    private int path = 1;
    private RushSigAdapter rushSigAdapter;
    private List<Rusheeny.DataBean> data;
    @Override
    protected void initview(View view) {
        unbinder = ButterKnife.bind(this, view);
        RecyclerView.LayoutManager manager = new LinearLayoutManager(getContext());
        recyclea.setLayoutManager(manager);
    }

    @Override
    protected void initData() {
        RushPersnter rushPersnter = new RushPersnter(this);
        rushPersnter.startData(hour_type, path);
    }

    public static SideFragment getInstance(String code) {
        SideFragment mf = new SideFragment();
        mf.hour_type = code;
        return mf;
    }

    @Override
    protected int getlayoutt() {
        return R.layout.item_rush_list;
    }

    @Override
    protected void onStopView() {
        LogManage.d("SideFragment视图销毁");
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void showDialog() {

    }

    @Override
    public void dissDialog() {

    }

    @Override
    public void showMessage(String msg) {
        ToastManage.showText(getActivity(),msg);
    }

    @Override
    public void RushCallback(Rusheeny rusheeny) {
        data = rusheeny.getData();
        rushSigAdapter = new RushSigAdapter(data,getContext());
        recyclea.setAdapter(rushSigAdapter);
        rushSigAdapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                Rusheeny.DataBean dataBean = data.get(position);
                ActivityUtils.goBeanActivity(PurchaseUtils.getJsonBean(dataBean), Constant.COMMODITY, getActivity(), PurchaseActivity.class);
            }
        });
    }

    @Override
    public void RushError(String s) {
        ToastManage.showText(getActivity(),s);
    }
}
