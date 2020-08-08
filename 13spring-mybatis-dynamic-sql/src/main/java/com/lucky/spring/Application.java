package com.lucky.spring;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
@MapperScan("com.lucky.spring.dao")
public class Application {


    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }


}
