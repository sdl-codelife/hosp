package com.sdl.hosp.model.dto;

public class ResponseBean {
    
    // http 状态码
    private  int code;

    // 返回信息
    private  String msg;

    // 返回的数据
    private  Object data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public ResponseBean() {
    }

    public ResponseBean(int code,String msg,Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public static ResponseBean success(String msg){
        return new ResponseBean(200,msg,null);
    }
    public static ResponseBean success(String msg,Object data){
        return new ResponseBean(200,msg,data);
    }
    public static ResponseBean error(String msg){
        return new ResponseBean(500,msg,null);
    }
}