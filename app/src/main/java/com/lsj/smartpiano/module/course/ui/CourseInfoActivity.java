package com.lsj.smartpiano.module.course.ui;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import com.lsj.smartpiano.R;
import com.lsj.smartpiano.common.customui.ExpandPopTabView;
import com.lsj.smartpiano.common.customui.PullLoadMoreRecyclerView;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by shiny_jia
 * on 2016-05-17 14:46.
 */
public class CourseInfoActivity extends Activity {

    @Bind(R.id.expandtab_view)
    ExpandPopTabView expandtabView;
    @Bind(R.id.recyclerView_list)
    PullLoadMoreRecyclerView recyclerViewList;
    @Bind(R.id.empty_view)
    TextView emptyView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.course_info__activity);
        ButterKnife.bind(this);

    }
}
