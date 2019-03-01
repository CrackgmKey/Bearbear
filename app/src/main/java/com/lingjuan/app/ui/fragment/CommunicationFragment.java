package com.lingjuan.app.ui.fragment;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.lingjuan.app.R;
import com.lingjuan.app.adapter.VideoTpAdapter;
import com.lingjuan.app.base.BaseFragment;
import com.lingjuan.app.constant.Constant;
import com.lingjuan.app.entity.EventBusRzy;
import com.lingjuan.app.entity.WelldoneVideo;
import com.lingjuan.app.mvp.video.presenter.VideoPersnter;
import com.lingjuan.app.mvp.video.view.iVideo;
import com.lingjuan.app.ui.activity.PurchaseActivity;
import com.lingjuan.app.utils.ActivityUtils;
import com.lingjuan.app.utils.LogManage;
import com.lingjuan.app.utils.ToastManage;
import com.lingjuan.app.utils.purchase.PurchaseUtils;
import com.yanzhenjie.recyclerview.SwipeRecyclerView;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import chuangyuan.ycj.videolibrary.video.ExoUserPlayer;

/**
 * 视频秀
 * Created by TaoHui on 2018/10/13.
 */

public class CommunicationFragment extends BaseFragment implements iVideo.Pview {
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.recyclea)
    SwipeRecyclerView recyclview;
    Unbinder unbinder;
    @BindView(R.id.refresh_layout)
    SwipeRefreshLayout refreshLayout;
    Unbinder unbinder1;
    private VideoPersnter videoPersnter;
    private VideoTpAdapter videoTpAdapter;
    private List<WelldoneVideo.DataBean> dataBean;
    public ExoUserPlayer exoUserr;
    private int mid;
    @Override
    protected void initview(View view) {
        EventBus.getDefault().register(this);
        unbinder = ButterKnife.bind(this, view);
        videoPersnter = new VideoPersnter(this);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclview.setLayoutManager(layoutManager);
        dataBean = new ArrayList<>();
        videoTpAdapter = new VideoTpAdapter(dataBean);
        videoTpAdapter.setContext(getContext());
        recyclview.setAdapter(videoTpAdapter);
        videoTpAdapter.setClick(new VideoTpAdapter.OnClick() {
            @Override
            public void OnClickListener(int position) {
                WelldoneVideo.DataBean json = dataBean.get(position);
                ActivityUtils.goBeanActivity(PurchaseUtils.getJsonBean(json), Constant.COMMODITY, getContext(), PurchaseActivity.class);
            }

            @Override
            public void onStopVideo(ExoUserPlayer exoUserPlayer) {
                exoUserr = exoUserPlayer;
            }
        });
        //加入下拉
        refreshLayout.setOnRefreshListener(refreshListener);
        recyclview.useDefaultLoadMore();
        recyclview.setLoadMoreListener(loadMoreListener);
    }

    @Override
    protected void initData() {
        videoPersnter.startVideo(mid);
    }

    @Override
    protected int getlayoutt() {
        return R.layout.fragment_circle;
    }

    @Override
    protected void onStopView() {
        unbinder.unbind();
    }

    @Override
    public void showDialog() {
        ToastManage.showText(getContext(), "开始加载");
        showLoading();
    }

    @Override
    public void dissDialog() {
        dismissLoading();
        ToastManage.showText(getContext(), "结束加载");
    }

    @Override
    public void showMessage(String msg) {
        ToastManage.showText(getContext(), msg);
    }

    @Override
    public void onSoucces(List<WelldoneVideo.DataBean> dataBean,int mid) {
        this.mid = mid;
        this.dataBean.addAll(dataBean);
        if(dataBean.size() == 0){
            recyclview.loadMoreFinish(true, false);
            return;
        }
        videoTpAdapter.replaceData(this.dataBean);
        recyclview.loadMoreFinish(false, true);

    }

    @Override
    public void onError(String msg) {
        ToastManage.showText(getContext(), msg);
    }

    @Subscribe(threadMode = ThreadMode.ASYNC, sticky = true)
    public void message(EventBusRzy eventBusRzy) {
        if (exoUserr != null) {
            exoUserr.onPause();
            videoTpAdapter.replaceData(dataBean);
            LogManage.d("=======暂停了");
        }
    }

    private SwipeRefreshLayout.OnRefreshListener refreshListener = new SwipeRefreshLayout.OnRefreshListener() {
        @Override
        public void onRefresh() {
            recyclview.postDelayed(new Runnable() {
                @Override
                public void run() {
                    ToastManage.showText(getActivity(),"刷新完毕");
                    refreshLayout.setRefreshing(false);
                }
            },3000);
        }
    };

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

    private SwipeRecyclerView.LoadMoreListener loadMoreListener = new SwipeRecyclerView.LoadMoreListener() {
        @Override
        public void onLoadMore() {
            videoPersnter.startVideo(mid);
        }
    };
}
