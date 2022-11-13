package com.panda.admin.web.controller.login;

import com.panda.common.result.ApiResult;
import com.panda.framework.web.service.LoginService;
import com.panda.system.entity.SysUser;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class LoginController {

    @Resource
    private LoginService loginService;

    @PostMapping("/user/login")
    @ApiOperation("登陆接口")
    public ApiResult login(@RequestBody SysUser user) {
        return loginService.login(user);
    }

    @RequestMapping("/user/logout")
    @ApiOperation("登出接口")
    public ApiResult logout() {
        return loginService.logout();
    }
}
