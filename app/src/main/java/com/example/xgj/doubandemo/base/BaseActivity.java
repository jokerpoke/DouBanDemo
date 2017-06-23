package com.example.xgj.doubandemo.base;

import android.content.Context;

import com.example.xgj.mybaselibrary.base.MyBaseActivity;

import butterknife.ButterKnife;

public abstract class BaseActivity extends MyBaseActivity {
    public  static Context mcontext;
    @Override
    protected void getButterKnifeBind() {
        ButterKnife.bind(this);
        mcontext=this;
    }


    //        @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
////        setContentView(R.layout.activity_base);
//    }
}
