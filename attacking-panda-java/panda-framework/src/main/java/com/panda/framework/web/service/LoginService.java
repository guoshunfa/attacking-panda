package com.panda.framework.web.service;

import com.panda.common.result.ApiResult;
import com.panda.system.entity.SysUser;

/**
 * 登陆接口
 *
 * @author GuoShunFa
 */
public interface LoginService {

    /**
     * 登陆接口
     *
     * @param user 用户名和密码
     * @return 登陆结果
     */
    ApiResult login(SysUser user);

    /**
     * 登出接口
     *
     * @return 登出结果
     */
    ApiResult logout();

}
