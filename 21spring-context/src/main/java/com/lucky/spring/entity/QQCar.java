package com.lucky.spring.entity;

import lombok.extern.slf4j.Slf4j;

/**
 * Created by zhangdd on 2020/8/26
 */
@Slf4j
public class QQCar implements Car {

    @Override
    public void drive() {
        log.info("开QQ车");
    }
}
