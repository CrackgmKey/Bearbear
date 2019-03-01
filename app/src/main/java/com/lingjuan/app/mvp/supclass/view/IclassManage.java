package com.lingjuan.app.mvp.supclass.view;

import com.lingjuan.app.entity.SupclassLeft;

/**
 * Created by TaoHui on 2018/10/5.
 */

public class IclassManage {
    public interface IsupclassView{
        void LeftSuccess(SupclassLeft supclassLeft);
        void RightSuccess(SupclassLeft supclassLeft,int pos);
        void RightSuccess(SupclassLeft supclassLeft);
        void FindError(String s);
    }
}
