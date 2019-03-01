package com.lingjuan.app.entity;

/**
 * 抽奖实体类
 * Created by TaoHui on 2018/11/29.
 */

public class LotterytRzy {

    /**
     * id : 62
     * name : 积分购测试商品1
     * img : null
     * thumb : null
     * serial_no : 20181129023032172
     * brand_id : 0
     * cate_id : 70
     * origin_price : 998.00
     * current_price : 9.00
     * brief : <p>99</p>
     * specifications : <p>999</p>
     * inventory : 999
     * delivery_fee : 99.00
     * spec_main : null
     * click : 0
     * is_recommend : 2
     * add_time : 1543473032
     * update_time : 0
     * status : 2
     * sort : 2
     * verify : 0
     * user_id : 0
     * is_qiniu : 0
     * isstart : 0
     * islotteryt : null
     * currenttimes : null
     * maxsize : null
     */

    private int id;
    //商品名称
    private String name;
    private String img;
    private String thumb;
    private String serial_no;
    private int brand_id;
    private int cate_id;
    private String origin_price;
    private String current_price;
    private String brief;
    private String specifications;
    private int inventory;
    private String delivery_fee;
    private String spec_main;
    private int click;
    private int is_recommend;
    private String add_time;
    private String update_time;
    private int status;
    private int sort;
    private int verify;

    private int user_id;
    private int is_qiniu;
    //是否开启抽奖
    private String isstart;
    //开奖时间
    private String islotteryt;
    //当前次数
    private String currenttimes;
    //最大次数
    private String maxsize;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getThumb() {
        return thumb;
    }

    public void setThumb(String thumb) {
        this.thumb = thumb;
    }

    public String getSerial_no() {
        return serial_no;
    }

    public void setSerial_no(String serial_no) {
        this.serial_no = serial_no;
    }

    public int getBrand_id() {
        return brand_id;
    }

    public void setBrand_id(int brand_id) {
        this.brand_id = brand_id;
    }

    public int getCate_id() {
        return cate_id;
    }

    public void setCate_id(int cate_id) {
        this.cate_id = cate_id;
    }

    public String getOrigin_price() {
        return origin_price;
    }

    public void setOrigin_price(String origin_price) {
        this.origin_price = origin_price;
    }

    public String getCurrent_price() {
        return current_price;
    }

    public void setCurrent_price(String current_price) {
        this.current_price = current_price;
    }

    public String getBrief() {
        return brief;
    }

    public void setBrief(String brief) {
        this.brief = brief;
    }

    public String getSpecifications() {
        return specifications;
    }

    public void setSpecifications(String specifications) {
        this.specifications = specifications;
    }

    public int getInventory() {
        return inventory;
    }

    public void setInventory(int inventory) {
        this.inventory = inventory;
    }

    public String getDelivery_fee() {
        return delivery_fee;
    }

    public void setDelivery_fee(String delivery_fee) {
        this.delivery_fee = delivery_fee;
    }

    public String getSpec_main() {
        return spec_main;
    }

    public void setSpec_main(String spec_main) {
        this.spec_main = spec_main;
    }

    public int getClick() {
        return click;
    }

    public void setClick(int click) {
        this.click = click;
    }

    public int getIs_recommend() {
        return is_recommend;
    }

    public void setIs_recommend(int is_recommend) {
        this.is_recommend = is_recommend;
    }

    public String getAdd_time() {
        return add_time;
    }

    public void setAdd_time(String add_time) {
        this.add_time = add_time;
    }

    public String getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(String update_time) {
        this.update_time = update_time;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getSort() {
        return sort;
    }

    public void setSort(int sort) {
        this.sort = sort;
    }

    public int getVerify() {
        return verify;
    }

    public void setVerify(int verify) {
        this.verify = verify;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getIs_qiniu() {
        return is_qiniu;
    }

    public void setIs_qiniu(int is_qiniu) {
        this.is_qiniu = is_qiniu;
    }

    public String getIsstart() {
        return isstart;
    }

    public void setIsstart(String isstart) {
        this.isstart = isstart;
    }

    public String getIslotteryt() {
        return islotteryt;
    }

    public void setIslotteryt(String islotteryt) {
        this.islotteryt = islotteryt;
    }

    public String getCurrenttimes() {
        return currenttimes;
    }

    public void setCurrenttimes(String currenttimes) {
        this.currenttimes = currenttimes;
    }

    public String getMaxsize() {
        return maxsize;
    }

    public void setMaxsize(String maxsize) {
        this.maxsize = maxsize;
    }
}
