package com.lucky.spring.controller;

import org.springframework.web.bind.annotation.*;

/**
 * Created by zhangdd on 2020/8/24
 */
@RestController
public class MethodController {

    @RequestMapping(value = "/method/getMethod", method = RequestMethod.GET)
    public String getMethod() {
        return "getMethod";
    }

    @RequestMapping(value = "/method/postMethod", method = RequestMethod.POST)
    public String postMethod() {
        return "postMethod";
    }

    @GetMapping("/method/getMapping")
    public String getMapping() {
        return "getMapping";
    }

    @PostMapping("/method/postMapping")
    public String postMapping() {
        return "postMapping";
    }
}
