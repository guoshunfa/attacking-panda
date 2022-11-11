package com.panda.admin.system.controller;


import com.panda.admin.system.entity.SysUser;
import com.panda.common.base.BaseController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 系统用户表 前端控制器
 * </p>
 *
 * @author guoshunfa
 * @since 2022-11-10
 */
@RestController
@RequestMapping("/system/sys-user")
public class SysUserController extends BaseController<SysUser> {

}
