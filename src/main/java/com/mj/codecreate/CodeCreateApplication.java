package com.mj.codecreate;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.mj.codecreate.mapper")
public class CodeCreateApplication {

    public static void main(String[] args) {
        SpringApplication.run(CodeCreateApplication.class, args);
    }

}
