package com.panda.admin.system.controller;


import com.panda.admin.system.entity.SysDept;
import com.panda.admin.system.service.ISysDeptService;
import com.panda.common.base.BaseController;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
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
@Api("asd")
public class SysDeptController extends BaseController<SysDept> {

    @Resource
    private ISysDeptService sysDeptService;

    @GetMapping("/add")
    @ApiOperation("sys-dept add 接口")
    public void add() {
        logger.debug("yo man");
        sysDeptService.save(new SysDept());
    }

}
