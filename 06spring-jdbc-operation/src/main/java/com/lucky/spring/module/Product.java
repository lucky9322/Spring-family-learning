package com.lucky.spring.module;

import lombok.Builder;
import lombok.Data;

/**
 * Created by zhangdd on 2020/7/21
 */
@Builder
@Data
public class Product {
    private int id;
    private String name;
    private String description;
}
