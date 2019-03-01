package com.lingjuan.app.customview;

import java.util.HashMap;

/**
 * Created by TaoHui on 2018/10/5.
 */

public class DataHashMap extends HashMap<String,String>{
    public static DataHashMap spicyhotMap;
    public DataHashMap(String title, String iamgeId) {
        put("iamge",iamgeId);
        put("title",title);
    }


    //获取单例
    public static DataHashMap getInstance(){
        if(spicyhotMap == null){
            spicyhotMap = new DataHashMap();
        }
        spicyhotMap.clear();
        return spicyhotMap;
    }

    public DataHashMap appParam(String key, String v){
        synchronized (spicyhotMap){
            spicyhotMap.put(key,v);
        }
        return  this;
    }
    public DataHashMap putll(DataHashMap map){
        spicyhotMap.putAll(map);
        return  this;
    }

    public DataHashMap Builder(){
        put("apikey","crackgmkey");
        return spicyhotMap;
    }

    public DataHashMap() {
    }

    public DataHashMap(String title) {
        put("Notitle",title);
    }
}
