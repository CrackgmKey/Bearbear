package com.lingjuan.app.ui.activity;

import android.app.Activity;
import android.graphics.Color;
import android.net.http.SslError;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.webkit.SslErrorHandler;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.jaeger.library.StatusBarUtil;
import com.lingjuan.app.R;
import com.lingjuan.app.base.BaseActivity;
import com.lingjuan.app.constant.Constant;
import com.lingjuan.app.entity.FootprintRzy;
import com.lingjuan.app.entity.PurchaseRzy;
import com.lingjuan.app.greendao.FootprintRzyDao;
import com.lingjuan.app.mvp.pruchase.persenter.PruchasePersnter;
import com.lingjuan.app.mvp.pruchase.view.PurchaseView;
import com.lingjuan.app.utils.ActivityUtils;
import com.lingjuan.app.utils.AlibcTradeSDKUtils;
import com.lingjuan.app.utils.DialogUtil;
import com.lingjuan.app.utils.GreenDaoUtils;
import com.lingjuan.app.utils.GsonUtil;
import com.lingjuan.app.utils.IntentUtils;
import com.lingjuan.app.utils.LogManage;
import com.lingjuan.app.utils.ToastManage;
import com.lingjuan.app.utils.WebImageUtils;
import com.lingjuan.app.utils.purchase.PurchaseUtils;
import com.lingjuan.app.wigth.CouponDisplayView;
import com.lingjuan.app.wigth.GradationScrollView;
import com.lingjuan.app.wigth.ScrollViewContainer;
import com.youth.banner.Banner;

import java.text.DecimalFormat;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 商品购买页面
 * Created by TaoHui on 2018/10/24.
 */

public class PurchaseActivity extends BaseActivity implements GradationScrollView.ScrollViewListener, PurchaseView.V, View.OnClickListener {
    @BindView(R.id.ll_good_detail)
    RelativeLayout llGoodDetail;
    @BindView(R.id.tv_good_detail_title_good)
    TextView tvGoodDetailTitleGood;
    @BindView(R.id.shangtou)
    GradationScrollView shangtou;
    @BindView(R.id.xiatou)
    GradationScrollView xiatou;
    @BindView(R.id.banner)
    Banner banner;
    @BindView(R.id.tv_commodityname)
    TextView tvCommodityname;
    @BindView(R.id.tv_commodityintroduce)
    TextView tvCommodityintroduce;
    @BindView(R.id.tv_postprice)
    TextView tvPostprice;
    @BindView(R.id.tv_commoditysales)
    TextView tvCommoditysales;
    @BindView(R.id.ll_offset)
    LinearLayout llOffset;
    @BindView(R.id.ll_good_detail_service)
    LinearLayout llGoodDetailService;
    @BindView(R.id.tv_money_text)
    TextView tvMoneyText;
    @BindView(R.id.tv_money)
    TextView tvMoney;
    @BindView(R.id.tv_coupon_msg)
    TextView tvCouponMsg;
    @BindView(R.id.tv_time)
    TextView tvTime;
    @BindView(R.id.tv_status)
    TextView tvStatus;
    @BindView(R.id.displayview)
    CouponDisplayView displayview;
    @BindView(R.id.namatitle)
    TextView namatitle;
    @BindView(R.id.layout)
    LinearLayout layout;
    @BindView(R.id.recycleadd)
    RecyclerView recycleadd;
    @BindView(R.id.tv_good_detail_tuodong)
    TextView tvGoodDetailTuodong;
    @BindView(R.id.sv_container)
    ScrollViewContainer svContainer;
    @BindView(R.id.iv_good_detai_back)
    ImageView ivGoodDetaiBack;
    @BindView(R.id.iv_good_detai_share)
    ImageView ivGoodDetaiShare;
    @BindView(R.id.ll_good_detail_collect)
    LinearLayout llGoodDetailCollect;
    @BindView(R.id.tv_good_detail_shop_cart)
    TextView tvGoodDetailShopCart;
    @BindView(R.id.tv_good_detail_buy)
    TextView tvGoodDetailBuy;
    @BindView(R.id.im_shopnpic)
    ImageView imShopnpic;
    @BindView(R.id.tv_shopname)
    TextView tvShopname;
    @BindView(R.id.im_shopntype)
    ImageView imShopntype;
    @BindView(R.id.webview)
    WebView webview;
    @BindView(R.id.tv_customerservice)
    TextView tvCustomerservice;
    @BindView(R.id.shoucang)
    TextView shoucang;
    private int height = 300;
    private PruchasePersnter pruchasePersnter;
    private PurchaseRzy.DataBean purchaseRzy;


    @Override
    protected void initView() {
        xiatou.setScrollViewListener(this);
        shangtou.setScrollViewListener(this);
        pruchasePersnter = new PruchasePersnter(this);
        ivGoodDetaiBack.setOnClickListener(this);
        webview.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }

