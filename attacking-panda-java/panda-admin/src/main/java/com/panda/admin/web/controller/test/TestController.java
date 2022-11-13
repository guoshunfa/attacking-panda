package com.panda.admin.web.controller.test;

import cn.hutool.log.Log;
import cn.hutool.log.LogFactory;
import io.swagger.annotations.ApiOperation;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 测试控制器
 *
 * @author GuoShunFa
 */
@RestController
public class TestController {

    @Resource
    private RedisTemplate redisTemplate;

    @ApiOperation("test01 接口")
    @GetMapping("/test01")
    public void test01() {
        redisTemplate.opsForValue().set("test", "测试测试");
    }

    @ApiOperation("test02 接口")
    @GetMapping("/test02")
    public String test02() {
        Log log = LogFactory.get();
        log.info("事实上撒打算大");
        return redisTemplate.opsForValue().get("test").toString();
    }

}
