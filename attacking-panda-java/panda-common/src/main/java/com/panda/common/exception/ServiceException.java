package com.panda.common.exception;

/**
 * 接口 异常类
 *
 * @className: ServiceException
 * @author: GuoShunFa
 * @date: 2022/11/11
 */
public class ServiceException extends RuntimeException {

    public ServiceException(String message) {
        super(message);
    }

    public ServiceException(String message, Throwable cause) {
        super(message, cause);
    }
}

