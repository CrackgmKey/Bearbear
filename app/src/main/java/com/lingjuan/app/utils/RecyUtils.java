package com.lingjuan.app.utils;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

/**
 * @author: TaoHui
 * @date: 2019/1/17
 */
public class RecyUtils {

    public static void setLayoutManager(RecyclerView recyclerView, Context context){
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(context);
        recyclerView.setLayoutManager(layoutManager);
    }
}
