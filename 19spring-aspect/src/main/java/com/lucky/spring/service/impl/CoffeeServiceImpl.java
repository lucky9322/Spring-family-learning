package com.lucky.spring.service.impl;

import com.lucky.spring.dao.CoffeeMapperExt;
import com.lucky.spring.model.Coffee;
import com.lucky.spring.service.CoffeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by zhangdd on 2020/8/22
 */
@Service
public class CoffeeServiceImpl implements CoffeeService {

    @Autowired
    private CoffeeMapperExt coffeeMapperExt;

    @Override
    public List<Coffee> findAllCoffee() {
        return coffeeMapperExt.queryAllCoffee();
    }
}
