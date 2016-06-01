package com.lsj.smartpiano.module.video.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.lsj.smartpiano.R;
import com.lsj.smartpiano.module.video.adapter.VideoFragmentPasgerAdapter;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by shiny_jia
 * on 2016-05-17 14:43.
 */
public class VideoActivity extends AppCompatActivity {

    @Bind(R.id.player_viewpager)
    ViewPager playerViewpager;
    @Bind(R.id.sliding_tabs)
    TabLayout slidingTabs;

    private VideoFragmentPasgerAdapter pagerAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);
        ButterKnife.bind(this);
        pagerAdapter = new VideoFragmentPasgerAdapter(getSupportFragmentManager(),this);
        playerViewpager.setAdapter(pagerAdapter);
        slidingTabs.setupWithViewPager(playerViewpager);

    }
}
