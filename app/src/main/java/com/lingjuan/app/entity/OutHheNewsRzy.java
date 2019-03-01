package com.lingjuan.app.entity;

import java.util.List;

/**
 * 首页滚蛋消息
 * Created by TaoHui on 2018/12/22.
 */

public class OutHheNewsRzy {

    /**
     * status : 200
     * result : [{"id":64,"title":"好劵上线欢迎使用","cate":72,"description":"驱蚊器翁群 ","content":"<p>惠涛666666666666666666666666666666666666666<\/p>","thumb":"","create_time":1545454613,"update_time":0,"sort":1,"verify":0,"user_id":0,"is_recommend":0,"click":0,"recommand":0,"is_qiniu":0}]
     */

    private int status;
    private List<ResultBean> result;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public List<ResultBean> getResult() {
        return result;
    }

    public void setResult(List<ResultBean> result) {
        this.result = result;
    }

    public static class ResultBean {
        /**
         * id : 64
         * title : 好劵上线欢迎使用
         * cate : 72
         * description : 驱蚊器翁群
         * content : <p>惠涛666666666666666666666666666666666666666</p>
         * thumb :
         * create_time : 1545454613
         * update_time : 0
         * sort : 1
         * verify : 0
         * user_id : 0
         * is_recommend : 0
         * click : 0
         * recommand : 0
         * is_qiniu : 0
         */

        private int id;
        private String title;
        private int cate;
        private String description;
        private String content;
        private String thumb;
        private int create_time;
        private int update_time;
        private int sort;
        private int verify;
        private int user_id;
        private int is_recommend;
        private int click;
        private int recommand;
        private int is_qiniu;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public int getCate() {
            return cate;
        }

        public void setCate(int cate) {
            this.cate = cate;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getThumb() {
            return thumb;
        }

        public void setThumb(String thumb) {
            this.thumb = thumb;
        }

        public int getCreate_time() {
            return create_time;
        }

        public void setCreate_time(int create_time) {
            this.create_time = create_time;
        }

        public int getUpdate_time() {
            return update_time;
        }

        public void setUpdate_time(int update_time) {
            this.update_time = update_time;
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

        public int getIs_recommend() {
            return is_recommend;
        }

        public void setIs_recommend(int is_recommend) {
            this.is_recommend = is_recommend;
        }

        public int getClick() {
            return click;
        }

        public void setClick(int click) {
            this.click = click;
        }

        public int getRecommand() {
            return recommand;
        }

        public void setRecommand(int recommand) {
            this.recommand = recommand;
        }

        public int getIs_qiniu() {
            return is_qiniu;
        }

        public void setIs_qiniu(int is_qiniu) {
            this.is_qiniu = is_qiniu;
        }

        @Override
        public String toString() {
            return "ResultBean{" +
                    "id=" + id +
                    ", title='" + title + '\'' +
                    ", cate=" + cate +
                    ", description='" + description + '\'' +
                    ", content='" + content + '\'' +
                    ", thumb='" + thumb + '\'' +
                    ", create_time=" + create_time +
                    ", update_time=" + update_time +
                    ", sort=" + sort +
                    ", verify=" + verify +
                    ", user_id=" + user_id +
                    ", is_recommend=" + is_recommend +
                    ", click=" + click +
                    ", recommand=" + recommand +
                    ", is_qiniu=" + is_qiniu +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "OutHheNewsRzy{" +
                "status=" + status +
                ", result=" + result +
                '}';
    }
}
