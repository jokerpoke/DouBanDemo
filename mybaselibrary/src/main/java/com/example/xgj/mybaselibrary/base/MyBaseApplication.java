package com.example.xgj.mybaselibrary.base;

import android.app.Application;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.widget.Toast;

import com.example.xgj.mybaselibrary.utils.IsDeBugUtils;

/**
 * Created by chen on 2017/6/19.
 */

public class MyBaseApplication extends Application {
    public static MyBaseApplication myBaseApplication;

    private static Toast toast;


    public static MyBaseApplication getBaseApplication() {
        return myBaseApplication;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        this.myBaseApplication = this;
        IsDeBugUtils.isInDebug(this);// debug包为true，release包为false
        //        if (NetUtil.isNetConnection(myBaseApplication)) {
        //            //网络请求操作
        //
        //        }
        //        //        else if (NetUtil.isWifiConnection(baseApplication)) {
        //        //            showToast("你现在正在非WIFI下浏览，请注意！", 1);
        //        //        }
        //        else {
        //            showToast("请检查网络是否已连接", 1);
        //        }


    }

    /**
     * 当time =0时，toast显示的时间为短，
     * 当time=1时，toast显示的时间为long
     *
     * @param str
     * @param time
     */
    public void showToast(String str, int time) {
        if (toast == null) {
            if (time == 0) {
                toast = Toast.makeText(myBaseApplication,
                        str,
                        Toast.LENGTH_SHORT);
            } else if (time == 1) {
                toast = Toast.makeText(myBaseApplication,
                        str,
                        Toast.LENGTH_SHORT);
            }
        } else {
            toast.setText(str);
        }
        toast.show();
    }

    public void ShowAlertDialog(String title, String message, int icon) {
        AlertDialog.Builder dialog = new AlertDialog.Builder(myBaseApplication);
        dialog.setTitle(title);
        dialog.setMessage(message);
        dialog.setIcon(icon);
        dialog.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //初始化网络请求
                dialog.dismiss();
            }
        });
        dialog.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //网络请求取消
                dialog.dismiss();
            }
        });
    }

    public ProgressDialog pd;

    public ProgressDialog progressDialog() {
        return pd = new ProgressDialog(MyBaseApplication.getBaseApplication());
    }

    //
    //    public static void showToast(Context context,
    //                                 String content) {
    //        if (toast == null) {
    //            toast = Toast.makeText(context,
    //                    content,
    //                    Toast.LENGTH_SHORT);
    //        } else {
    //            toast.setText(content);
    //        }
    //        toast.show();
    //    }

}
