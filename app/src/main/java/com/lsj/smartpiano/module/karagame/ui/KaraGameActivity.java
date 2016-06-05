package com.lsj.smartpiano.module.karagame.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.lsj.smartpiano.R;
import com.lsj.smartpiano.common.bean.KeyValueBean;
import com.lsj.smartpiano.common.customui.ExpandPopTabView;
import com.lsj.smartpiano.common.customui.PopOneListView;
import com.lsj.smartpiano.common.customui.PullLoadMoreRecyclerView;
import com.lsj.smartpiano.module.karagame.adapter.KaraGameAdapter;
import com.lsj.smartpiano.module.karagame.bean.KaraGameListBean;
import com.lsj.smartpiano.module.karagame.bean.KaraLevelAndCollection;
import com.lsj.smartpiano.module.karagame.net.KaraGameListInterface;
import com.lsj.smartpiano.module.karagame.net.KaraGameListRest;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import retrofit.Call;
import retrofit.Callback;
import retrofit.Response;

/**
 * Created by shiny_jia
 * on 2016-05-17 17:58.
 */
public class KaraGameActivity extends AppCompatActivity {

    @Bind(R.id.expandtab_view)
    ExpandPopTabView expandtabView;
    @Bind(R.id.recyclerView_list)
    PullLoadMoreRecyclerView recyclerViewList;
    @Bind(R.id.empty_view)
    TextView emptyView;
    @Bind(R.id.toolbar)
    Toolbar toolbar;

    private KaraGameListInterface service;
    private String[] categoryName;
    private String[] kara_level;
    private List<KeyValueBean> mLevelLists = new ArrayList<>();
    private List<KeyValueBean> mCategoryLists = new ArrayList<>();
    private KaraLevelAndCollection condition = new KaraLevelAndCollection();

    private List<KaraGameListBean.DataEntity.KarasEntity.LstEntity> mList = new ArrayList<>();
    private KaraGameAdapter adapter;

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
            toolbar.setTitle("卡拉游戏");
            toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
                @Override
                public boolean onMenuItemClick(MenuItem item) {
                    return false;
                }
            });
        }

        initView();
        getKaraListData();
    }

    private void initView() {
        recyclerViewList.setStaggeredGridLayout(2);
        service = KaraGameListRest.getClient();
    }

    public void getKaraListData() {
        Call<KaraGameListBean> call = service.getKaraGameList("1", "2.4.5", "android", "1tai", "1", "0", "0", "zh_CN");
        call.enqueue(new Callback<KaraGameListBean>() {
            @Override
            public void onResponse(Response<KaraGameListBean> response) {
                if (response.isSuccess()) {
                    recyclerViewList.setPullLoadMoreCompleted();
                    KaraGameListBean result = response.body();
                    if (mList != null) {
                        mList.clear();
                    }
                    mList = result.getData().getKaras().getLst();
                    adapter = new KaraGameAdapter(KaraGameActivity.this, mList);
                    recyclerViewList.setAdapter(adapter);
                    categoryName = getResources().getStringArray(R.array.kara_category);
                    kara_level = getResources().getStringArray(R.array.kara_level);
                    for (int i = 0; i < categoryName.length; i++) {
                        KeyValueBean kvBeanP = new KeyValueBean();
                        kvBeanP.setKey(i + "");
                        kvBeanP.setValue(categoryName[i]);
                        mCategoryLists.add(kvBeanP);
                    }

                    for (int i = 0; i < kara_level.length; i++) {
                        KeyValueBean kvBeanP = new KeyValueBean();
                        kvBeanP.setKey(i + "");
                        kvBeanP.setValue(kara_level[i]);
                        mLevelLists.add(kvBeanP);
                    }

                    addItem(expandtabView, mCategoryLists,
                            "娱乐",
                            "类别选择");
                    addItem(expandtabView, mLevelLists,
                            "全部级别",
                            "难度级别");

                    adapter.setOnItemClickListener(new KaraGameAdapter.OnRecyclerViewItemClickListener() {
                        @Override
                        public void onItemClick(View view, int position) {
                            Toast.makeText(KaraGameActivity.this, "玩第"+(position+1)+"个游戏喽~", Toast.LENGTH_SHORT).show();
                        }
                    });
                } else {
                    Toast.makeText(KaraGameActivity.this, "没有更多的数据", Toast.LENGTH_SHORT).show();
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
                        for(int i = 0; i < categoryName.length; i++){
                            if(categoryName[i].contains(key)){
                                condition.setCollection(i);
                                break;
                            }
                        }
                        for(int i = 0; i < kara_level.length; i++){
                            if(kara_level[i].contains(key)){
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
        Call<KaraGameListBean> call = service.getKaraGameWithLevelList(
                String.valueOf(condition.getCollection()),
                String.valueOf(condition.getLevel()),
                "2.4.5", "android", "1tai", "1", "0", "0", "zh_CN");
        call.enqueue(new Callback<KaraGameListBean>() {
            @Override
            public void onResponse(Response<KaraGameListBean> response) {
                setDataAccordingToTheCondition(response);
            }

            @Override
            public void onFailure(Throwable t) {

            }
        });
    }

    private void getSelectCategoryData() {
        Call<KaraGameListBean> call = service.getKaraGameList(
                String.valueOf(condition.getCollection()),
                "2.4.5", "android", "1tai", "1", "0", "0", "zh_CN");
        call.enqueue(new Callback<KaraGameListBean>() {
            @Override
            public void onResponse(Response<KaraGameListBean> response) {
                setDataAccordingToTheCondition(response);
            }

            @Override
            public void onFailure(Throwable t) {

            }
        });
    }

    private void setDataAccordingToTheCondition(Response<KaraGameListBean> response) {
        if (response.isSuccess()) {
            recyclerViewList.setPullLoadMoreCompleted();
            KaraGameListBean result = response.body();
            if (mList != null) {
                mList.clear();
            }
            mList = result.getData().getKaras().getLst();
            adapter = new KaraGameAdapter(KaraGameActivity.this, mList);
            recyclerViewList.setAdapter(adapter);
            adapter.setOnItemClickListener(new KaraGameAdapter.OnRecyclerViewItemClickListener() {
                @Override
                public void onItemClick(View view, int position) {

                }
            });
        }
        recyclerViewList.setPullLoadMoreCompleted();
    }
}
