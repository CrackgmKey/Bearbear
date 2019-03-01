package com.lingjuan.app.entity;

/**
 * Created by HuiTao on 2017/8/22.
 */

public class UserTResponse {
    private String result;
    private int status;

    public UserTResponse() {
    }




    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "ListResponse{" +
                "result=" + result +
                ", status='" + status + '\'' +
                '}';
    }
}
