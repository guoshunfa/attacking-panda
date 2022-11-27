package com.panda.framework.util;

import com.panda.framework.web.entity.LoginUser;
import com.panda.system.entity.SysUser;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * SpringSecurity框架 工具类
 *
 * @author mahe666
 * @date 2022/11/23
 */
public class UserInfoUtil {

    public static SecurityContext getSecurityContext(){
        return SecurityContextHolder.getContext();
    }

    public static Authentication getAuthentication(){
        return getSecurityContext().getAuthentication();
    }

    public static LoginUser getLoginUser(){
        return (LoginUser) getAuthentication().getPrincipal();
    }

    public static SysUser getSysUser(){
        return getLoginUser().getUser();
    }

}
