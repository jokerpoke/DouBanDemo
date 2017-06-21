package com.example.xgj.doubandemo.mvp.textnews;

import com.example.xgj.doubandemo.base.BasePresenter;
import com.example.xgj.doubandemo.mvp.latest.LatestContract;

/**
 * Created by chen on 2017/6/20.
 */

public class TextNewsPresenter  extends BasePresenter implements LatestContract.Presenter {
    private LatestContract.View mView;
    private TextNewsPresenterCallBack callBack;
    private TextNewsModel textNewsModel;


    public void setCallBack(TextNewsPresenterCallBack callBack) {
        this.callBack = callBack;
    }

    public TextNewsPresenter(TextNewsPresenterCallBack callBack) {
        this.textNewsModel=new TextNewsModel(this);
        this.callBack = callBack;
    }

    public void updataModel(int page) {

//        subscribe(page);
        textNewsModel.subscribe(page);
    }

    public void subscribe(int page) {
//        RetrofitService
//                .getInstance()
//                .getTextData(page)
//                .subscribe(new Observer<Object>() {
//                    @Override
//                    public void onSubscribe(Disposable d) {
//
//                    }
//
//                    @Override
//                    public void onNext(Object o) {
//
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//                        LogsUtils.e("TextNewsPresenter", e.toString());
//                    }
//
//                    @Override
//                    public void onComplete() {
//
//                    }
//                });
    }



    @Override
    public void updata() {

    }

    @Override
    public void upView() {

    }
    public void upView(Object o) {
        callBack.getModel(o);
    }

    public interface TextNewsPresenterCallBack {
        void getModel(Object o);
    }

}
