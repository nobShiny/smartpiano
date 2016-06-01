package com.lsj.smartpiano.module.home.ui;

import android.os.Handler;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.lsj.smartpiano.R;
import com.lsj.smartpiano.common.activity.BaseActivity;
import com.lsj.smartpiano.module.home.fragment.FavoriteFragment;
import com.lsj.smartpiano.module.home.fragment.HomeFragment;
import com.lsj.smartpiano.module.home.fragment.MineFragment;

import butterknife.Bind;

public class BaseDrawerActivity extends BaseActivity {

    @Bind(R.id.drawerLayout)
    DrawerLayout drawerLayout;
    @Bind(R.id.vNavigation)
    NavigationView vNavigation;

    private ImageView ivMenuUserProfilePhoto;

    @Override
    public void setContentView(int layoutResID) {
        super.setContentViewWithoutInject(R.layout.activity_drawer);
        ViewGroup viewGroup = (ViewGroup) findViewById(R.id.flContentRoot);
        LayoutInflater.from(this).inflate(layoutResID, viewGroup, true);
        bindViews();
        setupHeader();
    }

    @Override
    protected void setupToolbar() {
        super.setupToolbar();
        if (getToolbar() != null) {
            getToolbar().setNavigationOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    drawerLayout.openDrawer(Gravity.LEFT);
                }
            });
        }
    }

    private void setupHeader() {
        if (vNavigation != null) {
            View headerView = vNavigation.getHeaderView(0);
            headerView.findViewById(R.id.vGlobalMenuHeader).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onGlobalMenuHeaderClick(v);
                }
            });
            vNavigation.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(MenuItem item) {
                    switch (item.getItemId()) {
                        case R.id.menu_home:
                            getSupportFragmentManager().beginTransaction().replace(R.id.flContentRoot,
                                    new HomeFragment()).commit();
                            break;
                        case R.id.menu_favorite:
                            getSupportFragmentManager().beginTransaction().replace(R.id.flContentRoot,
                                    new FavoriteFragment()).commit();
                            break;
                        case R.id.menu_mine:
                            getSupportFragmentManager().beginTransaction().replace(R.id.flContentRoot,
                                    new MineFragment()).commit();
                            break;
                    }
                    item.setChecked(true);
                    drawerLayout.closeDrawers();
                    return true;
                }
            });
        }
    }

    public void onGlobalMenuHeaderClick(final View v) {
        drawerLayout.closeDrawer(Gravity.LEFT);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                //                int[] startingLocation = new int[2];
                //                v.getLocationOnScreen(startingLocation);
                //                startingLocation[0] += v.getWidth() / 2;
                //                UserProfileActivity.startUserProfileFromLocation(startingLocation, BaseDrawerActivity.this);
                //                overridePendingTransition(0, 0);
            }
        }, 200);
    }

    @Override
    public void onBackPressed() {
        if(isNavDrawerOpen()){
            closeNavDrawer();
        }else{
            super.onBackPressed();
        }
    }

    protected boolean isNavDrawerOpen() {
        return drawerLayout != null && drawerLayout.isDrawerOpen(GravityCompat.START);
    }

    protected void closeNavDrawer() {
        if (drawerLayout != null) {
            drawerLayout.closeDrawer(GravityCompat.START);
        }
    }

}
