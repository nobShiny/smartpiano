package com.lsj.smartpiano.common.utils;

import android.app.Activity;
import android.content.Context;
import android.os.Environment;
import android.os.StatFs;
import android.telephony.TelephonyManager;
import android.util.DisplayMetrics;

import java.io.File;
import java.security.MessageDigest;

/**
 * Created by shiny 15/12/30.
 */
public class DeviceUtil {

    /**
     * 根据手机的分辨率从 px(像素) 的单位 转成为 dp
     */
    public static int px2dp(Context context, float pxValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (pxValue / scale + 0.5f);
    }

    /**
     * 根据手机的分辨率从 px(像素) 的单位 转成为 sp,字体的转换
     */
    public static int px2sp(Context context, float pxValue) {
        final float fontScale = context.getResources().getDisplayMetrics().scaledDensity;
        return (int) (pxValue / fontScale + 0.5f);
    }

    /**
     * 根据手机的分辨率从 dp 的单位 转成为 px(像素)
     */
    public static int dp2px(Context context, float dpValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }

    /**
     * 获取DisplayMetrics，包括屏幕高宽，密度等
     * @param context
     * @return
     */
    public static DisplayMetrics getDisplayMetrics(Activity context) {
        DisplayMetrics dm = new DisplayMetrics();
        context.getWindowManager().getDefaultDisplay().getMetrics(dm);
        return dm;
    }

    /**
     * 获得屏幕宽度 px
     * @param context
     * @return
     */
    public static int getWidth(Activity context) {
        DisplayMetrics dm = new DisplayMetrics();
        context.getWindowManager().getDefaultDisplay().getMetrics(dm);
        return dm.widthPixels;
    }

    /**
     * 获得屏幕高度 px
     * @param context
     * @return
     */
    public static int getHeight(Activity context) {
        DisplayMetrics dm = new DisplayMetrics();
        context.getWindowManager().getDefaultDisplay().getMetrics(dm);
        return dm.heightPixels;
    }

    /**
     * 获取手机IMSI（国际移动用户识别码）码（用于唯一识别移动用户的一个号码）
     * @param context
     * @return
     */
    public static String getIMSI(Context context) {
        try {
            if (context == null) {
                return "";
            }
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
            return telephonyManager.getSubscriberId();
        } catch (Exception exception1) {
        }
        return "";
    }

    /**
     * 获取手机IMEI（手机序列号）码
     * @param context
     * @return
     */
    public static String getIMEI(Context context) {
        try {
            if (context == null) {
                return "";
            }
            TelephonyManager telephonyManager = (TelephonyManager) context
                    .getSystemService(Context.TELEPHONY_SERVICE);
            String imei = telephonyManager.getDeviceId();
            if (imei != null && !imei.equals("")) {
                return imei;
            }
        } catch (Exception exception1) {
        }

        return "";
    }


    /**
     * 生成手机用户唯一id
     * @param context
     * @return
     */
    public static String getDeviceId(Context context) {
        try {
            String strIMEI = getIMEI(context);
            if (strIMEI == null || strIMEI.equals("")) {
                strIMEI = getIMSI(context);
                if (strIMEI == null || strIMEI.equals("")) {
                    return "";
                }
            }
            String strTemp = strIMEI + strIMEI + strIMEI;
            String strMd5 = DeviceUtil.getMD5(strTemp.getBytes());
            return strMd5;
        } catch (Exception exception1) {
        }
        return "";
    }

    public static String getMD5(byte[] bytes) {
        String strTemp = "";
        try {
            MessageDigest algorithm = MessageDigest.getInstance("MD5");
            algorithm.reset();
            algorithm.update(bytes);
            return toHexString(algorithm.digest(), "");
        } catch (Exception e) {
            strTemp = "";
        }

        return strTemp;
    }

    public static String toHexString(byte[] bytes, String separator) {
        StringBuilder hexString = new StringBuilder();
        for (byte b : bytes) {
            if (Integer.toHexString(0xFF & b).length() == 1)
                hexString.append("0").append(Integer.toHexString(0xFF & b));
            else
                hexString.append(Integer.toHexString(0xFF & b));
        }
        return hexString.toString();
    }

    /**
     * 判断存储卡是否可用
     */
    private static DeviceUtil tool = null;
    // 检查SD卡是否挂载
    public boolean SD_EXIST = false;

    public static DeviceUtil instance() {
        if (tool == null) {
            synchronized (DeviceUtil.class) {
                if (tool == null) {
                    tool = new DeviceUtil();
                    tool.SD_EXIST = Environment.MEDIA_MOUNTED
                            .equals(Environment.getExternalStorageState());
                }
            }
        }
        return tool;
    }

    /**
     * 获取sd卡剩余空间
     * 单位 byte
     * @return
     */
    public long getSDFreeSize() {
        // 取得SD卡文件路径
        File path = Environment.getExternalStorageDirectory();
        StatFs sf = new StatFs(path.getPath());
        long blockSize = sf.getBlockSize();
        // 空闲的数据块的数量
        long freeBlocks = sf.getAvailableBlocks();
        // 返回SD卡空闲大小
        return freeBlocks * blockSize; // 单位Byte
    }

    /**
     * 获取sd卡全部空间
     * 单位 byte
     * @return
     */
    public long getSDAllSize() {
        // 取得SD卡文件路径
        File path = Environment.getExternalStorageDirectory();
        StatFs sf = new StatFs(path.getPath());
        // 获取单个数据块的大小(Byte)
        long blockSize = sf.getBlockSize();
        // 获取所有数据块数
        long allBlocks = sf.getBlockCount();
        // 返回SD卡大小
        return allBlocks * blockSize; // 单位Byte
    }

}