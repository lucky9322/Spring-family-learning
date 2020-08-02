package com.lucky.spring.controller;

import com.lucky.spring.config.PersonConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by zhangdd on 2020/7/16
 */
@RestController
public class PersonController {

    @Autowired
    PersonConfig personConfig;

    @GetMapping("/api/queryPersonInfo")
    public String queryPersonInfo() {
        StringBuilder builder = new StringBuilder();
        builder.append(personConfig.getName())
                .append(",")
                .append(personConfig.getAge());
        return builder.toString();
    }
}
