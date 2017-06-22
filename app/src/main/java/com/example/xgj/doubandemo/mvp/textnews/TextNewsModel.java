package com.example.xgj.doubandemo.mvp.textnews;

import com.example.xgj.doubandemo.base.BaseModel;
import com.example.xgj.doubandemo.base.BaseObserver;
import com.example.xgj.doubandemo.netutils.RetrofitFactory;
import com.example.xgj.mybaselibrary.base.MyBaseApplication;
import com.example.xgj.mybaselibrary.utils.RxUtils;

/**
 * Created by chen on 2017/6/20.
 */

public class TextNewsModel extends BaseModel {
    private TextNewsPresenter textNewsPresenter;

    public TextNewsModel(TextNewsPresenter textNewsPresenter) {
        this.textNewsPresenter = textNewsPresenter;
    }


    public void subscribe(int page) {

        //        observable = RetrofitFactory.getInstance().initRetrofit().getDatas("6000000395","w","15");
        observable = RetrofitFactory.getInstance().initRetrofit().getAllVedio(true);
        //        observable = RetrofitFactory.getInstance().initRetrofit().getTexts(1);
        observable.compose(RxUtils.rxSchedulerHelper()).subscribe(new BaseObserver(MyBaseApplication.getBaseApplication(), MyBaseApplication.getBaseApplication().progressDialog()) {



            @Override
            protected void onHandleSuccess(Object o) {
                textNewsPresenter.upView(o);
            }




        });

    }
}
