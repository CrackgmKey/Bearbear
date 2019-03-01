package com.lingjuan.app.wigth;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.TextAppearanceSpan;
import android.util.AttributeSet;
import android.view.Gravity;

import com.lingjuan.app.R;

/**
 * Created by TaoHui on 2018/10/10.
 */

public class RushRadioButton extends android.support.v7.widget.AppCompatRadioButton {
    //上文颜色
    private String uppercolor = "#FFF";
    //下文颜色
    private String lowercolor = "#FFF";
    //上文内容
    private String upperTitle = "测试";
    //下文内容
    private String lowerTitle = "我来看看";
    //上文内容字体大小
    private String upperTitleSzie = "5";
    //下文内容字体大小
    private String lowerTitleSize = "5";
    public RushRadioButton(Context context) {
        super(context);
        uppercolor = "#FFFFF0";
        lowercolor = "#FFFFF0";
        initTrueText();
    }

    public RushRadioButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        @SuppressLint({"Recycle", "CustomViewStyleable"}) TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.rush);
        //获取上文字体颜色
        uppercolor = typedArray.getString(R.styleable.rush_uppercolor);
        //获取下文字体颜色
        lowercolor = typedArray.getString(R.styleable.rush_lowercolor);
        //获取上文字体内容
        upperTitle = typedArray.getString(R.styleable.rush_upperTitle);
        //获取下文字体内容
        lowerTitle = typedArray.getString(R.styleable.rush_lowerTitle);
        //获取上文字体内容字体大小
        upperTitleSzie = typedArray.getString(R.styleable.rush_uppertitlesize);
        //获取下文字体内容字体大小
        lowerTitleSize = typedArray.getString(R.styleable.rush_lowertitlesize);
        typedArray.recycle();
        uppercolor = "#FFFFF0";
        lowercolor = "#FFFFF0";
        initTrueText();
    }

    public RushRadioButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        @SuppressLint({"Recycle", "CustomViewStyleable"}) TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.rush);
        //获取上文字体颜色
        uppercolor = typedArray.getString(R.styleable.rush_uppercolor);
        //获取下文字体颜色
        lowercolor = typedArray.getString(R.styleable.rush_lowercolor);
        //获取上文字体内容
        upperTitle = typedArray.getString(R.styleable.rush_upperTitle);
        //获取下文字体内容
        lowerTitle = typedArray.getString(R.styleable.rush_lowerTitle);
        //获取上文字体内容字体大小
        upperTitleSzie = typedArray.getString(R.styleable.rush_uppertitlesize);
        //获取下文字体内容字体大小
        lowerTitleSize = typedArray.getString(R.styleable.rush_lowertitlesize);
        typedArray.recycle();
        uppercolor = "#FFFFF0";
        lowercolor = "#FFFFF0";
    }

    public void initTrueText(){
        SpannableString styledText = new SpannableString(upperTitle+"\n"+lowerTitle);
        styledText.setSpan(new TextAppearanceSpan(getContext(),R.style.style0),0,upperTitle.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        styledText.setSpan(new TextAppearanceSpan(getContext(),R.style.style1),upperTitle.length()+1,styledText.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        setText(styledText);
        setGravity(Gravity.CENTER);
    }

    public void initFlaseText(){
        SpannableString styledText = new SpannableString(upperTitle+"\n"+lowerTitle);
        styledText.setSpan(new TextAppearanceSpan(getContext(),R.style.style2),0,upperTitle.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        styledText.setSpan(new TextAppearanceSpan(getContext(),R.style.style3),upperTitle.length()+1,styledText.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        setText(styledText);
        setGravity(Gravity.CENTER);
    }

    public String getUppercolor() {
        return uppercolor;
    }

    public void setUppercolor(String uppercolor) {
        this.uppercolor = uppercolor;
    }

    public String getLowercolor() {
        return lowercolor;
    }

    public void setLowercolor(String lowercolor) {
        this.lowercolor = lowercolor;
    }

    public void defaultText(){
        initFlaseText();

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }
}
