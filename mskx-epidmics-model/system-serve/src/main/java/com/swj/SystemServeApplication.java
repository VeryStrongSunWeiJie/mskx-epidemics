package com.swj;

import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.swj.dao")
public class SystemServeApplication {

    public static void main(String[] args) {
        SpringApplication.run(SystemServeApplication.class, args);
    }

}
