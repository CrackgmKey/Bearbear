package com.lingjuan.app.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.tu.loadingdialog.LoadingDailog;

import butterknife.ButterKnife;

/**
 * Created by TaoHui on 2018/10/5.
 */

public abstract class BaseFragment extends Fragment {
    private LoadingDailog.Builder loadBuilder;
    private LoadingDailog loadingDailog;
    @Override
    public String toString() {
        return super.toString();
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

    }


    @Override
    public void onStart() {
        super.onStart();

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = LayoutInflater.from(inflater.getContext()).inflate(getlayoutt(),container,false);
        ButterKnife.bind(this, view);
        loadBuilder=new LoadingDailog.Builder(getContext())
                .setCancelable(false)
                .setMessage("加载中...")
                .setCancelOutside(true);
        loadingDailog = loadBuilder.create();
        initview(view);
        initData();
        return view;
    }
    protected abstract void initview(View view);
    protected abstract void initData();
    protected abstract int getlayoutt();
    protected abstract void onStopView();


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        onStopView();
    }



    /**
     * 加载弹窗
     */
    public void showLoading(){
        try {
            if(loadingDailog != null){
                loadingDailog.show();
            }
        }catch (Exception e){

        }
    }

    /**
     * 关闭加载
     */
    public void dismissLoading(){
       try {
           if(loadingDailog != null){
               loadingDailog.dismiss();
           }
       }catch (Exception e){

       }
    }

}
