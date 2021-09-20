package com.einzberny.videoplayer.ijk;

import android.content.Context;

import com.example.eyvideoplayer_java.player.PlayerFactory;

public class IjkPlayerFactory extends PlayerFactory<IjkPlayer> {

    public static IjkPlayerFactory create() {
        return new IjkPlayerFactory();
    }

    @Override
    public IjkPlayer createPlayer(Context context) {
        return new IjkPlayer(context);
    }
}
