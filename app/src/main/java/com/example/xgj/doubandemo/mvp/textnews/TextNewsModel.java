package com.example.xgj.doubandemo.mvp.textnews;

import com.example.xgj.doubandemo.base.BaseModel;
import com.example.xgj.doubandemo.base.BaseObserver;
import com.example.xgj.doubandemo.netutils.RetrofitFactory;
import com.example.xgj.mybaselibrary.base.MyBaseApplication;
import com.example.xgj.mybaselibrary.utils.LogsUtils;
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

        observable = RetrofitFactory.getInstance().initRetrofit().getTexts(page);
        observable.compose(RxUtils.<Object>rxSchedulerHelper()).subscribe(new BaseObserver<Object>(MyBaseApplication.getBaseApplication(), MyBaseApplication.getBaseApplication().progressDialog()) {

            @Override
            protected void onHandleSuccess(Object o) {
                LogsUtils.d(o.toString());
                textNewsPresenter.upView(o);
            }
        });


    }
}
