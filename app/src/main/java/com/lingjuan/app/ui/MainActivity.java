package com.lingjuan.app.ui;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;

import com.lingjuan.app.R;
import com.lingjuan.app.base.BaseActivity;
import com.lingjuan.app.entity.EventBusRzy;
import com.lingjuan.app.ui.activity.SplashActivity;
import com.lingjuan.app.ui.fragment.CommunicationFragment;
import com.lingjuan.app.ui.fragment.FindFragment;
import com.lingjuan.app.ui.fragment.HomeFragment;
import com.lingjuan.app.ui.fragment.MyFragment;
import com.lingjuan.app.ui.fragment.SuperClassFragment;
import com.lingjuan.app.utils.ActivityUtils;
import com.lingjuan.app.utils.DialogUtil;
import com.lingjuan.app.utils.LogManage;
import com.lingjuan.app.utils.ToastManage;
import com.lingjuan.app.wigth.NoScrollViewPager;
import com.orhanobut.logger.Logger;
import com.tbruyelle.rxpermissions.RxPermissions;

import org.greenrobot.eventbus.EventBus;


public class MainActivity extends BaseActivity implements TabLayout.OnTabSelectedListener{
    //Tab 文字
    private final int[] TAB_TITLES = new int[]{R.string.home, R.string.superclass, R.string.find,R.string.rushtobuy, R.string.my};
   // private final int[] TAB_TITLES = new int[]{R.string.home, R.string.superclass, R.string.find,R.string.rushtobuy};
    //Tab 图片
    private final int[] TAB_IMGS = new int[]{R.drawable.selector_home, R.drawable.selector_super,R.drawable.selector_fin,R.drawable.selector_rushtobuy, R.drawable.selector_my};
   // private final int[] TAB_IMGS = new int[]{R.drawable.selector_home, R.drawable.selector_super,R.drawable.selector_fin,R.drawable.selector_rushtobuy};
    //Fragment 数组
   private final Fragment[] TAB_FRAGMENTS = new Fragment[]{new HomeFragment(), new SuperClassFragment(), new CommunicationFragment(), new FindFragment(), new MyFragment()};
   // private final Fragment[] TAB_FRAGMENTS = new Fragment[]{new HomeFragment(), new SuperClassFragment(), new CommunicationFragment(), new FindFragment()};
    @BindView(R.id.viewpager)
    NoScrollViewPager viewpager;
    @BindView(R.id.tablayout)
    TabLayout tablayout;
    private MyViewPagerAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initView();
        ActivityUtils.goActivity(this,SplashActivity.class);

    }







    @Override
    protected void initView() {
        setTaybar();
        mAdapter = new MyViewPagerAdapter(getSupportFragmentManager());
        viewpager.setAdapter(mAdapter);
        viewpager.setOffscreenPageLimit(4);
        viewpager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tablayout));
        tablayout.setOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener(viewpager));
        tablayout.addOnTabSelectedListener(this);
        getData();
    }

    private void setTaybar() {
        for (int i = 0; i < TAB_TITLES.length; i++) {
            TabLayout.Tab tab = tablayout.newTab();
            View view = LayoutInflater.from(this).inflate(R.layout.tab_custom, null);
            tab.setCustomView(view);
            TextView tvTitle = (TextView) view.findViewById(R.id.tv_tab);
            tvTitle.setText(TAB_TITLES[i]);
            ImageView imgTab = (ImageView) view.findViewById(R.id.img_tab);
            imgTab.setImageResource(TAB_IMGS[i]);
            if (tab.getCustomView() != null) {
                View tabView = (View) tab.getCustomView().getParent();
                tabView.setTag(i);
                tabView.setOnClickListener(onClickListener);
            }
            tablayout.addTab(tab);
        }
    }

    @Override
    protected void initData() {

    }

    @Override
    protected int getLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected Activity getActivity() {
        return this;
    }

    @Override
    public void onTabSelected(TabLayout.Tab tab) {
        EventBus.getDefault().post(new EventBusRzy<>(EventBusRzy.USER_LOGIIN,""));
        Logger.e("TAG","onTabSelected position:"+tab.getPosition());
    }

    @Override
    public void onTabUnselected(TabLayout.Tab tab) {
        EventBus.getDefault().post(new EventBusRzy<>(EventBusRzy.USER_LOGIIN,""));
        Logger.e("TAG","onTabUnselected position:"+tab.getPosition());
    }

    @Override
    public void onTabReselected(TabLayout.Tab tab) {
        Logger.e("TAG","onTabReselected position:"+tab.getPosition());
        EventBus.getDefault().post(new EventBusRzy<>(EventBusRzy.USER_LOGIIN,""));
    }

    private class MyViewPagerAdapter extends FragmentPagerAdapter {

        public MyViewPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return TAB_FRAGMENTS[position];
        }

        @Override
        public int getCount() {
            return TAB_FRAGMENTS.length;
        }
    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
        moveTaskToBack(false); // 关键的一行代码
    }


    public void getData(){

    }


    public View.OnClickListener onClickListener = v -> {
        int position = (int) v.getTag();
        if(position == 4){
            /*if (TextUtils.isEmpty(UserInfo.getInstance().getUsename())){
                ActivityUtils.goActivity(Objects.requireNonNull(this), LoginActivity.class);
                toast(this,"请先登录");
            }*/
        }
    };
}
