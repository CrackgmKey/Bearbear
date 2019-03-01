package com.lingjuan.app.utils;

import android.util.ArrayMap;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017-05-04.
 */

public class GsonUtil {
    public static ArrayList<String> WarehouseStatus;//入库状态
    public static ArrayList<String> OutgoingState;//出库状态
    private static Gson gson = null;

    static {
        if (gson == null) {
            gson = new Gson();

        }
    }

    private GsonUtil() {

    }


    public static void init() {
        WarehouseStatus = new ArrayList<>();//入库状态
        OutgoingState = new ArrayList<>();//出库状态
    }

    /**
     * 转成json
     *
     * @param object
     * @return
     */
    public static String GsonString(Object object) {
        String gsonString = null;
        if (gson != null) {
            gsonString = gson.toJson(object);
        }
        return gsonString;
    }


    /**
     * 转成bean
     *
     * @param gsonString
     * @param cls
     * @return
     */
    public static <T> T GsonToBean(String gsonString, Class<T> cls) {
        T t = null;
        if (gson != null) {
            t = gson.fromJson(gsonString, cls);
        }
        return t;
    }

    /**
     * 转成Map
     *
     * @param gsonString
     * @return
     */
    public static <T> T GsonToMap(String gsonString) {
        T t = null;
        if (gson != null) {
            t = gson.fromJson(gsonString, new TypeToken<Map<String, Map<String, String>>>() {
            }.getType());

        }
        return t;
    }


    /**
     * 转成list
     *
     * @param gsonString
     * @param cls
     * @return
     */
    public static <T> List<T> GsonToList(String gsonString, Class<T> cls) {
        List<T> list = new ArrayList<>();

        if (gson != null) {
            list = gson.fromJson(gsonString, new TypeToken<List<T>>() {
            }.getType());
        }
        return list;
    }

    /**
     * 转成list
     *
     * @param gsonString
     * @param cls
     * @return
     */
    public static <T> List<T> GsonToArrayList(String gsonString, Class<T> cls) {
        ArrayList<T> lst = new ArrayList<>();
        JsonArray array = new JsonParser().parse(gsonString).getAsJsonArray();

        if (gson != null) {
            for (final JsonElement elem : array) {
                T t = gson.fromJson(elem, cls);
                lst.add(t);
            }
        }
        return lst;
    }

    /**
     * 转成list中有map的
     *
     * @param gsonString
     * @return
     */
    public static <T> List<Map<String, T>> GsonToListMaps(String gsonString) {
        List<Map<String, T>> list = null;
        if (gson != null) {
            list = gson.fromJson(gsonString,
                    new TypeToken<List<Map<String, T>>>() {
                    }.getType());
        }
        return list;
    }

    /**
     * 转成map的
     *
     * @param gsonString
     * @return
     */
    public static <T> Map<String, T> GsonToMaps(String gsonString) {
        Map<String, T> map = null;
        if (gson != null) {
            map = gson.fromJson(gsonString, new TypeToken<Map<String, T>>() {
            }.getType());
        }
        return map;
    }

    /**
     * 转成arraymap的
     *
     * @param gsonString
     * @return
     */
    public static <T> ArrayMap<Integer, T> GsonToArrayMaps(String gsonString) {
        ArrayMap<Integer, T> map = null;
        if (gson != null) {
            map = gson.fromJson(gsonString, new TypeToken<Map<Integer, T>>() {
            }.getType());
        }
        return map;
    }

    /**
     * 添加出库状态
     *
     * @param wsId 工单Id
     */
    public static void addOutgoingState(String wsId) {
        //  OutgoingState.add(wsId);
        WarehouseStatus.add(wsId);
    }

    /**
     * 添加入库状态
     *
     * @param wsId 工单Id
     */
    public static void addWarehouseStatus(String wsId) {
        WarehouseStatus.add(wsId);
    }

    /**
     * 获取当前进库单最后页面
     *
     * @param wsId 工单ID
     * @return 是否
     */
    public static boolean getWarehouseStatus(String wsId) {
        int size = WarehouseStatus.size();
        if (size >= 1) {
            size = size - 1;
        } else if (size == 0) {
            return false;
        }
        return WarehouseStatus.get(size).equals(wsId);
    }

    /**
     * 获取当前出库单最后页面
     *
     * @param wsId 工单ID
     * @return 是否
     */
    public static boolean getOutgoingState(String wsId) {
     /*   int size = OutgoingState.size();
        if(size >= 1){
            size = size - 1;
        }else if(size == 0){
            return false;
        }
        return OutgoingState.get(size).equals(wsId);*/

        int size = WarehouseStatus.size();
        if (size >= 1) {
            size = size - 1;
        } else if (size == 0) {
            return false;
        }
        return WarehouseStatus.get(size).equals(wsId);

    }

    /**
     * 清除出库单状态
     */
    public static void clearOutgoingState() {
        //OutgoingState.clear();
        WarehouseStatus.clear();
    }

    /**
     * 清除入库单状态
     */
    public static void clearWarehouseStatus() {
        WarehouseStatus.clear();
    }

}
