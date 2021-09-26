package com.fit2cloud.distlock;

import com.fit2cloud.distlock.service.DistLockService;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.fit2cloud.distlock.mapper")
public class DistLockApplication {

    public static void main(String[] args) {
        SpringApplication.run(DistLockApplication.class, args);
    }

}
