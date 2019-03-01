package com.lingjuan.app.utils.db;

import com.lingjuan.app.entity.HistoryRzy;
import com.lingjuan.app.greendao.HistoryRzyDao;
import com.lingjuan.app.utils.GreenDaoUtils;

/**
 * 搜索数据库工具类
 * Created by TaoHui on 2018/10/17.
 */

public class QueryHistoryUtils {

    /**
     * 添加记录
     * @param historyRzy 内容
     * @return
     */
    public static long insert(HistoryRzy historyRzy) {
        return GreenDaoUtils.getCkDaoSession().getHistoryRzyDao().insert(historyRzy);
    }


    /**
     * 是否存在
     * @param msg 条件
     * @return
     */
    public static boolean isExistence(String msg){
        return GreenDaoUtils.getInitntes().queryBuilder(GreenDaoUtils.getCkDaoSession().getHistoryRzyDao()).where(HistoryRzyDao.Properties.Message.eq(msg)).list().size() == 0;
    }


    public static void delete(){
        GreenDaoUtils.getCkDaoSession().getHistoryRzyDao().deleteAll();
    }

    public static void getFootprintDelete(){
        GreenDaoUtils.getCkDaoSession().getFootprintRzyDao().deleteAll();
    }

}
