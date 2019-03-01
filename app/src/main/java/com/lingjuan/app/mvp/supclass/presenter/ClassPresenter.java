package com.lingjuan.app.mvp.supclass.presenter;

import java.util.ArrayList;
import java.util.List;

import com.lingjuan.app.constant.Constant;
import com.lingjuan.app.entity.SupclassLeft;
import com.lingjuan.app.mvp.supclass.model.SupClassModel;
import com.lingjuan.app.mvp.supclass.view.IclassManage;
import com.lingjuan.app.utils.LogManage;

/**
 * Created by TaoHui on 2018/10/6.
 */

public class ClassPresenter implements SupClassModel.ScuRzy {
    private SupClassModel supClassModel;
    private IclassManage.IsupclassView isupclassView;

    public ClassPresenter(IclassManage.IsupclassView isupclassView) {
        this.isupclassView = isupclassView;
        supClassModel = new SupClassModel();
        supClassModel.setScuRzy(this);
    }

    private int  theunknown;
    @Override
    public void left(SupclassLeft supclassLeft) {
        theunknown = 0;
        if (isupclassView == null) {
            return;
        }
        List<SupclassLeft.GeneralClassifyBean.DataBean> dataBeans = new ArrayList<>();
        for (int i = 0; i < supclassLeft.getGeneral_classify().size(); i++) {
            //达到女装分类
            SupclassLeft.GeneralClassifyBean gg = supclassLeft.getGeneral_classify().get(i);
            //得到连衣裙分类
            for (int j = 0; j < gg.getData().size(); j++) {
                gg.getData().get(j).setCid(gg.getCid());
                if(Constant.MAP.get(String.valueOf(gg.getCid())) == null){
                    Constant.MAP.put(String.valueOf(gg.getCid()),theunknown);
                }
                theunknown = theunknown + 1;
            }
            dataBeans.addAll(gg.getData());
        }
        SupclassLeft.GeneralClassifyBean generalClassifyBean = new SupclassLeft.GeneralClassifyBean();
        generalClassifyBean.setMain_name("全部");
        generalClassifyBean.setCid(99);
        generalClassifyBean.setData(dataBeans);
        supclassLeft.getGeneral_classify().add(0, generalClassifyBean);
        isupclassView.LeftSuccess(supclassLeft);
        isupclassView.RightSuccess(supclassLeft);
        LogManage.e("反复走了加载");
    }

    @Override
    public void loaddError(String s) {
        if (isupclassView == null) {
            return;
        }
        LogManage.e("出现错误：" + s);
        isupclassView.FindError(s);
    }


    public void startLift() {
        if (isupclassView == null) {
            return;
        }
        LogManage.e("开始加载分类");
        supClassModel.getSupclassLeft();
    }


    public void dissView() {
        supClassModel = null;
        isupclassView = null;
    }
}
