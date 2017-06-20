package com.example.xgj.doubandemo.base;

import com.example.xgj.mybaselibrary.base.MyBaseActivity;

import butterknife.ButterKnife;

public abstract class BaseActivity extends MyBaseActivity {
    @Override
    protected void getButterKnifeBind() {
        ButterKnife.bind(this);
    }

    //    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_base);
//    }
}
