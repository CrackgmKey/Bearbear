package com.lingjuan.app.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.widget.ImageView;

import com.lingjuan.app.constant.Constant;
import com.squareup.picasso.MemoryPolicy;
import com.squareup.picasso.Picasso;

import com.lingjuan.app.R;

/**
 * Created by TaoHui on 2018/10/5.
 */

public class PicassomageUtils  {

    public static void load(Context context, String path, ImageView view){
        Picasso picasso = Picasso.with(context);
        picasso .setIndicatorsEnabled(true);
        picasso
               // .load(path+ Constant.IMAGE_SUFFIX)
                .load(path)
                .config(Bitmap.Config.RGB_565)
                .memoryPolicy(MemoryPolicy.NO_CACHE,MemoryPolicy.NO_STORE) //静止内存缓存
                .placeholder(R.mipmap.jiazai)
                .into(view);
    }


    public static void loads(Context context, String path, ImageView view){
        LogManage.e("=============当前图片地址："+path+ Constant.IMAGE_SUFFIX);
        path = path+ Constant.IMAGE_SUFFIX;
        Picasso picasso = Picasso.with(context);
        picasso .setIndicatorsEnabled(true);
        picasso
                .load(path)
                .config(Bitmap.Config.RGB_565)
                .memoryPolicy(MemoryPolicy.NO_CACHE,MemoryPolicy.NO_STORE) //静止内存缓存
                .placeholder(R.mipmap.jiazai)
                .into(view);
    }

    public static void qtkLoad(Context context, String path, ImageView view){
        Picasso picasso = Picasso.with(context);
        picasso .setIndicatorsEnabled(true);
        picasso
                .load(path)
                .config(Bitmap.Config.RGB_565)
                .memoryPolicy(MemoryPolicy.NO_CACHE,MemoryPolicy.NO_STORE) //静止内存缓存
                .placeholder(R.mipmap.jiazai)
                .into(view);
    }

    public static void loadSzie(Context context, String path, ImageView view,int h){
        Picasso picasso = Picasso.with(context);
        picasso .setIndicatorsEnabled(true);
        picasso
                .load(path)
                .config(Bitmap.Config.RGB_565)
                .memoryPolicy(MemoryPolicy.NO_CACHE,MemoryPolicy.NO_STORE) //静止内存缓存
                .resize(300,h)
                .placeholder(R.mipmap.jiazai)
                .into(view);
    }

    /**
     * 加载GIf图
     */
    public static void LoadGifView(){


    }
}
