package com.lucky.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by zhangdd on 2020/9/4
 *
 * 测试跨域
 */
@Controller
@ResponseBody
public class CorsController {

    @GetMapping("/cross/fun")
    public String fun(){
        return "success";
    }
}
