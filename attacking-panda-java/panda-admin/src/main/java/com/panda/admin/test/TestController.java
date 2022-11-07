package com.panda.admin.test;

import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @ApiOperation("test01 接口")
    @GetMapping("/test01")
    public String test01() {
        return "";
    }

    @ApiOperation("test02 接口")
    @GetMapping("/test02")
    public String test02() {
        throw new RuntimeException("test02 错了");
    }

}
