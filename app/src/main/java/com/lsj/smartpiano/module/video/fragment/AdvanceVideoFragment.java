package com.lsj.smartpiano.module.video.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lsj.smartpiano.R;

/**
 * Created by shiny_jia
 * on 2016-05-18 11:27.
 * 进阶教程fragment
 */
public class AdvanceVideoFragment extends Fragment{
    public static final String ARG_PAGE = "ADVANCE_PAGE";

    private int mPage;

    public static AdvanceVideoFragment newInstance(int page) {
        Bundle args = new Bundle();
        args.putInt(ARG_PAGE, page);
        AdvanceVideoFragment fragment = new AdvanceVideoFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPage = getArguments().getInt(ARG_PAGE);
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.advance_fragment_page, container, false);
        return view;

    }
}
