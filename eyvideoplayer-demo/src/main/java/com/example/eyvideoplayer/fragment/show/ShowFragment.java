package com.example.eyvideoplayer.fragment.show;

import android.content.Intent;
import android.view.View;
import com.example.eyvideoplayer.R;
import com.example.eyvideoplayer.activity.show.PlayerActivity;
import com.example.eyvideoplayer.fragment.BaseFragment;
import com.example.eyvideoplayer.util.DataUtil;

public class ShowFragment extends BaseFragment implements View.OnClickListener {
    //    private static final String VOD_URL = "http://mov.bn.netease.com/open-movie/nos/flv/2017/01/03/SC8U8K7BC_hd.flv";
//    private static final String VOD_URL = "http://vfx.mtime.cn/Video/2019/03/18/mp4/190318231014076505.mp4";
    private static final String VOD_URL = DataUtil.SAMPLE_URL;
    //    private static final String VOD_URL = "http://155.138.214.164/test/1.mp4";
//    private static final String VOD_URL = "http://youku163.zuida-bofang.com/20190113/24356_0cbc9d8f/index.m3u8";
//    private static final String VOD_URL = "http://sohu.zuida-163sina.com/20190303/ZRkvZAiK/index.m3u8";
//    private static final String VOD_URL = "http://vfile.hshan.com/2018/1524/9156/4430/152491564430.ssm/152491564430.m3u8";
//    private static final String VOD_URL = "https://aweme.snssdk.com/aweme/v1/play/?video_id=3fdb4876a7f34bad8fa957db4b5ed159&line=0&ratio=720p&media_type=4&vr_type=0";
//    private static final String VOD_URL = "http://videofile2.cutv.com/mg/010061_t/2019/07/23/G15/G15fgfflggklinnkggoez2_cug.mp4.m3u8";
    //断线自动重连,需加上ijkhttphook:
//    private static final String VOD_URL = "ijkhttphook:http://mov.bn.netease.com/open-movie/nos/flv/2017/01/03/SC8U8K7BC_hd.flv";

    //    private static final String LIVE_URL = "rtmp://live.hkstv.hk.lxdns.com/live/hks";
//    private static final String LIVE_URL = "http://ivi.bupt.edu.cn/hls/sztv.m3u8";
    private static final String LIVE_URL = "http://cctvalih5ca.v.myalicdn.com/live/cctv1_2/index.m3u8";
//    private static final String LIVE_URL = "http://ivi.bupt.edu.cn/hls/cctv6.m3u8";
    // 音频
    private static final String MUSIC_URL = "https://music.163.com/song/media/outer/url?id=516497142.mp3";

    @Override
    protected int getLayoutResId() {
        return R.layout.fragment_api;
    }

    @Override
    protected void initView() {
        super.initView();
        findViewById(R.id.btn_vod).setOnClickListener(this);
        findViewById(R.id.btn_live).setOnClickListener(this);
        findViewById(R.id.btn_music).setOnClickListener(this);
//        findViewById(R.id.btn_raw_assets).setOnClickListener(this);
//        findViewById(R.id.btn_parallel_play).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_vod:
                PlayerActivity.start(getActivity(), VOD_URL, "点播", false);
                break;
            case R.id.btn_live:
                PlayerActivity.start(getActivity(), LIVE_URL, "直播", true);
                break;
            case R.id.btn_music:
                PlayerActivity.start(getActivity(), MUSIC_URL, "音乐", false);
                break;
        }
    }
}
