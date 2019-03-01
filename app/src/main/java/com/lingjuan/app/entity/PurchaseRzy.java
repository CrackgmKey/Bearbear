package com.lingjuan.app.entity;

import java.io.Serializable;

/**
 * 商品类目
 * Created by TaoHui on 2018/10/24.
 */

public class PurchaseRzy  implements Serializable{
    private static final long serialVersionUID = 1L;
    /**
     * code : 1
     * min_id : 1
     * msg : SUCCESS
     * data : {"product_id":"7520658","itemid":"557787124271","seller_id":"1370","itemtitle":"太平有象3支纳米牙刷替换头硅胶成人软毛家用家庭装旅行盒套装","itemshorttitle":"太平有象3支纳米牙刷替换头硅胶","itemdesc":"纳米软胶牙刷，纳米牙刷按摩牙龈，标准家庭经典版牙刷，全家适用，预防出血，清洁牙龈","itemprice":"25.80","itemsale":"256","itemsale2":"0","todaysale":"0","itempic":"http://img.alicdn.com/imgextra/i1/2912566525/TB2D1ynavBNTKJjy0FdXXcPpVXa_!!2912566525.jpg","itempic_copy":"0_557787124271_1532858265.jpg","fqcat":"10","itemendprice":"15.80","shoptype":"B","tktype":"营销计划","tkrates":"30.00","cuntao":"0","tkmoney":"4.74","couponurl":"http://uland.taobao.com/quan/detail?sellerId=2912566525&activityId=849bc11feb1b44e4b2f5261f94bb024e","couponmoney":"10","couponsurplus":"10000","couponreceive":"0","couponreceive2":"0","todaycouponreceive":"0","couponnum":"10000","couponexplain":"单笔满25.0元可用","couponstarttime":"1540310400","couponendtime":"1540828799","start_time":"1540310400","end_time":"1540828799","starttime":"1540310400","isquality":"0","report_status":"0","is_brand":"0","is_live":"0","guide_article":"纳米软胶牙刷，纳米牙刷按摩牙龈，标准家庭经典版牙刷，全家适用，预防出血，清洁牙龈","videoid":"50021350536","activity_type":"普通活动","general_index":"131","planlink":null,"seller_name":"小猴猴团队","userid":"2912566525","sellernick":"太平有象旗舰店","online_users":"0","original_img":"","original_article":"","discount":"6.10","is_explosion":"0","me":null,"activityid":"849bc11feb1b44e4b2f5261f94bb024e","coupon_condition":"25.00","taobao_image":"http://img.alicdn.com/imgextra/i2/2912566525/TB2NfmnavBNTKJjy0FdXXcPpVXa_!!2912566525.jpg,http://img.alicdn.com/imgextra/i2/2912566525/TB2nqm0hUFWMKJjSZFvXXaenFXa_!!2912566525.jpg,http://img.alicdn.com/imgextra/i1/2912566525/TB2D1ynavBNTKJjy0FdXXcPpVXa_!!2912566525.jpg,http://img.alicdn.com/imgextra/i2/2912566525/TB2Ru9navBNTKJjy0FdXXcPpVXa_!!2912566525.jpg,http://img.alicdn.com/imgextra/i1/2912566525/TB2ReaIbn0ATuJjSZFEXXap2FXa_!!2912566525.jpg","down_type":"0","shopid":"162406654"}
     */

    private int code;
    private int min_id;
    private String msg;
    private DataBean data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public int getMin_id() {
        return min_id;
    }

