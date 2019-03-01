package com.lingjuan.app.wigth;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.PopupWindow;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.lingjuan.app.R;
import com.lingjuan.app.entity.SearchPop;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by TaoHui on 2018/10/20.
 */

public class SearchPopupWindow extends PopupWindow {
    private Context context;
    private List<SearchPop> popList;
    private SerarchAdapter serarchAdapter;
    private OnClickSucce clickSucce;
    private View view;


    public void setClickSucce(OnClickSucce clickSucce) {
        this.clickSucce = clickSucce;
    }

    public SearchPopupWindow(Context context){
        super(context);
        this.context = context;
        popList = new ArrayList<>();
        // 设置可以获得焦点
        setFocusable(true);
        // 设置弹窗内可点击
        setTouchable(true);
        // 设置弹窗外可点击
        setOutsideTouchable(true);
        setBackgroundDrawable(new ColorDrawable(0));//new
        initview(context);
    }

    /**
     * 初始化控件
     */
    private void initview(Context context) {
        view = LayoutInflater.from(context).inflate(R.layout.item_search, null);
        //设置布局
        setContentView(view);
        //设置宽度
        setWidth(ViewGroup.LayoutParams.MATCH_PARENT);
        //设置高度
        setHeight(ViewGroup.LayoutParams.WRAP_CONTENT);
        //设置列表
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(context);
        RecyclerView recyclerView = view.findViewById(R.id.search_recyclea);
        recyclerView.setLayoutManager(layoutManager);
        addData();
        serarchAdapter = new SerarchAdapter(R.layout.pop_general_layout, popList);
        recyclerView.setAdapter(serarchAdapter);
        serarchAdapter.setOnItemChildClickListener((adapter, view1, position) -> {
            for (int i = 0; i < popList.size(); i++) {
                SearchPop searchPop;
                if (i == position) {
                    searchPop = popList.get(i);
                    searchPop.setaBoolean(true);
                    popList.remove(i);
                    popList.add(i, searchPop);
                } else {
                    searchPop = popList.get(i);
                    searchPop.setaBoolean(false);
                    popList.remove(i);
                    popList.add(i, searchPop);
                }
            }
            serarchAdapter.replaceData(popList);
            dismiss();
            clickSucce.getClickPosition(position,popList.get(position).getSort());
        });
    }

    public void addData() {
        popList.clear();
        SearchPop searchPop = new SearchPop();
        searchPop.setTitle("综合");
        searchPop.setaBoolean(true);
        searchPop.setSort(3);
        popList.add(searchPop);
        SearchPop searchPop1 = new SearchPop();
        searchPop1.setTitle("最新");
        searchPop1.setSort(5);
        searchPop1.setaBoolean(false);
        popList.add(searchPop1);
        SearchPop searchPop2 = new SearchPop();
        searchPop2.setTitle("人气");
        searchPop2.setaBoolean(false);
        searchPop2.setSort(9);
        popList.add(searchPop2);
        if(serarchAdapter != null){
            serarchAdapter.replaceData(popList);
        }
    }

    public class SerarchAdapter extends BaseQuickAdapter<SearchPop, BaseViewHolder> {

        public SerarchAdapter(int layoutResId, @Nullable List<SearchPop> data) {
            super(layoutResId, data);
        }

        @Override
        protected void convert(BaseViewHolder helper, SearchPop item) {
            helper.setText(R.id.tv_title, item.getTitle());
            helper.addOnClickListener(R.id.baselayouts);
            if (item.isaBoolean()) {
                helper.setVisible(R.id.imageHong, true);
                helper.setTextColor(R.id.tv_title, context.getResources().getColor(R.color.hongdui));
            } else {
                helper.setVisible(R.id.imageHong, false);
                helper.setTextColor(R.id.tv_title, context.getResources().getColor(R.color.font_1f));
            }
        }
    }

    public   interface OnClickSucce{
        void getClickPosition (int position,int sont);
        void onAnimationEnd ();
    }


    @Override
    public void showAsDropDown(View anchor) {
        Animation anim = AnimationUtils.loadAnimation(context, R.anim.popdonghua);
        anim.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                clickSucce.onAnimationEnd();
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        view.setAnimation(anim);
        super.showAsDropDown(anchor);
    }
}
