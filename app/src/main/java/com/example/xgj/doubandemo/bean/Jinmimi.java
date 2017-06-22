package com.example.xgj.doubandemo.bean;

/**
 * Created by chen on 2017/6/22.
 */

public class Jinmimi {

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    /**
     * orderNo : 11
     * resultCode : 0
     * errorMsg : 获取二维码成功
     * code_url : https: //myun.tenpay.com/mqq/pay/qrcode.html?_wv=1027&_bid=2183&t=5Vb74557979176cce01b48106d90f95a
     */

    private String orderNo;
    private int resultCode;
    private String errorMsg;
    private String code_url;



    public int getResultCode() {
        return resultCode;
    }

    public void setResultCode(int resultCode) {
        this.resultCode = resultCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public String getCode_url() {
        return code_url;
    }

    public void setCode_url(String code_url) {
        this.code_url = code_url;
    }
}
