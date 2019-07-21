package com.coolchatting.netty.protocol;

import java.io.Serializable;

public class RpcResponse implements Serializable {
    private int code;
    private String msg;
    private Object data;

    public RpcResponse(int code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

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

    public static RpcResponse buildSucess(Object data) {
        return new RpcResponse(1, "操作成功", data);
    }

    public static RpcResponse buildFailure(Object data) {
        return new RpcResponse(-1, "操作失败", data);
    }

    @Override
    public String toString() {
        return "RpcResponse{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }
}
