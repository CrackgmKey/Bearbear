package com.lingjuan.app.adapter;

import android.content.Context;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.lingjuan.app.R;
import com.lingjuan.app.constant.Constant;
import com.lingjuan.app.entity.WelldoneVideo;
import com.lingjuan.app.utils.PicassomageUtils;
import com.google.android.exoplayer2.ExoPlaybackException;

import java.util.List;

import chuangyuan.ycj.videolibrary.listener.VideoInfoListener;
import chuangyuan.ycj.videolibrary.video.ExoUserPlayer;
import chuangyuan.ycj.videolibrary.video.VideoPlayerManager;
import chuangyuan.ycj.videolibrary.widget.VideoPlayerView;

/**
 * 视频秀Adapter
 * Created by TaoHui on 2018/10/13.
 */

public class VideoTpAdapter extends BaseQuickAdapter<WelldoneVideo.DataBean, BaseViewHolder> {

    private OnClick click;
    private Context context;
    public VideoTpAdapter(@Nullable List<WelldoneVideo.DataBean> data) {
        super(R.layout.item_video_sc, data);
    }

    public void setContext(Context context) {
        this.context = context;
    }

    @Override
    protected void convert(final BaseViewHolder helper, final WelldoneVideo.DataBean item) {
        helper.setText(R.id.tv_titleMessage,item.getItemshorttitle())
                .setText(R.id.tv_dName,item.getSellernick())
                .setText(R.id.sp_juan,String.valueOf(item.getCouponmoney()))
        .setText(R.id.lingkuan,""+String.valueOf(item.getItemprice()));  //卷后价
        PicassomageUtils.loads(context,item.getItempic(),helper.getView(R.id.videopic_id));
        final VideoPlayerView videoPlayerView = helper.getView(R.id.video_maggaes);
        final ExoUserPlayer userPlayer = new VideoPlayerManager.Builder(VideoPlayerManager.TYPE_PLAY_USER,videoPlayerView).create();
        userPlayer.setPlayUri(Constant.VIDEO_URL + item.getVideoid()+".mp4");
        videoPlayerView.showFullscreenTempView(View.GONE);
        userPlayer.setTag(helper.getAdapterPosition());
        helper.setOnClickListener(R.id.line1, view -> {
            helper.setVisible(R.id.line1,false);
            videoPlayerView.setTitle(item.getItemshorttitle());
            userPlayer.startPlayer();
            click.onStopVideo(userPlayer);
        });
        helper.setVisible(R.id.line1,true);
        helper.setOnClickListener(R.id.dianjiview,(v) ->{
            click.OnClickListener(helper.getAdapterPosition());
            userPlayer.reset();
            helper.setVisible(R.id.line1,true);
        });

        userPlayer.addVideoInfoListener(new VideoInfoListener() {

            @Override
            public void onPlayStart(long currPosition) {

            }

            @Override
            public void onLoadingChanged() {
                //加载变化
            }

            @Override
            public void onPlayerError(ExoPlaybackException e) {
                //加载错误
                helper.setVisible(R.id.line1,true);
            }

            @Override
            public void onPlayEnd() {
                //播放结束
                helper.setVisible(R.id.line1,true);
            }

            @Override
            public void isPlaying(boolean playWhenReady) {

            }


        });
    }

    public void setClick(OnClick click) {
        this.click = click;
    }

    public static abstract class OnClick{
        public abstract void OnClickListener(int position);
        public abstract void onStopVideo(ExoUserPlayer exoUserPlayer);
    }

}
