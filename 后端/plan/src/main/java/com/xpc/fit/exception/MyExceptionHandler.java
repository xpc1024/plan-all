package com.xpc.fit.exception;

import com.xpc.fit.result.ErrorResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class MyExceptionHandler {
    private Logger logger = LoggerFactory.getLogger(MyExceptionHandler.class);
    /**
     * 拦截已定义的业务异常
     */
    @ExceptionHandler(MyException.class)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public ErrorResult myException(MyException e){
        logger.error("已知的自定义异常:",e);
        return new ErrorResult(e.getCode(),e.getMsg());
    }

    /**
     * 拦截运行时的未知异常
     */
    @ExceptionHandler(RuntimeException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public ErrorResult myException(RuntimeException e){
        logger.error("未知的系统异常:",e);
        return new ErrorResult(ExceptionEnum.UNKNOWN_ERROR.getCode(),ExceptionEnum.UNKNOWN_ERROR.getMsg());
    }
}
