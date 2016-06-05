package com.lsj.smartpiano.module.video.ui;

import android.content.DialogInterface;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.MediaController;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

import com.lsj.smartpiano.R;
import com.lsj.smartpiano.common.utils.NetWorkUtil;
import com.lsj.smartpiano.module.video.utils.VideoIntent;

import java.io.File;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by shiny_jia
 * on 2016-06-02 11:39.
 */
public class VideoViewPlayerActivity extends AppCompatActivity {
    public static VideoIntent.VideoUri uri;
    private String videoPath;
    @Bind(R.id.videoView)
    VideoView videoViewPlayer;
    @Bind(R.id.loading_textview)
    TextView loading_textview;

    private int sign;
    private boolean flag = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.videoview_player_activity);
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
        ButterKnife.bind(this);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.MATCH_PARENT);
        layoutParams.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
        layoutParams.addRule(RelativeLayout.ALIGN_PARENT_TOP);
        layoutParams.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
        layoutParams.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
        videoViewPlayer.setLayoutParams(layoutParams);

        //自带的播放控制器
        videoViewPlayer.setMediaController(new MediaController(this));
        videoViewPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                loading_textview.setVisibility(View.GONE);
            }
        });
        Bundle vPath = getIntent().getExtras();
        sign = vPath.getInt("PlayerSign");
        if (sign == 1) {
            videoPath = vPath.getString("path");
            videoPathPlayer(videoPath);
        } else {
            videoUriPlayer(uri.getUri());
            if (flag == false) {
                new Thread(
                        new Runnable() {
                            @Override
                            public void run() {
                                try {
                                    Thread.sleep(3000);
                                    finish();
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                            }
                        }
                ).start();
            }
        }

    }

    public void videoUriPlayer(final Uri videoUri) {
        //网络判断
        if (!NetWorkUtil.isNetWorkAvailable()) {
            loading_textview.setVisibility(View.GONE);
            loading_textview.setText(getResources().getString(R.string.load_fail));
            flag = false;
            return;
        } else {
            if (!NetWorkUtil.isWifiConnected() && NetWorkUtil.isMobileConnected()) {
                final Uri vidUri = videoUri;
                new AlertDialog.Builder(this)
                        .setTitle("温馨提示!")
                        .setMessage("当前状态为数据网络，将耗费流量，继续播放吗?")
                        .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                finish();
                            }
                        }).setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        if (vidUri != null) {
                            videoViewPlayer.setVideoURI(vidUri);
                            videoViewPlayer.start();
                        }
                    }
                }).create().show();

            } else {
                if (videoUri != null) {
                    videoViewPlayer.setVideoURI(videoUri);
                    videoViewPlayer.start();
                }
            }

        }

    }

    public void videoPathPlayer(String videoPath) {
        File file = new File(videoPath);
        if (file.exists()) {
            videoViewPlayer.setVideoPath(videoPath);
            videoViewPlayer.start();
        } else {
            Toast.makeText(VideoViewPlayerActivity.this, "文件路径出错啦!", Toast.LENGTH_SHORT).show();
        }
    }

}
