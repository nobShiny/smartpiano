package com.lsj.smartpiano.module.video.ui;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.Nullable;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.lsj.smartpiano.R;
import com.lsj.smartpiano.common.utils.FastBlurUtil;
import com.lsj.smartpiano.module.video.adapter.LessonContentAdapter;
import com.lsj.smartpiano.module.video.bean.LessonContentBean;
import com.lsj.smartpiano.module.video.customui.PullLoadMoreRecyclerView;
import com.lsj.smartpiano.module.video.net.VideoListInterface;
import com.lsj.smartpiano.module.video.net.VideoListRest;
import com.lsj.smartpiano.module.video.utils.VideoIntent;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.FileCallBack;

import java.io.File;
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
    private ProgressBar mProgressBar ;
    private int scaleRatio = 4;

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
                                if(!checkFile(mList.get(position).getTitle())){
                                    mProgressBar = (ProgressBar) view.findViewById(R.id.btn_download);
                                    mProgressBar.setVisibility(View.VISIBLE);
                                    mProgressBar.setMax(100);
                                    downloadFile(mList.get(position).getMovieUrl(),mList.get(position).getTitle());
                                }else{
                                    VideoIntent intent = new VideoIntent(AdvanceContentActivity.this, VideoViewPlayerActivity.class);
                                    String path = Environment.getExternalStorageDirectory()
                                            + "/smartPiano/"+ "smartPiano-"+mList.get(position).getTitle();
                                    intent.pathStartVideo(path);
                                    startActivity(intent);
                                }
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

    private boolean checkFile(String fileName) {
        String path = Environment.getExternalStorageDirectory()
                + "/smartPiano/"+"smartPiano-"+fileName;
        File file = new File(path);
        if (file.exists()) {
            return true;
        }
        return false;
    }

    private void downloadFile(String url,String fileName) {
        if(url.equals("")){
            return ;
        }
        String mFileName;
        if(!fileName.equals("")){
            mFileName= "smartPiano-"+fileName;
        }else{
            return ;
        }

        String path = Environment.getExternalStorageDirectory()
                + "/smartPiano/";
        File file = new File(path);
        // 如果SD卡目录不存在创建
        if (!file.exists()) {
            file.mkdir();
        }
        OkHttpUtils.get()
                .url(url)
                .build()
                .execute(new FileCallBack(path,mFileName) {
                    @Override
                    public void inProgress(float progress, long total) {
                        mProgressBar.setProgress((int) (100 * progress));
                        if(mProgressBar.getProgress()==100){
                            mProgressBar.setVisibility(View.GONE);
                        }
                    }

                    @Override
                    public void onError(okhttp3.Call call, Exception e) {
                        Log.d("AdvanceContentActivity","有误--->"+e.getMessage());
                        mProgressBar.setVisibility(View.GONE);
                    }

                    @Override
                    public void onResponse(File response) {
                    }
                });
    }

    private void initData() {
        Intent intent = getIntent();
        collapsingToolbar.setTitle(intent.getSerializableExtra("active_detail_name").toString());
        Picasso.with(AdvanceContentActivity.this)
                .load(intent.getStringExtra("active_detail_url"))
                .into(ivHeaderPic);
        tvHeaderText.setText(intent.getSerializableExtra("active_detail_desc").toString());

        Picasso.with(AdvanceContentActivity.this)
                .load(intent.getStringExtra("active_detail_url"))
                .into(new Target() {
                    @Override
                    public void onBitmapLoaded(Bitmap bitmap, Picasso.LoadedFrom from) {
                        BitmapDrawable bg = new BitmapDrawable(AdvanceContentActivity.this.getResources(),
                                FastBlurUtil.toBlur(bitmap,scaleRatio));
                        llAdvanceHeaderBg.setBackground(bg);
                    }

                    @Override
                    public void onBitmapFailed(Drawable errorDrawable) {
                        Log.d("AdvanceContentActivity", "加载失败");
                    }

                    @Override
                    public void onPrepareLoad(Drawable placeHolderDrawable) {

                    }
                });
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
        advanceContentList.setLinearLayout();
        advanceContentList.setPullRefreshEnable(false);
        advanceContentList.setSwipeRefreshEnable(false);
        advanceContentList.setPushRefreshEnable(false);
    }

    @Override
    protected void onDestroy()
    {
        super.onDestroy();
        OkHttpUtils.getInstance().cancelTag(this);
    }
}
