package com.example.xgj.doubandemo.base;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.example.xgj.doubandemo.R;
import com.example.xgj.mybaselibrary.base.MyBaseActivity;

import butterknife.ButterKnife;

public abstract class BaseActivity extends MyBaseActivity {
    public static Context mcontext;
    private LayoutInflater layoutInflater;
    protected View mView;

   private FrameLayout fl_container;
   private  TextView tv_title;
    private Toolbar toolbar;

//    @Override
//    protected void getButterKnifeBind() {

//        mcontext = this;
//    }

    @Override
    protected int getResLayoutId(Bundle savedInstanceState) {
        return R.layout.base_titlebar;
    }

    @Override
    protected void initView() {
        mcontext=this;

        fl_container= (FrameLayout) this.findViewById( R.id.base_titlebar_fl_container);
        tv_title= (TextView) this.findViewById(R.id.base_titlebar_tv_title);
        toolbar= (Toolbar) this.findViewById(R.id.base_titlebar_toolbar);

        toolbar.setNavigationIcon(R.mipmap.ic_launcher_round);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        tv_title.setText(getPageTitle());//设置标题

        mView = layoutInflater.from(mcontext).inflate(addChildView(),fl_container,false);
        fl_container.addView(mView);
        ButterKnife.bind(this);
        initChildContentView();
    }

    protected abstract int addChildView();

    protected abstract void initChildContentView();

    /**
     * 获取页面标题
     *
     * @return
     */
    protected abstract CharSequence getPageTitle();
}