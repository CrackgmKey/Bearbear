package com.lingjuan.app.customview;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.widget.ImageView;

import com.lingjuan.app.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 加载动画
 * Created by TaoHui on 2018/11/8.
 */

public class LoadDialog extends Dialog {
    @BindView(R.id.iamge_anit)
    ImageView iamgeAnit;
    private Context context;
    private AnimationDrawable frameAnim;

    public LoadDialog(@NonNull Context context) {
        super(context);
        this.context = context;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_load);
        ButterKnife.bind(this);
        setCancelable(true);
        frameAnim = (AnimationDrawable) context.getResources().getDrawable(R.drawable.ic_black);
        iamgeAnit.setBackgroundDrawable(frameAnim);
        frameAnim.start();
        frameAnim.clearColorFilter();
    }

    @Override
    public void dismiss() {
        super.dismiss();
        frameAnim.stop();
    }


    @Override
    public void show() {
        super.show();
        frameAnim.start();
    }

    /**
     * 回收
     */
    public void clearAnimation(){
        frameAnim.stop();
        for (int i = 0; i < frameAnim.getNumberOfFrames(); i++) {
            Drawable frame = frameAnim.getFrame(i);
            if (frame instanceof BitmapDrawable) {
                ((BitmapDrawable) frame).getBitmap().recycle();
            }
            frame.setCallback(null);
        }
        frameAnim.setCallback(null);
    }
}
