package com.xpc.fit.result;

public class ErrorResult extends Result {
    public ErrorResult(int code,String msg){
        super();
        this.code = code;
        this.msg = msg;
    }
}
