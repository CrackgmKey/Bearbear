package com.lingjuan.app.utils;

import android.content.Intent;

/**
 * 获取数据
 * Created by TaoHui on 2018/10/25.
 */

public class IntentUtils<T> {
    private static IntentUtils intentUtils;


    public static IntentUtils getInitialization(){
            if(intentUtils == null){
                intentUtils = new IntentUtils();
            }
            return intentUtils;
    }

    public T getData(String conney, Intent intent){
        return (T) intent.getExtras().getSerializable(conney);
    }
}
