package com.lingjuan.app.entity;

import java.util.List;

/**
 * 商品
 * Created by TaoHui on 2018/10/5.
 */

    public class Commodity {
        private int code;

        private int min_id;

        private String msg;

        private List<CommodityData> data;

        public void setCode(int code) {
            this.code = code;
        }

        public int getCode() {
            return this.code;
        }

        public void setMin_id(int min_id) {
            this.min_id = min_id;
        }

        public int getMin_id() {
            return this.min_id;
        }

        public void setMsg(String msg) {
            this.msg = msg;
        }

        public String getMsg() {
            return this.msg;
        }

        public void setData(List<CommodityData> data) {
            this.data = data;
        }

        public List<CommodityData> getData() {
            return this.data;
        }


   public class CommodityData {
        private String product_id;

        private String itemid;

        private String seller_id;

        private String itemtitle;

        private String itemshorttitle;

        private String itemdesc;

        private String itemprice;

        private String itemsale;

        private String itemsale2;

        private String todaysale;

        private String itempic;

        private String itempic_copy;

        private String fqcat;

        private String itemendprice;

        private String shoptype;

        private String tktype;

        private String tkrates;

        private String cuntao;

        private String tkmoney;

        private String couponurl;

        private String couponmoney;

        private String couponsurplus;

        private String couponreceive;

        private String couponreceive2;

        private String todaycouponreceive;

        private String couponnum;

        private String couponexplain;

        private String couponstarttime;

        private String couponendtime;

        private String start_time;

        private String end_time;

        private String starttime;

        private String isquality;

        private String report_status;

        private String is_brand;

        private String is_live;

        private String guide_article;

        private String videoid;

        private String activity_type;

        private String general_index;

        private String planlink;

        private String seller_name;

        private String userid;

        private String sellernick;

        private String online_users;

        private String original_img;

        private String original_article;

        private String discount;

        private String is_explosion;

        private String me;

        private String activityid;

        private String coupon_condition;

        private String taobao_image;

        public void setProduct_id(String product_id) {
            this.product_id = product_id;
        }

        public String getProduct_id() {
            return this.product_id;
        }

        public void setItemid(String itemid) {
            this.itemid = itemid;
        }

        public String getItemid() {
            return this.itemid;
        }

        public void setSeller_id(String seller_id) {
            this.seller_id = seller_id;
        }

        public String getSeller_id() {
            return this.seller_id;
        }

        public void setItemtitle(String itemtitle) {
            this.itemtitle = itemtitle;
        }

        public String getItemtitle() {
            return this.itemtitle;
        }

        public void setItemshorttitle(String itemshorttitle) {
            this.itemshorttitle = itemshorttitle;
        }

        public String getItemshorttitle() {
            return this.itemshorttitle;
        }

        public void setItemdesc(String itemdesc) {
            this.itemdesc = itemdesc;
        }

        public String getItemdesc() {
            return this.itemdesc;
        }

        public void setItemprice(String itemprice) {
            this.itemprice = itemprice;
        }

        public String getItemprice() {
            return this.itemprice;
        }

        public void setItemsale(String itemsale) {
            this.itemsale = itemsale;
        }

        public String getItemsale() {
            return this.itemsale;
        }

        public void setItemsale2(String itemsale2) {
            this.itemsale2 = itemsale2;
        }

        public String getItemsale2() {
            return this.itemsale2;
        }

        public void setTodaysale(String todaysale) {
            this.todaysale = todaysale;
        }

        public String getTodaysale() {
            return this.todaysale;
        }

        public void setItempic(String itempic) {
            this.itempic = itempic;
        }

        public String getItempic() {
            return this.itempic;
        }

        public void setItempic_copy(String itempic_copy) {
            this.itempic_copy = itempic_copy;
        }

        public String getItempic_copy() {
            return this.itempic_copy;
        }

        public void setFqcat(String fqcat) {
            this.fqcat = fqcat;
        }

        public String getFqcat() {
            return this.fqcat;
        }

        public void setItemendprice(String itemendprice) {
            this.itemendprice = itemendprice;
        }

        public String getItemendprice() {
            return this.itemendprice;
        }

        public void setShoptype(String shoptype) {
            this.shoptype = shoptype;
        }

        public String getShoptype() {
            return this.shoptype;
        }

        public void setTktype(String tktype) {
            this.tktype = tktype;
        }

        public String getTktype() {
            return this.tktype;
        }

        public void setTkrates(String tkrates) {
            this.tkrates = tkrates;
        }

        public String getTkrates() {
            return this.tkrates;
        }

        public void setCuntao(String cuntao) {
            this.cuntao = cuntao;
        }

        public String getCuntao() {
            return this.cuntao;
        }

        public void setTkmoney(String tkmoney) {
            this.tkmoney = tkmoney;
        }

        public String getTkmoney() {
            return this.tkmoney;
        }

        public void setCouponurl(String couponurl) {
            this.couponurl = couponurl;
        }

        public String getCouponurl() {
            return this.couponurl;
        }

        public void setCouponmoney(String couponmoney) {
            this.couponmoney = couponmoney;
        }

        public String getCouponmoney() {
            return this.couponmoney;
        }

        public void setCouponsurplus(String couponsurplus) {
            this.couponsurplus = couponsurplus;
        }

        public String getCouponsurplus() {
            return this.couponsurplus;
        }

        public void setCouponreceive(String couponreceive) {
            this.couponreceive = couponreceive;
        }

        public String getCouponreceive() {
            return this.couponreceive;
        }

        public void setCouponreceive2(String couponreceive2) {
            this.couponreceive2 = couponreceive2;
        }

        public String getCouponreceive2() {
            return this.couponreceive2;
        }

        public void setTodaycouponreceive(String todaycouponreceive) {
            this.todaycouponreceive = todaycouponreceive;
        }

        public String getTodaycouponreceive() {
            return this.todaycouponreceive;
        }

        public void setCouponnum(String couponnum) {
            this.couponnum = couponnum;
        }

        public String getCouponnum() {
            return this.couponnum;
        }

        public void setCouponexplain(String couponexplain) {
            this.couponexplain = couponexplain;
        }

        public String getCouponexplain() {
            return this.couponexplain;
        }

        public void setCouponstarttime(String couponstarttime) {
            this.couponstarttime = couponstarttime;
        }

        public String getCouponstarttime() {
            return this.couponstarttime;
        }

        public void setCouponendtime(String couponendtime) {
            this.couponendtime = couponendtime;
        }

        public String getCouponendtime() {
            return this.couponendtime;
        }

        public void setStart_time(String start_time) {
            this.start_time = start_time;
        }

        public String getStart_time() {
            return this.start_time;
        }

        public void setEnd_time(String end_time) {
            this.end_time = end_time;
        }

        public String getEnd_time() {
            return this.end_time;
        }

        public void setStarttime(String starttime) {
            this.starttime = starttime;
        }

        public String getStarttime() {
            return this.starttime;
        }

        public void setIsquality(String isquality) {
            this.isquality = isquality;
        }

        public String getIsquality() {
            return this.isquality;
        }

        public void setReport_status(String report_status) {
            this.report_status = report_status;
        }

        public String getReport_status() {
            return this.report_status;
        }

        public void setIs_brand(String is_brand) {
            this.is_brand = is_brand;
        }

        public String getIs_brand() {
            return this.is_brand;
        }

        public void setIs_live(String is_live) {
            this.is_live = is_live;
        }

        public String getIs_live() {
            return this.is_live;
        }

        public void setGuide_article(String guide_article) {
            this.guide_article = guide_article;
        }

        public String getGuide_article() {
            return this.guide_article;
        }

        public void setVideoid(String videoid) {
            this.videoid = videoid;
        }

        public String getVideoid() {
            return this.videoid;
        }

        public void setActivity_type(String activity_type) {
            this.activity_type = activity_type;
        }

        public String getActivity_type() {
            return this.activity_type;
        }

        public void setGeneral_index(String general_index) {
            this.general_index = general_index;
        }

        public String getGeneral_index() {
            return this.general_index;
        }

        public void setPlanlink(String planlink) {
            this.planlink = planlink;
        }

        public String getPlanlink() {
            return this.planlink;
        }

        public void setSeller_name(String seller_name) {
            this.seller_name = seller_name;
        }

        public String getSeller_name() {
            return this.seller_name;
        }

        public void setUserid(String userid) {
            this.userid = userid;
        }

        public String getUserid() {
            return this.userid;
        }

        public void setSellernick(String sellernick) {
            this.sellernick = sellernick;
        }

        public String getSellernick() {
            return this.sellernick;
        }

        public void setOnline_users(String online_users) {
            this.online_users = online_users;
        }

        public String getOnline_users() {
            return this.online_users;
        }

        public void setOriginal_img(String original_img) {
            this.original_img = original_img;
        }

        public String getOriginal_img() {
            return this.original_img;
        }

        public void setOriginal_article(String original_article) {
            this.original_article = original_article;
        }

        public String getOriginal_article() {
            return this.original_article;
        }

        public void setDiscount(String discount) {
            this.discount = discount;
        }

        public String getDiscount() {
            return this.discount;
        }

        public void setIs_explosion(String is_explosion) {
            this.is_explosion = is_explosion;
        }

        public String getIs_explosion() {
            return this.is_explosion;
        }

        public void setMe(String me) {
            this.me = me;
        }

        public String getMe() {
            return this.me;
        }

        public void setActivityid(String activityid) {
            this.activityid = activityid;
        }

        public String getActivityid() {
            return this.activityid;
        }

        public void setCoupon_condition(String coupon_condition) {
            this.coupon_condition = coupon_condition;
        }

        public String getCoupon_condition() {
            return this.coupon_condition;
        }

        public void setTaobao_image(String taobao_image) {
            this.taobao_image = taobao_image;
        }

        public String getTaobao_image() {
            return this.taobao_image;
        }

    }
}