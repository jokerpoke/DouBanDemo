package com.example.xgj.doubandemo.mvp.textnews;

import com.example.xgj.doubandemo.base.BaseModel;
import com.example.xgj.doubandemo.base.BaseObserver;
import com.example.xgj.doubandemo.netutils.RetrofitFactory;
import com.example.xgj.mybaselibrary.base.MyBaseApplication;
import com.example.xgj.mybaselibrary.utils.RxUtils;

import io.reactivex.Observer;

/**
 * Created by chen on 2017/6/20.
 */

public class TextNewsModel extends BaseModel {
    private TextNewsPresenter textNewsPresenter;

    public TextNewsModel(TextNewsPresenter textNewsPresenter) {
        this.textNewsPresenter = textNewsPresenter;
    }


    public void subscribe(int page) {

//        observable = RetrofitFactory.getInstance().initRetrofit().getTexts(page);
//        observable.compose(RxUtils.<TextEntity.ItemsBean>rxSchedulerHelper()).subscribe(new BaseObserver<TextEntity.ItemsBean>(MyBaseApplication.getBaseApplication(), MyBaseApplication.getBaseApplication().progressDialog()) {
//
//            @Override
//            protected void onHandleSuccess(TextEntity.ItemsBean textEntity) {
//                Log.d(TAG, "onHandleSuccess: =="+textEntity.toString());
//            }
//
//
//
////            @Override
////            protected void onHandleSuccess(TextEntity.ItemsBean itemsBean) {
////
////            }
//            //
//            //            @Override
//            //            protected void onHandleSuccess(Object o) {
//            //                LogsUtils.d(o.toString());
//            //                textNewsPresenter.upView(o);
//            //            }
//        });
observable= RetrofitFactory.getInstance().initRetrofit().getDatas("6000000395","w","14");
        observable.compose(RxUtils.<Object>rxSchedulerHelper()).subscribe(new BaseObserver<Observer>(MyBaseApplication.getBaseApplication(),MyBaseApplication.getBaseApplication().progressDialog()) {
            @Override
            protected void onHandleSuccess(Observer observer) {

            }


        });

    }
}
