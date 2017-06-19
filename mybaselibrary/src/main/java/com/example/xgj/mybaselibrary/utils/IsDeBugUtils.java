package com.example.xgj.mybaselibrary.utils;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;

/**
 * Created by chen on 2017/6/19.
 */

public class IsDeBugUtils {

    /**
     * 判断当前应用是否是debug状态
     */

    public static boolean isInDebug(Context context) {
        try {
            ApplicationInfo info = context.getApplicationInfo();
            return (info.flags & ApplicationInfo.FLAG_DEBUGGABLE) != 0;

        } catch (Exception e) {
            return false;
        }
    }

    /**
     * 检测其他应用是否处于debug模式。
     */

    public static boolean isApkDebugable(Context context, String packageName) {
        try {
            PackageInfo pkginfo = context.getPackageManager().getPackageInfo(
                    packageName, 1);
            if (pkginfo != null) {
                ApplicationInfo info = pkginfo.applicationInfo;
                return (info.flags & ApplicationInfo.FLAG_DEBUGGABLE) != 0;
            }

        } catch (Exception e) {

        }
        return false;
    }
}

