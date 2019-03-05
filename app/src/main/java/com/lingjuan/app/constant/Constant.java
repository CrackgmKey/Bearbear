package com.lingjuan.app.constant;

import java.util.Map;

/**
 * Created by TaoHui on 2018/10/5.
 */

public class Constant {
    //注册成功返回码
    public static final int REG_CODE = 100;
    //第一次加载
    public static boolean CK_SWITCH = true;
    //客服QQ
    public static String USER_QQ_NUM = "";
    //是否为调试环境
    public static final boolean DEBUG = true;
    //分类排序MAP
    public static Map<String, Object> MAP;
    //服务器一级目录
    public static final String HTTP_FILE = "yg";
    //服务器IP地址
    public static final String HTTP_IP = "123.207.156.197";
    //自家服务器地址
    public static final String HTTP_URL = "http://"+ HTTP_IP +"/"+HTTP_FILE +"/index.php/api/";
    //服务器图片地址
    public static final String HTTP_PIC = "http://"+HTTP_IP+"/"+HTTP_FILE +"/public/uploads/";
    //获取更新地址
    public static final String HTTP_UPDATA = "http://"+HTTP_IP+"/"+HTTP_FILE+"/updata/";
    //抽奖转盘
    public static final String HTTP_DRAW = "http://"+HTTP_IP+"/"+HTTP_FILE+"/draw/index.html";
    //图片后缀
    public static final String IMAGE_SUFFIX = "_310x310.jpg";
    //好单库APPK
    public static final String HAODAN_APPKEY = "crackgmkey";
    //数据库名称
    public static final String GREED_NAME = "crackgmkey.db";
    //轻淘客APPIDKEY
    public static final String QTK_APPKEY = "LdMnLUGl";
    //商品详情页面取值
    public static final String COMMODITY = "commodity";
    //视频播放接口
    public static final String VIDEO_URL = "http://cloud.video.taobao.com/play/u/1/p/1/e/6/t/1/";
    //淘客基地APPK
    public static final String TAOJD_APPKEY = "7bc56a1a59cd14b7257b1ca3ded90eda";
    //获取商品Url
    public static final String COMMODITY_LINK = "http://v2.api.haodanku.com/itemlist/apikey/" + HAODAN_APPKEY + "/nav/3/cid/1/back/20/min_id/1";
    //获取超级分类URL
    public static final String SUPER_CLASSIFICATION = " http://v2.api.haodanku.com/super_classify/apikey/" + HAODAN_APPKEY;
    //获取抢购接口
    public static final String RUSH_BUY_URL = "http://v2.api.haodanku.com/fastbuy/apikey/" + HAODAN_APPKEY + "/hour_type/7/min_id/1";
    //从淘客基地获取TOp100
    public static final String TAOJD_TOP100 = "http://api.tkjidi.com/getGoodsLink?appkey=" + TAOJD_APPKEY + "&type=top100&sort=sales&cid=0&sort_type=desc&page=1";
    //获取视频推举的接口
    public static final String DATA_VIDEO = "http://v2.api.haodanku.com/itemlist/apikey/crackgmkey/nav/4/cid/1/back/20/sort/11/min_id/1";
    //获取视频推举的接口
    public static final String HOT_KEY = "http://v2.api.haodanku.com/hot_key/apikey/" + HAODAN_APPKEY;
    //获取搜索数据内容
    public static final String PRODCU_URL = "http://v2.api.haodanku.com/supersearch/apikey/" + HAODAN_APPKEY + "/keyword/零食/back/20/min_id/1/tb_p/1/sort/0/is_tmall/0/is_coupon/1/limitrate/0";
    //单品详情接口
    public static final String ITEM_DETAIL = "http://v2.api.haodanku.com/item_detail/apikey/" + HAODAN_APPKEY + "/itemid/557787124271";
    //单品详情图文接口
    public static final String DATA_DETAIL = "http://hws.m.taobao.com/cache/desc/5.0?";
    //获取App是否需要更新
    public static final String UPDATA_DETAIL = HTTP_URL + "/User/getUpdata";
    //获取首页淘抢购接口
    public static final String ACQUTIONOFPANIC_URL = "http://openapi.qingtaoke.com/qingsoulist?sort=1&page=1&app_key=" + QTK_APPKEY + "&v=1.0&cat=2&min_price=1&max_price=100&new=0&is_ju=1&is_tqg=0&is_ali=0";
    //用户注册接口
    public static final String APP_REG_USER = HTTP_URL + "/User/addUser";
    //用户登录接口
    public static final String APP_LOGIN_USER = HTTP_URL + "/User/userLogin";
    //用户获取
    public static final String APP_GET_GAMBLING = HTTP_URL + "/User/luckyCommodity";
    //获取首页最新轮播数据
    public static final String APP_GET_ADVERTISING = HTTP_URL + "/User/getAdvertising";
    //获取首页最新滚动消息
    public static final String APP_GET_GUNDAN = HTTP_URL + "/User/getOutHheNews";
    //获取每日快讯
    public static final String APP_GET_EVERYDAY = HTTP_URL + "/User/getEverydayGood";
    //用户相关常量
    public  class User {
        //判断是否登录
        public static final String ISLONIG = "islogin";
        //成功操作表示
        public static final int USER_SUCCESS = 200;
        //注册用户失败
        public static final int USER_REG_FAIL = 202;
        //注册用户已存在
        public static final int USER_REG_EXISTENCE = 201;
        //登录用户失败
        public static final int USER_LONGIN_FAIL = 203;
    }

    //内容类
    public  class Message {
        //轮播广告的分类ID
        public static final String WHEEL_NLANTING_AD = "23";
        //轮播广告的分类ID
        public static final String GOOD_ESSAY_CLASSIFICATION = "73";
        //注册用户已存在
        public static final String ROTATION_TEXT = "72";
    }
}
