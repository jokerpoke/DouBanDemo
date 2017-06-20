package com.example.xgj.mybaselibrary.base;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public abstract class MyBaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initContentView(savedInstanceState);
        getButterKnifeBind();// 在外部调用ButterKnife.bind(this);
        //        setContentView(R.layout.activity_base);
        init();
    }

    private void initContentView(Bundle savedInstanceState) {
        Object layoutResIdOrView = getResLayoutId(savedInstanceState);
        if (layoutResIdOrView == null) {
            throw new IllegalArgumentException("layoutResIdOrView can not be null");
        }
        if (layoutResIdOrView instanceof Integer) {
            setContentView((Integer) layoutResIdOrView);
        } else {
            setContentView((View) layoutResIdOrView);
        }
    }


    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
        init();
    }

    private void init() {

        initIntentData();
        onPresenter();
        initData();
        initView();

    }


    @Override
    protected void onStart() {
        super.onStart();

    }

    protected abstract int getResLayoutId(Bundle savedInstanceState);

    protected abstract void getButterKnifeBind();

    protected abstract void onPresenter();

    protected abstract void initView();

    protected abstract void initData();//得到自身解析得到的数据

    protected abstract void initIntentData();//得到intent传递的数据
}
