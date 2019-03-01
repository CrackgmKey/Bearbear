package com.lingjuan.app.wigth;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.lingjuan.app.R;

/**
 * Created by TaoHui on 2018/10/19.
 */

public class CategoryButton extends LinearLayout {
    //标题名字
    private String textTitle;
    //是否显示图标
    private boolean isImage;
    //颜色值
    private int titleBarBackGround;
    //上下文
    private Context context;
    //图片地址
    private int imageSelectId;
    //图片地址
    private int imageNotId;
    private TextView tvTiTle;
    private ImageView Image, Image2;
    private int position;
    private int dangqian;
    private boolean itbright;
    private boolean xiaoliang;

    public CategoryButton(Context context) {
        super(context);
        this.context = context;
        TypedArray attributes = context.obtainStyledAttributes(R.styleable.category);
        titleBarBackGround = attributes.getResourceId(R.styleable.category_backcolor, Color.RED);
        isImage = attributes.getBoolean(R.styleable.category_isimage, false);
        itbright = attributes.getBoolean(R.styleable.category_itbright, false);
        xiaoliang = attributes.getBoolean(R.styleable.category_issort, false);
        textTitle = attributes.getString(R.styleable.category_textname);
        imageSelectId = attributes.getResourceId(R.styleable.category_imageyesId, 0);
        imageNotId = attributes.getResourceId(R.styleable.category_imagenotId, 0);
        attributes.recycle();
        init();
    }

    /**
     * 当前位置
     *
     * @param position 自身位置
     */
    public void setPosition(int position) {
        this.position = position;
        invalidate();

    }


    public CategoryButton(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        TypedArray attributes = context.obtainStyledAttributes(attrs, R.styleable.category);
        titleBarBackGround = attributes.getResourceId(R.styleable.category_backcolor, Color.RED);
        isImage = attributes.getBoolean(R.styleable.category_isimage, false);
        textTitle = attributes.getString(R.styleable.category_textname);
        itbright = attributes.getBoolean(R.styleable.category_itbright, false);
        xiaoliang = attributes.getBoolean(R.styleable.category_issort, false);
        imageSelectId = attributes.getResourceId(R.styleable.category_imageyesId, 0);
        imageNotId = attributes.getResourceId(R.styleable.category_imagenotId, 0);
        attributes.recycle();
        init();

    }

    private void init() {
        LayoutInflater.from(context).inflate(R.layout.item_screeningcategory, this, true);
        tvTiTle = findViewById(R.id.tv_codeName);
        Image = findViewById(R.id.im_codeName);
        Image2 = findViewById(R.id.iamg2);
        tvTiTle.setText(textTitle);
        if(xiaoliang){
            Image2.setVisibility(VISIBLE);
        }else {
            Image2.setVisibility(GONE);
        }
        if (position == 2) {
            setImageRez();
        } else {
            setImageColor();
        }

    }

    private void setImageRez() {
        Image.setVisibility(GONE);
        //设置未选中
        Image2.setBackgroundResource(R.mipmap.weixuanzhong);
    }

    private void setImageColor() {
        if (imageSelectId == 0 || imageNotId == 0) {
            imageSelectId = R.mipmap.pointer1;
            imageNotId = R.mipmap.pointer0;
        }
        if (!isImage) {
            Image.setVisibility(GONE);
        } else {
            Image.setVisibility(VISIBLE);
        }

        if (itbright) {
            Image.setBackgroundResource(imageSelectId);
            tvTiTle.setTextColor(titleBarBackGround);
        } else {
            Image.setBackgroundResource(imageNotId);
            tvTiTle.setTextColor(context.getResources().getColor(R.color.font_1f));
        }
        invalidate();


    }

    public CategoryButton(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context = context;
        TypedArray attributes = context.obtainStyledAttributes(attrs, R.styleable.category);
        titleBarBackGround = attributes.getResourceId(R.styleable.category_backcolor, Color.RED);
        isImage = attributes.getBoolean(R.styleable.category_isimage, false);
        textTitle = attributes.getString(R.styleable.category_textname);
        attributes.recycle();
        init();
    }

    public void setColr(int dangqian) {
        Image2.setVisibility(GONE);
        if(position == 0){
            Image.setVisibility(VISIBLE);
        }else {
            Image.setVisibility(GONE);
        }
        this.dangqian = dangqian;
        if (position != dangqian) {
            tvTiTle.setTextColor(context.getResources().getColor(R.color.font_1f));
            Image.setBackgroundResource(R.mipmap.pointer0);
        } else {
            tvTiTle.setTextColor(titleBarBackGround);
            Image.setBackgroundResource(R.mipmap.pointer1);
        }
        invalidate();
    }

    public void setColr(int dangqian, boolean sort) {
        Image2.setVisibility(VISIBLE);
        Image.setVisibility(GONE);

        this.dangqian = dangqian;
        if (dangqian == position) {

            tvTiTle.setTextColor(titleBarBackGround);
            if (sort) {
                Image2.setBackgroundResource(R.mipmap.gaodaodi);
            } else {
                Image2.setBackgroundResource(R.mipmap.didaogao);
            }
        } else {
            tvTiTle.setTextColor(context.getResources().getColor(R.color.font_1f));
            Image2.setBackgroundResource(R.mipmap.weixuanzhong);
        }
        invalidate();
    }
}
