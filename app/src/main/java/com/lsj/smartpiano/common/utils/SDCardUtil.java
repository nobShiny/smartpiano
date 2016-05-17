package com.lsj.smartpiano.common.utils;

import android.os.Environment;

public class SDCardUtil {

    // 检测SD卡是否挂载了,已挂载返回true
    public static boolean isMounted() {
        // 得到当前主要的存储设备的状态
        if (Environment.MEDIA_MOUNTED.equals(Environment
                .getExternalStorageState())) {
            return true;
        }
        return false;
    }
}
