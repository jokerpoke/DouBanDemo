package com.example.xgj.mybaselibrary.utils;

/**
 * Created by chen on 2017/4/28.
 */


import android.util.Log;

import com.example.xgj.mybaselibrary.base.BaseApplication;

/**
 * Log统一管理类
 *
 * @author way
 */
public class LogsUtils {

    private LogsUtils() {
        /* cannot be instantiated */
        throw new UnsupportedOperationException("cannot be instantiated");
    }

    // debug包为true，release包为false
    public static boolean isDebug = IsDeBugUtils.isInDebug(BaseApplication.getBaseApplication());
    private static final String TAG = "Demo_Chen_Test=";


    // 下面四个是默认tag的函数
    public static void i(String msg) {
        if (isDebug)
            Log.i(TAG, msg);
    }

    public static void d(String msg) {
        if (isDebug)
            Log.d(TAG, msg);
    }

    public static void e(String msg) {
        if (isDebug)
            Log.e(TAG, msg);
    }

    public static void v(String msg) {
        if (isDebug)
            Log.v(TAG, msg);
    }

    // 下面是传入自定义tag的函数
    public static void i(String tag, String msg) {
        if (isDebug)
            Log.i(tag, msg);
    }

    public static void d(String tag, String msg) {
        if (isDebug)
            Log.d(tag, msg);
    }

    public static void e(String tag, String msg) {
        if (isDebug)
            Log.e(tag, msg);
    }

    public static void v(String tag, String msg) {
        if (isDebug)
            Log.i(tag, msg);
    }
}
