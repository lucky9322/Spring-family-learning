package com.lucky.spring.config;

import com.lucky.spring.entity.Car;
import com.lucky.spring.entity.Man;
import com.lucky.spring.entity.QQCar;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by zhangdd on 2020/8/26
 */
@Configuration
public class ManConfig {
    @Bean
    public Man man() {
        return new Man(car());
    }
    @Bean
    public Car car() {
        return new QQCar();
    }
}
