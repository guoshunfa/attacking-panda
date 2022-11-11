package com.panda.framework.handler;

import com.panda.common.result.ApiResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 异常处理器
 *
 * @author GuoShunFa
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     * 兜底异常，其他异常都没有匹配到的会来到这个方法进行处理。
     */
    @ExceptionHandler({Exception.class})
    public ApiResult Exception(Exception e) {
        return ApiResult.fail("Exception:" + e);
    }

}
