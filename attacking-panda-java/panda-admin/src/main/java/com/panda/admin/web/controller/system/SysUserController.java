package com.panda.admin.web.controller.system;


import cn.hutool.crypto.digest.BCrypt;
import com.panda.common.base.BaseController;
import com.panda.common.exception.UsernameIsExitedException;
import com.panda.common.result.ApiResult;
import com.panda.system.entity.SysUser;
import com.panda.system.service.ISysUserService;
import io.swagger.annotations.ApiOperation;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.*;

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

    @Resource
    private ISysUserService sysUserService;

    @ApiOperation("删除用户")
    @DeleteMapping("/{ids}")
    public ApiResult delete(@PathVariable String[] ids) {
        return toAjax(sysUserService.removeByIds(Arrays.asList(ids)));
    }

    @ApiOperation("修改用户")
    @PutMapping
    public ApiResult update(@RequestBody SysUser user) {
        return toAjax(sysUserService.updateById(user));
    }

    @ApiOperation("注册用户 默认开启白名单")
    @PostMapping("/signup")
    public ApiResult signup(@RequestBody SysUser user) {
        SysUser bizUser = sysUserService.findByUsername(user.getUserName());
        if (null != bizUser) {
            throw new UsernameIsExitedException("用户已经存在");
        }
        user.setUserPassword(BCrypt.hashpw(user.getUserPassword()));
        return toAjax(sysUserService.save(user));
    }

    /**
     * 获取用户列表
     *
     * @return
     */
    @ApiOperation("获取用户列表")
    @GetMapping("/userList")
    public Map<String, Object> userList() {
        List<SysUser> users = sysUserService.list();
        logger.info("users: {}", users);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("users", users);
        return map;
    }

    @ApiOperation("获取用户权限")
    @GetMapping("/authorityList")
    public List<String> authorityList() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
        List<String> list = new ArrayList<>();
        for (GrantedAuthority grantedAuthority : authorities) {
            logger.info("权限列表：{}", grantedAuthority.getAuthority());
            list.add(grantedAuthority.getAuthority());
        }
        return list;
    }

}
