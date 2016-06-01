package com.lsj.smartpiano.common.application;

import android.app.Application;
import android.content.Context;

import com.lsj.smartpiano.R;
import com.lsj.smartpiano.common.utils.SharedPreferenceUtil;
import com.lsj.smartpiano.module.search.bean.LogQuickSearch;
import com.orhanobut.logger.AndroidLogTool;
import com.orhanobut.logger.LogLevel;
import com.orhanobut.logger.Logger;
import com.orm.androrm.DatabaseAdapter;
import com.orm.androrm.Model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by shiny_jia
 * on 2016-05-11 13:56.
 */
public class SmartPianoApplication extends Application {
//    private static RequestQueue mQueue;
    public static Context mContext;

    /**
     * 缓存的目录
     */
    private static final String ICON_CACHE_DIR = "cache";
    /**
     * 缓存的路径，清理缓存时即清理此
     */
    private static String mCacheDir;
    /**
     * 文件下载的目录
     */
    private static final String FILE_ERRORAUDIO_DIR = "audio";
    private static final String FILE_ERRORPICTURE_DIR = "picture";
    /**
     * 缓存的路径，清理缓存时即清理此
     */
    public static String mDownloadDir;
    private static String mErrorAudioDir;
    private static String mErrorPictureDir;

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = this;
        SharedPreferenceUtil.init(getApplicationContext());
        initializeDatabase();
        Logger.init("SMART_PIANO").
                methodCount(3).
//                hideThreadInfo().
                logLevel(LogLevel.NONE).
                methodOffset(2).
                logTool(new AndroidLogTool());
    }

    private void initializeDatabase() {
        List<Class<? extends Model>> models = new ArrayList<>(0);
        models.add(LogQuickSearch.class);
        String dbName = this.getResources().getString(R.string.database_name);
        DatabaseAdapter.setDatabaseName(dbName);
        DatabaseAdapter adapter = new DatabaseAdapter(mContext);
        adapter.setModels(models);
    }

    public static Context getContext() {
        return mContext;
    }
}
