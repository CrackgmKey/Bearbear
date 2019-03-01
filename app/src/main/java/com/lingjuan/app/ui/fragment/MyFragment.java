package com.lingjuan.app.ui.fragment;

import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.lingjuan.app.R;
import com.lingjuan.app.base.BaseFragment;
import com.lingjuan.app.entity.EventBusRzy;
import com.lingjuan.app.entity.UserInfo;
import com.lingjuan.app.ui.activity.FootprintActivity;
import com.lingjuan.app.ui.activity.LoginActivity;
import com.lingjuan.app.utils.ActivityUtils;
import com.lingjuan.app.utils.AlibcTradeSDKUtils;
import com.lingjuan.app.utils.LogManage;
import com.lingjuan.app.utils.UpdateMagas;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import de.hdodenhof.circleimageview.CircleImageView;

/**
 * 我的
 * Created by TaoHui on 2018/10/5.
 */

public class MyFragment extends BaseFragment {
    Unbinder unbinder;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.iamge_tou)
    CircleImageView iamgeTou;
    @BindView(R.id.btn_loin)
    TextView btnLoin;
    @BindView(R.id.user_dengji)
    TextView userDengji;
    @BindView(R.id.usertype)
    RelativeLayout usertype;
    @BindView(R.id.toulauout)
    RelativeLayout toulauout;
    @BindView(R.id.user_money)
    TextView userMoney;
    @BindView(R.id.user_score)
    TextView userScore;
    @BindView(R.id.user_hongbao)
    TextView userHongbao;
    @BindView(R.id.userinfo)
    LinearLayout userinfo;
    @BindView(R.id.viewcolors)
    View viewcolors;
    @BindView(R.id.dingdan)
    LinearLayout dingdan;
    @BindView(R.id.viewcolorsds)
    View viewcolorsds;
    @BindView(R.id.iamge_shoucang)
    ImageView iamgeShoucang;
    @BindView(R.id.iamge_zuji)
    ImageView iamgeZuji;
    @BindView(R.id.iamge_guanyu)
    ImageView iamgeGuanyu;
    Unbinder unbinder1;
    @BindView(R.id.relat_footprint)
    RelativeLayout relatFootprint;
    @BindView(R.id.new_version)
    TextView newVersion;

    @Override
    protected void initview(View rootView) {
        unbinder = ButterKnife.bind(this, rootView);
        EventBus.getDefault().register(this);
        UpdateMagas updateMagas = new UpdateMagas();
        try {
            newVersion.setText("v"+updateMagas.getVersion(getActivity()));
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void initData() {
        //  SPUtils.getInstance(getActivity()).put("putInt",1);//存储一个int值
    }

    @Override
    protected int getlayoutt() {
        return R.layout.newmy_frament;
    }

    @Override
    protected void onStopView() {
        EventBus.getDefault().unregister(getContext());
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder1.unbind();
    }

    @OnClick({R.id.iamge_tou, R.id.usertype, R.id.btn_loin, R.id.relat_footprint, R.id.dingdan})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iamge_tou:
                ActivityUtils.goActivity(Objects.requireNonNull(getContext()), LoginActivity.class);
                break;
            case R.id.usertype:
                break;
            case R.id.btn_loin:
                if (btnLoin.getText().toString().equals("点我登录")) {
                    ActivityUtils.goActivity(Objects.requireNonNull(getContext()), LoginActivity.class);
                }
                break;
            case R.id.relat_footprint:
                ActivityUtils.goActivity(Objects.requireNonNull(getContext()), FootprintActivity.class);
                break;
            case R.id.dingdan:
                AlibcTradeSDKUtils.showOrder(getActivity());
                break;
            default:
                break;
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN, sticky = true)
    public void getEventData(EventBusRzy eventBusRzy) {
        switch (eventBusRzy.getCode()) {
            case EventBusRzy.USER_LOGIIN:
                onSuccessLogin();
                break;
            default:break;
        }
    }

    /**
     * 填充个人中心信息
     */
    private void onSuccessLogin() {
        try {
            //设置用户名
            btnLoin.setText(UserInfo.getInstance().getPhone());
            //设置用户等级
            String dengJi;
            switch (UserInfo.getInstance().getGroup_id()) {
                case 1:
                    dengJi = "普通会员";
                    break;
                default:
                    dengJi = "CrackGmKey";
                    break;
            }
            userDengji.setText(String.valueOf(dengJi));
            //设置用户积分
            userScore.setText(String.valueOf(UserInfo.getInstance().getScore()));
            //设置用户金额
            userMoney.setText(String.valueOf(UserInfo.getInstance().getAccount()));
            //设置用户红包
            userHongbao.setText(String.valueOf("1"));
        } catch (Exception e) {
            LogManage.e("==========发现错误：" + e.toString());
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        unbinder1 = ButterKnife.bind(this, rootView);
        return rootView;
    }


}
