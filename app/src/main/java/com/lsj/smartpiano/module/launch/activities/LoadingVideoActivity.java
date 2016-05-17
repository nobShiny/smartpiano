package com.lsj.smartpiano.module.launch.activities;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;

import com.lsj.smartpiano.R;
import com.lsj.smartpiano.common.activity.BaseActivity;
import com.lsj.smartpiano.module.home.ui.MainActivity;
import com.lsj.smartpiano.module.launch.customui.LaunchVideoActivity;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by shiny_jia
 * on 2016-05-05 17:45.
 */
public class LoadingVideoActivity extends BaseActivity {

    @Bind(R.id.videoview)
    LaunchVideoActivity videoview;
    @Bind(R.id.btn_start)
    Button btnStart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loading_video);
        ButterKnife.bind(this);
        initView();
    }

    private void initView() {
        //设置播放加载路径
        videoview.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.introduction));
        //播放
        videoview.start();
        //        //循环播放
        //        videoview.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
        //            @Override
        //            public void onCompletion(MediaPlayer mediaPlayer) {
        //                videoview.start();
        //            }
        //        });
    }

    @OnClick(R.id.btn_start)
    void onClick() {
        startActivity(new Intent(LoadingVideoActivity.this, MainActivity.class));
        finish();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }
}