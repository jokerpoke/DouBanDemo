package com.example.xgj.mybaselibrary.base;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public abstract class MyBaseActivity extends AppCompatActivity {


    public ProgressDialog pd;
//    public Function<Observable, ObservableSource> composeFunction;
    private final long RETRY_TIMES = 1;
    private boolean showLoading = true;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);//去掉了默认的导航栏
//        getToolbarLayoutId();
        initContentView(savedInstanceState);

//        initView();
        //        setContentView(R.layout.activity_base);

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
//        initNet();
        onPresenter();
        initData();


    }

    private void initNet() {
        pd = new ProgressDialog(this);
        if (pd!=null&&!pd.isShowing()){
            pd.show();
        }

//        composeFunction = new Function<Observable, ObservableSource>() {
//            @Override
//            public ObservableSource apply(Observable observable) throws Exception {
//                return observable.retry(RETRY_TIMES)
//                        .subscribeOn(Schedulers.io())
//                        .doOnSubscribe(new Consumer<Disposable>() {
//                            @Override
//                            public void accept(Disposable disposable) throws Exception {
//                                if (NetworkUtil.isNetworkAvailable(MyBaseActivity.this)) {
//                                    if (showLoading) {
//                                        if(pd != null && !pd.isShowing()){
//                                            pd.show();
//                                        }
//                                    }
//                                } else {
//                                    Toast.makeText(MyBaseActivity.this, "网络连接异常，请检查网络", Toast.LENGTH_LONG).show();
//                                }
//                            }
//                        })
//                        .observeOn(AndroidSchedulers.mainThread());
//            }
//        };
    }

    public void setLoadingFlag(boolean show) {
        showLoading = show;
    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
//        getButterKnifeBind();// 在外部调用ButterKnife.bind(this);
        initView();
        init();
    }

    @Override
    protected void onStop() {
        super.onStop();

        if (pd != null && pd.isShowing()) {
            pd.dismiss();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        relievePresenter();
    }

    protected abstract int getResLayoutId(Bundle savedInstanceState);

//    protected  abstract int getToolbarLayoutId();

//    protected abstract void getButterKnifeBind();

    protected abstract void onPresenter();

    protected abstract void initView();

    protected abstract void initData();//得到自身解析得到的数据

    protected abstract void initIntentData();//得到intent传递的数据

    protected  abstract  void relievePresenter();
}
