package com.example.xgj.doubandemo.mvp.textnews;

import com.example.xgj.doubandemo.mvp.latest.LatestContract;
import com.example.xgj.doubandemo.netutils.RetrofitService;
import com.example.xgj.mybaselibrary.utils.LogsUtils;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * Created by chen on 2017/6/20.
 */

public class TextNewsPresenter implements LatestContract.Presenter {
    private LatestContract.View mView;
    private TextNewsPresenterCallBack callBack;


    public void setCallBack(TextNewsPresenterCallBack callBack) {
        this.callBack = callBack;
    }

    public TextNewsPresenter(TextNewsPresenterCallBack callBack) {
        this.callBack = callBack;
    }

    public void updataModel(int page) {

        subscribe(page);
    }

    public void subscribe(int page) {
        RetrofitService
                .getInstance()
                .getTextData(page)
                .subscribe(new Observer<Object>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(Object o) {
                        callBack.getModel(o);
                    }

                    @Override
                    public void onError(Throwable e) {
                        LogsUtils.e("TextNewsPresenter", e.toString());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }


    @Override
    public void subscribe() {

    }

    @Override
    public void unsubscribe() {

    }

    public interface TextNewsPresenterCallBack {
        void getModel(Object o);
    }

}
