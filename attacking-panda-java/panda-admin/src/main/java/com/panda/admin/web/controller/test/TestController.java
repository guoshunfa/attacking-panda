package com.panda.admin.web.controller.test;

import cn.hutool.log.Log;
import cn.hutool.log.LogFactory;
import cn.hutool.system.UserInfo;
import com.panda.framework.util.UserInfoUtil;
import io.swagger.annotations.ApiOperation;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 测试控制器
 *
 * @author GuoShunFa
 */
@RestController
@RequestMapping("/testDemo")
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

    @ApiOperation("test03 测试redis")
    @GetMapping("/test03")
    public String test03(){
        return (String) redisTemplate.execute((RedisCallback) connection -> {
            String ping = connection.ping();
            Log log = LogFactory.get();
            log.info(ping);
            return ping;
        });
    }

    @ApiOperation("test04 测试SpringSecurity工具类 UserInfoUtil")
    @GetMapping("/test04")
    public void test04(){
        Log log = LogFactory.get();
        log.info(UserInfoUtil.getSecurityContext().toString());
        log.info(UserInfoUtil.getAuthentication().toString());
        log.info(UserInfoUtil.getLoginUser().toString());
        log.info(UserInfoUtil.getSysUser().toString());
    }

    public static void main(String[] args) {
        Integer a = 1 ;
        Integer b = 1;
        System.out.println(a.equals(b));
    }
}
