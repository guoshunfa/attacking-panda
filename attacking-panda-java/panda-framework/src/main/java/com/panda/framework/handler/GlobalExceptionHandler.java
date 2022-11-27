package com.panda.framework.handler;

import com.panda.common.exception.ServiceException;
import com.panda.common.exception.UsernameIsExistedException;
import com.panda.common.result.ApiResult;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.servlet.NoHandlerFoundException;

import javax.servlet.http.HttpServletResponse;
import java.net.ConnectException;

/**
 * 异常处理器
 *
 * @author GuoShunFa
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @ExceptionHandler(BadCredentialsException.class)
    public ApiResult handlerNoFoundException(BadCredentialsException e) {
        logger.error(e.getMessage(), e);
        return ApiResult.fail(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "密码错误");
    }

    @ExceptionHandler(NoHandlerFoundException.class)
    public ApiResult handlerNoFoundException(Exception e) {
        logger.error(e.getMessage(), e);
        return ApiResult.fail(HttpServletResponse.SC_NOT_FOUND, "路径不存在，请检查路径是否正确");
    }

    @ExceptionHandler(DuplicateKeyException.class)
    public ApiResult handleDuplicateKeyException(DuplicateKeyException e) {
        logger.error(e.getMessage(), e);
        return ApiResult.fail("数据库中已存在该记录");
    }

    @ExceptionHandler(UsernameIsExistedException.class)
    public ApiResult usernameIsExitedException(UsernameIsExistedException e) {
        logger.error(e.getMessage(), e);
        return ApiResult.fail("用户已经存在");
    }

    @ExceptionHandler(ServiceException.class)
    public ApiResult serviceException(ServiceException e) {
        logger.error(e.getMessage(), e);
        return ApiResult.fail();
    }

    @ExceptionHandler(ConnectException.class)
    public ApiResult connectException(ConnectException e) {
        logger.error(e.getMessage(), e);
        return ApiResult.fail("系统调用异常");
    }

    @ExceptionHandler(ResourceAccessException.class)
    public ApiResult connectException(ResourceAccessException e) {
        logger.error(e.getMessage(), e);
        return ApiResult.fail("系统之间调用异常");
    }

    @ExceptionHandler(value = {ExpiredJwtException.class})
    public ApiResult expiredJwtException(ExpiredJwtException e) {
        logger.error(e.getMessage(), e);
        return ApiResult.fail("Token过期");
    }

    @ExceptionHandler(value = UnsupportedJwtException.class)
    public ApiResult unsupportedJwtException(UnsupportedJwtException e) {
        logger.error(e.getMessage(), e);
        return ApiResult.fail("Token签名失败");
    }

    @ExceptionHandler(value = SignatureException.class)
    public ApiResult signatureException(SignatureException e) {
        logger.error(e.getMessage(), e);
        return ApiResult.fail("Token格式错误");
    }

    @ExceptionHandler(value = IllegalArgumentException.class)
    public ApiResult illegalArgumentException(IllegalArgumentException e) {
        logger.error(e.getMessage(), e);
        return ApiResult.fail("Token非法参数异常");
    }

    @ExceptionHandler(value = AccessDeniedException.class)
    public ApiResult accessDeniedException(AccessDeniedException e) {
        logger.error(e.getMessage(), e);
        return ApiResult.fail("Token非法参数异常");
    }

    @ExceptionHandler(value = MalformedJwtException.class)
    public ApiResult malformedJwtException(MalformedJwtException e) {
        logger.error(e.getMessage(), e);
        return ApiResult.fail("Token没有被正确构造");
    }

    @ExceptionHandler(value = Exception.class)
    public ApiResult exception(Exception e) {
        logger.error(e.getMessage(), e);
        return ApiResult.fail("接口异常");
    }
}
