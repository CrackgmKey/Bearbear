package com.lingjuan.app.ui.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.VirtualLayoutManager;
import com.alibaba.android.vlayout.layout.GridLayoutHelper;
import com.alibaba.android.vlayout.layout.OnePlusNLayoutHelper;
import com.alibaba.android.vlayout.layout.StaggeredGridLayoutHelper;
import com.youth.banner.Banner;
import com.youth.banner.Transformer;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import com.lingjuan.app.R;
import com.lingjuan.app.adapter.OneLayoutAdapter;
import com.lingjuan.app.adapter.StaggeredGridLayoutAdapter;
import com.lingjuan.app.base.BaseActivity;
import com.lingjuan.app.utils.GlideImageLoader;

public class HoneActivity extends BaseActivity {
    @BindView(R.id.banner)
    Banner banner;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.xrecyclerview_main)
    RecyclerView recycleview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_activiity);
        ButterKnife.bind(this);
        toolbar.setTitle("123");
        List<String> stringList = new ArrayList<>();
        stringList.add("http://t2.hddhhn.com/uploads/tu/201703/306/qfoi31wu5oa.jpg");
        stringList.add("http://t2.hddhhn.com/uploads/tu/201703/306/sbasesgl2k5.jpg");
        stringList.add("http://t2.hddhhn.com/uploads/tu/201703/306/txbjgdznmd2.jpg");
        stringList.add("http://t2.hddhhn.com/uploads/tu/201806/9999/b0b70cdc4b.jpg");
        stringList.add("http://t2.hddhhn.com/uploads/tu/201806/9999/988c353c0a.jpg");
        stringList.add("http://t2.hddhhn.com/uploads/tu/201806/9999/ab3109d889.jpg");
        stringList.add("http://t2.hddhhn.com/uploads/tu/201806/9999/4a1435cb19.jpg");
        recycleview = findViewById(R.id.xrecyclerview_main);
        //设置加载源
        banner.setImageLoader(new GlideImageLoader());
        //设置动画
        banner.setBannerAnimation(Transformer.Default);
        banner.setImages(stringList);
        banner.setDelayTime(3000);
        banner.start();
        init();
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {

    }

    @Override
    protected int getLayout() {
        return R.layout.home_activiity;
    }

    @Override
    protected Activity getActivity() {
        return this;
    }

    /**
     * 初始化操作
     */
    private void init() {
        VirtualLayoutManager layoutManager = new VirtualLayoutManager(this);
        recycleview.setLayoutManager(layoutManager);
        RecyclerView.RecycledViewPool viewPool = new RecyclerView.RecycledViewPool();
        viewPool.setMaxRecycledViews(0, 10);
        recycleview.setRecycledViewPool(viewPool);
        DelegateAdapter delegateAdapter = new DelegateAdapter(layoutManager, false);

        List<Integer> mdataList = new ArrayList<>();
        GridLayoutHelper gridLayoutHelper = new GridLayoutHelper(5);
        gridLayoutHelper.setMarginTop(30);
        gridLayoutHelper.setVGap(5);
        //设置水平方向条目的间隔
        gridLayoutHelper.setHGap(5);
        gridLayoutHelper.setMarginLeft(30);
        gridLayoutHelper.setMarginBottom(30);
        //自动填充满布局
        gridLayoutHelper.setAutoExpand(true);


       // delegateAdapter.addAdapter(new GridLayoutAdapter(mdataList, gridLayoutHelper));

        List<Integer> goodSrc = new ArrayList<>();

        OnePlusNLayoutHelper onePlusNLayoutHelper1 = new OnePlusNLayoutHelper();
        onePlusNLayoutHelper1.setBgColor(R.color.colorPrimary);
        onePlusNLayoutHelper1.setPadding(10, 10, 10, 10);
        onePlusNLayoutHelper1.setColWeights(new float[]{50f});
        onePlusNLayoutHelper1.setMargin(10, 10, 10, 10);
       // delegateAdapter.addAdapter(new OneLayoutAdapter(goodSrc.subList(0, 2), onePlusNLayoutHelper1,getActivity()));

        OnePlusNLayoutHelper helper2 = new OnePlusNLayoutHelper();
        helper2.setBgColor(R.color.colorPrimary);
        helper2.setPadding(5, 10, 5, 5);
        helper2.setColWeights(new float[]{65f, 35f});
        helper2.setMargin(10, 10, 10, 10);
     //   delegateAdapter.addAdapter(new OneLayoutAdapter(goodSrc.subList(2, 4), helper2,getActivity()));

        OnePlusNLayoutHelper helper3 = new OnePlusNLayoutHelper();
        helper3.setBgColor(0xffef8ba3);
        helper3.setAspectRatio(2.0f);
        helper3.setColWeights(new float[]{40f});
        helper3.setRowWeight(30f);
        helper3.setMargin(10, 10, 10, 20);
        helper3.setPadding(10, 10, 10, 10);
      //  delegateAdapter.addAdapter(new OneLayoutAdapter(goodSrc.subList(4, 9), helper3,getActivity()));

        List<Integer> stagSrc = new ArrayList<>();


      /*  //Linear 布局
        LinearLayoutHelper linearHelper = new LinearLayoutHelper(10);
        delegateAdapter.addAdapter(new LinearAdapter(this, null, linearHelper));*/

        StaggeredGridLayoutHelper staggeredGridLayoutHelper = new StaggeredGridLayoutHelper(2);
        staggeredGridLayoutHelper.setHGap(5);
        staggeredGridLayoutHelper.setVGap(5);
        delegateAdapter.addAdapter(new StaggeredGridLayoutAdapter(this, stagSrc, staggeredGridLayoutHelper));
        recycleview.setAdapter(delegateAdapter);

    }
}
