package com.example.xgj.doubandemo.mvp.textnews;

import com.example.xgj.doubandemo.base.BasePresenter;

/**
 * Created by chen on 2017/6/20.
 */

public class TextNewsPresenter extends BasePresenter implements TextNewsContract.Presenter {
    private TextNewsContract.View mView;
    private TextNewsModel textNewsModel;


    public TextNewsPresenter(TextNewsContract.View mView) {
        this.textNewsModel = new TextNewsModel(this);
        this.mView = mView;
        mView.setPresenter(this);
    }


    @Override
    public void upModel(Object o) {
        textNewsModel.subscribe((int) o);
    }

    @Override
    public void upView(Object o) {
        mView.getModel(o);
    }


}
