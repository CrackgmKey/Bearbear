package com.lingjuan.app.wigth;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.lingjuan.app.R;
import com.lingjuan.app.customview.FrameAnimation;

import butterknife.BindView;
import butterknife.ButterKnife;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;

/**
 * 加载视图
 * Created by TaoHui on 2018/11/28.
 */

public class LoadLayout extends RelativeLayout {
    @BindView(R.id.start_loading)
    ImageView startLoading;
    @BindView(R.id.loadingerror)
    ImageView loadingerror;
    @BindView(R.id.baseview)
    RelativeLayout baseview;
    private FrameAnimation frameAnim;
    private Context context;
    private AlphaAnimation alphaAnimation;
    public LoadLayout(Context context) {
        super(context);
    }


    public LoadLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        initView(context);
    }

    public LoadLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context = context;
        initView(context);
    }

    private void initView(Context context) {
        //初始化视图
        View view = LayoutInflater.from(context).inflate(R.layout.loading_layout_item, this, true);
        alphaAnimation = new AlphaAnimation(1.0f,0.0f);
        alphaAnimation.setDuration(1);
        alphaAnimation.setAnimationListener(animatorListener);
        alphaAnimation.setFillAfter(true);
        ButterKnife.bind(view);
    }

    /**
     * 开始加载
     */
    public void showLoading() {
        Observable.create((Observable.OnSubscribe<String>) subscriber -> {
            subscriber.onNext("");
        }).observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(AndroidSchedulers.mainThread()).subscribe(s -> {
            //显示加载
            startLoading.setVisibility(View.VISIBLE);
            frameAnim = new FrameAnimation(startLoading, getRes(), 100, true);
            frameAnim.setAnimationListener(new FrameAnimation.AnimationListener() {
                @Override
                public void onAnimationStart() {

                }

                @Override
                public void onAnimationEnd() {

                }

                @Override
                public void onAnimationRepeat() {

                }
            });
        });
    }


    private int[] getRes() {
        int[] resId = new int[8];
        return resId;
    }




    /**
     * 加载失败
     */
    public void LoadingFail() {
        Observable.create((Observable.OnSubscribe<String>) subscriber -> {
            subscriber.onNext("");
        }).observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(AndroidSchedulers.mainThread()).subscribe(s -> {
            //隐藏加载
            startLoading.setVisibility(View.GONE);
            //显示错误
            loadingerror.setVisibility(View.VISIBLE);
            //停止动画
            clearAnimation();
        });
    }

    /**
     * 加载成功
     */
    public void LoadingSuccess() {
        Observable.create((Observable.OnSubscribe<String>) subscriber -> {
            subscriber.onNext("");
        }).observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(AndroidSchedulers.mainThread()).subscribe(s -> {
            //停止动画
            clearAnimation();
            baseview.startAnimation(alphaAnimation);
        });

    }



    private Animation.AnimationListener animatorListener = new Animation.AnimationListener(){

        @Override
        public void onAnimationStart(Animation animation) {

        }

        @Override
        public void onAnimationEnd(Animation animation) {
            setVisibility(GONE);
            alphaAnimation = null;
        }

        @Override
        public void onAnimationRepeat(Animation animation) {

        }
    };
}
