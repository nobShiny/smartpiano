package com.lsj.smartpiano.module.home.ui;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.lsj.smartpiano.R;
import com.lsj.smartpiano.common.utils.ScreenUtils;
import com.lsj.smartpiano.module.course.ui.CourseInfoActivity;
import com.lsj.smartpiano.module.home.adapter.HomeListAdapter;
import com.lsj.smartpiano.module.home.listener.OnRecyclerItemClickListener;
import com.lsj.smartpiano.module.karagame.ui.KaraGameActivity;
import com.lsj.smartpiano.module.video.ui.VideoActivity;

import butterknife.Bind;

public class MainActivity extends BaseDrawerActivity {

    @Bind(R.id.rvList)
    RecyclerView rvList;

    private static final int ANIM_DURATION_TOOLBAR = 300;
    private int[] str_title = {R.string.player_title, R.string.lesson_title, R.string.kara_title};
    private int[] str_content = {R.string.player_content, R.string.lesson_content, R.string.kara_content};
    private int[] pic = {R.drawable.ic_lesson_play, R.drawable.ic_lesson_score, R.drawable.ic_lesson_kara};
    private int[] bgColor = {R.color.home_list_bg_green, R.color.home_list_bg_blue, R.color.home_list_bg_purple};

    private HomeListAdapter homeListAdapter;
    private boolean pendingIntroAnimation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState == null) {
            pendingIntroAnimation = true;
        }
        homeListAdapter = new HomeListAdapter(this, str_title, str_content, pic, bgColor);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this) {
            @Override
            protected int getExtraLayoutSpace(RecyclerView.State state) {
                return 300;
            }
        };
        rvList.setLayoutManager(linearLayoutManager);
        rvList.setAdapter(homeListAdapter);
        rvList.setItemAnimator(new DefaultItemAnimator());
        rvList.addOnItemTouchListener(new OnRecyclerItemClickListener(rvList) {

            @Override
            public void onItemClick(RecyclerView.ViewHolder vh) {
                switch (vh.getAdapterPosition()) {
                    case 0:
                        Intent intentPlay = new Intent(MainActivity.this, VideoActivity.class);
                        startActivity(intentPlay);
                        break;
                    case 1:
                        Intent intentLesson = new Intent(MainActivity.this, CourseInfoActivity.class);
                        startActivity(intentLesson);
                        break;
                    case 2:
                        Intent intentKara = new Intent(MainActivity.this, KaraGameActivity.class);
                        startActivity(intentKara);
                        break;
                    default:
                        break;
                }
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if(id==R.id.action_search){
            Toast.makeText(MainActivity.this, "sousuo", Toast.LENGTH_SHORT).show();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        if (pendingIntroAnimation) {
            pendingIntroAnimation = false;
            startIntroAnimation();
        }
        return true;
    }

    private void startIntroAnimation() {
        int actionbarSize = ScreenUtils.dpToPx(56);
        getToolbar().setTranslationY(-actionbarSize);
        getIvLogo().setTranslationY(-actionbarSize);
        getInboxMenuItem().getActionView().setTranslationY(-actionbarSize);

        getToolbar().animate()
                .translationY(0)
                .setDuration(ANIM_DURATION_TOOLBAR)
                .setStartDelay(300);
        getIvLogo().animate()
                .translationY(0)
                .setDuration(ANIM_DURATION_TOOLBAR)
                .setStartDelay(400);
        getInboxMenuItem().getActionView().animate()
                .translationY(0)
                .setDuration(ANIM_DURATION_TOOLBAR)
                .setStartDelay(500)
                .setListener(new AnimatorListenerAdapter() {
                    @Override
                    public void onAnimationEnd(Animator animation) {

                    }
                })
                .start();
    }

}
