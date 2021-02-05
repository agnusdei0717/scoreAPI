package com.bofa.payment.scoreAPI.Component;


import com.bofa.payment.scoreAPI.utils.ObjTransJsonUtil;
import net.sf.json.JSONObject;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(value = "prototype")
public class ResultJSONObj {

    private boolean result = false;
    private String status;
    private String msg;
    private JSONObject data = new JSONObject();

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

    public JSONObject getData() {
        return data;
    }

    public ResultJSONObj setData(JSONObject data) {
        this.data = data;
        return this;
    }

    public ResultJSONObj addData(String key, Object value){
        try{
            JSONObject json = JSONObject.fromObject(value);
            this.data.put(key,json);
        }catch(Exception e){
            this.data.put(key,value);
        }
        return  this;
    }

    public ResultJSONObj removeData(String key){
        this.data.remove(key);
        return  this;
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
