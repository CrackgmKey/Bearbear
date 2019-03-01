package com.lingjuan.app.entity;

import java.util.List;

/**
 * 分类
 * Created by TaoHui on 2018/10/6.
 */

public class SupclassLeft {


    private int code;
    private int min_id;
    private String msg;
    private List<GeneralClassifyBean> general_classify;

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

    public List<GeneralClassifyBean> getGeneral_classify() {
        return general_classify;
    }

    public void setGeneral_classify(List<GeneralClassifyBean> general_classify) {
        this.general_classify = general_classify;
    }

    public static class GeneralClassifyBean {
        /**
         * cid : 1
         * main_name : 女装
         * data : [{"next_name":"裙装","info":[{"son_name":"连衣裙","imgurl":"http://img.haodanku.com/89937f347f81f5c5539f9da9b35b7a62-600"},{"son_name":"雪纺裙","imgurl":"http://img.haodanku.com/3deb054da8cb2f4b1b5a07ab530e7e41-600"},{"son_name":"半身裙","imgurl":"http://img.haodanku.com/b68bc66ab1a81db336110b7c1196b5a9-600"},{"son_name":"印花裙","imgurl":"http://img.haodanku.com/3ce7249ba847286308c82bed97f7817d-600"},{"son_name":"吊带裙","imgurl":"http://img.haodanku.com/0716abc13652355b130dc3c83d39a7dc-600"},{"son_name":"纯色裙","imgurl":"http://img.haodanku.com/de464503dab5d20a5d6505573f1624bd-600"}]},{"next_name":"套装","info":[{"son_name":"两件套","imgurl":"http://img.haodanku.com/dcabee1a81b9c631bbc903597fad52a2-600"},{"son_name":"夏季套装","imgurl":"http://img.haodanku.com/fcf45b47afad11fe7ac05c179de174c1-600"},{"son_name":"大码女装","imgurl":"http://img.haodanku.com/005f603379aa285718b3f7c99c1ca88a-600"},{"son_name":"妈妈装","imgurl":"http://img.haodanku.com/cf445d5d9ddad49a38c0e542be22b565-600"},{"son_name":"婚纱","imgurl":"http://img.haodanku.com/d40c79df78c0a0cfbbb05605891950db-600"},{"son_name":"小香风","imgurl":"http://img.haodanku.com/2907a1a4faf78674c4ff422ce9ca16eb-600"},{"son_name":"运动套装","imgurl":"http://img.haodanku.com/97340565f9420afafc7a37966095da75-600"},{"son_name":"雪纺套装","imgurl":"http://img.haodanku.com/233b900fde6dc193a0c4b8886d121002-600"}]},{"next_name":"T恤","info":[{"son_name":"T恤","imgurl":"http://img.haodanku.com/397fc31d9f3abdef5177ab1ec82a254c-600"},{"son_name":"一字肩","imgurl":"http://img.haodanku.com/f4ca5e271d74fd5c29d051c7b1106f04-600"},{"son_name":"印花雪纺","imgurl":"http://img.haodanku.com/60e743e4a53b475f2b01a606b61ab217-600"},{"son_name":"吊带T恤","imgurl":"http://img.haodanku.com/7aad5119d9e8d49c74ab97e31944ba63-600"},{"son_name":"娃娃衫","imgurl":"http://img.haodanku.com/9a596fb1d0c7008cdfad30e5562b3b3f-600"},{"son_name":"情侣T恤","imgurl":"http://img.haodanku.com/9880baf8c939776a65a64c6ec6b37621-600"},{"son_name":"白衬衣","imgurl":"http://img.haodanku.com/1c60edccb596c5f3496d883be75869c5-600"},{"son_name":"短袖T恤","imgurl":"http://img.haodanku.com/81ee9efd599bcfb76668e0ab3d08df6d-600"},{"son_name":"纯色T恤","imgurl":"http://img.haodanku.com/44d365c3c459a4a04185f1fa947e7353-600"},{"son_name":"蕾丝拼接","imgurl":"http://img.haodanku.com/f77f58f4f0f67b4c3cd830954354462a-600"},{"son_name":"蕾丝衫","imgurl":"http://img.haodanku.com/fe7c5357cb05b2128bf95c014c402092-600"},{"son_name":"防晒衫","imgurl":"http://img.haodanku.com/99d63b5ef04f0599ef94a71b1a247fef-600"},{"son_name":"露肩上衣","imgurl":"http://img.haodanku.com/a39d41be029747367e3889ea195043b1-600"},{"son_name":"长袖T恤","imgurl":"http://img.haodanku.com/d0ae23ec9b6d46e16bd2e0e924b2bd83-600"}]},{"next_name":"内搭","info":[{"son_name":"喇叭袖","imgurl":"http://img.haodanku.com/6d8739d3e2aba86cfe98c3d8c631cb18-600"},{"son_name":"开衫","imgurl":"http://img.haodanku.com/051f12a2106ca222a4a651ef556419b2-600"},{"son_name":"打底毛衣","imgurl":"http://img.haodanku.com/d93f276b06e1aa4d9f5a7c4718ca675d-600"},{"son_name":"毛衣","imgurl":"http://img.haodanku.com/5ae75e2e972aec9126ac7ef6e44bd279-600"},{"son_name":"针织衫","imgurl":"http://img.haodanku.com/d989f5485e411a23b53d903787e9e8ae-600"},{"son_name":"高领","imgurl":"http://img.haodanku.com/226f1370ec92bd4804621851e4a45cd4-600"}]},{"next_name":"外套","info":[{"son_name":"卫衣","imgurl":"http://img.haodanku.com/2329f94b4030aa27e819e159d64969c4-600"},{"son_name":"夹克","imgurl":"http://img.haodanku.com/ab499244178c525025d8a3e1ff4ed36e-600"},{"son_name":"棉服","imgurl":"http://img.haodanku.com/6d3898d409060a49ebc6a80c150d15b2-600"},{"son_name":"毛呢","imgurl":"http://img.haodanku.com/5b397df30169b79af64c569606b7e0af-600"},{"son_name":"牛仔","imgurl":"http://img.haodanku.com/38a001153e2f30933f3cae16f2b2a171-600"},{"son_name":"皮衣","imgurl":"http://img.haodanku.com/78c7fcecea8eaf4b329002b3308b3545-600"},{"son_name":"短外套","imgurl":"http://img.haodanku.com/26a08a44cce036a5cf49a3322e4cbf37-600"},{"son_name":"羽绒","imgurl":"http://img.haodanku.com/8b319845442d1ca43866388b3cdc9008-600"},{"son_name":"西装","imgurl":"http://img.haodanku.com/8760d56b968fff5f4542cba45398f911-600"},{"son_name":"风衣","imgurl":"http://img.haodanku.com/fce2eacae26fdd2be1e56319570db29e-600"},{"son_name":"马甲","imgurl":"http://img.haodanku.com/72c6ef4b40de18dddb9ae5dd38a9a051-600"}]},{"next_name":"裤子","info":[{"son_name":"休闲裤","imgurl":"http://img.haodanku.com/047d30183d119f6805767a2649e05047-600"},{"son_name":"哈伦裤","imgurl":"http://img.haodanku.com/a1711789779fbd5c921fe1672619879f-600"},{"son_name":"棉麻裤","imgurl":"http://img.haodanku.com/a3e99f528f0cf163b96b0f6090226364-600"},{"son_name":"牛仔裤","imgurl":"http://img.haodanku.com/d1c7bf2b3a3d52047bf2bba87527ce2c-600"},{"son_name":"短裤","imgurl":"http://img.haodanku.com/d370086ea3d2a9c4ba569cfb8daf0d8e-600"},{"son_name":"破洞牛仔裤","imgurl":"http://img.haodanku.com/82462d589beb34111e9fccf66c170c7d-600"},{"son_name":"裤子","imgurl":"http://img.haodanku.com/049ea9c85a7b917eb9f0844df3910d4b-600"},{"son_name":"阔腿裤","imgurl":"http://img.haodanku.com/d59ec97908e5f2a3af232cbb23c54f31-600"}]}]
         */

