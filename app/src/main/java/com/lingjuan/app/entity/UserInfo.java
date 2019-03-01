package com.lingjuan.app.entity;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.lingjuan.app.base.AppManager;
import com.lingjuan.app.utils.GsonUtil;
import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;

/**
 * 用户名表
 * Created by TaoHui on 2018/10/28.
 */
public class UserInfo {
    //用户Id
    @SerializedName("id")
    private String userId;
    //用户名称
    @SerializedName("user_name")
    private String usename;
    //用户密码
    private String password;
    //用户签名
    private String signature;
    //用户手机号
    private String phone;
    //用户积分
    private String score;
    //用户余额
    private String account;
    //用户是否可用
    private int audit;
    //用户类型
    private int group_id;

    public void setGroup_id(int group_id) {
        this.group_id = group_id;
    }

    public int getGroup_id() {
        return group_id;
    }

    private static UserInfo instance = null;
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUsename() {
        return usename;
    }

    public void setUsename(String usename) {
        this.usename = usename;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public int getAudit() {
        return audit;
    }

    public void setAudit(int audit) {
        this.audit = audit;
    }



    public static UserInfo getInstance() {
        if (instance == null) {
            SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(AppManager.getContext());
            String bodyString = prefs.getString("user", null);
            if (bodyString == null) {
                instance = new UserInfo();
            } else {
                instance = new Gson().fromJson(bodyString, UserInfo.class);
            }
        }
        return instance;
    }


    public static void saveUser(UserInfo user) {
        if (user != null) {
            SharedPreferences.Editor editor = PreferenceManager.getDefaultSharedPreferences(AppManager.getContext()).edit();
            editor.putString("user", GsonUtil.GsonString(user));
            editor.apply();
        }
    }
}
