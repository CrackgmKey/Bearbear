package com.lingjuan.app.entity;

import com.lingjuan.app.wigth.SearchTypePopupWindow;

/**
 * 商品筛选
 * Created by TaoHui on 2018/10/21.
 */

public class Screeningstrategy {
    private SearchTypePopupWindow.Meaning source;
   private double price_min,price_max;

    public SearchTypePopupWindow.Meaning getSource() {
        return source;
    }

    public void setSource(SearchTypePopupWindow.Meaning source) {
        this.source = source;
    }

    public double getPrice_min() {
        return price_min;
    }

    public void setPrice_min(double price_min) {
        this.price_min = price_min;
    }

    public double getPrice_max() {
        return price_max;
    }

    public void setPrice_max(double price_max) {
        this.price_max = price_max;
    }
}
