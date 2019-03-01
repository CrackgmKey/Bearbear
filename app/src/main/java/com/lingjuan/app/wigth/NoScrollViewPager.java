package com.lingjuan.app.wigth;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

/**
 * Created by TaoHui on 2018/10/6.
 */

public class NoScrollViewPager extends ViewPager {
    private boolean noScroll = false;
    public NoScrollViewPager(@NonNull Context context) {
        super(context);
    }
    public NoScrollViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
    }
    @Override
    public void scrollTo(int x, int y) {
        super.scrollTo(x, y);
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        return false;
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        return false;
    }

    @Override
    public void setCurrentItem(int item) {
        super.setCurrentItem(item,false);
    }
}
