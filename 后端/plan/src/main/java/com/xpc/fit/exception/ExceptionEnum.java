package com.xpc.fit.exception;

public enum ExceptionEnum {
    UNKNOWN_ERROR(-1,"未知错误")
    ;
    private Integer code;
    private String msg;
    ExceptionEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
