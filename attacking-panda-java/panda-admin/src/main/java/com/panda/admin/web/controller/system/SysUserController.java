package com.panda.admin.web.controller.system;


import com.panda.common.base.BaseController;
import com.panda.common.exception.UsernameIsExitedException;
import com.panda.common.result.ApiResult;
import com.panda.system.entity.SysUser;
import com.panda.system.service.ISysUserService;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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
    protected BCryptPasswordEncoder bCryptPasswordEncoder;
    @Resource
    private ISysUserService sysUserService;

    /**
     * 注册用户 默认开启白名单
     *
     * @param user
     */
    @PostMapping("/signup")
    public ApiResult signup(@RequestBody SysUser user) {
        SysUser bizUser = sysUserService.findByUsername(user.getUserName());
        if (null != bizUser) {
            throw new UsernameIsExitedException("用户已经存在");
        }
        /*user.setPassword(DigestUtils.md5DigestAsHex((user.getPassword()).getBytes()));*/
        user.setUserPassword(bCryptPasswordEncoder.encode(user.getUserPassword()));

        return toAjax(sysUserService.save(user));
    }

    /**
     * 获取用户列表
     *
     * @return
     */
    @ApiModelProperty(value = "获取用户列表")
    @GetMapping("/userList")
    public Map<String, Object> userList() {
        List<SysUser> users = sysUserService.list();
        logger.info("users: {}", users);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("users", users);
        return map;
    }

    /**
     * 获取用户权限
     *
     * @return
     */
    @ApiModelProperty(value = "获取用户权限")
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
