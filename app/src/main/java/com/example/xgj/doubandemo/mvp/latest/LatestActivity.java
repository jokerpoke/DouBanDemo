package com.example.xgj.doubandemo.mvp.latest;

import android.os.Bundle;
import android.widget.TextView;

import com.example.xgj.doubandemo.R;
import com.example.xgj.doubandemo.base.BaseActivity;

import butterknife.BindView;

public class LatestActivity extends BaseActivity {
    @BindView(R.id.LatestActivity_tv_testId)
    TextView tv_testid;

    private LatestPresenter latestPresenter;

    @Override
    protected int getResLayoutId(Bundle savedInstanceState) {
        return R.layout.activity_latest;
    }


    @Override
    protected void onPresenter() {
        latestPresenter = new LatestPresenter();

    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initIntentData() {

    }

    //    @Override
    //    protected void onCreate(Bundle savedInstanceState) {
    //        super.onCreate(savedInstanceState);
    //        setContentView(R.layout.activity_latest);
    //    }
}
