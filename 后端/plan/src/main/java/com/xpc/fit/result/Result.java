package com.xpc.fit.result;

import lombok.Data;

@Data
public class Result {
    protected Integer code;
    protected String msg;
    protected Object data;
}
