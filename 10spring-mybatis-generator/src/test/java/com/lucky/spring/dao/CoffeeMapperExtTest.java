package com.lucky.spring.dao;

import com.lucky.spring.model.Coffee;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by zhangdd on 2020/8/16
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class CoffeeMapperExtTest {

    @Autowired
    CoffeeMapperExt mapperExt;

    @Test
    public void queryLessThanByPrice() throws Exception {
        List<Coffee> coffees = mapperExt.queryLessThanByPrice(2600L);
        coffees.forEach(c -> System.out.println(c));
    }

    @Test
    public void queryGreaterThanByPrice() throws Exception {
        List<Coffee> coffees = mapperExt.queryGreaterThanByPrice(2600L);
        coffees.forEach(c -> System.out.println(c));
    }

}