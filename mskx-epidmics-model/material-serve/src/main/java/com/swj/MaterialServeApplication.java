package com.swj;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.swj.dao")
public class MaterialServeApplication {

    public static void main(String[] args) {
        SpringApplication.run(MaterialServeApplication.class, args);
    }

}
