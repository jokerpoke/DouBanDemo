package com.example.xgj.doubandemo.base;

import java.io.Serializable;

/**
 * Created by chen on 2017/6/20.
 */

public class BaseEntity<E> implements Serializable {


//    private int code;//code表示成功还是失败，0为成功，非0为失败
//    private String message;//message是提示内容，而主要的内容都封装在data里面，
//    private E data;//data为泛型，可以指定为任何内容
//
//    public int getCode() {
//        return code;
//    }
//
//    public void setCode(int code) {
//        this.code = code;
//    }
//
//    public String getMessage() {
//        return message;
//    }
//
//    public void setMessage(String message) {
//        this.message = message;
//    }
//
//    public E getData() {
//        return data;
//    }
//
//    public void setData(E data) {
//        this.data = data;
//    }

    private int count;
    private int err;
    private int total;
    private int page;
    private int refresh;
    private E data;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getErr() {
        return err;
    }

    public void setErr(int err) {
        this.err = err;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getRefresh() {
        return refresh;
    }

    public void setRefresh(int refresh) {
        this.refresh = refresh;
    }

    public E getData() {
        return data;
    }

    public void setData(E data) {
        this.data = data;
    }
}
