package com.lingjuan.app.ui.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.lingjuan.app.R;
import com.lingjuan.app.adapter.ProudctAdapter;
import com.lingjuan.app.base.BaseActivity;
import com.lingjuan.app.constant.Constant;
import com.lingjuan.app.entity.ProducRzy;
import com.lingjuan.app.entity.Screeningstrategy;
import com.lingjuan.app.mvp.prouck.persenter.ProduckPresenter;
import com.lingjuan.app.mvp.prouck.view.ProducContract;
import com.lingjuan.app.utils.ActivityUtils;
import com.lingjuan.app.utils.ToastManage;
import com.lingjuan.app.utils.purchase.PurchaseUtils;
import com.lingjuan.app.wigth.CategoryButton;
import com.lingjuan.app.wigth.SearchPopupWindow;
import com.lingjuan.app.wigth.SearchTypePopupWindow;
import com.yanzhenjie.recyclerview.SwipeRecyclerView;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 搜索结果页面
 * Created by TaoHui on 2018/10/18.
 */
public class ProductActivity extends BaseActivity implements ProducContract.View, View.OnClickListener {

    @BindView(R.id.image_return)
    ImageView imageReturn;
    @BindView(R.id.llTop)
    LinearLayout llTop;
    @BindView(R.id.qiehuan)
    ImageView qiehuan;
    @BindView(R.id.senctoolbar)
    RelativeLayout senctoolbar;
    @BindView(R.id.recycleview)
    SwipeRecyclerView recycleview;
    RecyclerView.LayoutManager layoutManager;
    GridLayoutManager gridLayoutManager;
    ProduckPresenter produckPresenter;
    String QueryContent = "";
    ProudctAdapter proudctAdapter;
    List<ProducRzy.DataBean> dataBeanList;
    @BindView(R.id.categobtn1)
    CategoryButton categobtn1;
    @BindView(R.id.vwiw)
    LinearLayout vwiw;
    @BindView(R.id.zhezhaobuju)
    RelativeLayout zhezhaobuju;
    @BindView(R.id.categobtn2)
    CategoryButton categobtn2;
    @BindView(R.id.categobtn3)
    CategoryButton categobtn3;
    @BindView(R.id.categobtn4)
    CategoryButton categobtn4;
    @BindView(R.id.tvSearch)
    EditText tvSearch;
    @BindView(R.id.refresh_layout)
    SwipeRefreshLayout refreshLayout;
    private boolean type = false;
    private boolean issory;
    private boolean iscomprehensive = true;
    private SearchPopupWindow searchPopupWindow;
    private SearchTypePopupWindow searchTypePopupWindow;
    private Screeningstrategy screeningstrategy;
    private int is_tmall;
    int sort;
    private int types;
    private int mid = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);
        ButterKnife.bind(this);
        initView();
        initData();
    }


    @Override
    protected void initView() {
        types = getIntent().getExtras().getInt("type");
        QueryContent = getIntent().getExtras().getString("content", "");
        recycleview.setFocusable(true);
        recycleview.setFocusableInTouchMode(true);
        recycleview.requestFocus();
        tvSearch.setFocusable(false);
        tvSearch.setFocusableInTouchMode(false);
        tvSearch.setText(QueryContent);
        tvSearch.setSelection(QueryContent.length());
        layoutManager = new LinearLayoutManager(this);
        gridLayoutManager = new GridLayoutManager(this, 2);
        recycleview.setLayoutManager(gridLayoutManager);
        produckPresenter = new ProduckPresenter(this);
        dataBeanList = new ArrayList<>();
        proudctAdapter = new ProudctAdapter(dataBeanList, this, R.layout.item_commodity, screeningstrategy);
        recycleview.setAdapter(proudctAdapter);
        qiehuan.setOnClickListener(this);
        imageReturn.setOnClickListener(this);
        searchPopupWindow = new SearchPopupWindow(this);
        searchTypePopupWindow = new SearchTypePopupWindow(this);
        searchPopupWindow.setClickSucce(new SearchPopupWindow.OnClickSucce() {
            @Override
            public void getClickPosition(int position, int sont) {
              //  ToastManage.showText(ProductActivity.this, "您选择了" + position);
                zhezhaobuju.setVisibility(View.GONE);
                mid = 0;
                switch (position) {
                    case 0:
                        sort = 0;
                        break;
                    case 1:
                        sort = 1;
                        break;
                    case 2:
                        sort = 6;
                        break;
                    default:break;
                }
                runOnUiThread(() -> produckPresenter.getData(QueryContent, sort, is_tmall,mid));
            }

            @Override
            public void onAnimationEnd() {
                zhezhaobuju.setVisibility(View.VISIBLE);
            }
        });
        searchTypePopupWindow.setClickSucce(new SearchTypePopupWindow.OnClickSucce() {
            @Override
            public void getClickPosition(SearchTypePopupWindow.Meaning commoditymeaning, double price_min, double price_max) {
                screeningstrategy = new Screeningstrategy();
                screeningstrategy.setSource(commoditymeaning);
                is_tmall = commoditymeaning.equals(SearchTypePopupWindow.Meaning.Tmall) ? 1 : 0;
                runOnUiThread(() -> produckPresenter.getData(QueryContent, sort, is_tmall,mid));
                proudctAdapter.setScreeningstrategy(screeningstrategy);
            }

            @Override
            public void onAnimationEnd() {
                zhezhaobuju.setVisibility(View.VISIBLE);
            }

            @Override
            public void ToastMeeage(String msg) {
                ToastManage.showText(ProductActivity.this, msg);
            }
        });

        searchTypePopupWindow.setOnDismissListener(() -> {
            zhezhaobuju.setVisibility(View.GONE);
        });

        searchPopupWindow.setOnDismissListener(() -> {
            zhezhaobuju.setVisibility(View.GONE);
        });
        categobtn1.setPosition(0);
        categobtn2.setPosition(1);
        categobtn3.setPosition(2);
        categobtn4.setPosition(3);
    }


    @Override
    protected void initData() {
        runOnUiThread(() -> produckPresenter.getData(QueryContent, sort, is_tmall,mid));
        proudctAdapter.setOnItemClickListener((adapter, view, position) -> {
            ProducRzy.DataBean dataBean = dataBeanList.get(position);
            ActivityUtils.goBeanActivity(PurchaseUtils.getJsonBean(dataBean), Constant.COMMODITY, getActivity(), PurchaseActivity.class);
        });
        recycleview.useDefaultLoadMore();
        recycleview.setLoadMoreListener(loadMoreListener);
        refreshLayout.setOnRefreshListener(refreshListener);
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_product;
    }

    @Override
    public void showDialog() {
        //  ToastManage.showText(ProductActivity.this,"开始加载");
        showLoading();
    }

    @Override
    public void dissDialog() {
        //  ToastManage.showText(ProductActivity.this,"加载结束");
        dismissLoading();
    }

    @Override
    public void showMessage(String msg) {
        //    ToastManage.showText(ProductActivity.this,msg);
    }

    @Override
    public void onFailedMsg(String error) {
        ToastManage.showText(ProductActivity.this, error);
    }

    @Override
    public void onSuccess(List<ProducRzy.DataBean> userBean,int mid) {
        runOnUiThread(() -> {
            if(this.mid == 0){
                dataBeanList.clear();
                proudctAdapter.replaceData(dataBeanList);
                dataBeanList  = userBean;
                proudctAdapter.replaceData(dataBeanList);
            }else {
                dataBeanList.addAll(userBean);
            }
            this.mid = mid;

            if(userBean.size() == 0){
                recycleview.loadMoreFinish(true, false);
                return;
            }
            recycleview.loadMoreFinish(false, true);
            proudctAdapter.replaceData(dataBeanList);
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.qiehuan:
/*                if (type) {
                    qiehuan.setBackgroundResource(R.mipmap.heng);
                    type item_commoditycolumn= false;
                    recycleview.setLayoutManager(layoutManager);
                    proudctAdapter = new ProudctAdapter(dataBeanList, this, R.layout.item_commoditycolumn, screeningstrategy);
                    recycleview.setAdapter(proudctAdapter);
                } else {
                    qiehuan.setBackgroundResource(R.mipmap.shu);
                    type = true;
                    recycleview.setLayoutManager(gridLayoutManager);
                    proudctAdapter = new ProudctAdapter(dataBeanList, this, R.layout.item_commodity, screeningstrategy);
                    recycleview.setAdapter(proudctAdapter);
                }*/

                break;
            case R.id.image_return:
                finish();
                break;
            default:break;
        }
    }

    @Override
    protected Activity getActivity() {
        return this;
    }

    @OnClick({R.id.categobtn2, R.id.categobtn3, R.id.categobtn4, R.id.categobtn1, R.id.tvSearch})
    public void onViewClicked(View view) {
        mid = 0;
        switch (view.getId()) {
            case R.id.categobtn1:
                categobtn1.setColr(0);
                categobtn2.setColr(0);
                categobtn3.setColr(0, issory);
                categobtn4.setColr(0);
                if (iscomprehensive) {
                    searchPopupWindow.showAsDropDown(vwiw);
                } else {
                    iscomprehensive = true;
                    searchPopupWindow.addData();
                }
                sort = 0;

                runOnUiThread(() -> produckPresenter.getData(QueryContent, sort, is_tmall,mid));
                break;
            case R.id.categobtn2:
                iscomprehensive = false;
                categobtn2.setColr(1);
                categobtn1.setColr(1);
                categobtn3.setColr(1, issory);
                categobtn4.setColr(1);
                sort = 2;
                runOnUiThread(() -> produckPresenter.getData(QueryContent, sort, is_tmall,mid));
                break;
            case R.id.categobtn3:
                iscomprehensive = false;
                categobtn3.setColr(2, issory);
                categobtn2.setColr(2);
                categobtn1.setColr(2);
                categobtn4.setColr(2);
                sort = issory ? 5 : 4;
                runOnUiThread(() -> produckPresenter.getData(QueryContent, sort, is_tmall,mid));
                issory = !issory;
                break;
            case R.id.categobtn4:
             /*   iscomprehensive = false;
                categobtn3.setColr(3, issory);
                categobtn2.setColr(3);
                categobtn1.setColr(3);
                categobtn4.setColr(3);*/
                searchTypePopupWindow.showAsDropDown(vwiw);
                break;
            case R.id.tvSearch:
                if (types != 0) {
                    ActivityUtils.goActivity(Objects.requireNonNull(getActivity()), SupersearchActivity.class);
                } else {
                    finish();
                }
                break;
            default:
                break;
        }
    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }


    SwipeRefreshLayout.OnRefreshListener refreshListener = new SwipeRefreshLayout.OnRefreshListener() {
        @Override
        public void onRefresh() {
            recycleview.postDelayed(new Runnable() {
                @Override
                public void run() {
                    refreshLayout.setRefreshing(false);
                   ToastManage.showText(getActivity(),"加载成功");
                }
            },3000);
        }
    };

    private SwipeRecyclerView.LoadMoreListener loadMoreListener = new SwipeRecyclerView.LoadMoreListener() {
        @Override
        public void onLoadMore() {
            runOnUiThread(() -> produckPresenter.getData(QueryContent, sort, is_tmall,mid));
        }
    };
}
