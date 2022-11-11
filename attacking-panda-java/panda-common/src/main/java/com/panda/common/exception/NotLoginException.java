package com.panda.common.exception;

/**
 * 没有登陆 异常类
 *
 * @className: NotLoginException
 * @author: GuoShunFa
 * @date: 2022/11/11
 **/
public class NotLoginException extends RuntimeException {

    public NotLoginException(String message) {
        super(message);
    }

    public NotLoginException(String message, Throwable cause) {
        super(message, cause);
    }

}
