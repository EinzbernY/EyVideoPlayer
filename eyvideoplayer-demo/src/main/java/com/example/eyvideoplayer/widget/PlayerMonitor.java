package com.example.eyvideoplayer.widget;

import android.view.View;
import android.view.animation.Animation;

import androidx.annotation.NonNull;

import com.example.eyvideoplayer.util.Utils;
import com.example.eyvideoplayer_java.controller.ControlWrapper;
import com.example.eyvideoplayer_java.controller.IControlComponent;
import com.example.eyvideoplayer_java.util.L;

public class PlayerMonitor implements IControlComponent {

    private ControlWrapper mControlWrapper;

    @Override
    public void attach(@NonNull ControlWrapper controlWrapper) {
        mControlWrapper = controlWrapper;
    }

    @Override
    public View getView() {
        return null;
    }

    @Override
    public void onVisibilityChanged(boolean isVisible, Animation anim) {
        L.d("onVisibilityChanged: " + isVisible);
    }

    @Override
    public void onPlayStateChanged(int playState) {
        L.d("onPlayStateChanged: " + Utils.playState2str(playState));
    }

    @Override
    public void onPlayerStateChanged(int playerState) {
        L.d("onPlayerStateChanged: " + Utils.playerState2str(playerState));
    }

    @Override
    public void setProgress(int duration, int position) {
        L.d("setProgress: duration: " + duration + " position: " + position + " buffered percent: " + mControlWrapper.getBufferedPercentage());
        L.d("network speed: " + mControlWrapper.getTcpSpeed());
    }

    @Override
    public void onLockStateChanged(boolean isLocked) {
        L.d("onLockStateChanged: " + isLocked);
    }
}
