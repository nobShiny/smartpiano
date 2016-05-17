package com.lsj.smartpiano.common.application;

import android.app.Application;
import android.content.Context;

import com.lsj.smartpiano.common.utils.SharedPreferenceUtil;

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
        SharedPreferenceUtil.init(getApplicationContext());
    }
}
