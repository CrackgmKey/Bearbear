package com.lingjuan.app.wigth;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathEffect;
import android.util.AttributeSet;
import android.widget.RelativeLayout;

import com.lingjuan.app.R;

/**
 * Created by Administrator on 2017/4/5.
 */

public class CouponDisplayView extends RelativeLayout{

    private Paint mPaint;

    private Paint mPaint2;
    /**
     * 圆间距
     */
    private float gap = 0;
    /**
     * 半径
     */
    private float radius = 20;
    /**
     * 圆数量
     */
    private int circleNum;

    private float remain;

    private int color;

    public CouponDisplayView(Context context) {
        super(context);
    }

    public CouponDisplayView(Context context, AttributeSet attrs) {
        super(context, attrs);
        TypedArray mTypedArray = context.obtainStyledAttributes(attrs, R.styleable.CouponDisplayView);
        color = mTypedArray.getColor(R.styleable.CouponDisplayView_CircleColor, Color.WHITE);
        mTypedArray.recycle();

    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        if (remain == 0) {
            remain = (int) (w - gap) % (2 * radius + gap);
        }
        circleNum = (int) ((w - gap) / (2 * radius + gap));

        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaint.setDither(true);
        mPaint.setColor(color);
        mPaint.setStyle(Paint.Style.FILL);
    }


    public CouponDisplayView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        for (int i = 0; i < circleNum; i++) {
            float x = gap + radius + remain / 2 + ((gap + radius * 2) * i);
            canvas.drawCircle(x, 0, radius, mPaint);
        }
        mPaint2 = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaint2.setDither(true);
        mPaint2.setColor(getResources().getColor(R.color.divider_color_car));
        mPaint2.setStyle(Paint.Style.FILL);
        Paint paint = new Paint();
        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(Color.DKGRAY);
        Path path = new Path();
        path.moveTo(0, getHeight() / 2 + 60);
        path.lineTo(getWidth(), getHeight() / 2 + 60);
        PathEffect effects = new DashPathEffect(new float[]{15, 15, 15, 15}, 2);
        paint.setPathEffect(effects);
        canvas.drawPath(path, paint);

        canvas.drawCircle(0, getHeight() / 2 + 60, radius, mPaint2);
        canvas.drawCircle(getWidth(), getHeight() / 2 + 60, radius, mPaint2);
    }

    public void setColor(int color) {
        this.color = color;
    }
}
