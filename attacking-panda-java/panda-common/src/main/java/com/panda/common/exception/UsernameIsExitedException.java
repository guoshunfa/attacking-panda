package com.panda.common.exception;

/**
 * 用户名存在 异常类
 *
 * @className: ServiceException
 * @author: GuoShunFa
 * @date: 2022/11/11
 */
public class UsernameIsExitedException extends ServiceException {

    public UsernameIsExitedException(String msg) {
        super(msg);
    }

    public UsernameIsExitedException(String msg, Throwable t) {
        super(msg, t);
    }
}