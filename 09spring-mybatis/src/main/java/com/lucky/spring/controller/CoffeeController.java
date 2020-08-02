package com.lucky.spring.controller;

import com.lucky.spring.mapper.CoffeeMapper;
import com.lucky.spring.model.Coffee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by zhangdd on 2020/7/29
 */
@RestController
public class CoffeeController {

    @Autowired
    CoffeeMapper coffeeMapper;

    @GetMapping("/api/mybatis/queryCoffee")
    public Coffee queryCoffee(){
        Coffee coffee = coffeeMapper.findById(1L);
        return coffee;
    }
}
