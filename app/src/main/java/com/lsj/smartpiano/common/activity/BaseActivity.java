package com.lsj.smartpiano.common.activity;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.Nullable;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.lsj.smartpiano.R;
import com.lsj.smartpiano.module.search.adapter.LogQuickSearchAdapter;
import com.lsj.smartpiano.module.search.bean.LogQuickSearch;
import com.lsj.smartpiano.module.search.bean.SearchKaraBean;
import com.lsj.smartpiano.module.search.bean.SearchSongBean;
import com.lsj.smartpiano.module.search.bean.SearchVideoBean;
import com.lsj.smartpiano.module.search.net.SearchListInterface;
import com.lsj.smartpiano.module.search.net.SearchVideoListRest;
import com.lsj.smartpiano.module.search.util.InitiateSearch;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import butterknife.Bind;
import butterknife.ButterKnife;
import retrofit.Call;
import retrofit.Callback;
import retrofit.Response;

/**
 * Created by shiny_jia
 * on 2016-05-16 16:07.
 */
public class BaseActivity extends AppCompatActivity {

    private long exitTime = 0;

    private InitiateSearch initiateSearch;
    private LogQuickSearchAdapter logQuickSearchAdapter;
    private Set<String> set = new HashSet<>();
    @Bind(R.id.content)
    CoordinatorLayout clContent;

    @Nullable
    @Bind(R.id.toolbar)
    public
    Toolbar toolbar;

    @Nullable
    @Bind(R.id.ivLogo)
    ImageView ivLogo;

    @Bind(R.id.view_search)
    RelativeLayout view_search;
    @Bind(R.id.listContainer)
    ListView listContainer;
    @Bind(R.id.listView)
    ListView listView;
    @Bind(R.id.card_search)
    CardView card_search;
    @Bind(R.id.marker_progress)
    ProgressBar marker_progress;
    @Bind(R.id.image_search_back)
    ImageView image_search_back;
    @Bind(R.id.clearSearch)
    ImageView clearSearch;
    @Bind(R.id.edit_text_search)
    EditText edit_text_search;
    @Bind(R.id.toolbar_shadow)
    View toolbar_shadow;
    @Bind(R.id.line_divider)
    View line_divider;

    private MenuItem inboxMenuItem;

    @Override
    public void setContentView(int layoutResID) {
        super.setContentView(layoutResID);
        bindViews();
    }

    protected void bindViews() {
        ButterKnife.bind(this);
//        marker_progress = (ProgressBar) findViewById(R.id.marker_progress);
        marker_progress.getIndeterminateDrawable().setColorFilter(Color.parseColor("#FFFFFF"),
                        android.graphics.PorterDuff.Mode.MULTIPLY);
        initiateSearch = new InitiateSearch();
        logQuickSearchAdapter = new LogQuickSearchAdapter(this, 0, LogQuickSearch.all());
//        listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter(logQuickSearchAdapter);

        setupToolbar();
    }

    public void setContentViewWithoutInject(int layoutResId) {
        super.setContentView(layoutResId);
    }

