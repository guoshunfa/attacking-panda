package com.panda.admin.web.controller.test;

import cn.hutool.log.Log;
import cn.hutool.log.LogFactory;
import com.panda.framework.util.UserInfoUtil;
import io.swagger.annotations.ApiOperation;
import org.springframework.data.redis.connection.RedisConnectionCommands;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @className: MaTestController
 * @author: mahe666
 * @date: 2022/11/27
 *
 * 测试类
 **/
@RestController
@RequestMapping("/MaTest")
public class MaTestController {

    @Resource
    private RedisTemplate redisTemplate;

    @ApiOperation("test01 测试redis")
    @GetMapping("/test01")
    public String test01(){
        return (String) redisTemplate.execute(RedisConnectionCommands::ping);
    }

    @ApiOperation("test02 测试SpringSecurity工具类 UserInfoUtil")
    @GetMapping("/test02")
    public void test02(){
        Log log = LogFactory.get();
        log.info(UserInfoUtil.getSecurityContext().toString());
        log.info(UserInfoUtil.getAuthentication().toString());
        log.info(UserInfoUtil.getLoginUser().toString());
        log.info(UserInfoUtil.getSysUser().toString());
    }

}
