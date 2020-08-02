package com.lucky.spring.run;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * Created by zhangdd on 2020/7/12
 */
@Component
@Order(value = 2)
public class StartupRunnerTwo implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {
        System.out.println(">>>>>>>>>>>>>>>服务第二顺序启动执行，执行加载数据等操作<<<<<<<<<<<<<");
    }
}
