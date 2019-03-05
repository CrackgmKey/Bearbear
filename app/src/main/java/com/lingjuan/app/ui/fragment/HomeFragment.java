package com.lingjuan.app.ui.fragment;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.content.FileProvider;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.VirtualLayoutManager;
import com.alibaba.android.vlayout.layout.GridLayoutHelper;
import com.alibaba.android.vlayout.layout.LinearLayoutHelper;
import com.alibaba.android.vlayout.layout.OnePlusNLayoutHelper;
import com.lingjuan.app.BuildConfig;
import com.lingjuan.app.R;
import com.lingjuan.app.adapter.CommoditDataAdapter;
import com.lingjuan.app.adapter.GridLayoutAdapter;
import com.lingjuan.app.adapter.LinearAdapter;
import com.lingjuan.app.adapter.NoticeAdapter;
import com.lingjuan.app.adapter.OneLayoutAdapter;
import com.lingjuan.app.adapter.TodayAdapter;
import com.lingjuan.app.base.BaseFragment;
import com.lingjuan.app.constant.Constant;
import com.lingjuan.app.customview.DataHashMap;
import com.lingjuan.app.customview.UpgradeDialog;
import com.lingjuan.app.entity.AdvertisingData;
import com.lingjuan.app.entity.Commodity;
import com.lingjuan.app.entity.OutHheNewsRzy;
import com.lingjuan.app.mvp.commodity.CommodityInterface;
import com.lingjuan.app.mvp.data.persenter.DataPersenter;
import com.lingjuan.app.mvp.data.view.DataView;
import com.lingjuan.app.mvp.updata.Contract;
import com.lingjuan.app.ui.activity.DrawActivity;
import com.lingjuan.app.ui.activity.FunctionalCommodityActivity;
import com.lingjuan.app.ui.activity.PurchaseActivity;
import com.lingjuan.app.ui.activity.RushActivity;
import com.lingjuan.app.ui.activity.SupersearchActivity;
import com.lingjuan.app.utils.ActivityUtils;
import com.lingjuan.app.utils.AlibcTradeSDKUtils;
import com.lingjuan.app.utils.DialogUtil;
import com.lingjuan.app.utils.GlideImageLoader;
import com.lingjuan.app.utils.LogManage;
import com.lingjuan.app.utils.ToastManage;
import com.lingjuan.app.utils.UpdateMagas;
import com.lingjuan.app.utils.purchase.PurchaseUtils;
import com.yanzhenjie.recyclerview.SwipeRecyclerView;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;
import com.youth.banner.listener.OnBannerListener;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * 主页
 * Created by TaoHui on 2018/10/5.
 */

