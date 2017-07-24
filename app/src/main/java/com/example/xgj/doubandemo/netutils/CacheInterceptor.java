package com.example.xgj.doubandemo.netutils;

import android.text.TextUtils;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by chen on 2017/7/24.
 */

public class CacheInterceptor implements Interceptor {
    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
        Response response = chain.proceed(request);
        String cache = request.header("Cache-Time");
        if (!TextUtils.isEmpty(cache)) {//缓存时间不为空
            Response response1 = response.newBuilder()
                    .removeHeader("Pragma")
                    .removeHeader("Cache-Control")
                    //cache for cache seconds
                    .header("Cache-Control", "max-age="+ 3600 * 24 * 30)
                    .build();
            return response1;
        } else {
            return response;
        }
    }
}