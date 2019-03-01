package com.lingjuan.app.mvp.upto.view;

import com.lingjuan.app.entity.Commodity;
import com.lingjuan.app.mvp.base.BaseViw;

import java.util.List;

/**
 * Created by TaoHui on 2018/10/10.
 */

public  class UptoView {

    public  interface pview{
        void uptoSucceed(List<Commodity.CommodityData>  dataBean);
        void error(String e);
    }

    public  interface mview{
        void uptoSucceed(List<Commodity.CommodityData>  dataBean);
    }

    public interface uptoview extends BaseViw{
        void uptoSucceed(List<Commodity.CommodityData>  dataBean);
        void error(String e);
    }
}
