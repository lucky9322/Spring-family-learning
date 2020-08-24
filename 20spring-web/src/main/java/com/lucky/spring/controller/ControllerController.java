package com.lucky.spring.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by zhangdd on 2020/8/23
 */
@Controller
@Slf4j
public class ControllerController {

    @RequestMapping("/controller/hello1")
    public ModelAndView hello1() {
        log.info("/controller/hello1");
        ModelAndView mv = new ModelAndView();
        mv.setViewName("controller");
        return mv;
    }
}
