package com.lingjuan.app.mvp.supclass.model;

import com.lingjuan.app.customview.DataHashMap;
import com.lingjuan.app.entity.SupclassLeft;
import com.lingjuan.app.utils.HttpManage;
import com.lingjuan.app.utils.LogManage;

import rx.Subscriber;

/**
 * Created by TaoHui on 2018/10/6.
 */

public class SupClassModel {
    private ScuRzy scuRzy;


    public void setScuRzy(ScuRzy scuRzy) {
        this.scuRzy = scuRzy;
    }


    public void getSupclassLeft(){
        DataHashMap spicyhotMap = DataHashMap.getInstance().Builder();
        HttpManage.getInstance().getSuperClassLifeData(spicyhotMap, new Subscriber<SupclassLeft>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                scuRzy.loaddError(e.toString());
            }

            @Override
            public void onNext(SupclassLeft supclassLeft) {
                LogManage.d("分类数据加载成功："+supclassLeft.toString());

                for (int i = 0;i <supclassLeft.getGeneral_classify().size() ;i++){
                    if(supclassLeft.getGeneral_classify().get(i).getCid() == 8){
                        supclassLeft.getGeneral_classify().remove(i);
                        i--;
                    }else if( supclassLeft.getGeneral_classify().get(i).getCid() == 9){
                        supclassLeft.getGeneral_classify().remove(i);
                        i--;
                    }else if( supclassLeft.getGeneral_classify().get(i).getCid() == 5){
                        supclassLeft.getGeneral_classify().remove(i);
                        i--;
                    }

                }
                scuRzy.left(supclassLeft);
            }
        });
    }


    public interface ScuRzy{
        void left(SupclassLeft supclassLeft);
        void loaddError(String s);
    }
}