    protected void setupToolbar() {
        if (toolbar != null) {
            setSupportActionBar(toolbar);
            toolbar.setNavigationIcon(R.drawable.ic_menu_white);
            toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
                @Override
                public boolean onMenuItemClick(MenuItem item) {
                    int menuItem = item.getItemId();
                    switch (menuItem) {
                        case R.id.action_search:
                            IsAdapterEmpty();
                            initiateSearch.handleToolBar(BaseActivity.this, card_search, toolbar, view_search, listView, edit_text_search, line_divider);
                            break;
                        default:
                            break;
                    }
                    return false;
                }
            });
        }
        setSearchActive();
    }

    private void setSearchActive() {
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                LogQuickSearch logQuickSearch = logQuickSearchAdapter.getItem(position);
                edit_text_search.setText(logQuickSearch.getName());
                listView.setVisibility(View.GONE);
                ((InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE)).hideSoftInputFromWindow(edit_text_search.getWindowToken(), 0);
                toolbar_shadow.setVisibility(View.GONE);

            }
        });
        edit_text_search.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (edit_text_search.getText().toString().length() == 0) {
                    logQuickSearchAdapter = new LogQuickSearchAdapter(BaseActivity.this, 0, LogQuickSearch.all());
                    listView.setAdapter(logQuickSearchAdapter);
                    IsAdapterEmpty();
                } else {
                    logQuickSearchAdapter = new LogQuickSearchAdapter(BaseActivity.this, 0, LogQuickSearch.FilterByName(edit_text_search.getText().toString()));
                    listView.setAdapter(logQuickSearchAdapter);
                    clearSearch.setImageResource(R.drawable.ic_close);
                    IsAdapterEmpty();
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        clearSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (edit_text_search.getText().toString().length() == 0) {

                } else {
                    edit_text_search.setText("");
                    listView.setVisibility(View.VISIBLE);
                    //                    clearItems();
                    ((InputMethodManager) BaseActivity.this.getSystemService(Context.INPUT_METHOD_SERVICE)).toggleSoftInput(InputMethodManager.SHOW_FORCED, InputMethodManager.HIDE_IMPLICIT_ONLY);
                    IsAdapterEmpty();
                }
            }
        });

        doSearch();
    }

    private void IsAdapterEmpty() {
        if (logQuickSearchAdapter.getCount() == 0) {
            line_divider.setVisibility(View.GONE);
        } else {
            line_divider.setVisibility(View.VISIBLE);
        }
    }

    private void doSearch() {
        image_search_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initiateSearch.handleToolBar(BaseActivity.this, card_search, toolbar, view_search, listView, edit_text_search, line_divider);
                listContainer.setVisibility(View.GONE);
                toolbar_shadow.setVisibility(View.VISIBLE);
            }
        });
        edit_text_search.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                    if (edit_text_search.getText().toString().trim().length() > 0) {
                        ((InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE)).hideSoftInputFromWindow(edit_text_search.getWindowToken(), 0);
                        UpdateQuickSearch(edit_text_search.getText().toString());
                        listView.setVisibility(View.GONE);
                        toolbar_shadow.setVisibility(View.GONE);
                        //请求网络拿搜索数据
                        getDateWithKeyword(edit_text_search.getText().toString().trim());
                    }
                    return true;
                }
                return false;
            }
        });
    }

    private void getDateWithKeyword(final String keyword) {
        SearchListInterface service = SearchVideoListRest.getClient();
        Call<SearchVideoBean> call_video = service.getSearchVideoList(keyword,"1","20",
                "2.4.5", "android", "1tai", "1", "0", "0", "zh_CN");
        call_video.enqueue(new Callback<SearchVideoBean>() {
            @Override
            public void onResponse(Response<SearchVideoBean> response) {
                if(response.isSuccess()){
                    SearchVideoBean result = response.body();
                    int count = result.getData().getLessons().getNextCursor();
                    Toast.makeText(BaseActivity.this,"找到有关“"+ keyword +"”的视频:" + count+"个", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Throwable t) {

            }
        });

        Call<SearchKaraBean> call_kara = service.getSearchKarasList(keyword,"1","20",
                "2.4.5", "android", "1tai", "1", "0", "0", "zh_CN");
        call_kara.enqueue(new Callback<SearchKaraBean>() {
            @Override
            public void onResponse(Response<SearchKaraBean> response) {
                if(response.isSuccess()){
                    SearchKaraBean result = response.body();
                    int count = result.getData().getKaras().getNextCursor();
                    Toast.makeText(BaseActivity.this,"找到有关“"+ keyword +"”的卡拉游戏:" + count+"个", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Throwable t) {

            }
        });

        Call<SearchSongBean> call_song = service.getSearchSongsList(keyword,"1","20",
                "2.4.5", "android", "1tai", "1", "0", "0", "zh_CN");
        call_song.enqueue(new Callback<SearchSongBean>() {
            @Override
            public void onResponse(Response<SearchSongBean> response) {
                if(response.isSuccess()){
                    SearchSongBean result = response.body();
                    int count = result.getData().getSongs().getNextCursor();
                    Toast.makeText(BaseActivity.this,"找到有关“"+ keyword +"”的曲谱:" + count+"个", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Throwable t) {

            }
        });
    }

    private void UpdateQuickSearch(String item) {
        for (int i = 0; i < logQuickSearchAdapter.getCount(); i++) {
            LogQuickSearch ls = logQuickSearchAdapter.getItem(i);
            String name = ls.getName();
            set.add(name.toUpperCase());
        }
        if (set.add(item.toUpperCase())) {
            LogQuickSearch recentLog = new LogQuickSearch();
            recentLog.setName(item);
            recentLog.setDate(new Date());
            recentLog.save();
            logQuickSearchAdapter.add(recentLog);
            logQuickSearchAdapter.notifyDataSetChanged();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        inboxMenuItem = menu.findItem(R.id.action_search);
        inboxMenuItem.setActionView(R.layout.menu_item_view);
        inboxMenuItem.getActionView().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(clContent, "Hello!", Snackbar.LENGTH_SHORT).show();
            }
        });
        return super.onCreateOptionsMenu(menu);
    }

    public Toolbar getToolbar() {
        return toolbar;
    }

    public MenuItem getInboxMenuItem() {
        return inboxMenuItem;
    }

    public ImageView getIvLogo() {
        return ivLogo;
    }


    public void doExitApp() {
        if ((System.currentTimeMillis() - exitTime) > 2000) {
            Toast.makeText(this, R.string.press_again_exit_app, Toast.LENGTH_SHORT).show();
            exitTime = System.currentTimeMillis();
        } else {
            finish();
        }
    }

    /*@Override
    public void onBackPressed() {
//        if (mDrawerLayout.isDrawerOpen(Gravity.LEFT)) {
//            mDrawerLayout.closeDrawer(Gravity.LEFT);
//        } else {
            doExitApp();
//        }

    }*/
}
