package com.lingjuan.app.wigth;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.lingjuan.app.R;

import butterknife.BindView;

/**
 * Created by TaoHui on 2018/10/20.
 */

public class SearchTypePopupWindow extends PopupWindow implements View.OnClickListener {
    @BindView(R.id.et_price_min)
    EditText etPriceMin;
    @BindView(R.id.et_price_max)
    EditText etPriceMax;
    @BindView(R.id.layTmall)
    TextView layTmall;
    @BindView(R.id.layTaoBao)
    TextView layTaoBao;
    @BindView(R.id.layVideo)
    TextView layVideo;
    @BindView(R.id.positiveButton)
    Button positiveButton;
    @BindView(R.id.negativeButton)
    Button negativeButton;
    private Context context;
    private OnClickSucce clickSucce;
    private View view;
    //商品来源
    private Meaning commoditymeaning;
    private double price_min,price_max;
    public void setClickSucce(OnClickSucce clickSucce) {
        this.clickSucce = clickSucce;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.layTmall:
                commoditymeaning = Meaning.Tmall;
                layTmall.setSelected(true);
                layTaoBao.setSelected(false);
                layVideo.setSelected(false);
                break;
            case R.id.layTaoBao:
                commoditymeaning = Meaning.TaoBao;
                layTmall.setSelected(false);
                layTaoBao.setSelected(true);
                layVideo.setSelected(false);
                break;
            case R.id.layVideo:
                commoditymeaning = Meaning.Tvideo;
                layTmall.setSelected(false);
                layTaoBao.setSelected(false);
                layVideo.setSelected(true);
                break;
            case R.id.positiveButton:
                commoditymeaning = Meaning.Default;
                price_min = 0;
                price_max = 999;
                clickSucce.ToastMeeage("筛选条件已经重置");
                break;
            case R.id.negativeButton:
                clickSucce.getClickPosition(commoditymeaning,price_min,price_max);
                dismiss();
                break;
            default:break;
        }
    }


    public enum Meaning{
        Tmall,TaoBao,Tvideo,Default
    }
    public SearchTypePopupWindow(Context context) {
        super(context);
        this.context = context;
        // 设置可以获得焦点
        setFocusable(true);
        // 设置弹窗内可点击
        setTouchable(true);
        // 设置弹窗外可点击
        setOutsideTouchable(true);
        setBackgroundDrawable(new ColorDrawable(0));
        initview(context);
    }

    /**
     * 初始化控件
     */
    private void initview(Context context) {
        view = LayoutInflater.from(context).inflate(R.layout.popwin_screen, null);
        //设置布局
        setContentView(view);
        layTmall = view.findViewById(R.id.layTmall);
        layTaoBao = view.findViewById(R.id.layTaoBao);
        layVideo = view.findViewById(R.id.layVideo);
        etPriceMin = view.findViewById(R.id.et_price_min);
        etPriceMax = view.findViewById(R.id.et_price_max);
        positiveButton = view.findViewById(R.id.positiveButton);
        negativeButton = view.findViewById(R.id.negativeButton);
        positiveButton.setOnClickListener(this);
        negativeButton.setOnClickListener(this);
        layTmall.setOnClickListener(this);
        layTaoBao.setOnClickListener(this);
        layVideo.setOnClickListener(this);
        //设置宽度
        setWidth(ViewGroup.LayoutParams.MATCH_PARENT);
        //设置高度
        setHeight(ViewGroup.LayoutParams.WRAP_CONTENT);
        commoditymeaning = Meaning.Default;
    }

    public interface OnClickSucce {
        void getClickPosition(Meaning commoditymeaning,double price_min, double price_max);
        void onAnimationEnd();
        void ToastMeeage(String msg);
    }


    @Override
    public void showAsDropDown(View anchor) {
        Animation anim = AnimationUtils.loadAnimation(context, R.anim.popdonghua);
        anim.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                clickSucce.onAnimationEnd();
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        view.setAnimation(anim);
        super.showAsDropDown(anchor);
    }
}
