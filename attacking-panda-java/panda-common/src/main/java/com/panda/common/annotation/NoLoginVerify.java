package com.panda.common.annotation;

import java.lang.annotation.*;

/**
 * 不需要登陆验证 注解
 *
 * @className: NoLoginVerify
 * @author: GuoShunFa
 * @date: 2022/11/27
 **/
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface NoLoginVerify {
}
