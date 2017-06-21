package com.example.xgj.doubandemo.mvp.textnews;

import com.example.xgj.doubandemo.base.BasePresenter;

/**
 * Created by chen on 2017/6/20.
 */

public class TextNewsPresenter extends BasePresenter implements TextNewsContract.Presenter {
    private TextNewsContract.View mView;
    private TextNewsModel textNewsModel;





    public TextNewsPresenter(TextNewsContract.View mView) {
        this.textNewsModel=new TextNewsModel(this);
        this.mView = mView;
        mView.setPresenter(this);
    }


//    public void updataModel(int page) {

        //        subscribe(page);

//    }

//    public void subscribe(int page) {
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
//    }


    @Override
    public void upModel(Object o) {
        textNewsModel.subscribe((int) o);
    }

    @Override
    public void upView(Object o) {
        mView.getModel(o);
    }


}
