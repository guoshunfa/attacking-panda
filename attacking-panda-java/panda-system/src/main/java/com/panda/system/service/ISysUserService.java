package com.panda.system.service;

import com.panda.common.base.BaseService;
import com.panda.system.entity.SysUser;

/**
 * <p>
 * 系统用户表 服务类
 * </p>
 *
 * @author guoshunfa
 * @since 2022-11-11
 */
public interface ISysUserService extends BaseService<SysUser> {

    /**
     * 根据用户名查找用户
     *
     * @param username 用户名
     * @return 用户信息
     */
    SysUser findByUsername(String username);
}
