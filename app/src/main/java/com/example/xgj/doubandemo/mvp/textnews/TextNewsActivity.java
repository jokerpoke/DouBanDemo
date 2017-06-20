package com.example.xgj.doubandemo.mvp.textnews;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;

import com.example.xgj.doubandemo.R;
import com.example.xgj.doubandemo.base.BaseActivity;
import com.example.xgj.mybaselibrary.utils.LogsUtils;

import butterknife.BindView;

public class TextNewsActivity extends BaseActivity implements TextNewsPresenter.TextNewsPresenterCallBack {
    @BindView(R.id.LatestActivity_rvlist)
    RecyclerView rv_list;
    @BindView(R.id.LatestActivity_srflayout)
    SwipeRefreshLayout srf_layout;
    int page=1;


    private TextNewsPresenter textNewsPresenter;


    @Override
    protected int getResLayoutId(Bundle savedInstanceState) {
        return R.layout.activity_latest;
    }


    @Override
    protected void onPresenter() {
        textNewsPresenter = new TextNewsPresenter(this);

        textNewsPresenter.updataModel(page);

    }

    @Override
    protected void initView() {
        srf_layout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                if (srf_layout.isRefreshing()){
                    textNewsPresenter.updataModel(++page);
                }
            }
        });
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initIntentData() {

    }

    //得到presenter解析回调的数据
    @Override
    public void getModel(Object o) {

        LogsUtils.d(o.toString());
    }


}