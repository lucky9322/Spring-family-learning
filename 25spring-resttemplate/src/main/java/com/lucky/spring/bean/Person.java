package com.lucky.spring.bean;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * Created by zhangdd on 2020/11/1
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Person implements Serializable {

    private String name;
    private int age;
    private String address;
    private List<String> hobby;
}
