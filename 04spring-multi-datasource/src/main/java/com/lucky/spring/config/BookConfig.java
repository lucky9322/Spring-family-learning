package com.lucky.spring.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * Created by zhangdd on 2020/7/16
 */
@PropertySource(value = "book.properties",encoding = "utf-8")
@ConfigurationProperties(prefix = "book")
@Component
public class BookConfig {
    private String name;
    private String price;
    private String version;

    public String getName() {
        return name;
    }

    public String getPrice() {
        return price;
    }

    public String getVersion() {
        return version;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public void setVersion(String version) {
        this.version = version;
    }
}
