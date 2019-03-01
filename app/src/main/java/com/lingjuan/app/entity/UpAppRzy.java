package com.lingjuan.app.entity;

/**
 * Created by TaoHui on 2018/10/28.
 */

public class UpAppRzy {

    /**
     * update : Yes
     * new_version : 0.8.3
     * apk_file_url : https://raw.githubusercontent.com/WVector/AppUpdateDemo/master/apk/sample-debug.apk
     * update_log : 1，添加删除信用卡接口。
     2，添加vip认证。
     3，区分自定义消费，一个小时不限制。
     4，添加放弃任务接口，小时内不生成。
     5，消费任务手动生成。
     * target_size : 5M
     * constraint : false
     */

    private boolean update;
    private String new_version;
    private String apk_file_url;
    private String update_log;
    private String target_size;
    private String qq_num;
    private boolean constraint;

    public void setQq_num(String qq_num) {
        this.qq_num = qq_num;
    }

    public String getQq_num() {
        return qq_num;
    }


    public void setUpdate(boolean update) {
        this.update = update;
    }

    public boolean  getUpdate() {
        return update;
    }
    public String getNew_version() {
        return new_version;
    }

    public void setNew_version(String new_version) {
        this.new_version = new_version;
    }

    public String getApk_file_url() {
        return apk_file_url;
    }

    public void setApk_file_url(String apk_file_url) {
        this.apk_file_url = apk_file_url;
    }

    public String getUpdate_log() {
        return update_log;
    }

    public void setUpdate_log(String update_log) {
        this.update_log = update_log;
    }

    public String getTarget_size() {
        return target_size;
    }

    public void setTarget_size(String target_size) {
        this.target_size = target_size;
    }

    public boolean isConstraint() {
        return constraint;
    }

    public void setConstraint(boolean constraint) {
        this.constraint = constraint;
    }
}
