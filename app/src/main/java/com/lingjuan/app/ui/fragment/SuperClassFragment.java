package com.lingjuan.app.ui.fragment;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import com.lingjuan.app.R;
import com.lingjuan.app.adapter.ClassReigthAdpater;
import com.lingjuan.app.adapter.SuperClassLeftAdapter;
import com.lingjuan.app.base.BaseFragment;
import com.lingjuan.app.constant.Constant;
import com.lingjuan.app.customview.DataHashMap;
import com.lingjuan.app.entity.SupclassLeft;
import com.lingjuan.app.mvp.supclass.presenter.ClassPresenter;
import com.lingjuan.app.mvp.supclass.view.IclassManage;
import com.lingjuan.app.utils.LogManage;
import com.lingjuan.app.utils.ToastManage;
import rx.Observable;

/**
 * 超级分类
 * Created by TaoHui on 2018/10/5.
 */

public class SuperClassFragment extends BaseFragment implements IclassManage.IsupclassView {
    @BindView(R.id.classify_left)
    RecyclerView classifyLeft;
    @BindView(R.id.classify_right)
    RecyclerView classifyRight;
    Unbinder unbinder;
    private ClassPresenter classPresenter;
    private SuperClassLeftAdapter superClassLeftAdapter;
    private ClassReigthAdpater classReigthAdpater;
    private List<SupclassLeft.GeneralClassifyBean> data;
    private List<SupclassLeft.GeneralClassifyBean> dataBeanList;
    private SupclassLeft supclassLeft;
    private DataHashMap spicyhotMap = new DataHashMap();
    private int weizhiyi;
    private int yimnposd;
    private LinearLayoutManager layoutManag1er;

    @Override
    protected void initview(View view) {
        unbinder = ButterKnife.bind(this, view);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        classifyLeft.setLayoutManager(layoutManager);
        //网格布局
        layoutManag1er = new LinearLayoutManager(getContext()){};
        classifyRight.setLayoutManager(layoutManag1er);
        classPresenter = new ClassPresenter(this);
        data = new ArrayList<>();
        dataBeanList = new ArrayList<>();
        //左边列表
        superClassLeftAdapter = new SuperClassLeftAdapter(R.layout.item_class_left,data);
        classifyLeft.setAdapter(superClassLeftAdapter);
        //右边列表
        classReigthAdpater = new ClassReigthAdpater(getActivity(),dataBeanList);
        classifyRight.setAdapter(classReigthAdpater);
    }
    @Override
    protected void initData() {
        classPresenter.startLift();
        //点击事件
        superClassLeftAdapter.setOnItemChildClickListener((adapter, view, position) -> {
            int sum = 0;
            if(position == 0){
                sum = 0;
                ToastManage.showText(getContext(),"以切换到滑动模式");
            }else {
                sum = bbq(position);
            }
            yimnposd = position;
            superClassLeftAdapter.setSelectedPosition(position);
            superClassLeftAdapter.notifyDataSetChanged();
            RightSuccess(supclassLeft,position);
            //根据左侧，定位右侧的展示数据
            LinearLayoutManager layoutManager = (LinearLayoutManager) classifyRight.getLayoutManager();
            layoutManager.scrollToPositionWithOffset(sum, 0);
        });
        //滑动监听
        classifyRight.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                LinearLayoutManager layoutManager = (LinearLayoutManager) classifyRight.getLayoutManager();
                int position = layoutManager.findLastVisibleItemPosition();
                if(weizhiyi != position){
                    weizhiyi = position;
                    int huitao;
                    int cid;
                    if(yimnposd != 0){
                        huitao = bbq(yimnposd);
                         cid = dataBeanList.get(0).getData().get(huitao).getCid();
                        yimnposd = 0;
                    }else {
                        cid = dataBeanList.get(0).getData().get(position).getCid();
                    }
                    if(yimnposd == cid){
                        return;
                    }
                    if(spicyhotMap.size() != 0){
                        superClassLeftAdapter.setSelectedPosition(Integer.valueOf(spicyhotMap.get(String.valueOf(cid))));
                    }
                    LogManage.d("位置信息"+position+",Cid="+cid+",取出来的顺序："+spicyhotMap.get(String.valueOf(cid)));
                }
            }
        });

    }
    private int  longosd = 0;
    private void initMap(SupclassLeft supclassLeft) {
        longosd = 0;
        Observable.from(supclassLeft.getGeneral_classify()).subscribe(generalClassifyBean -> {
            spicyhotMap.put(String.valueOf(generalClassifyBean.getCid()),String.valueOf(longosd));
            longosd = longosd + 1;
        });
        this.supclassLeft = supclassLeft;
        data.addAll(supclassLeft.getGeneral_classify());
        superClassLeftAdapter.replaceData(data);
        superClassLeftAdapter.setSelectedPosition(0);
    }

    @Override
    protected int getlayoutt() {
        return R.layout.superclass_frament;
    }

    @Override
    protected void onStopView() {
        unbinder.unbind();
        data.clear();
        dataBeanList.clear();
        supclassLeft = null;
        classPresenter.dissView();
        superClassLeftAdapter.replaceData(data);
        classReigthAdpater.setDataBeanList(dataBeanList);
    }


    @Override
    public void LeftSuccess(SupclassLeft supclassLeft) {
        initMap(supclassLeft);
    }

    @Override
    public void RightSuccess(SupclassLeft supclassLeft, int pos) {

    }

    @Override
    public void RightSuccess(SupclassLeft supclassLeft) {
        if(dataBeanList.size() == 0){
            dataBeanList.addAll(supclassLeft.getGeneral_classify());
        }
        classReigthAdpater.setDataBeanList(dataBeanList);
    }


    @Override
    public void FindError(String s) {
        ToastManage.showText(getContext(),s);
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
    }


    /**
     * RecyclerView 移动到当前位置，
     *
     * @param manager  设置RecyclerView对应的manager
     * @param n  要跳转的位置
     */
    public static void GoToPosition(LinearLayoutManager manager, int n) {
        manager.scrollToPositionWithOffset(n, 0);
        manager.setStackFromEnd(false);
    }


    private int bbq(int pos){
        //拿到分类的Cid
        final int Cname = supclassLeft.getGeneral_classify().get(pos).getCid();
        return (int) Constant.MAP.get(String.valueOf(Cname));
    }
}