public class HomeFragment extends BaseFragment implements View.OnClickListener, Contract.View, GridLayoutAdapter.OnClickListener, DataView.View, OnBannerListener {
    @BindView(R.id.banner)
    Banner banner;
    @BindView(R.id.llTop)
    LinearLayout llTop;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.xrecyclerview_main)
    SwipeRecyclerView recycleview;
    Unbinder unbinder;
    @BindView(R.id.tvSearch)
    TextView tvSearch;
    @BindView(R.id.refresh_layout)
    SwipeRefreshLayout refreshLayout;
    Unbinder unbinder1;
    @BindView(R.id.shoppingcart)
    ImageView shoppingcart;
    //商品集合
    private List<Commodity.CommodityData> commodityDataList;
    //商品适配器
    private CommoditDataAdapter commoditDataAdapter;
    //商品数据
    private CommodityInterface.CommodityPresenter commodityPresenter;
    //列表商品
    private CommPresenter commPresenter;
    //更新操作
    private UpdateMagas updateMagas;
    //升级弹窗
    private UpgradeDialog upgradeDialog;
    //进度条 后期改
    private ProgressDialog progressDialog;
    //九宫格点击
    private GridLayoutAdapter gridLayoutAdapter;
    //九宫格数据
    private List<DataHashMap> mdataList;
    //加载数据
    private DataPersenter dataPersenter;
    //轮播数据
    private List<AdvertisingData.ResultBean> resultBeanList;
    private List<DataHashMap> noList;
    private NoticeAdapter noticeAdapter;
    private Commodity commodityBean;
    private TodayAdapter todayAdapter;
    /**
     * 当前第一个填充
     */
    private OneLayoutAdapter oneLayoutAdapter;
    private OneLayoutAdapter oneLayoutAdapterno;

    @Override
    protected void initview(View view) {
        banner = view.findViewById(R.id.banner);
        unbinder = ButterKnife.bind(this, view);
        //设置加载源
        banner.setImageLoader(new GlideImageLoader());
        //设置动画
        banner.setBannerAnimation(Transformer.Default);
        banner.setDelayTime(3000);
        resultBeanList = new ArrayList<>();
        banner.setOnBannerListener(this);
        tvSearch.setOnClickListener(this);
        updateMagas = new UpdateMagas();
        updateMagas.setContract(this, getContext());
        new Handler().postAtTime(() -> updateMagas.getApkInfo(), 2000);
        dataPersenter = new DataPersenter(this);
        //获取首页轮播图
        dataPersenter.getGoNewData(Constant.Message.WHEEL_NLANTING_AD);
    }

    @Override
    public void initData() {
        LogManage.d("==================反复");
        commPresenter = new CommPresenter();
        commodityDataList = new ArrayList<>();
        commodityPresenter = new CommodityInterface.CommodityPresenter(commPresenter);
        commoditDataAdapter = new CommoditDataAdapter(getContext(), commodityDataList);
        commodityPresenter.handledata(0);
        todayAdapter = new TodayAdapter(new LinearLayoutHelper(1), commodityDataList);
        init();
        commoditDataAdapter.setRecyclerListeners(new CommoditDataAdapter.RecyclerListeners() {
            @Override
            protected void onClick(int position) {
                Commodity.CommodityData dataBean = commodityDataList.get(position);
                ActivityUtils.goBeanActivity(PurchaseUtils.getJsonBean(dataBean), Constant.COMMODITY, getActivity(), PurchaseActivity.class);
            }
        });
    }


    @Override
    protected int getlayoutt() {
        return R.layout.home_fragment;
    }

    @Override
    protected void onStopView() {

    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    private SwipeRefreshLayout.OnRefreshListener onRefreshListener = new SwipeRefreshLayout.OnRefreshListener() {
        @Override
        public void onRefresh() {
            recycleview.postDelayed(new Runnable() {
                @Override
                public void run() {
                    refreshLayout.setRefreshing(false);
                    ToastManage.showText(getContext(), "刷新完毕");
                }
            }, 3000);
        }
    };


    private SwipeRecyclerView.LoadMoreListener loadMoreListener = new SwipeRecyclerView.LoadMoreListener() {
        @Override
        public void onLoadMore() {
            if (commodityBean != null) {
                commodityPresenter.handledata(commodityBean.getMin_id());
            } else {
                // 数据完更多数据，一定要掉用这个方法。
                // 第一个参数：表示此次数据是否为空。
                // 第二个参数：表示是否还有更多数据。
                recycleview.loadMoreFinish(false, false);
            }
        }
    };

    /**
     * 初始化操作
     */
    private void init() {
        VirtualLayoutManager layoutManager = new VirtualLayoutManager(getContext());
        recycleview.setLayoutManager(layoutManager);
        RecyclerView.RecycledViewPool viewPool = new RecyclerView.RecycledViewPool();
        viewPool.setMaxRecycledViews(0, 30);
        recycleview.setRecycledViewPool(viewPool);

        recycleview.useDefaultLoadMore(); // 使用默认的加载更多的View。
        recycleview.setLoadMoreListener(loadMoreListener); // 加载更多的监听。
        refreshLayout.setOnRefreshListener(onRefreshListener);
        DelegateAdapter delegateAdapter = new DelegateAdapter(layoutManager, false);
        //========================添加网格视图=======================================
        GridLayoutHelper gridLayoutHelper = new GridLayoutHelper(5);
        gridLayoutHelper.setMarginTop(30);
        gridLayoutHelper.setVGap(5);
        //设置水平方向条目的间隔
        gridLayoutHelper.setHGap(3);
        gridLayoutHelper.setMarginLeft(30);
        gridLayoutHelper.setMarginBottom(30);
        //自动填充满布局
        gridLayoutHelper.setAutoExpand(true);
        mdataList = new ArrayList<>();
        mdataList.add(new DataHashMap("9.9包邮", String.valueOf(R.mipmap.bcd1)));
        mdataList.add(new DataHashMap("大额卷", String.valueOf(R.mipmap.bcd12)));
        mdataList.add(new DataHashMap("聚划算", String.valueOf(R.mipmap.bcd13)));
        mdataList.add(new DataHashMap("活动", String.valueOf(R.mipmap.bcd14)));
        mdataList.add(new DataHashMap("抽奖", String.valueOf(R.mipmap.bcd15)));
        gridLayoutAdapter = new GridLayoutAdapter(mdataList, gridLayoutHelper);
        gridLayoutAdapter.setClickListener(this);
        delegateAdapter.addAdapter(gridLayoutAdapter);
        //=======================添加在线客服等========================================
        LinearLayoutHelper linearHelper = new LinearLayoutHelper(1);
        delegateAdapter.addAdapter(new LinearAdapter(getContext(), linearHelper, R.layout.layout_taype_title));
        //=======================添加公告==============================================
        noList = new ArrayList<>();
        noList.add(new DataHashMap("欢迎使用"));
        LinearLayoutHelper nohelper = new LinearLayoutHelper(1);
        nohelper.setMarginTop(2);
        noticeAdapter = new NoticeAdapter(getContext(), nohelper, noList);
        delegateAdapter.addAdapter(noticeAdapter);
        //============================添加一对多布局===================================
        List<Integer> goodSrc = new ArrayList<>();
        goodSrc.add(R.mipmap.baoguan2);
        goodSrc.add(R.mipmap.baokuan1);
        goodSrc.add(R.mipmap.baokuan4);
        goodSrc.add(R.mipmap.baoguan3);
        goodSrc.add(R.mipmap.img1);
        goodSrc.add(R.mipmap.img2);
        goodSrc.add(R.mipmap.p1);
        goodSrc.add(R.mipmap.p2);
        OnePlusNLayoutHelper onePlusNLayoutHelper1 = new OnePlusNLayoutHelper();
        onePlusNLayoutHelper1.setBgColor(R.color.font_noselect);
        onePlusNLayoutHelper1.setPadding(1, 1, 1, 1);
        onePlusNLayoutHelper1.setMargin(10, 1, 10, 10);
        oneLayoutAdapter = new OneLayoutAdapter(goodSrc.subList(0, 4), onePlusNLayoutHelper1, getActivity(), position -> {
            switch (position) {
                case 0:
                    Intent intent = new Intent(getContext(), FunctionalCommodityActivity.class);
                    //9.9包邮
                    intent.putExtra("sort", 3);
                    intent.putExtra("min_price", 2);
                    intent.putExtra("max_price", 10);
                    intent.putExtra("name", "9.9包邮");
                    getContext().startActivity(intent);
                    break;
                case 1:
                    Intent intenta = new Intent(getContext(), FunctionalCommodityActivity.class);
                    //聚划算
                    intenta.putExtra("type", true);
                    intenta.putExtra("is_ju", 1);
                    intenta.putExtra("name", "聚划算");
                    getContext().startActivity(intenta);
                    break;
                default:break;
            }
        });
        delegateAdapter.addAdapter(oneLayoutAdapter);
        OnePlusNLayoutHelper helper2 = new OnePlusNLayoutHelper();
        helper2.setBgColor(R.color.font_noselect);
        helper2.setColWeights(new float[]{50f});
        helper2.setPadding(1, 0, 1, 1);
        helper2.setMargin(10, 0, 10, 10);
        oneLayoutAdapterno = new OneLayoutAdapter(goodSrc.subList(4, 8), helper2, getActivity(), position -> {
            switch (position) {
                case 0:
                    Intent intent = new Intent(getContext(), RushActivity.class);
                    getContext().startActivity(intent);
                    break;
                case 1:
                    Intent intenta = new Intent(getContext(), FunctionalCommodityActivity.class);
                    //聚划算
                    //聚划算
                    intenta.putExtra("type", true);
                    intenta.putExtra("is_ju", 0);
                    intenta.putExtra("news", 1);
                    intenta.putExtra("name", "每日新品");
                    getContext().startActivity(intenta);
                    break;
                default:break;
            }
        });
        delegateAdapter.addAdapter(oneLayoutAdapterno);
        //==========================最新商品======================================
        LinearLayoutHelper zuixinhelper = new LinearLayoutHelper(1);
        delegateAdapter.addAdapter(new LinearAdapter(getContext(), zuixinhelper, R.layout.home_wellayout));
        //==========================瀑布流======================================
        delegateAdapter.addAdapter(commoditDataAdapter);
        //===============================================================================
        recycleview.setAdapter(delegateAdapter);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tvSearch:
                ActivityUtils.goActivity(Objects.requireNonNull(getActivity()), SupersearchActivity.class);
                break;
            default:
                break;
        }
    }

    @Override
    public void downLoading(int i) {
        Objects.requireNonNull(getActivity()).runOnUiThread(() -> progressDialog.setProgress(i));
    }

    @Override
    public void downSuccess(File file, String apkName) {

        Intent intent = new Intent(Intent.ACTION_VIEW);
        //判断是否是AndroidN以及更高的版本
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            intent.setFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
            Uri contentUri = FileProvider.getUriForFile(getContext(), BuildConfig.APPLICATION_ID + ".fileProvider", file);
            intent.setDataAndType(contentUri, "application/vnd.android.package-archive");
        } else {
            intent.setDataAndType(Uri.fromFile(file), "application/vnd.android.package-archive");
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        }
        startActivity(intent);
        System.exit(0);
    }

    @Override
    public void downFial() {

    }

    @Override
    public void setMax(int l) {
        getActivity().runOnUiThread(() -> {
            upgradeDialog.dismiss();
            progressDialog = new ProgressDialog(getContext());
            progressDialog.setTitle("正在下载中");
            progressDialog.setCanceledOnTouchOutside(false);
            progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
            progressDialog.setCancelable(false);
            progressDialog.setMax(l);
            progressDialog.show();
        });
    }

    @Override
    public void downShow(String title, String message, boolean updata) {
        LogManage.e("====弹出Dialog");
        upgradeDialog = new UpgradeDialog(getActivity(), updata);
        upgradeDialog.setTitle(title);
        upgradeDialog.setMsg(message);
        upgradeDialog.setView(this);
        upgradeDialog.show();

    }

    @Override
    public void downApp() {
        updateMagas.startApp();
    }

    @Override
    public void onGridItemClick(View view, int position) {
        Intent intent = new Intent(getContext(), FunctionalCommodityActivity.class);
        switch (position) {
            case 0:
                //9.9包邮
                intent.putExtra("sort", 3);
                intent.putExtra("min_price", 2);
                intent.putExtra("max_price", 10);
                intent.putExtra("name", "9.9包邮");
                getContext().startActivity(intent);
                break;
            case 1:
                //大额卷
                intent.putExtra("sort", 3);
                intent.putExtra("type", false);
                intent.putExtra("min_price", 100);
                intent.putExtra("max_price", 997);
                intent.putExtra("name", "大额卷");
                getContext().startActivity(intent);
                break;
            case 2:
                //聚划算
                intent.putExtra("type", true);
                intent.putExtra("is_ju", 1);
                intent.putExtra("name", "聚划算");
                getContext().startActivity(intent);
                break;
            case 3:
                //官方活动
                DialogUtil.showDialog(getActivity(), "暂无活动", "知道了", null);
                break;
            case 4:
                //分类
               /* intent.putExtra("min_price", 2);
                intent.putExtra("max_price", 9.9);
                intent.putExtra("name", "9.9包邮");*/
              //  DialogUtil.showDialog(getActivity(), "暂无抽奖", "知道了", null);
                ActivityUtils.goActivity(Objects.requireNonNull(getContext()),DrawActivity.class);
                break;
            default:
                return;
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
        ToastManage.showText(getContext(), msg);
    }

    @Override
    public void onSuccess(List<String> stringList,List<String> nameList, List<AdvertisingData.ResultBean> resultBeanList) {
        this.resultBeanList = resultBeanList;
        if (banner == null) {
            return;
        }
        banner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR_TITLE);//设置圆形指示器与标题
        banner.setIndicatorGravity(BannerConfig.RIGHT);//设置指示器位置
        banner.setBannerTitles(nameList);//设置标题源
        banner.setImages(stringList);
        banner.start();
    }

    @Override
    public void onErrorMsg(String msg) {
        List<String> stringList = new ArrayList<>();
        stringList.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1550211091387&di=ab348c82737e74cf206e465af77ad582&imgtype=0&src=http%3A%2F%2Fpic7.photophoto.cn%2F20080529%2F0034034812231827_b.jpg");
        stringList.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1550211091382&di=86c3733c38b5d9b71b9b1439402fcb3e&imgtype=0&src=http%3A%2F%2Fpic30.nipic.com%2F20130605%2F12949204_213054651194_2.jpg");
        stringList.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1550211091381&di=859d8ef7a71a8e8113946c857909f857&imgtype=0&src=http%3A%2F%2Fpic46.nipic.com%2F20140814%2F19268738_232534528000_2.jpg");
        stringList.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1550211091381&di=859d8ef7a71a8e8113946c857909f857&imgtype=0&src=http%3A%2F%2Fpic46.nipic.com%2F20140814%2F19268738_232534528000_2.jpg");
        stringList.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1550211091381&di=859d8ef7a71a8e8113946c857909f857&imgtype=0&src=http%3A%2F%2Fpic46.nipic.com%2F20140814%2F19268738_232534528000_2.jpg");
        banner.setImages(stringList);
        banner.start();
        // ToastManage.showText(getContext(),msg);
    }

    @Override
    public void onRollSuccess(List<OutHheNewsRzy.ResultBean> resultBeanList) {
        noList.clear();
        for (OutHheNewsRzy.ResultBean resultBean : resultBeanList) {
            noList.add(new DataHashMap(resultBean.getTitle()));
        }
        if (noList.size() == 0) {
            return;
        }
        noticeAdapter.setmDatas(noList);
    }

    @Override
    public void OnBannerClick(int position) {
        if(resultBeanList.size() == 0){
            ToastManage.showText(getActivity(),"轮播数据存在错误");
            return;
        }
        AdvertisingData.ResultBean dataBean = resultBeanList.get(position);
        if(TextUtils.isEmpty(dataBean.getUrl())){
            ToastManage.showText(getActivity(),"该商品没有设置商品Id");
            return;
        }
        ActivityUtils.goBeanActivity(PurchaseUtils.getJsonBean(dataBean), Constant.COMMODITY, getActivity(), PurchaseActivity.class);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        unbinder1 = ButterKnife.bind(this, rootView);
        return rootView;
    }

    @OnClick({R.id.shoppingcart})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.shoppingcart:
                AlibcTradeSDKUtils.showOrder(getActivity());
                break;
            default:break;

        }
    }

    public class CommPresenter implements CommodityInterface.PreseView {

        @Override
        public void showLoading() {
            ToastManage.showText(getContext(), "加载成功");
        }

        @Override
        public void hideLoading() {
            ToastManage.showText(getContext(), "加载完成");
        }

        @Override
        public void callbackData(Commodity commodity, int mid) {
            commodityBean = commodity;
            if (mid == 0) {
                commodityDataList = commodity.getData();
                commoditDataAdapter.setCommodityDataList(commodityDataList);
                todayAdapter.setData(commodity.getData());
            } else {
                commodityDataList.addAll(commodity.getData());
                commoditDataAdapter.setCommodityDataList(commodityDataList);
            }

            refreshLayout.setRefreshing(false);
            // 第一次加载数据：一定要调用这个方法，否则不会触发加载更多。
            // 第一个参数：表示此次数据是否为空，假如你请求到的list为空(== null || list.size == 0)，那么这里就要true。
            // 第二个参数：表示是否还有更多数据，根据服务器返回给你的page等信息判断是否还有更多，这样可以提供性能，如果不能判断则传true。
            recycleview.loadMoreFinish(false, true);
        }

        @Override
        public void failed(String message) {
            ToastManage.showText(getContext(), message);
        }

        @Override
        public void showMessage(String message) {
            ToastManage.showText(getContext(), message);
        }
    }


}
