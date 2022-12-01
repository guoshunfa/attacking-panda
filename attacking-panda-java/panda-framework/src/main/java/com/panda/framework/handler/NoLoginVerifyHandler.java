package com.panda.framework.handler;

import com.panda.common.annotation.NoLoginVerify;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author mahe666
 * @date 2022/12/1
 */
@Component
public class NoLoginVerifyHandler {

    protected final Logger logger = LoggerFactory.getLogger(NoLoginVerifyHandler.class);

    @Resource
    private ApplicationContext applicationContext;

    /**
     * 所有带有RequestMapping的方法
     */
    private static Map<RequestMappingInfo, HandlerMethod> handlerMethodMap;

    /**
     * 待返回的anonymousUrls
     */
    private static Set<String> anonymousUrlsSet;

    /**
     * 初始化当前处理器
     */
    @PostConstruct
    public void init() {
        NoLoginVerifyHandler noLoginVerifyHandler = this;
        handlerMethodMap = noLoginVerifyHandler.applicationContext.getBean(RequestMappingHandlerMapping.class).getHandlerMethods();
        anonymousUrlsSet = new HashSet<>();
    }

    /**
     * 根据方法上的注解，添加匿名访问路径
     */
    private void getAnonymousUrlsByMethodAnnotation() {
        handlerMethodMap.entrySet().stream()
                // 过滤出包含匿名访问注解的handlerMethodEntry
                .filter(handlerMethodEntry -> handlerMethodEntry.getValue().getMethodAnnotation(NoLoginVerify.class) != null)
                .forEach(this::addToAnonymousUrls);
    }

    /**
     * 根据类上的注解，添加匿名访问路径
     */
    private void getAnonymousUrlsByBeanAnnotation() {
        // 获取所有带有匿名访问注解的bean
        Map<String, Object> beansWithAnnotation = applicationContext.getBeansWithAnnotation(NoLoginVerify.class);
        // 获取所有bean中的所有Method的toString
        Set<String> methodNameArray = getMethodNameSet(beansWithAnnotation);
        handlerMethodMap.entrySet().stream()
                .filter(handlerMethodEntry -> methodNameArray.contains(getMethodNameSet(handlerMethodEntry)))
                .forEach(this::addToAnonymousUrls);
    }

    /**
     * 添加到匿名访问set中的具体实现
     * @param handlerMethodEntry
     * @return
     */
    private boolean addToAnonymousUrls(Map.Entry<RequestMappingInfo, HandlerMethod> handlerMethodEntry) {
        return anonymousUrlsSet.addAll(handlerMethodEntry.getKey().getPatternsCondition().getPatterns());
    }

    /**
     * 获取匿名访问路径的数组
     * @return
     */
    public String[] getAnonymousUrl() {
        getAnonymousUrlsByBeanAnnotation();
        getAnonymousUrlsByMethodAnnotation();
        logger.info("可以匿名访问的路径为:" + String.join(", ", anonymousUrlsSet));
        return anonymousUrlsSet.toArray(new String[0]);
    }

    /**
     * 获取方法名
     * @param mapEntry
     * @return String
     */
    private String getMethodNameSet(Map.Entry<RequestMappingInfo, HandlerMethod> mapEntry){
        return mapEntry.getValue().getMethod().toString();
    }

    /**
     * 获取方法名数组
     * @param map
     * @return Set<String>
     */
    private Set<String> getMethodNameSet(Map<String, Object> map){
        return map.values().stream()
                .map(aClass -> aClass.getClass().getMethods())
                .flatMap(Arrays::stream)
                .map(Objects::toString)
                .collect(Collectors.toSet());
    }



}
