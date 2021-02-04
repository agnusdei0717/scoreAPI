package com.bofa.payment.scoreAPI.pojo;


import com.bofa.payment.scoreAPI.utils.ObjTransJsonUtil;
import com.fasterxml.jackson.databind.util.JSONPObject;

public class ResultJSONObj {

    private boolean result = false;
    private String status;
    private String msg;
    private String data;

    public boolean isResult() {
        return result;
    }

    public ResultJSONObj setResult(boolean result) {
        this.result = result;
        return this;
    }

    public String getStatus() {
        return status;
    }

    public ResultJSONObj setStatus(String status) {
        this.status = status;
        return this;
    }

    public String getMsg() {
        return msg;
    }

    public ResultJSONObj setMsg(String msg) {
        this.msg = msg;
        return this;
    }

    public String getData() {
        return data;
    }

    public ResultJSONObj setData(String data) {
        this.data = data;
        return this;
    }

    @Override
    public String toString(){
        try {
            return ObjTransJsonUtil.objToJson(this);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

}
