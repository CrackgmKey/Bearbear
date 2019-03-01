package com.lingjuan.app.ui.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.lingjuan.app.R;
import com.lingjuan.app.base.BaseActivity;
import com.yanzhenjie.recyclerview.SwipeRecyclerView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * @author: TaoHui
 * data: 2019/2/26 15:04
 */
public class EverydayGoodActivity extends BaseActivity {

    @BindView(R.id.image_return)
    ImageView imageReturn;
    @BindView(R.id.title_view)
    TextView titleView;
    @BindView(R.id.baseviwes)
    Toolbar baseviwes;
    @BindView(R.id.recycleview)
    SwipeRecyclerView recycleview;
    @BindView(R.id.refresh_layout)
    SwipeRefreshLayout refreshLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_everydaygood);
        ButterKnife.bind(this);
        initView();
        initData();
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {

    }

    @Override
    protected int getLayout() {
        return R.layout.activity_everydaygood;
    }

    @Override
    protected Activity getActivity() {
        return this;
    }

    @OnClick({R.id.image_return, R.id.title_view, R.id.baseviwes, R.id.recycleview})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.image_return:
                break;
            case R.id.title_view:
                break;
            case R.id.baseviwes:
                break;
            case R.id.recycleview:
                break;
            default:break;
        }
    }
}
