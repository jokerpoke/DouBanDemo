package com.example.xgj.doubandemo.mvp.textnews;

import com.example.xgj.doubandemo.base.BasePresenterInterface;
import com.example.xgj.doubandemo.base.BaseView;

/**
 * Created by chen on 2017/6/20.
 */

public interface TextNewsContract {

    interface View extends BaseView<Presenter> {
        void getModel(Object o);//object可以改为当前需要的bean如Ship
    }

    interface Presenter extends BasePresenterInterface {


    }
}

