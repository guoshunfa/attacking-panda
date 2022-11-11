package com.panda.framework.handler;

import cn.hutool.json.JSONUtil;
import com.panda.common.result.ApiResult;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 自定义认证错误拦截器
 *
 * @className: Http401AuthenticationEntryPoint
 * @author: GuoShunFa
 * @date: 2022/11/11
 **/
public class Http401AuthenticationEntryPoint implements AuthenticationEntryPoint {

    private final String headerValue;

    public Http401AuthenticationEntryPoint(String headerValue) {
        this.headerValue = headerValue;
    }

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
        response.setHeader("Authorization", this.headerValue);
        response.setHeader("Content-type", "text/html;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(JSONUtil.toJsonStr(
                ApiResult.fail(HttpServletResponse.SC_UNAUTHORIZED, "没有登陆")));
    }

}
