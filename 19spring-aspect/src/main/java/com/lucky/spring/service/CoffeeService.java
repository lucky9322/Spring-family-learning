package com.lucky.spring.service;

import com.lucky.spring.model.Coffee;

import java.util.List;

/**
 * Created by zhangdd on 2020/8/22
 */
public interface CoffeeService {

    List<Coffee> findAllCoffee();
}
