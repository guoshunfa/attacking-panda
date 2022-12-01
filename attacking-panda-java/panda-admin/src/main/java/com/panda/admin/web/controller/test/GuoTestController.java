package com.panda.admin.web.controller.test;

import com.panda.common.annotation.NoLoginVerify;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @className: GuoTestController
 * @author: GuoShunFa
 * @date: 2022/11/27
 **/
@RestController
public class GuoTestController {

    @ApiOperation("test01")
    @GetMapping("/test01")
    @NoLoginVerify
    public String test01() {
        return "test01";
    }

    @ApiOperation("test02")
    @GetMapping("/test02")
    @NoLoginVerify
    public String test02() {
        return "test02";
    }


}
