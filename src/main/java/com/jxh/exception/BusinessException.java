package com.jxh.exception;

/**
 * @author meizh
 * 自定义异常
 */
public class BusinessException extends RuntimeException{
    public BusinessException() {
    }

    public BusinessException(String message) {
        super(message);
    }
}
