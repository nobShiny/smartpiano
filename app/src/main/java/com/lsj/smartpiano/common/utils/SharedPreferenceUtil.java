package com.lsj.smartpiano.common.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.preference.PreferenceManager;


/**
 * sp工具类
 *
 */
public class SharedPreferenceUtil {
    /**保存Preference的name*/
    public static final String PREFERENCE_NAME = "config";
    private final static int CONTEXT_MODE = Context.MODE_PRIVATE;
    private static SharedPreferences mSharedPreferences;
    private static SharedPreferenceUtil mPreferencemManager;
    private static SharedPreferences.Editor editor;

    private SharedPreferenceUtil(Context context) {
        mSharedPreferences = context.getSharedPreferences(PREFERENCE_NAME, Context.MODE_PRIVATE);
        editor = mSharedPreferences.edit();
    }
    public static synchronized void init(Context context){
        if(mPreferencemManager == null){
            mPreferencemManager = new SharedPreferenceUtil(context);
        }
    }
    /**
     * 单例模式，获取instance实例
     */
    public synchronized static SharedPreferenceUtil getInstance() {
        if (mPreferencemManager == null) {
            throw new RuntimeException("please init first!");
        }

        return mPreferencemManager;
    }

    /**
     * 获取旧的版本号
     * @param context
     * @param prefName
     * @return
     */
    public static int getAppPrefInt(Context context, String prefName){
        int result = -1;
        if(context != null){
            SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
            if(sharedPreferences!=null){
                result = sharedPreferences.getInt(
                        prefName, -1);
            }
        }
        return result;
    }

    /**
     * 设置版本号
     * @param context
     * @param prefName
     * @param value
     */
    public static void putAppPrefInt(Context context, String prefName, int value) {
        if(context!=null){
            SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
            SharedPreferences.Editor edit = sharedPreferences.edit();
            edit.putInt(prefName, value);
            if(Build.VERSION.SDK_INT>=9){
                edit.apply();
            }else{
                edit.commit();
            }
        }
    }

    /**
     * 获取String值
     * @param context
     * @param prefsname
     * @param key
     * @param defValue
     * @return 给定文件名获取key对应的value，若无，返回defValue
     */
    public static String getString(Context context, String prefsname,
            String key, String defValue) {
        if (context == null) {
            return "";
        }
        SharedPreferences sp = context.getSharedPreferences(prefsname,
                CONTEXT_MODE);
        return sp.getString(key, defValue);
    }
    
    public static int getInt(Context context, String prefsname,
            String key, int defValue) {
        SharedPreferences sp = context.getSharedPreferences(prefsname,
                CONTEXT_MODE);
        return sp.getInt(key, defValue);
    }
    
    public static long getLong(Context context, String prefsname,
            String key, long defValue) {
        SharedPreferences sp = context.getSharedPreferences(prefsname,
                CONTEXT_MODE);
        return sp.getLong(key, defValue);
    }
    
    public static boolean getBoolean(Context context, String prefsname,
            String key, boolean defValue) {
        if (context == null)
            return false;
        SharedPreferences sp = context.getSharedPreferences(prefsname,
                CONTEXT_MODE);
        return sp.getBoolean(key, defValue);
    }
    
    
    public static void putInt(Context context, String prefsname, String key,
            int value) {
        context.getSharedPreferences(prefsname, CONTEXT_MODE).edit()
        .putInt(key, value).commit();
    }
    
    public static void putLong(Context context, String prefsname, String key,
            long value) {
        context.getSharedPreferences(prefsname, CONTEXT_MODE).edit()
                .putLong(key, value).commit();
    }
    
    public static void putBoolean(Context context, String prefsname, String key,
            boolean value) {
        context.getSharedPreferences(prefsname, CONTEXT_MODE).edit()
        .putBoolean(key, value).commit();
    }
    
    public static void putString(Context context, String prefsname, String key,
            String value) {
        context.getSharedPreferences(prefsname, CONTEXT_MODE).edit()
        .putString(key, value).commit();
    }
    
    public static void remove(Context context, String prefsname, String key) {
        if (key == null || "".equals(key))
            context.getSharedPreferences(prefsname, CONTEXT_MODE).edit().clear().commit();
        else
            context.getSharedPreferences(prefsname, CONTEXT_MODE).edit()
                    .remove(key).commit();
    }

}
