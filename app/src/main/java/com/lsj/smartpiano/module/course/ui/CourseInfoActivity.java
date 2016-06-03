package com.lsj.smartpiano.module.course.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.lsj.smartpiano.R;
import com.lsj.smartpiano.common.bean.KeyValueBean;
import com.lsj.smartpiano.common.customui.ExpandPopTabView;
import com.lsj.smartpiano.common.customui.PopOneListView;
import com.lsj.smartpiano.common.customui.PullLoadMoreRecyclerView;
import com.lsj.smartpiano.module.course.adapter.CourseAdapter;
import com.lsj.smartpiano.module.course.bean.CourseCategoryBean;
import com.lsj.smartpiano.module.course.bean.CourseListBean;
import com.lsj.smartpiano.module.course.bean.SelectBean;
import com.lsj.smartpiano.module.course.net.CourseListInterface;
import com.lsj.smartpiano.module.course.net.CourseListRest;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import retrofit.Call;
import retrofit.Callback;
import retrofit.Response;

/**
 * Created by shiny_jia
 * on 2016-05-17 14:46.
 */
public class CourseInfoActivity extends AppCompatActivity {

    @Bind(R.id.expandtab_view)
    ExpandPopTabView expandtabView;
    @Bind(R.id.recyclerView_list)
    PullLoadMoreRecyclerView recyclerViewList;
    @Bind(R.id.empty_view)
    TextView emptyView;
    @Bind(R.id.toolbar)
    Toolbar toolbar;

    private CourseListInterface service;
    private List<KeyValueBean> mLevelLists = new ArrayList<>();
    private List<KeyValueBean> mCategoryLists = new ArrayList<>();
    private List<CourseCategoryBean.DataEntity.XxEntity.ListEntity> categoryList = new ArrayList<>();
    private SelectBean condition = new SelectBean();
    private String[] course_level;
    private List<CourseListBean.DataEntity.SubsEntity.ListEntity> mList = new ArrayList<>();
    private CourseAdapter adapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.course_info__activity);
        ButterKnife.bind(this);
        if (toolbar != null) {
            setSupportActionBar(toolbar);
            toolbar.setNavigationIcon(getResources().getDrawable(R.drawable.ic_arrow_back));
            toolbar.setNavigationOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    finish();
                }
            });
            toolbar.setTitle("跟灯练习");
            toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
                @Override
                public boolean onMenuItemClick(MenuItem item) {
                    return false;
                }
            });
        }
        initContentView();
        initData();
        getCourseCategoryData();
    }

    private void initContentView() {
        recyclerViewList.setGridLayout(2);
        service = CourseListRest.getClient();
    }

    private void initData() {
        Call<CourseListBean> call = service.getCourseList(
                "404",
                "2.4.5", "android", "1tai", "1", "0", "0", "zh_CN");
        call.enqueue(new Callback<CourseListBean>() {
            @Override
            public void onResponse(Response<CourseListBean> response) {
                setDataAccordingToTheCondition(response);
            }

            @Override
            public void onFailure(Throwable t) {

            }
        });
    }


    public void getCourseCategoryData() {
        Call<CourseCategoryBean> call = service.getCourseCategoryList(
                "2.4.5", "android", "1tai", "1", "0", "0", "zh_CN");
        call.enqueue(new Callback<CourseCategoryBean>() {
            @Override
            public void onResponse(Response<CourseCategoryBean> response) {
                if (response.isSuccess()) {
                    recyclerViewList.setPullLoadMoreCompleted();
                    CourseCategoryBean result = response.body();
                    categoryList = result.getData().getXx().getList();
                    for(int i = 0; i < categoryList.size(); i++){
                        KeyValueBean kvBeanP = new KeyValueBean();
                        kvBeanP.setKey(categoryList.get(i).getId()+"");
                        kvBeanP.setValue(categoryList.get(i).getName());
                        mCategoryLists.add(kvBeanP);
                    }
                    course_level = getResources().getStringArray(R.array.course_level);
                    for (int i = 0; i < course_level.length; i++) {
                        KeyValueBean kvBeanP = new KeyValueBean();
                        kvBeanP.setKey(i + "");
                        kvBeanP.setValue(course_level[i]);
                        mLevelLists.add(kvBeanP);
                    }
                    addItem(expandtabView, mCategoryLists,
                            "热门推荐",
                            "类别筛选");
                    addItem(expandtabView, mLevelLists,
                            "全部级别",
                            "难度级别");
                    adapter = new CourseAdapter(CourseInfoActivity.this, mList);
                    recyclerViewList.setAdapter(adapter);
                    adapter.setOnItemClickListener(new CourseAdapter.OnRecyclerViewItemClickListener() {
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
    }

    public void addItem(ExpandPopTabView expandTabView, List<KeyValueBean> lists,
                        String defaultSelect, String defaultShowText) {
        PopOneListView popOneListView = new PopOneListView(this);
        popOneListView.setDefaultSelectByValue(defaultSelect);
        popOneListView.setCallBackAndData(lists, expandTabView,
                new PopOneListView.OnSelectListener() {
                    @Override
                    public void getValue(String key, String value) {
                        for(int i = 0; i < categoryList.size(); i++){
                            if(categoryList.get(i).getName().equals(value)){
                                condition.setCategory(Integer.valueOf(key));
                                break;
                            }
                        }
                        for(int i = 0; i < course_level.length; i++){
                            if(course_level[i].contains(key)){
                                condition.setLevel(i);
                                break;
                            }
                        }
                        if(condition.getLevel()==0){
                            getSelectCategoryData();
                        }else{
                            getSelectCategoryWithLevelData();
                        }
                    }

                });
        expandTabView.addItemToExpandTab(defaultShowText, popOneListView);
    }

    private void getSelectCategoryWithLevelData() {
        Call<CourseListBean> call = service.getCourseWithLevelList(
                String.valueOf(condition.getCategory()),
                String.valueOf(condition.getLevel()),
                "2.4.5", "android", "1tai", "1", "0", "0", "zh_CN");
        call.enqueue(new Callback<CourseListBean>() {
            @Override
            public void onResponse(Response<CourseListBean> response) {
                setDataAccordingToTheCondition(response);
            }

            @Override
            public void onFailure(Throwable t) {

            }
        });
    }

    private void getSelectCategoryData() {
        Call<CourseListBean> call = service.getCourseList(
                String.valueOf(condition.getCategory()),
                "2.4.5", "android", "1tai", "1", "0", "0", "zh_CN");
        call.enqueue(new Callback<CourseListBean>() {
            @Override
            public void onResponse(Response<CourseListBean> response) {
                setDataAccordingToTheCondition(response);
            }

            @Override
            public void onFailure(Throwable t) {

            }
        });
    }

    private void setDataAccordingToTheCondition(Response<CourseListBean> response) {
        if (response.isSuccess()) {
            recyclerViewList.setPullLoadMoreCompleted();
            CourseListBean result = response.body();
            if (mList != null) {
                mList.clear();
            }
            mList = result.getData().getSubs().getList();
            adapter = new CourseAdapter(CourseInfoActivity.this, mList);
            recyclerViewList.setAdapter(adapter);
            adapter.setOnItemClickListener(new CourseAdapter.OnRecyclerViewItemClickListener() {
                @Override
                public void onItemClick(View view, int position) {

                }
            });
        }
        recyclerViewList.setPullLoadMoreCompleted();
    }

}
