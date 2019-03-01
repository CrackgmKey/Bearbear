package com.lingjuan.app.entity;

/**
 * 是否被选中综合筛选
 * Created by TaoHui on 2018/10/20.
 */

public class SearchPop {
    private String title;
    private boolean aBoolean;
    private int sort;

    public void setSort(int sort) {
        this.sort = sort;
    }


    public int getSort() {
        return sort;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isaBoolean() {
        return aBoolean;
    }

    public void setaBoolean(boolean aBoolean) {
        this.aBoolean = aBoolean;
    }
}
