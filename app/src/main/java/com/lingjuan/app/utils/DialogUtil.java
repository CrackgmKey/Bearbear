package com.lingjuan.app.utils;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.lingjuan.app.R;
import com.lingjuan.app.customview.CustomDialog;


/**
 * Created by Administrator on 2017-06-20.
 */

public class DialogUtil {
    public static AlertDialog alertDialog;
    public static void showComfirmDialog(final Context context, String msg, DialogInterface.OnClickListener confirmListener,
                                         DialogInterface.OnClickListener cancelListener) {

        CustomDialog.Builder builder = new CustomDialog.Builder(context);
        builder.setMessage(msg);
        builder.setPositiveButton("确定", confirmListener);
        builder.setNegativeButton("取消", cancelListener);
        builder.create().show();

    }


    public static void showComfirmDialog(final Context context, String msg, DialogInterface.OnClickListener confirmListener) {
        CustomDialog.Builder builder = new CustomDialog.Builder(context);
        builder.setTitle(context.getString(R.string.title_alert));
        builder.setMessage(msg);
        builder.setPositiveButton("取消", (dialog, which) -> dialog.dismiss());
        builder.setNegativeButton("确定", confirmListener);
        builder.create().show();

    }

    public static void showMsgDialog(Context context, String msg, DialogInterface.OnClickListener confirmListener) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setCancelable(true);
        builder.setMessage(msg);
        builder.setPositiveButton("确定", confirmListener);
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }



    public static void showDialog(Context context, String str,String buttonText,View.OnClickListener clickListener){
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setCancelable(false);
        View view = LayoutInflater.from(context).inflate(R.layout.dialog_title,null);
        Button bt = (Button) view.findViewById(R.id.btn_recharge);
        bt.setText(buttonText);
        TextView tv = view.findViewById(R.id.tip);
        tv.setText(str);
        builder.setView(view);
        alertDialog = builder.create();
        alertDialog.show();
        if(clickListener == null){
            bt.setOnClickListener(v -> alertDialog.dismiss());
        }else {
            bt.setOnClickListener(clickListener);
        }
    }

    public void diss(){
        if(alertDialog != null){
            alertDialog.dismiss();
        }
    }

}
