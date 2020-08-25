package com.lucky.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by zhangdd on 2020/8/25
 */
@Controller
public class ForwardController {

    @GetMapping("/forward/function1")
    public String function1() {
        return "forward:/forward1.html";
    }

    @GetMapping("/forward/function1WithParam")
    public String function1WithParam(HttpServletRequest request) {
        request.setAttribute("username", "张三");////把username参数传递到request中
        return "forward:/forward1.html";
    }

    @GetMapping("/forward/function2")
    public ModelAndView function2() {
        ModelAndView model = new ModelAndView("forward:/forward1.html");//默认forward，可以不用写
        return model;
    }

    @GetMapping("/forward/function2WithParam")
    public ModelAndView function2WithParam() {
        ModelAndView model = new ModelAndView("forward:/forward1.html");//默认forward，可以不用写
        model.addObject("userName", "张三");  //把userName参数带入到controller的RedirectAttributes
        return model;
    }

}
