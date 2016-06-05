package com.lsj.smartpiano.module.home.ui;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentTransaction;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.lsj.smartpiano.R;
import com.lsj.smartpiano.common.utils.ScreenUtils;
import com.lsj.smartpiano.module.home.fragment.HomeFragment;
import com.lsj.smartpiano.module.home.fragment.MineFragment;

public class MainActivity extends BaseDrawerActivity {


    private HomeFragment homeFragment;
    private static final int ANIM_DURATION_TOOLBAR = 300;

    private boolean pendingIntroAnimation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState == null) {
            pendingIntroAnimation = true;
        }
        showDefaultFragment();
        initNavigationSelectClick();
    }

    private void showDefaultFragment() {
        homeFragment = new HomeFragment();
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.add(R.id.container_list,homeFragment);
        fragmentTransaction.commit();
    }


    private void initNavigationSelectClick() {
        vNavigation.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.menu_home:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container_list,
                                new HomeFragment()).commit();
                        toolbar.setBackgroundColor(MainActivity.this.getResources().getColor(R.color.colorPrimary));
                        break;
                    case R.id.menu_favorite:
//                        getSupportFragmentManager().beginTransaction().replace(R.id.flContentRoot,
//                                new FavoriteFragment()).commit();
                        Toast.makeText(MainActivity.this, "待开发", Toast.LENGTH_SHORT).show();
                        toolbar.setBackgroundColor(MainActivity.this.getResources().getColor(R.color.colorPrimaryDark));
                        break;
                    case R.id.menu_mine:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container_list,
                                new MineFragment()).commit();
                        toolbar.setBackgroundColor(MainActivity.this.getResources().getColor(R.color.colorAccent));
                        break;
                }
                item.setChecked(true);
                drawerLayout.closeDrawers();
                return true;
            }
        });
    }

 /*   @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if(id==R.id.action_search){
            Toast.makeText(MainActivity.this, "sousuo", Toast.LENGTH_SHORT).show();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }*/

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        if (pendingIntroAnimation) {
            pendingIntroAnimation = false;
            startIntroAnimation();
        }
        return super.onCreateOptionsMenu(menu);
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
