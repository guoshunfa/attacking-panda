package com.panda.admin;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.panda.*")
@MapperScan("com.panda.*.*.mapper")
public class PandaAdminApplication {

    public static void main(String[] args) {
        SpringApplication.run(PandaAdminApplication.class, args);
    }

}
