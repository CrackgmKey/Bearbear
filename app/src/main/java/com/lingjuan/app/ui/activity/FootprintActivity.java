package com.lingjuan.app.ui.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.lingjuan.app.R;
import com.lingjuan.app.adapter.FootprinAdapter;
import com.lingjuan.app.base.BaseActivity;
import com.lingjuan.app.constant.Constant;
import com.lingjuan.app.entity.FootprintRzy;
import com.lingjuan.app.greendao.FootprintRzyDao;
import com.lingjuan.app.utils.ActivityUtils;
import com.lingjuan.app.utils.DialogUtil;
import com.lingjuan.app.utils.GreenDaoUtils;
import com.lingjuan.app.utils.RecyUtils;
import com.lingjuan.app.utils.db.QueryHistoryUtils;
import com.lingjuan.app.utils.purchase.PurchaseUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 足迹
 * @author: TaoHui
 * @date: 2019/1/17
 */
public class FootprintActivity extends BaseActivity implements BaseQuickAdapter.OnItemChildClickListener, BaseQuickAdapter.OnItemLongClickListener {

    @BindView(R.id.image_return)
    ImageView imageReturn;
    @BindView(R.id.title_view)
    TextView titleView;
    @BindView(R.id.baseviwes)
    Toolbar baseviwes;
    @BindView(R.id.reclcieviwe)
    RecyclerView reclcieviwe;
    @BindView(R.id.image_mask)
    ImageView imageMask;
    @BindView(R.id.browse_empty)
    TextView browseEmpty;

    /**
     * 适配器
     */
    private FootprinAdapter footprinAdapter;
    /**
     * 数据源
     */
    private List<FootprintRzy> rzyList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_footprint_acity);
        ButterKnife.bind(this);
        initView();
        initData();
    }

    @Override
    protected void initView() {
        //设置布局管理
        RecyUtils.setLayoutManager(reclcieviwe, this);
        //设置适配器
        rzyList = new ArrayList<>();
    }

    @Override
    protected void initData() {
        rzyList.addAll(GreenDaoUtils.getDaoSession().getFootprintRzyDao().queryBuilder().list());
        footprinAdapter = new FootprinAdapter(rzyList, this);
        reclcieviwe.setAdapter(footprinAdapter);
        footprinAdapter.setOnItemChildClickListener(this);
        footprinAdapter.setOnItemLongClickListener(this);
        if (rzyList.size() == 0) {
            imageMask.setVisibility(View.VISIBLE);
            footprinAdapter.replaceData(rzyList);
            toast(this, "您还没有看过商品哦");
            return;
        }
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_footprint_acity;
    }

    @Override
    protected Activity getActivity() {
        return this;
    }

    @Override
    public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
        FootprintRzy dataBean = rzyList.get(position);
        ActivityUtils.goBeanActivity(PurchaseUtils.getJsonBean(dataBean), Constant.COMMODITY,getActivity() , PurchaseActivity.class);
    }

    @Override
    public boolean onItemLongClick(BaseQuickAdapter adapter, View view, int position) {
        DialogUtil.showComfirmDialog(getActivity(), "确定删除该条足迹吗？",(dialog, which) -> {
            FootprintRzy dataBean = rzyList.get(position);
            GreenDaoUtils.getDaoSession().getFootprintRzyDao().delete(GreenDaoUtils.getDaoSession().getFootprintRzyDao().queryBuilder().where(FootprintRzyDao.Properties.Itemid.eq(dataBean.getItemid())).unique());
            toast(getActivity(),getString(R.string.qingchuyes));
        });
        return false;
    }

    @OnClick({R.id.browse_empty, R.id.baseviwes,R.id.image_return})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.browse_empty:

                DialogUtil.showComfirmDialog(getActivity(), getString(R.string.qingchu), (dialog, which) -> {
                    dialog.dismiss();
                    QueryHistoryUtils.getFootprintDelete();
                    toast(getActivity(),getString(R.string.qingchuyes));
                    initData();
                });
                break;
            case R.id.image_return:
                finish();
                break;
                default:break;
        }
    }


}
