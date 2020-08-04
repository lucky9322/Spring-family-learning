package com.lucky.spring.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * Created by zhangdd on 2020/8/3
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class CoffeeOrderServiceTest {

    @Autowired
    CoffeeOrderService service;

    @Test
    public void createOrder() throws Exception {
        service.createOrder(null, null);
    }

}