package com.lucky.spring.controller;

import com.lucky.spring.bean.Person;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by zhangdd on 2020/11/1
 */
@RestController
public class HelloController {

    private static Map<String, Person> personMap = new HashMap<>();

    static {
        personMap.put("张三", Person.builder().name("张三").age(18).build());
    }

    @GetMapping("/api/hello/{name}")
    public Person getPerson(@PathVariable("name") String name) {
        Person person = personMap.get(name);
        return person;
    }

    @GetMapping("/api/hello")
    public Person getPerson(@RequestParam(required = false) String name, @RequestParam(required = false) String address) {
        return Person.builder()
                .name(name)
                .address(address)
                .build();
    }
}
