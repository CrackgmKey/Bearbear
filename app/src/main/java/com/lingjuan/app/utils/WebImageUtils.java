package com.lingjuan.app.utils;

import android.content.Context;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by TaoHui on 2018/10/27.
 */

public class WebImageUtils {
    public static String NAME = "<img src=\"http://*\"  width=\"100%\"  alt=\"小熊优品详情页\" />";

    public static String readAssetsTxt(Context context){
        try {
            //Return an AssetManager instance for your application's package
            InputStream is = context.getAssets().open("details.html");
            int size = is.available();
            // Read the entire asset into a local byte buffer.
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            // Convert the buffer into a string.
            String text = new String(buffer, "utf-8");
            // Finally stick the string into the text view.
            return text;
        } catch (IOException e) {
            // Should never happen!
//            throw new RuntimeException(e);
            e.printStackTrace();
        }
        return "读取错误，请检查文件名";
    }
}
