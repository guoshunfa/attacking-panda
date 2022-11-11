package com.panda.admin.web.controller.system;


import com.panda.common.base.BaseController;
import com.panda.system.entity.SysDept;
import com.panda.system.service.ISysDeptService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * <p>
 * 系统部门表 前端控制器
 * </p>
 *
 * @author guoshunfa
 * @since 2022-11-10
 */
@RestController
@RequestMapping("/system/sys-dept")
public class SysDeptController extends BaseController<SysDept> {

    @Resource
    private ISysDeptService sysDeptService;

}
