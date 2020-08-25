package com.lucky.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by zhangdd on 2020/8/25
 */
@Controller
public class RedirectController {

    @GetMapping("/redirect/function1")
    public void function1(HttpServletResponse response) throws IOException {
        response.sendRedirect("https://www.baidu.com");
        //response.sendRedirect("/redirect1.html");
    }


    @GetMapping("/redirect/function2")
    public String function2() throws IOException {
        return "redirect:/redirect1.html";
    }

    @GetMapping("/redirect/function2WithParam")
    public String function2WithParam(RedirectAttributes attr) throws IOException {
        attr.addAttribute("test", "51gjie");//跳转地址带上test参数
        attr.addFlashAttribute("u2", "51gjie");//u2参数不会跟随在URL后面
        return "redirect:/redirect1.html";
    }

    @GetMapping("/redirect/function3")
    public ModelAndView function3() throws IOException {
        ModelAndView model = new ModelAndView("redirect:/redirect1.html");
        return model;
    }

    @GetMapping("/redirect/function3WithParam")
    public ModelAndView function3WithParam() throws IOException {
        ModelAndView model = new ModelAndView("redirect:/redirect1.html");
        model.addObject("userName", "张三");  //把userName参数带入到controller的RedirectAttributes
        return model;
    }
}
