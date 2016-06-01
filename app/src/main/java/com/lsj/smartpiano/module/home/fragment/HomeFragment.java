package com.lsj.smartpiano.module.home.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lsj.smartpiano.R;
import com.lsj.smartpiano.module.course.ui.CourseInfoActivity;
import com.lsj.smartpiano.module.home.adapter.HomeListAdapter;
import com.lsj.smartpiano.module.home.listener.OnRecyclerItemClickListener;
import com.lsj.smartpiano.module.karagame.ui.KaraGameActivity;
import com.lsj.smartpiano.module.video.ui.VideoActivity;

/**
 * Created by shiny_jia
 * on 2016-05-31 15:27.
 */
public class HomeFragment extends Fragment {

    private RecyclerView rvList;
    private Context mContent;
    private HomeListAdapter homeListAdapter;
    private int[] str_title = {R.string.player_title, R.string.lesson_title, R.string.kara_title};
    private int[] str_content = {R.string.player_content,
            R.string.lesson_content, R.string.kara_content};
    private int[] pic = {R.drawable.ic_lesson_play, R.drawable.ic_lesson_score, R.drawable.ic_lesson_kara};
    private int[] bgColor = {R.color.home_list_bg_green,
            R.color.home_list_bg_blue, R.color.home_list_bg_purple};

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mContent = getActivity();
        View view = inflater.inflate(R.layout.home_fragment,null);
        initView(view);
        return view;
    }

    private void initView(View view) {
        rvList = (RecyclerView) view.findViewById(R.id.rvList);
        homeListAdapter = new HomeListAdapter(mContent, str_title, str_content, pic, bgColor);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(mContent) {
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
                        Intent intentPlay = new Intent(mContent, VideoActivity.class);
                        startActivity(intentPlay);
                        break;
                    case 1:
                        Intent intentLesson = new Intent(mContent, CourseInfoActivity.class);
                        startActivity(intentLesson);
                        break;
                    case 2:
                        Intent intentKara = new Intent(mContent, KaraGameActivity.class);
                        startActivity(intentKara);
                        break;
                    default:
                        break;
                }
            }
        });
    }
}
