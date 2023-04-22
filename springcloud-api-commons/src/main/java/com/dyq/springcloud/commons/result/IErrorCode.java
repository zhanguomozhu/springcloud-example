package com.dyq.springcloud.commons.result;

/**
 * 封装API的错误码
 */
public interface IErrorCode {

    long getCode();

    String getMessage();
}
