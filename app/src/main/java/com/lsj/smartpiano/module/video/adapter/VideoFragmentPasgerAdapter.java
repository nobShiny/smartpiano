package com.lsj.smartpiano.module.video.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.lsj.smartpiano.R;
import com.lsj.smartpiano.module.video.fragment.AdvanceVideoFragment;
import com.lsj.smartpiano.module.video.fragment.BaseVideoFragment;

/**
 * Created by shiny_jia
 * on 2016-05-18 10:43.
 */
public class VideoFragmentPasgerAdapter extends FragmentPagerAdapter {

    final int PAGE_COUNT = 2;
    private int[] tabTitles = {R.string.video_base_lesson, R.string.video_advance_lesson};
    private Context mContext;

    public VideoFragmentPasgerAdapter(FragmentManager fm, Context context) {
        super(fm);
        this.mContext = context;
    }

    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return BaseVideoFragment.newInstance(position + 1);
        } else if (position == 1) {
            return AdvanceVideoFragment.newInstance(position + 1);
        }
        return BaseVideoFragment.newInstance(position + 1);
    }

    @Override
    public int getCount() {
        return PAGE_COUNT;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mContext.getResources().getString(tabTitles[position]);
    }
}
