package com.lsj.smartpiano.module.video.ui;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.lsj.smartpiano.R;
import com.lsj.smartpiano.module.video.adapter.LessonContentAdapter;
import com.lsj.smartpiano.module.video.bean.LessonContentBean;
import com.lsj.smartpiano.module.video.customui.PullLoadMoreRecyclerView;
import com.lsj.smartpiano.module.video.net.VideoListInterface;
import com.lsj.smartpiano.module.video.net.VideoListRest;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import retrofit.Call;
import retrofit.Callback;
import retrofit.Response;

/**
 * Created by shiny_jia
 * on 2016-06-04 20:53.
 */
public class AdvanceContentActivity extends AppCompatActivity {
    @Bind(R.id.iv_header_pic)
    ImageView ivHeaderPic;
    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.collapsing_toolbar)
    CollapsingToolbarLayout collapsingToolbar;
    @Bind(R.id.tv_header_text)
    TextView tvHeaderText;
    @Bind(R.id.ll_advance_header_bg)
    LinearLayout llAdvanceHeaderBg;
    @Bind(R.id.advance_content_list)
    PullLoadMoreRecyclerView advanceContentList;

    private String lessonId;
    private List<LessonContentBean.DataEntity.LessonsEntity.ListEntity> mList = new ArrayList<>();
    private LessonContentAdapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.advance_content_activity);
        initView();
        initData();
    }

    private void getLessonList(String lessonId) {
        VideoListInterface service = VideoListRest.getClient();
        Call<LessonContentBean> call = service.getAdvanceContentWithId(
                lessonId,"2.4.5", "android", "1tai", "1", "0", "0", "zh_CN");
        if(!lessonId.equals("")){
            call.enqueue(new Callback<LessonContentBean>() {
                @Override
                public void onResponse(Response<LessonContentBean> response) {
                    if(response.isSuccess()){
                        LessonContentBean lessonContentBean = response.body();
                        if (mList != null) {
                            mList.clear();
                        }
                        mList = lessonContentBean.getData().getLessons().getList();
                        adapter = new LessonContentAdapter(AdvanceContentActivity.this, mList);
                        advanceContentList.setAdapter(adapter);
                        adapter.setOnItemClickListener(new LessonContentAdapter.OnRecyclerViewItemClickListener() {
                            @Override
                            public void onItemClick(View view, int position) {

                            }
                        });
                    }
                }

                @Override
                public void onFailure(Throwable t) {

                }
            });
        }else{
            Toast.makeText(this, "课程列表获取失败，请检查课程id", Toast.LENGTH_SHORT).show();
        }

    }

    private void initData() {
        Intent intent = getIntent();
        collapsingToolbar.setTitle(intent.getSerializableExtra("active_detail_name").toString());
        Picasso.with(AdvanceContentActivity.this)
                .load(intent.getStringExtra("active_detail_url"))
                .into(ivHeaderPic);
        tvHeaderText.setText(intent.getSerializableExtra("active_detail_desc").toString());
        llAdvanceHeaderBg.setBackgroundColor(Color.parseColor("#11122233"));
        lessonId = intent.getSerializableExtra("active_detail_id").toString();
        getLessonList(lessonId);
    }

    private void initView() {
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
    }
}