    public void setMin_id(int min_id) {
        this.min_id = min_id;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean  implements Serializable{
        /**
         * product_id : 7520658
         * itemid : 557787124271
         * seller_id : 1370
         * itemtitle : 太平有象3支纳米牙刷替换头硅胶成人软毛家用家庭装旅行盒套装
         * itemshorttitle : 太平有象3支纳米牙刷替换头硅胶
         * itemdesc : 纳米软胶牙刷，纳米牙刷按摩牙龈，标准家庭经典版牙刷，全家适用，预防出血，清洁牙龈
         * itemprice : 25.80
         * itemsale : 256
         * itemsale2 : 0
         * todaysale : 0
         * itempic : http://img.alicdn.com/imgextra/i1/2912566525/TB2D1ynavBNTKJjy0FdXXcPpVXa_!!2912566525.jpg
         * itempic_copy : 0_557787124271_1532858265.jpg
         * fqcat : 10
         * itemendprice : 15.80
         * shoptype : B
         * tktype : 营销计划
         * tkrates : 30.00
         * cuntao : 0
         * tkmoney : 4.74
         * couponurl : http://uland.taobao.com/quan/detail?sellerId=2912566525&activityId=849bc11feb1b44e4b2f5261f94bb024e
         * couponmoney : 10
         * couponsurplus : 10000
         * couponreceive : 0
         * couponreceive2 : 0
         * todaycouponreceive : 0
         * couponnum : 10000
         * couponexplain : 单笔满25.0元可用
         * couponstarttime : 1540310400
         * couponendtime : 1540828799
         * start_time : 1540310400
         * end_time : 1540828799
         * starttime : 1540310400
         * isquality : 0
         * report_status : 0
         * is_brand : 0
         * is_live : 0
         * guide_article : 纳米软胶牙刷，纳米牙刷按摩牙龈，标准家庭经典版牙刷，全家适用，预防出血，清洁牙龈
         * videoid : 50021350536
         * activity_type : 普通活动
         * general_index : 131
         * planlink : null
         * seller_name : 小猴猴团队
         * userid : 2912566525
         * sellernick : 太平有象旗舰店
         * online_users : 0
         * original_img :
         * original_article :
         * discount : 6.10
         * is_explosion : 0
         * me : null
         * activityid : 849bc11feb1b44e4b2f5261f94bb024e
         * coupon_condition : 25.00
         * taobao_image : http://img.alicdn.com/imgextra/i2/2912566525/TB2NfmnavBNTKJjy0FdXXcPpVXa_!!2912566525.jpg,http://img.alicdn.com/imgextra/i2/2912566525/TB2nqm0hUFWMKJjSZFvXXaenFXa_!!2912566525.jpg,http://img.alicdn.com/imgextra/i1/2912566525/TB2D1ynavBNTKJjy0FdXXcPpVXa_!!2912566525.jpg,http://img.alicdn.com/imgextra/i2/2912566525/TB2Ru9navBNTKJjy0FdXXcPpVXa_!!2912566525.jpg,http://img.alicdn.com/imgextra/i1/2912566525/TB2ReaIbn0ATuJjSZFEXXap2FXa_!!2912566525.jpg
         * down_type : 0
         * shopid : 162406654
         */
        private static final long serialVersionUID = 2L;
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
        private Object planlink;
        private String seller_name;
        private String userid;
        private String sellernick;
        private String online_users;
        private String original_img;
        private String original_article;
        private String discount;
        private String is_explosion;
        private Object me;
        private String activityid;
        private String coupon_condition;
        private String taobao_image;
        private String down_type;
        private String shopid;

        public String getProduct_id() {
            return product_id;
        }

        public void setProduct_id(String product_id) {
            this.product_id = product_id;
        }

        public String getItemid() {
            return itemid;
        }

        public void setItemid(String itemid) {
            this.itemid = itemid;
        }

        public String getSeller_id() {
            return seller_id;
        }

        public void setSeller_id(String seller_id) {
            this.seller_id = seller_id;
        }

        public String getItemtitle() {
            return itemtitle;
        }

        public void setItemtitle(String itemtitle) {
            this.itemtitle = itemtitle;
        }

        public String getItemshorttitle() {
            return itemshorttitle;
        }

        public void setItemshorttitle(String itemshorttitle) {
            this.itemshorttitle = itemshorttitle;
        }

        public String getItemdesc() {
            return itemdesc;
        }

        public void setItemdesc(String itemdesc) {
            this.itemdesc = itemdesc;
        }

        public String getItemprice() {
            return itemprice;
        }

        public void setItemprice(String itemprice) {
            this.itemprice = itemprice;
        }

        public String getItemsale() {
            return itemsale;
        }

        public void setItemsale(String itemsale) {
            this.itemsale = itemsale;
        }

        public String getItemsale2() {
            return itemsale2;
        }

        public void setItemsale2(String itemsale2) {
            this.itemsale2 = itemsale2;
        }

        public String getTodaysale() {
            return todaysale;
        }

        public void setTodaysale(String todaysale) {
            this.todaysale = todaysale;
        }

        public String getItempic() {
            return itempic;
        }

        public void setItempic(String itempic) {
            this.itempic = itempic;
        }

        public String getItempic_copy() {
            return itempic_copy;
        }

        public void setItempic_copy(String itempic_copy) {
            this.itempic_copy = itempic_copy;
        }

        public String getFqcat() {
            return fqcat;
        }

        public void setFqcat(String fqcat) {
            this.fqcat = fqcat;
        }

        public String getItemendprice() {
            return itemendprice;
        }

        public void setItemendprice(String itemendprice) {
            this.itemendprice = itemendprice;
        }

        public String getShoptype() {
            return shoptype;
        }

        public void setShoptype(String shoptype) {
            this.shoptype = shoptype;
        }

        public String getTktype() {
            return tktype;
        }

        public void setTktype(String tktype) {
            this.tktype = tktype;
        }

        public String getTkrates() {
            return tkrates;
        }

        public void setTkrates(String tkrates) {
            this.tkrates = tkrates;
        }

        public String getCuntao() {
            return cuntao;
        }

        public void setCuntao(String cuntao) {
            this.cuntao = cuntao;
        }

        public String getTkmoney() {
            return tkmoney;
        }

        public void setTkmoney(String tkmoney) {
            this.tkmoney = tkmoney;
        }

        public String getCouponurl() {
            return couponurl;
        }

        public void setCouponurl(String couponurl) {
            this.couponurl = couponurl;
        }

        public String getCouponmoney() {
            return couponmoney;
        }

        public void setCouponmoney(String couponmoney) {
            this.couponmoney = couponmoney;
        }

        public String getCouponsurplus() {
            return couponsurplus;
        }

        public void setCouponsurplus(String couponsurplus) {
            this.couponsurplus = couponsurplus;
        }

        public String getCouponreceive() {
            return couponreceive;
        }

        public void setCouponreceive(String couponreceive) {
            this.couponreceive = couponreceive;
        }

        public String getCouponreceive2() {
            return couponreceive2;
        }

        public void setCouponreceive2(String couponreceive2) {
            this.couponreceive2 = couponreceive2;
        }

        public String getTodaycouponreceive() {
            return todaycouponreceive;
        }

        public void setTodaycouponreceive(String todaycouponreceive) {
            this.todaycouponreceive = todaycouponreceive;
        }

        public String getCouponnum() {
            return couponnum;
        }

        public void setCouponnum(String couponnum) {
            this.couponnum = couponnum;
        }

        public String getCouponexplain() {
            return couponexplain;
        }

        public void setCouponexplain(String couponexplain) {
            this.couponexplain = couponexplain;
        }

        public String getCouponstarttime() {
            return couponstarttime;
        }

        public void setCouponstarttime(String couponstarttime) {
            this.couponstarttime = couponstarttime;
        }

        public String getCouponendtime() {
            return couponendtime;
        }

        public void setCouponendtime(String couponendtime) {
            this.couponendtime = couponendtime;
        }

        public String getStart_time() {
            return start_time;
        }

        public void setStart_time(String start_time) {
            this.start_time = start_time;
        }

        public String getEnd_time() {
            return end_time;
        }

        public void setEnd_time(String end_time) {
            this.end_time = end_time;
        }

        public String getStarttime() {
            return starttime;
        }

        public void setStarttime(String starttime) {
            this.starttime = starttime;
        }

        public String getIsquality() {
            return isquality;
        }

        public void setIsquality(String isquality) {
            this.isquality = isquality;
        }

        public String getReport_status() {
            return report_status;
        }

        public void setReport_status(String report_status) {
            this.report_status = report_status;
        }

        public String getIs_brand() {
            return is_brand;
        }

        public void setIs_brand(String is_brand) {
            this.is_brand = is_brand;
        }

        public String getIs_live() {
            return is_live;
        }

        public void setIs_live(String is_live) {
            this.is_live = is_live;
        }

        public String getGuide_article() {
            return guide_article;
        }

        public void setGuide_article(String guide_article) {
            this.guide_article = guide_article;
        }

        public String getVideoid() {
            return videoid;
        }

        public void setVideoid(String videoid) {
            this.videoid = videoid;
        }

        public String getActivity_type() {
            return activity_type;
        }

        public void setActivity_type(String activity_type) {
            this.activity_type = activity_type;
        }

        public String getGeneral_index() {
            return general_index;
        }

        public void setGeneral_index(String general_index) {
            this.general_index = general_index;
        }

        public Object getPlanlink() {
            return planlink;
        }

        public void setPlanlink(Object planlink) {
            this.planlink = planlink;
        }

        public String getSeller_name() {
            return seller_name;
        }

        public void setSeller_name(String seller_name) {
            this.seller_name = seller_name;
        }

        public String getUserid() {
            return userid;
        }

        public void setUserid(String userid) {
            this.userid = userid;
        }

        public String getSellernick() {
            return sellernick;
        }

        public void setSellernick(String sellernick) {
            this.sellernick = sellernick;
        }

        public String getOnline_users() {
            return online_users;
        }

        public void setOnline_users(String online_users) {
            this.online_users = online_users;
        }

        public String getOriginal_img() {
            return original_img;
        }

        public void setOriginal_img(String original_img) {
            this.original_img = original_img;
        }

        public String getOriginal_article() {
            return original_article;
        }

        public void setOriginal_article(String original_article) {
            this.original_article = original_article;
        }

        public String getDiscount() {
            return discount;
        }

        public void setDiscount(String discount) {
            this.discount = discount;
        }

        public String getIs_explosion() {
            return is_explosion;
        }

        public void setIs_explosion(String is_explosion) {
            this.is_explosion = is_explosion;
        }

        public Object getMe() {
            return me;
        }

        public void setMe(Object me) {
            this.me = me;
        }

        public String getActivityid() {
            return activityid;
        }

        public void setActivityid(String activityid) {
            this.activityid = activityid;
        }

        public String getCoupon_condition() {
            return coupon_condition;
        }

        public void setCoupon_condition(String coupon_condition) {
            this.coupon_condition = coupon_condition;
        }

        public String getTaobao_image() {
            return taobao_image;
        }

        public void setTaobao_image(String taobao_image) {
            this.taobao_image = taobao_image;
        }

        public String getDown_type() {
            return down_type;
        }

        public void setDown_type(String down_type) {
            this.down_type = down_type;
        }

        public String getShopid() {
            return shopid;
        }

        public void setShopid(String shopid) {
            this.shopid = shopid;
        }

        @Override
        public String toString() {
            return "DataBean{" +
                    "product_id='" + product_id + '\'' +
                    ", itemid='" + itemid + '\'' +
                    ", seller_id='" + seller_id + '\'' +
                    ", itemtitle='" + itemtitle + '\'' +
                    ", itemshorttitle='" + itemshorttitle + '\'' +
                    ", itemdesc='" + itemdesc + '\'' +
                    ", itemprice='" + itemprice + '\'' +
                    ", itemsale='" + itemsale + '\'' +
                    ", itemsale2='" + itemsale2 + '\'' +
                    ", todaysale='" + todaysale + '\'' +
                    ", itempic='" + itempic + '\'' +
                    ", itempic_copy='" + itempic_copy + '\'' +
                    ", fqcat='" + fqcat + '\'' +
                    ", itemendprice='" + itemendprice + '\'' +
                    ", shoptype='" + shoptype + '\'' +
                    ", tktype='" + tktype + '\'' +
                    ", tkrates='" + tkrates + '\'' +
                    ", cuntao='" + cuntao + '\'' +
                    ", tkmoney='" + tkmoney + '\'' +
                    ", couponurl='" + couponurl + '\'' +
                    ", couponmoney='" + couponmoney + '\'' +
                    ", couponsurplus='" + couponsurplus + '\'' +
                    ", couponreceive='" + couponreceive + '\'' +
                    ", couponreceive2='" + couponreceive2 + '\'' +
                    ", todaycouponreceive='" + todaycouponreceive + '\'' +
                    ", couponnum='" + couponnum + '\'' +
                    ", couponexplain='" + couponexplain + '\'' +
                    ", couponstarttime='" + couponstarttime + '\'' +
                    ", couponendtime='" + couponendtime + '\'' +
                    ", start_time='" + start_time + '\'' +
                    ", end_time='" + end_time + '\'' +
                    ", starttime='" + starttime + '\'' +
                    ", isquality='" + isquality + '\'' +
                    ", report_status='" + report_status + '\'' +
                    ", is_brand='" + is_brand + '\'' +
                    ", is_live='" + is_live + '\'' +
                    ", guide_article='" + guide_article + '\'' +
                    ", videoid='" + videoid + '\'' +
                    ", activity_type='" + activity_type + '\'' +
                    ", general_index='" + general_index + '\'' +
                    ", planlink=" + planlink +
                    ", seller_name='" + seller_name + '\'' +
                    ", userid='" + userid + '\'' +
                    ", sellernick='" + sellernick + '\'' +
                    ", online_users='" + online_users + '\'' +
                    ", original_img='" + original_img + '\'' +
                    ", original_article='" + original_article + '\'' +
                    ", discount='" + discount + '\'' +
                    ", is_explosion='" + is_explosion + '\'' +
                    ", me=" + me +
                    ", activityid='" + activityid + '\'' +
                    ", coupon_condition='" + coupon_condition + '\'' +
                    ", taobao_image='" + taobao_image + '\'' +
                    ", down_type='" + down_type + '\'' +
                    ", shopid='" + shopid + '\'' +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "PurchaseRzy{" +
                "code=" + code +
                ", min_id=" + min_id +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }
}
