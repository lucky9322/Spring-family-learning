package com.lucky.spring.entity;

/**
 * Created by zhangdd on 2020/8/26
 */
public class Man {

    private Car car;

    public Man() {
    }

    public Man(Car car) {
        this.car = car;
    }

    public void work() {
        car.drive();
    }

    public Car getCar() {
        return car;
    }
}
