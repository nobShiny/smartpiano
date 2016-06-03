package com.lsj.smartpiano.module.video.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

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
    @Bind(R.id.toolbar)
    Toolbar toolbar;


    private VideoFragmentPasgerAdapter pagerAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);
        ButterKnife.bind(this);
        pagerAdapter = new VideoFragmentPasgerAdapter(getSupportFragmentManager(), this);
        playerViewpager.setAdapter(pagerAdapter);
        slidingTabs.setupWithViewPager(playerViewpager);
        if (toolbar != null) {
            setSupportActionBar(toolbar);
            toolbar.setNavigationIcon(getResources().getDrawable(R.drawable.ic_arrow_back));
            toolbar.setNavigationOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    finish();
                }
            });
            toolbar.setTitle("视频教程");
            toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
                @Override
                public boolean onMenuItemClick(MenuItem item) {
                    return false;
                }
            });
        }
    }
}
