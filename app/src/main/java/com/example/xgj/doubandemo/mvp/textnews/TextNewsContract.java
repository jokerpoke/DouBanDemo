package com.example.xgj.doubandemo.mvp.textnews;

import com.example.xgj.doubandemo.base.BasePresenterInterface;
import com.example.xgj.doubandemo.base.BaseView;

/**
 * Created by chen on 2017/6/20.
 */

public interface TextNewsContract {

    interface View extends BaseView<Presenter> {
        void getModel(Object o);
    }

    interface Presenter extends BasePresenterInterface {


    }
}

