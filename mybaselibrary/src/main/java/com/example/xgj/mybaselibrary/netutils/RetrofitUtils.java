package com.example.xgj.mybaselibrary.netutils;

import android.app.Service;

import retrofit2.GsonConverterFactory;
import retrofit2.Retrofit;

/**
 * Created by chen on 2017/6/19.
 */

public class RetrofitUtils {
    protected Service mService;
    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://api.github.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build();
    public void start(){
//        retrofit.create()
    }

}
