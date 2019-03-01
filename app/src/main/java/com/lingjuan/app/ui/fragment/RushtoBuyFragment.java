package com.lingjuan.app.ui.fragment;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

import com.lingjuan.app.R;
import com.lingjuan.app.base.BaseFragment;
import com.lingjuan.app.utils.DateUtils;
import com.lingjuan.app.utils.LogManage;

/**
 * 抢购
 * Created by TaoHui on 2018/10/5.
 */

public class RushtoBuyFragment extends BaseFragment {

    @BindView(R.id.tablayout)
    TabLayout tablayout;
    @BindView(R.id.viiewpager)
    ViewPager viiewpager;
    Unbinder unbinder;
    private MyPagerAdapter adapter;
    private ArrayList<SideFragment> mFagments = new ArrayList<>();
    private List<String> stringList = new ArrayList<>();//tab名的列表
    private int [] ints  = {6,7,8,9,10};
    private String [] runtime = new String[5];
    private String [] strings = {"0","10","12","15","20"};
    private String TailTitle;
    private int count;
    List<String> AdList = new ArrayList<>();
    List<String> BcList = new ArrayList<>();
    private int chazhi;
    @Override
    protected void initview(View view) {
        unbinder = ButterKnife.bind(this, view);
        final String runtime = DateUtils.getCurrentTime();

        for (int i = 0 ;i < strings.length;i++){
            if(Integer.parseInt(runtime) >= Integer.parseInt(strings[i])){
                TailTitle = "疯狂抢购中";
                count = i;
            }else {
                TailTitle = "即将开始";
            }
            stringList.add(strings[i] + ":00\n" + TailTitle);
        }
        for (int s : ints) {
            mFagments.add(SideFragment.getInstance(String.valueOf(s)));
        }
        adapter = new MyPagerAdapter(getChildFragmentManager());
        viiewpager.setAdapter(adapter);
        viiewpager.setCurrentItem(count,false);
        tablayout.setupWithViewPager(viiewpager);
    }

    @Override
    protected void initData() {

    }

    @Override
    protected int getlayoutt() {
        return R.layout.rush_to_buy_frament;
    }

    @Override
    protected void onStopView() {
        LogManage.d("Fragment视图销毁");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    private class MyPagerAdapter extends FragmentPagerAdapter {

        public MyPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return mFagments.get(position);
        }


        @Override
        public CharSequence getPageTitle(int position) {
            return stringList.get(position);
        }


        @Override
        public int getCount() {
            return mFagments.size();
        }
    }
}
