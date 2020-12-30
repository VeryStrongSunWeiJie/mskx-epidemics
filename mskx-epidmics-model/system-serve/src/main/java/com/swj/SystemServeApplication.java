package com.swj;

import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@MapperScan("com.swj.dao")
@EnableDiscoveryClient
public class SystemServeApplication {

    public static void main(String[] args) {
        SpringApplication.run(SystemServeApplication.class, args);
    }

}
