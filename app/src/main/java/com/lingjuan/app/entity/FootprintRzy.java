package com.lingjuan.app.entity;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;

/**
 * Created by TaoHui on 2019/1/4.
 */
@Entity
public class FootprintRzy {
    @Id(autoincrement = true)
    private Long id;
    private String itemshorttitle;
    private String itemprice;
    private String itemsale;
    private String couponmoney;
    private String itemendprice;
    private String itempic;
    private String itemid;
    @Generated(hash = 1020987846)
    public FootprintRzy(Long id, String itemshorttitle, String itemprice,
            String itemsale, String couponmoney, String itemendprice,
            String itempic, String itemid) {
        this.id = id;
        this.itemshorttitle = itemshorttitle;
        this.itemprice = itemprice;
        this.itemsale = itemsale;
        this.couponmoney = couponmoney;
        this.itemendprice = itemendprice;
        this.itempic = itempic;
        this.itemid = itemid;
    }
    @Generated(hash = 543617260)
    public FootprintRzy() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getItemshorttitle() {
        return this.itemshorttitle;
    }
    public void setItemshorttitle(String itemshorttitle) {
        this.itemshorttitle = itemshorttitle;
    }
    public String getItemprice() {
        return this.itemprice;
    }
    public void setItemprice(String itemprice) {
        this.itemprice = itemprice;
    }
    public String getItemsale() {
        return this.itemsale;
    }
    public void setItemsale(String itemsale) {
        this.itemsale = itemsale;
    }
    public String getCouponmoney() {
        return this.couponmoney;
    }
    public void setCouponmoney(String couponmoney) {
        this.couponmoney = couponmoney;
    }
    public String getItemendprice() {
        return this.itemendprice;
    }
    public void setItemendprice(String itemendprice) {
        this.itemendprice = itemendprice;
    }
    public String getItempic() {
        return this.itempic;
    }
    public void setItempic(String itempic) {
        this.itempic = itempic;
    }
    public String getItemid() {
        return this.itemid;
    }
    public void setItemid(String itemid) {
        this.itemid = itemid;
    }




}
