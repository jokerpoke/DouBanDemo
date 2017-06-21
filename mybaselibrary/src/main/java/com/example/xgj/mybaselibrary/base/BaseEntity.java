package com.example.xgj.mybaselibrary.base;

import java.io.Serializable;

/**
 * Created by chen on 2017/6/20.
 */

public class BaseEntity<E> implements Serializable {


    private int code;//code表示成功还是失败，0为成功，非0为失败
    private String message;//message是提示内容，而主要的内容都封装在data里面，
    private Date<E> data;//data为泛型，可以指定为任何内容



    private int count;
    private int err;
    private int total;
    private int page;
    private int refresh;


    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
//
//    public E getData() {
//        return data;
//    }
//
//    public void setData(E data) {
//        this.data = data;
//    }


    public class Date<E> {
        public  E datainn1;//data为泛型，可以指定为任何内容
        public  E datainn2;//data为泛型，可以指定为任何内容
    }

}
