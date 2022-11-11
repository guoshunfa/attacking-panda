package com.panda.common.annotation;

import java.lang.annotation.*;

/**
 * 当不需要按照框架内部的通用返回时，将注解配置到接口方法上。
 *
 * @author GuoShunFa
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface NotUnifiedResult {
}
