package com.example.eyvideoplayer.activity.extend;

import android.os.Build;
import android.view.View;
import android.view.WindowManager;
import android.widget.LinearLayout;

import com.example.eyvideoplayer.activity.BaseActivity;
import com.example.eyvideoplayer.util.DataUtil;
import com.example.eyvideoplayer_java.player.VideoView;
import com.example.eyvideoplayer_java.util.PlayerUtils;
import com.example.eyvideoplayer_ui.component.*;
import com.example.eyvideoplayer_ui.StandardVideoController;
import com.example.eyvideoplayer.R;


/**
 * 全屏播放
 */

public class FullScreenActivity extends BaseActivity<VideoView> {

    private StandardVideoController mController;

    @Override
    protected View getContentView() {
        mVideoView = new VideoView(this);
        adaptCutoutAboveAndroidP();
        return mVideoView;
    }

    @Override
    protected int getTitleResId() {
        return R.string.str_fullscreen_directly;
    }

    @Override
    protected void initView() {
        super.initView();
        mVideoView.startFullScreen();
        mVideoView.setUrl(DataUtil.SAMPLE_URL);
        mController = new StandardVideoController(this);
        mController.addControlComponent(new CompleteView(this));
        mController.addControlComponent(new ErrorView(this));
        mController.addControlComponent(new PrepareView(this));

        TitleView titleView = new TitleView(this);
        // 我这里改变了返回按钮的逻辑，我不推荐这样做，我这样只是为了方便，
        // 如果你想对某个组件进行定制，直接将该组件的代码复制一份，改成你想要的样子
        titleView.findViewById(R.id.back).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        titleView.setTitle(getString(R.string.str_fullscreen_directly));
        mController.addControlComponent(titleView);
        VodControlView vodControlView = new VodControlView(this);
        // 我这里隐藏了全屏按钮并且调整了边距，我不推荐这样做，我这样只是为了方便，
        // 如果你想对某个组件进行定制，直接将该组件的代码复制一份，改成你想要的样子
        vodControlView.findViewById(R.id.fullscreen).setVisibility(View.GONE);
        LinearLayout.LayoutParams lp = (LinearLayout.LayoutParams) vodControlView.findViewById(R.id.total_time).getLayoutParams();
        lp.rightMargin = PlayerUtils.dp2px(this, 16);
        mController.addControlComponent(vodControlView);
        mController.addControlComponent(new GestureView(this));
        mVideoView.setVideoController(mController);
        mVideoView.setScreenScaleType(VideoView.SCREEN_SCALE_16_9);
        mVideoView.start();
    }

    private void adaptCutoutAboveAndroidP() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
            WindowManager.LayoutParams lp = getWindow().getAttributes();
            lp.layoutInDisplayCutoutMode = WindowManager.LayoutParams.LAYOUT_IN_DISPLAY_CUTOUT_MODE_SHORT_EDGES;
            getWindow().setAttributes(lp);
        }
    }


    @Override
    public void onBackPressed() {
        if (!mController.isLocked()) {
            finish();
        }
    }
}