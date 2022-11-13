package com.panda.admin.web.controller.login;

import com.panda.common.result.ApiResult;
import com.panda.framework.web.service.LoginService;
import com.panda.system.entity.SysUser;
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
    public ApiResult login(@RequestBody SysUser user) {
        //登录
        return loginService.login(user);
    }

    @RequestMapping("/user/logout")
    public ApiResult logout() {
        return loginService.logout();
    }
}
