package com.lsj.smartpiano.common.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import com.lsj.smartpiano.common.application.SmartPianoApplication;

/**
 * Created by shiny_jia
 * on 2016-06-02 11:49.
 */
public class NetWorkUtil {

    private static Context context = SmartPianoApplication.getContext();

    // 判断网络是否可以使用
    public static boolean isNetWorkAvailable() {
        // 得到一个网络连接管理器对象
        ConnectivityManager manager = (ConnectivityManager) context
                .getSystemService(Context.CONNECTIVITY_SERVICE);
        // NetworkInfo:描述了某个网络类型的与网络相关的信息
        NetworkInfo info = manager.getActiveNetworkInfo();
        // isAvailable():用来判断网络是否可用.
        if (info != null && info.isAvailable()) {
            return true;
        }
        return false;
    }

    // 判断网络是否连接
    public static boolean isNetWorkConnected() {
        ConnectivityManager manager = (ConnectivityManager) context
                .getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo info = manager.getActiveNetworkInfo();
        // isConnected():判断网络连接是否存在,并且是否可以建立连接和传递数据
        if (info != null && info.isConnected()) {
            return true;
        }
        return false;
    }

    // 判断WiFi是否已连接
    public static boolean isWifiConnected() {
        ConnectivityManager manager = (ConnectivityManager) context
                .getSystemService(Context.CONNECTIVITY_SERVICE);
        // 得到关于Wifi网络的网络信息
        NetworkInfo info = manager
                .getNetworkInfo(ConnectivityManager.TYPE_WIFI);
        if (info != null && info.isConnected()) {
            return true;
        }
        return false;
    }

    // 判断MOBILE是否已连接
    public static boolean isMobileConnected() {
        ConnectivityManager manager = (ConnectivityManager) context
                .getSystemService(Context.CONNECTIVITY_SERVICE);
        // 得到关于Wifi网络的网络信息
        NetworkInfo info = manager
                .getNetworkInfo(ConnectivityManager.TYPE_MOBILE);
        if (info != null && info.isConnected()) {
            return true;
        }
        return false;
    }
}
