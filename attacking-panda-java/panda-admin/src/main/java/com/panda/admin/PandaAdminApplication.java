package com.panda.admin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.panda.*")
public class PandaAdminApplication {

    public static void main(String[] args) {
        SpringApplication.run(PandaAdminApplication.class, args);
    }

}
