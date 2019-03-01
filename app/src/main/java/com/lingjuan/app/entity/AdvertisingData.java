package com.lingjuan.app.entity;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * 首页轮播广告数据
 * Created by TaoHui on 2018/12/21.
 */

public class AdvertisingData {

    /**
     * status : 200
     * result : [{"id":32,"name":"清新格调","cate":23,"url":"http://www.leesuntech.com","intro":"清新格调","pic":"20171001/289241506871696.jpg","sort":5,"user_id":0,"click":0,"is_qiniu":0},{"id":31,"name":"品味时尚","cate":23,"url":"http://www.leesuntech.com","intro":"品味时尚","pic":"20171001/27661506871623.jpg","sort":2,"user_id":0,"click":2,"is_qiniu":0},{"id":30,"name":"时尚都市","cate":23,"url":"http://www.leesuntech.com","intro":"时尚都市","pic":"20171001/35671506871629.jpg","sort":3,"user_id":0,"click":0,"is_qiniu":0},{"id":29,"name":"夏日小清新","cate":23,"url":"http://www.leesuntech.com","intro":"夏日小清新","pic":"20171001/9691506871612.jpg","sort":1,"user_id":0,"click":1,"is_qiniu":0}]
     */

    private String status;
    private List<ResultBean> result;

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public List<ResultBean> getResult() {
        return result;
    }

    public void setResult(List<ResultBean> result) {
        this.result = result;
    }

    public static class ResultBean {
        /**
         * id : 32
         * name : 清新格调
         * cate : 23
         * url : http://www.leesuntech.com
         * intro : 清新格调
         * pic : 20171001/289241506871696.jpg
         * sort : 5
         * user_id : 0
         * click : 0
         * is_qiniu : 0
         */

        private int id;
        private String name;
        private int cate;
        @SerializedName("url")
        private String itemid;
        private String intro;
        private String pic;
        private int sort;
        private int user_id;
        private int click;
        private int is_qiniu;

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

        public int getCate() {
            return cate;
        }

        public void setCate(int cate) {
            this.cate = cate;
        }

        public String getUrl() {
            return itemid;
        }

        public void setUrl(String itemid) {
            this.itemid = itemid;
        }

        public String getIntro() {
            return intro;
        }

        public void setIntro(String intro) {
            this.intro = intro;
        }

        public String getPic() {
            return pic;
        }

        public void setPic(String pic) {
            this.pic = pic;
        }

        public int getSort() {
            return sort;
        }

        public void setSort(int sort) {
            this.sort = sort;
        }

        public int getUser_id() {
            return user_id;
        }

        public void setUser_id(int user_id) {
            this.user_id = user_id;
        }

        public int getClick() {
            return click;
        }

        public void setClick(int click) {
            this.click = click;
        }

        public int getIs_qiniu() {
            return is_qiniu;
        }

        public void setIs_qiniu(int is_qiniu) {
            this.is_qiniu = is_qiniu;
        }
    }
}
