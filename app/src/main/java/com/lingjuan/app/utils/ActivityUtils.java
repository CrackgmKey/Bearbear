package com.lingjuan.app.utils;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;

import com.lingjuan.app.constant.Constant;
import com.lingjuan.app.entity.PurchaseRzy;

import java.util.List;
/**
 * Created by TaoHui on 2018/10/17.
 */

public class ActivityUtils {

    private ActivityUtils() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    /**
     * 判断是否存在Activity
     *
     * @param context     上下文
     * @param packageName 包名
     * @param className   activity全路径类名
     * @return {@code true}: 是<br>{@code false}: 否
     */
    public static boolean isActivityExists(Context context, String packageName, String className) {
        Intent intent = new Intent();
        intent.setClassName(packageName, className);
        return !(context.getPackageManager().resolveActivity(intent, 0) == null ||
                intent.resolveActivity(context.getPackageManager()) == null ||
                context.getPackageManager().queryIntentActivities(intent, 0).size() == 0);
    }

    /**
     * 获取launcher activity
     *
     * @param context     上下文
     * @param packageName 包名
     * @return launcher activity
     */
    public static String getLauncherActivity(Context context, String packageName) {
        Intent intent = new Intent(Intent.ACTION_MAIN, null);
        intent.addCategory(Intent.CATEGORY_LAUNCHER);
        PackageManager pm = context.getPackageManager();
        List<ResolveInfo> infos = pm.queryIntentActivities(intent, 0);
        for (ResolveInfo info : infos) {
            if (info.activityInfo.packageName.equals(packageName)) {
                return info.activityInfo.name;
            }
        }
        return "no " + packageName;
    }

    public static void goActivity(Context context,Class a){
        context.startActivity(new Intent(context,a));
    }

    public static void goActivity(String msg,String content,String type,Context context,Class a){
        Intent intent = new Intent(context,a);
        intent.putExtra(content,msg);
        intent.putExtra(type,1);
        context.startActivity(intent);
    }

    public static void goActivity(String msg,String content,Context context,Class a){
        Intent intent = new Intent(context,a);
        intent.putExtra(content,msg);
        context.startActivity(intent);
    }

    public static void goBeanActivity(PurchaseRzy.DataBean msg, String content, Context context, Class a){
        Intent intent = new Intent(context,a);
        intent.putExtra(content,msg);
        context.startActivity(intent);
    }

    /**
     * 跳转QQQ
     * @param context 上下文
     */
    public static void showQQ(Context context){
        if (checkApkExist(context, "com.tencent.mobileqq")){
            context.startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("mqqwpa://im/chat?chat_type=wpa&uin="+Constant.USER_QQ_NUM +"&version=1")));
        }else{
            ToastManage.showText(context,"本机未安装QQ应用");
        }
    }


    public static boolean checkApkExist(Context context, String packageName) {
        if (packageName == null || "".equals(packageName)){
            return false;
        }
        try {
            ApplicationInfo info = context.getPackageManager().getApplicationInfo(packageName,
                    PackageManager.GET_UNINSTALLED_PACKAGES);
            return true;
        } catch (PackageManager.NameNotFoundException e) {
            return false;
        }
    }

}