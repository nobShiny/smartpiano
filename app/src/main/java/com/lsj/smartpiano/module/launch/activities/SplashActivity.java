package com.lsj.smartpiano.module.launch.activities;

import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;

import com.lsj.smartpiano.R;
import com.lsj.smartpiano.common.activity.BaseActivity;
import com.lsj.smartpiano.common.constant.SmartPianoConfig;
import com.lsj.smartpiano.common.utils.SharedPreferenceUtil;
import com.lsj.smartpiano.module.home.ui.MainActivity;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by shiny_jia
 * on 2016-05-05 17:18.
 */
public class SplashActivity extends BaseActivity {

    //跳转延迟时间
    private static int delayedTime = 3000;
    @Bind(R.id.bg)
    View bg;
    @Bind(R.id.logo)
    ImageView iv_logo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.start_activity_splash);
        ButterKnife.bind(this);
        bgShowing(bg);
        iv_logo.postDelayed(new Runnable() {
            @Override
            public void run() {
                logoAnim(iv_logo);
            }
        }, 600);

        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if(!SharedPreferenceUtil.getBoolean(SplashActivity.this,SmartPianoConfig.SP_FILE_NAME,
                        SmartPianoConfig.KEY_IS_SHOW_GUIDE,false)){
                    SharedPreferenceUtil.putBoolean(SplashActivity.this, SmartPianoConfig.SP_FILE_NAME,
                            SmartPianoConfig.KEY_IS_SHOW_GUIDE,true);
                    startActivity(new Intent(SplashActivity.this, LoadingVideoActivity.class));
                    finish();
                }else{
                    startActivity(new Intent(SplashActivity.this, MainActivity.class));
                    overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
                    finish();
                }
            }
        }, delayedTime);

    }

    private void bgShowing(View view) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "alpha", new float[]{1.0f, 0.3f});
        ofFloat.setDuration(3000);
        ofFloat.start();
    }

    private void logoAnim(View view) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "alpha", new float[]{0.0f, 1.0f});
        ofFloat.setDuration(2400);
        ofFloat.start();
    }

}