        private int cid;
        private String main_name;
        private List<DataBean> data;

        public int getCid() {
            return cid;
        }

        public void setCid(int cid) {
            this.cid = cid;
        }

        public String getMain_name() {
            return main_name;
        }

        public void setMain_name(String main_name) {
            this.main_name = main_name;
        }

        public List<DataBean> getData() {
            return data;
        }

        public void setData(List<DataBean> data) {
            this.data = data;
        }

        public static class DataBean {
            /**
             * next_name : 裙装
             * info : [{"son_name":"连衣裙","imgurl":"http://img.haodanku.com/89937f347f81f5c5539f9da9b35b7a62-600"},{"son_name":"雪纺裙","imgurl":"http://img.haodanku.com/3deb054da8cb2f4b1b5a07ab530e7e41-600"},{"son_name":"半身裙","imgurl":"http://img.haodanku.com/b68bc66ab1a81db336110b7c1196b5a9-600"},{"son_name":"印花裙","imgurl":"http://img.haodanku.com/3ce7249ba847286308c82bed97f7817d-600"},{"son_name":"吊带裙","imgurl":"http://img.haodanku.com/0716abc13652355b130dc3c83d39a7dc-600"},{"son_name":"纯色裙","imgurl":"http://img.haodanku.com/de464503dab5d20a5d6505573f1624bd-600"}]
             */

            private String next_name;
            private int cid;
            private List<InfoBean> info;


            public void setCid(int cid) {
                this.cid = cid;
            }

            public int getCid() {
                return cid;
            }

            public String getNext_name() {
                return next_name;
            }

            public void setNext_name(String next_name) {
                this.next_name = next_name;
            }

            public List<InfoBean> getInfo() {
                return info;
            }

            public void setInfo(List<InfoBean> info) {
                this.info = info;
            }

            public static class InfoBean {
                /**
                 * son_name : 连衣裙
                 * imgurl : http://img.haodanku.com/89937f347f81f5c5539f9da9b35b7a62-600
                 */

                private String son_name;
                private String imgurl;

                public String getSon_name() {
                    return son_name;
                }

                public void setSon_name(String son_name) {
                    this.son_name = son_name;
                }

                public String getImgurl() {
                    return imgurl;
                }

                public void setImgurl(String imgurl) {
                    this.imgurl = imgurl;
                }
            }
        }
    }

    @Override
    public String toString() {
        return "SupclassLeft{" +
                "code=" + code +
                ", min_id=" + min_id +
                ", msg='" + msg + '\'' +
                ", general_classify=" + general_classify +
                '}';
    }
}
