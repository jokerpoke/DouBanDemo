package com.example.xgj.doubandemo.netutils;

import android.content.Context;

import okhttp3.Cache;

/**
 * Created by chen on 2017/7/24.
 */

public class CacheProvide {
    Context mContext;

    public CacheProvide(Context context) {
        mContext = context;
    }

    public Cache provideCache() {//使用应用缓存文件路径，缓存大小为10MB
        return new Cache(mContext.getCacheDir(), 1024 * 1024 * 10);
    }
}