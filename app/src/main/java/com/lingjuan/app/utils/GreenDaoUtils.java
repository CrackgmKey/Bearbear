package com.lingjuan.app.utils;

import android.content.Context;

import com.lingjuan.app.constant.Constant;
import com.lingjuan.app.greendao.DaoMaster;
import com.lingjuan.app.greendao.DaoSession;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.query.QueryBuilder;

/**
 * Created by TaoHui on 2018/10/17.
 */

public class GreenDaoUtils {
    public static DaoSession daoSession;
    public static GreenDaoUtils greenDaoUtils;

    public static void init(Context context) {
        initDbSellet(context);
    }

    private static void initDbSellet(Context context) {
        DaoMaster.DevOpenHelper openHelper = new DaoMaster.DevOpenHelper(context, Constant.GREED_NAME);
        Database database = openHelper.getWritableDb();
        DaoMaster daoMaster = new DaoMaster(database);
        daoSession = daoMaster.newSession();
    }

    public enum Type{
         USERINFO,
         HisKeyDATA;
    }


    public static GreenDaoUtils getInitntes() {
        if (greenDaoUtils == null) {
            greenDaoUtils = new GreenDaoUtils();
        }
        return greenDaoUtils;
    }

    public static DaoSession getCkDaoSession() {
        return daoSession;
    }
    public static DaoSession getDaoSession() {
        return daoSession;
    }


    public QueryBuilder queryBuilder(AbstractDao abstractDao) {
        return abstractDao.queryBuilder();
    }

}