            @Override
            public void onReceivedSslError(WebView view, SslErrorHandler handler, SslError error) {
                super.onReceivedSslError(view, handler, error);
                handler.proceed();
            }
        });
        //判断版本
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            webview.getSettings().setLayoutAlgorithm(WebSettings.LayoutAlgorithm.TEXT_AUTOSIZING);
        } else {
            webview.getSettings().setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NORMAL);
        }
    }

    @Override
    protected void initData() {
        //获取数据
        purchaseRzy = (PurchaseRzy.DataBean) IntentUtils.getInitialization().getData(Constant.COMMODITY, getIntent());
        //开始加载
        pruchasePersnter.forTheglory(purchaseRzy.getItemid());
    }

    @Override
    protected int getLayout() {
        return R.layout.purchase_activity;
    }

    @Override
    protected Activity getActivity() {
        return this;
    }


    @Override
    public void onScrollChanged(GradationScrollView scrollView, int x, int y, int oldx, int oldy) {
        if (y <= 0) {
            llGoodDetail.setBackgroundColor(Color.argb((int) 0, 255, 255, 255));
        } else if (y > 0 && y <= height) {
            float scale = (float) y / height;
            float alpha = (255 * scale);
            tvGoodDetailTitleGood.setTextColor(Color.argb((int) alpha, 1, 24, 28));
            llGoodDetail.setBackgroundColor(Color.argb((int) alpha, 255, 255, 255));
        } else {
            llGoodDetail.setBackgroundColor(Color.argb((int) 255, 255, 255, 255));
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
        StatusBarUtil.setTranslucentForCoordinatorLayout(this, height);
        initView();
        initData();
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
        ToastManage.showText(this, msg);
    }

    @Override
    public void SuccessfuData(PurchaseRzy.DataBean dataBean) {
        purchaseRzy = dataBean;
        setData(purchaseRzy);
    }

    @Override
    public void SuccessfuDataDetails(String picdata) {
        //展示加载详情
        String html = WebImageUtils.readAssetsTxt(this);
        html = html.replace("*", picdata);
        webview.loadData(html, "text/html; charset=UTF-8", null);
    }

    @Override
    public void ErrorFeedback(String msgn) {
        ToastManage.showText(this, msgn);
        DialogUtil.showDialog(getActivity(), "商品加载失败", "去看看其他的", new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void setData(PurchaseRzy.DataBean purchaseRzy) {
        //判断是否存在记录
        FootprintRzy footprintRzy = GreenDaoUtils.getCkDaoSession().getFootprintRzyDao().queryBuilder().where(FootprintRzyDao.Properties.Itemid.eq(purchaseRzy.getItemid())).unique();
        if (footprintRzy == null) {
            footprintRzy = GsonUtil.GsonToBean(GsonUtil.GsonString(purchaseRzy), FootprintRzy.class);
            //名字
            footprintRzy.setItemshorttitle(purchaseRzy.getItemtitle());
            //劵
            footprintRzy.setCouponmoney(purchaseRzy.getCouponmoney());
            //销量
            footprintRzy.setItemsale(purchaseRzy.getItemsale());
            //原价
            footprintRzy.setItemprice(purchaseRzy.getItemprice());
            try {
                //现价
                double xianjia = Double.parseDouble(purchaseRzy.getItemprice()) - Double.parseDouble(purchaseRzy.getCouponmoney());
                DecimalFormat df = new DecimalFormat("#.0");
                String str = df.format(xianjia);
                footprintRzy.setItemendprice(str);
                LogManage.d("========足迹添加成功：" + footprintRzy.getItemid());
                GreenDaoUtils.getCkDaoSession().getFootprintRzyDao().insert(footprintRzy);
            } catch (Exception e) {
            }
        }
        //设置信息
        PurchaseUtils.assignmentText(this, purchaseRzy, imShopnpic, imShopntype, banner, tvCommodityname, tvCommodityintroduce, tvPostprice, tvCommoditysales, tvMoney, tvTime, tvStatus, tvShopname);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv_good_detai_back:
                finish();
                break;
            default:
                break;
        }
    }

    @OnClick({R.id.tv_good_detail_shop_cart, R.id.tv_good_detail_buy, R.id.tv_customerservice, R.id.iv_good_detai_share})
    public void onViewClicked(View view) {
        showLoading();
        switch (view.getId()) {
            case R.id.tv_good_detail_shop_cart:
                AlibcTradeSDKUtils.showDetail(purchaseRzy.getItemid(), this);
                break;
            case R.id.tv_good_detail_buy:

                AlibcTradeSDKUtils.showUrl(purchaseRzy.getCouponurl(), this);
                break;
            case R.id.tv_customerservice:
                ActivityUtils.showQQ(this);
                break;
            case R.id.iv_good_detai_share:
                ToastManage.showText(getActivity(),"暂无分享平台");
                break;
            default:
                break;
        }
    }

    @Override
    protected void onPause() {
        dismissLoading();
        super.onPause();
    }

    @OnClick(R.id.shoucang)
    public void onViewClicked() {
        ToastManage.showText(getActivity(),"当前版本暂不支持收藏");
    }
}
