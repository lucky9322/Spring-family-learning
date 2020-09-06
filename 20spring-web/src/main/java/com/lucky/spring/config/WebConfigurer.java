package com.lucky.spring.config;

import com.lucky.spring.interceptor.WebInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Created by zhangdd on 2020/8/25
 */
@Configuration
public class WebConfigurer implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //配置 WebInterceptor 这个拦截器生效，/** 表示该拦截器对所有的请求都拦截，但是排除了/error请求的拦截
        registry.addInterceptor(new WebInterceptor())
                .addPathPatterns("/**")
                .excludePathPatterns("/error");
    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**").
                allowedOrigins("https://www.baidu.com", "https://zhangdd.com")//必须字段，允许跨域的域名，可以用*表示允许任何域名使用
        //.allowedMethods("*")//可选字段，允许跨域的方法，使用*表示允许任何方法
        //.allowCredentials(true)//可选字段，布尔值，表示是否允许发送cookie信息
        //.allowedHeaders("*")//允许任何请求头
        //.exposedHeaders("name")//可选字段，指定响应头里的字段信息
        //.maxAge(1000) //可选字段，用来指定本次预检请求的有效期，单位为秒
        ;
    }

    /**
     * 这一个配置在之前是经常被使用到的，最经常用到的就是"/"、"/index"路径请求时不通过@RequestMapping配置，
     * 而是直接通过配置文件映射指定请求路径到指定View页面，
     * 当然也是在请求目标页面时不需要做什么数据处理才可以这样使用
     * @param registry
     */
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("/index");
    }
}
