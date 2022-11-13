package com.panda.framework.web.service;

import com.panda.common.result.ApiResult;
import com.panda.system.entity.SysUser;

public interface LoginService {
    ApiResult login(SysUser user);

    ApiResult logout();

}
