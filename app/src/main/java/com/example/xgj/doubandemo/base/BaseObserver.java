package com.example.xgj.doubandemo.base;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.widget.Toast;

import com.example.xgj.mybaselibrary.base.BaseEntity;
import com.example.xgj.mybaselibrary.utils.LogsUtils;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * Created by chen on 2017/6/21.
 */
//当格式符合要求时，使用Observer<BaseEntity<T>>
public abstract class BaseObserver<T> implements Observer<BaseEntity<T>> {
    private Context mContext;
    private ProgressDialog mDialog;
    private Disposable mDisposable;
    private final int SUCCESS_CODE = 1;


    public BaseObserver(Context context) {
        mContext = context;
        mDialog = new ProgressDialog(context);
        mDialog.setMessage("数据正在加载。");
        mDialog.setOnCancelListener(new DialogInterface.OnCancelListener() {
            @Override
            public void onCancel(DialogInterface dialog) {
                mDisposable.dispose();
            }
        });
        mDialog.show();
    }

    @Override
    public void onSubscribe(Disposable d) {
        mDisposable = d;

    }

    @Override
    public void onNext(BaseEntity<T> value) {
        if (value.getRet() == SUCCESS_CODE && "成功".equals(value.getMsg())) {
            T t = value.getData();
            onHandleSuccess(t);
        } else {
            onHandleError(value.getRet(), value.getMsg());
        }
    }

    @Override
    public void onError(Throwable e) {
        LogsUtils.d("chen",e.toString());

        if (mDialog != null && mDialog.isShowing()) {
            mDialog.dismiss();
        }

        Toast.makeText(mContext, "网络异常，请稍后再试", Toast.LENGTH_LONG).show();
    }

    @Override
    public void onComplete() {
        LogsUtils.d("chen","onComplete");
        if (mDialog != null && mDialog.isShowing()) {
            mDialog.dismiss();
        }
    }

    protected abstract void onHandleSuccess(T t);

    void onHandleError(int code, String message) {
        Toast.makeText(mContext, message, Toast.LENGTH_LONG).show();
    }
}
