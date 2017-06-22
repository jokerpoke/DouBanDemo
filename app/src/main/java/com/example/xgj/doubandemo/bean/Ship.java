package com.example.xgj.doubandemo.bean;

import java.io.Serializable;

import static android.R.attr.data;

/**
 * Created by chen on 2017/6/22.
 */

public class Ship implements Serializable {

    /**
     * ret : 1
     * msg : 成功
     * data : [{" id":0,"name":"qianyan.mp4","url":"","title":" 前言"}]
     */
    //后台回传回来的json数据格式 ，必须，否则报错
    //    {
    //        "ret": 1,
    //            "msg": "成功",
    //            "data": [
    //        {
    //            " id": 0,
    //                "name": "qianyan.mp4",
    //                "url": "",
    //                "title": " 前言"
    //        }
    //    ]
    //    }

    //    private int ret;
    //    private String msg;
    //    private List<DataBean> data;

    //    public static class DataBean {
    /**
     * id : 0
     * name : qianyan.mp4
     * url :
     * title :  前言
     */

    private int id;
    private String name;
    private String url;
    private String title;
    //    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Ship{" +
                //                "ret=" + ret +
                //                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }

    //    public int getRet() {
    //        return ret;
    //    }
    //
    //    public void setRet(int ret) {
    //        this.ret = ret;
    //    }
    //
    //    public String getMsg() {
    //        return msg;
    //    }
    //
    //    public void setMsg(String msg) {
    //        this.msg = msg;
    //    }
    //
    //    public List<DataBean> getData() {
    //        return data;
    //    }
    //
    //    public void setData(List<DataBean> data) {
    //        this.data = data;
    //    }
}
