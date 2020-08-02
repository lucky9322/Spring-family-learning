package com.lucky.spring.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * Created by zhangdd on 2020/7/16
 */
@Component
@PropertySource(value = "classpath:config/person.properties",encoding = "utf-8")
@ConfigurationProperties(prefix = "person")
public class PersonConfig {
    private String name;
    private String age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}
