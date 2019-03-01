package com.lingjuan.app.ui.activity;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.lingjuan.app.R;
import com.lingjuan.app.adapter.HotKeyAdapter;
import com.lingjuan.app.base.BaseActivity;
import com.lingjuan.app.entity.HistoryRzy;
import com.lingjuan.app.entity.HookLopKey;
import com.lingjuan.app.greendao.HistoryRzyDao;
import com.lingjuan.app.mvp.hotkey.persenter.HotKeyPresenter;
import com.lingjuan.app.mvp.hotkey.view.IhotKey;
import com.lingjuan.app.utils.ActivityUtils;
import com.lingjuan.app.utils.ColorUtil;
import com.lingjuan.app.utils.DialogUtil;
import com.lingjuan.app.utils.GreenDaoUtils;
import com.lingjuan.app.utils.LogManage;
import com.lingjuan.app.utils.ToastManage;
import com.lingjuan.app.utils.db.QueryHistoryUtils;
import com.nex3z.flowlayout.FlowLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 超级搜索
 * Created by TaoHui on 2018/10/17.
 */
public class SupersearchActivity extends BaseActivity implements IhotKey.P {

    @BindView(R.id.tvSearch)
    EditText tvSearch;
    @BindView(R.id.whatyoulayout)
    FlowLayout whatyoulayout;
    @BindView(R.id.historylayout)
    FlowLayout historylayout;
    @BindView(R.id.reclcieviwe)
    RecyclerView reclcieviwe;
    @BindView(R.id.souguo)
    TextView souguo;
    @BindView(R.id.clarimage)
    ImageView clarimage;
    private HotKeyPresenter hotKeyPresenter;
    private List<HookLopKey.DataBean> dataBean;
    private HotKeyAdapter hotKeyAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_supersearch);
        ButterKnife.bind(this);
        initView();
        initData();
    }

    @Override
    protected void initView() {
        tvSearch.setOnKeyListener(onKeyListener);
        RecyclerView.LayoutManager layoutParams = new LinearLayoutManager(this);
        reclcieviwe.setLayoutManager(layoutParams);
        dataBean = new ArrayList<>();
        hotKeyAdapter = new HotKeyAdapter(dataBean);
        reclcieviwe.setAdapter(hotKeyAdapter);
        hotKeyAdapter.setOnItemChildClickListener((adapter, view, position) -> {
            ToastManage.showText(SupersearchActivity.this, "点击了：" + position);
        });
        queryData();
    }

    @Override
    protected void initData() {
        hotKeyPresenter = new HotKeyPresenter(this, this);
        hotKeyPresenter.getHotData();
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_supersearch;
    }

    @Override
    protected Activity getActivity() {
        return this;
    }


    @OnClick({R.id.tvSearch, R.id.souguo})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tvSearch:

                break;
            case R.id.souguo:
                String msg = tvSearch.getText().toString();
                if(TextUtils.isEmpty(msg)){
                    return;
                }
                if (QueryHistoryUtils.isExistence(msg)) {
                    HistoryRzy historyRzy = new HistoryRzy();
                    historyRzy.setUserId("9999");
                    historyRzy.setMessage(msg);
                    QueryHistoryUtils.insert(historyRzy);
                    queryData();
                }
                ActivityUtils.goActivity(msg,"content", SupersearchActivity.this, ProductActivity.class);
                break;
            default:break;
        }
    }

    //监听输入框回车
    private View.OnKeyListener onKeyListener = (v, keyCode, event) -> {
        if (keyCode == KeyEvent.KEYCODE_ENTER && event.getAction() == KeyEvent.ACTION_DOWN) {// 修改回车键功能
            // 先隐藏键盘
            ((InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE)).hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
            // 按完搜索键后将当前查询的关键字保存起来,如果该关键字已经存在就不执行保存
            // TODO 根据输入的内容模糊查询商品，并跳转到另一个界面，由你自己去实现
            ToastManage.showText(SupersearchActivity.this, "您要搜索：" + "点了回车");
        }
        return false;
    };

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
        ToastManage.showText(SupersearchActivity.this, msg);
    }

    @Override
    public void getData(List<HookLopKey.DataBean> dataBean) {
        //   hotKeyAdapter.replaceData(dataBean);
        for (int i = 0; i < 14; i++) {
            LogManage.d("======        whatyoulayout.getRowSpacing:" + whatyoulayout.getChildCount());
            TextView tv = new TextView(this);
            tv.setText(dataBean.get(i).getKeyword());
            tv.setTextSize(TypedValue.COMPLEX_UNIT_SP, 16);
            tv.setPadding(30, 10, 30, 10);
            tv.setBackground(getResources().getDrawable(R.drawable.shape_corner));
            GradientDrawable gradientDrawable = (GradientDrawable) tv.getBackground();
            gradientDrawable.setColor(Color.parseColor(ColorUtil.statisticsColors[i]));
            tv.setOnClickListener(v -> {
                if (QueryHistoryUtils.isExistence(tv.getText().toString())) {
                    HistoryRzy historyRzy = new HistoryRzy();
                    historyRzy.setUserId("9999");
                    historyRzy.setMessage(tv.getText().toString());
                    QueryHistoryUtils.insert(historyRzy);
                    queryData();
                }
                ActivityUtils.goActivity(tv.getText().toString(), "content",SupersearchActivity.this, ProductActivity.class);
                ToastManage.showText(SupersearchActivity.this, "热搜：" + tv.getText().toString());
            });
            whatyoulayout.addView(tv);
        }
    }

    @Override
    public void onErrorMsg(String mgs) {
        ToastManage.showText(SupersearchActivity.this, mgs);
    }

    private void queryData() {
        List<HistoryRzy> historyRzyList = GreenDaoUtils.getInitntes().queryBuilder(GreenDaoUtils.getCkDaoSession().getHistoryRzyDao()).where(HistoryRzyDao.Properties.UserId.eq("9999")).list();
        historylayout.removeAllViews();
        for (int i = 0; i < historyRzyList.size(); i++) {
            TextView tv = new TextView(this);
            tv.setText(historyRzyList.get(i).getMessage());
            tv.setTextSize(TypedValue.COMPLEX_UNIT_SP, 16);
            tv.setPadding(30, 10, 30, 10);
            tv.setBackground(getResources().getDrawable(R.drawable.shape_corner));
            tv.setTextColor(getResources().getColor(R.color.bgColor_overlay));
            tv.setOnClickListener(v -> {
                if (QueryHistoryUtils.isExistence(tv.getText().toString())) {
                    HistoryRzy historyRzy = new HistoryRzy();
                    historyRzy.setUserId("9999");
                    historyRzy.setMessage(tv.getText().toString());
                    QueryHistoryUtils.insert(historyRzy);
                    queryData();
                }
                ActivityUtils.goActivity(tv.getText().toString(),"content", SupersearchActivity.this, ProductActivity.class);
                ToastManage.showText(SupersearchActivity.this, "历史：" + tv.getText().toString());
            });
            historylayout.addView(tv);
        }
    }


    @OnClick(R.id.clarimage)
    public void onViewClicked() {
        ActivityUtils.goActivity( SupersearchActivity.this, PurchaseActivity.class);

        DialogUtil.showComfirmDialog(SupersearchActivity.this, getString(R.string.qingchu), (dialog, which) -> {
            dialog.dismiss();
            QueryHistoryUtils.delete();
            ToastManage.showText(SupersearchActivity.this,getString(R.string.qingchuyes));
            queryData();
        });
    }
}
