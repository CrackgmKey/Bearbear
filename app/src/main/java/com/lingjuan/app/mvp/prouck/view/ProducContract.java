package com.lingjuan.app.mvp.prouck.view;

import com.lingjuan.app.entity.ProducRzy;
import com.lingjuan.app.mvp.base.BaseViw;

import java.util.List;

/**
 * Created by TaoHui on 2018/10/18.
 */

public class ProducContract {
    public interface Model {
        void getData(String msg,int sort,int is_tmall,int min_id);
    }

    public interface Presenter {
        void onFailedMsg(String error);

        void onSuccess(ProducRzy userBean);

        void getData(String msg,int sort,int is_tmall,int min_id);

    }

    public interface View extends BaseViw{

        void onFailedMsg(String error);

        void onSuccess(List<ProducRzy.DataBean> userBean,int mid);

    }
}
