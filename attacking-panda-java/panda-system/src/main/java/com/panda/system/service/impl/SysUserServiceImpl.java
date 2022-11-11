package com.panda.system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.panda.common.base.BaseServiceImpl;
import com.panda.system.entity.SysUser;
import com.panda.system.mapper.SysUserMapper;
import com.panda.system.service.ISysUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 * 系统用户表 服务实现类
 * </p>
 *
 * @author guoshunfa
 * @since 2022-11-11
 */
@Service
public class SysUserServiceImpl extends BaseServiceImpl<SysUserMapper, SysUser> implements ISysUserService {

    @Resource
    private SysUserMapper sysUserMapper;

    @Override
    public SysUser findByUsername(String username) {
        QueryWrapper<SysUser> queryWrapper = new QueryWrapper<SysUser>();
        queryWrapper.eq("user_name", username);
        return sysUserMapper.selectOne(queryWrapper);
    }
}
