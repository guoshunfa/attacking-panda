package com.panda.common.exception;

/**
 * 用户名存在 异常类
 *
 * @className: UsernameIsExitedException
 * @author: GuoShunFa
 * @date: 2022/11/11
 */
public class UsernameIsExistedException extends ServiceException {

    public UsernameIsExistedException(String msg) {
        super(msg);
    }

    public UsernameIsExistedException(String msg, Throwable t) {
        super(msg, t);
    }
}