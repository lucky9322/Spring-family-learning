package com.lucky.spring.service;

import com.lucky.spring.dao.CoffeeMapperExt;
import com.lucky.spring.model.Coffee;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by zhangdd on 2020/8/3
 */
@Service
@Slf4j
public class CoffeeService {

    @Autowired
    CoffeeMapperExt coffeeMapperExt;

    public Coffee queryOneCoffee(String name) {
        Coffee coffee = coffeeMapperExt.queryByName(name);
        log.info("query coffee:{}", coffee);
        return coffee;
    }
}
