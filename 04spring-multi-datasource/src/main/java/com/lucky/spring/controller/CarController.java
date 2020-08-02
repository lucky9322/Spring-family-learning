package com.lucky.spring.controller;

import com.lucky.spring.config.CarConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by zhangdd on 2020/7/16
 */
@RestController
public class CarController {

    @Autowired
    CarConfig carConfig;

    @GetMapping("/api/queryCarInfo")
    public String queryCarInfo() {
        StringBuilder builder = new StringBuilder();
        builder.append(carConfig.getName())
                .append(",")
                .append(carConfig.getPrice());
        return builder.toString();
    }
}
