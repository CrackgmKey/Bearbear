package com.lingjuan.app.ui.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.lingjuan.app.R;
import com.lingjuan.app.adapter.FunctionalCommodityAdapter;
import com.lingjuan.app.base.BaseActivity;
import com.lingjuan.app.constant.Constant;
import com.lingjuan.app.customview.DataHashMap;
import com.lingjuan.app.entity.FunctionalCommodityRzy;
import com.lingjuan.app.mvp.functiona.presenter.FunctionCommodiPersenter;
import com.lingjuan.app.mvp.functiona.view.FunctionCommodi;
import com.lingjuan.app.utils.ActivityUtils;
import com.lingjuan.app.utils.ToastManage;
import com.lingjuan.app.utils.purchase.PurchaseUtils;
import com.yanzhenjie.recyclerview.SwipeRecyclerView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 商品类别情况
 * Created by TaoHui on 2018/10/18.
 */
public class FunctionalCommodityActivity extends BaseActivity implements FunctionCommodi.View {

    @BindView(R.id.image_return)
    ImageView imageReturn;
    @BindView(R.id.title_view)
    TextView titleView;
    @BindView(R.id.reclcieviwe)
    SwipeRecyclerView reclcieviwe;
    @BindView(R.id.refresh_layout)
    SwipeRefreshLayout refreshLayout;
    @BindView(R.id.tv_zonghe)
    TextView tvZonghe;
    @BindView(R.id.tv_xiaoliang)
    TextView tvXiaoliang;

    /**
     * 数据操作类
     */
    private FunctionCommodiPersenter functionCommodiPersenter;

    /**
     * 数据适配器
     */
    private FunctionalCommodityAdapter functionalCommodityAdapter;
    /**
     * mage_return
     */
    private List<FunctionalCommodityRzy.DataBean.ListBean> functionCommList;
    /**
     * 数据标示
     */
    private int min_price, max_price, sort, is_ju, news;

    /**
     * 数据类型
     */
    private boolean type;
    /**
     * title名字
     */
    private String name;

    /**
     * 当前页面的MID
     */
    private int mid = 1;
    private DataHashMap spicyhotMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_functional_commodity);
        ButterKnife.bind(this);
        min_price = getIntent().getExtras().getInt("min_price", 5);
        max_price = getIntent().getExtras().getInt("max_price", 999);
        sort = getIntent().getExtras().getInt("sort", 3);
        is_ju = getIntent().getExtras().getInt("is_ju", 0);
        type = getIntent().getExtras().getBoolean("type");
        name = getIntent().getExtras().getString("name");
        news = getIntent().getExtras().getInt("news");
        initView();
        initData();
    }

    @Override
    protected void initView() {
        titleView.setText(name);
        refreshLayout.setOnRefreshListener(refreshListener);
        reclcieviwe.setLayoutManager(new GridLayoutManager(this, 2));
        functionCommList = new ArrayList<>();
        functionalCommodityAdapter = new FunctionalCommodityAdapter(this, functionCommList);
        reclcieviwe.setAdapter(functionalCommodityAdapter);
        functionalCommodityAdapter.setOnItemChildClickListener((adapter, view, position) -> {
            FunctionalCommodityRzy.DataBean.ListBean dataBean = functionCommList.get(position);
            ActivityUtils.goBeanActivity(PurchaseUtils.getJsonBean(dataBean), Constant.COMMODITY, getActivity(), PurchaseActivity.class);
        });

        reclcieviwe.useDefaultLoadMore();
        reclcieviwe.setLoadMoreListener(loadMoreListener);
    }

    @Override
    protected void initData() {
        functionCommodiPersenter = new FunctionCommodiPersenter(this);
        getData();
    }

    private void getData(){
        spicyhotMap = DataHashMap.getInstance()
                .appParam("sort", String.valueOf(sort))
                .appParam("cat", String.valueOf(0))
                .appParam("news", String.valueOf(news))
                .appParam("page", String.valueOf(mid))
                .appParam("is_ju    ", String.valueOf(is_ju))
                .appParam("min_price", String.valueOf(min_price))
                .appParam("max_price", String.valueOf(max_price));
        functionCommodiPersenter.startData(spicyhotMap, 0);
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_functional_commodity;
    }

    @Override
    protected Activity getActivity() {
        return this;
    }

    @OnClick({R.id.image_return, R.id.title_view,R.id.tv_zonghe, R.id.tv_xiaoliang})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.image_return:
                finish();
                break;
            case R.id.title_view:
                break;
            case R.id.tv_zonghe:
                tvZonghe.setTextColor(getResources().getColor(R.color.color_sososu_red));
                tvXiaoliang.setTextColor(getResources().getColor(R.color.bg_fgs));
                mid = 1;
                sort = 1;
                getData();
                break;
            case R.id.tv_xiaoliang:
                tvXiaoliang.setTextColor(getResources().getColor(R.color.color_sososu_red));
                tvZonghe.setTextColor(getResources().getColor(R.color.bg_fgs));
                mid = 1;
                sort = 3;
                getData();
                break;
            default:break;
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
    public void dataSuccess(List<FunctionalCommodityRzy.DataBean.ListBean> functionComm) {
        if(mid == 1){
            functionCommList.clear();
        }
        this.functionCommList.addAll(functionComm);
        functionalCommodityAdapter.replaceData(functionCommList);
        if (functionComm.size() == 0) {
            reclcieviwe.loadMoreFinish(true, false);
            return;
        }
        // 数据完更多数据，一定要掉用这个方法。
        // 第一个参数：表示此次数据是否为空。
        // 第二个参数：表示是否还有更多数据。
        reclcieviwe.loadMoreFinish(false, true);
        mid++;
    }

    @Override
    public void onFaiMes(String msg) {
        ToastManage.showText(getActivity(), msg);
    }


    private SwipeRefreshLayout.OnRefreshListener refreshListener = new SwipeRefreshLayout.OnRefreshListener() {
        @Override
        public void onRefresh() {
            reclcieviwe.postDelayed(new Runnable() {
                @Override
                public void run() {
                    refreshLayout.setRefreshing(false);
                    ToastManage.showText(getActivity(), "刷新完毕");
                }
            }, 3000);
        }
    };


    private SwipeRecyclerView.LoadMoreListener loadMoreListener = new SwipeRecyclerView.LoadMoreListener() {
        @Override
        public void onLoadMore() {
            spicyhotMap = DataHashMap.getInstance()
                    .appParam("sort", String.valueOf(sort))
                    .appParam("cat", String.valueOf(0))
                    .appParam("page", String.valueOf(mid))
                    .appParam("is_ju    ", String.valueOf(is_ju))
                    .appParam("min_price", String.valueOf(min_price))
                    .appParam("max_price", String.valueOf(max_price));
            functionCommodiPersenter.startData(spicyhotMap, 0);
        }
    };

}
