package com.lucky.spring.controller;

import com.lucky.spring.entity.Person;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by zhangdd on 2020/8/23
 */
@Controller
@ResponseBody
public class JsonController {

    @RequestMapping("/json/helloJson")
    private String helloJson() {
        return "helloJson";
    }


    @RequestMapping("/json/helloObject")
    private Person helloObject() {
        return new Person();
    }

}
