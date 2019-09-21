package com.liyang.common;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * 响应数据的实体类
 */
public class ReturnMakeJson implements Serializable {
    private static int returnCode = 200;
    private static String returnMsg = "调用成功";
    private static Object data = null;
    private static String version = "springboot-demo:v20190921.1";

    public ReturnMakeJson(int returnCode,String returnMsg,Object data){
        this.returnCode = returnCode;
        this.returnMsg = returnMsg;
        this.data = data;
    }
    public ReturnMakeJson(){}
    public Object getData() {
        return data;
    }

    public int getReturnCode() {
        return returnCode;
    }

    public String getReturnMsg() {
        return returnMsg;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public void setReturnCode(int returnCode) {
        this.returnCode = returnCode;
    }

    public void setReturnMsg(String returnMsg) {
        this.returnMsg = returnMsg;
    }

    public  Map<String,Object> result(){
        Map map = new HashMap();
        map.put("retrun_code",returnCode);
        map.put("return_msg",returnMsg);
        map.put("data",data);
        map.put("version",version);
        return map;
    }
}
