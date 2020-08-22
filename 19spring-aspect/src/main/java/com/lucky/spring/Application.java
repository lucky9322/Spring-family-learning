package com.lucky.spring;

import com.lucky.spring.model.Coffee;
import com.lucky.spring.service.CoffeeService;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
@MapperScan("com.lucky.spring.dao")
public class Application implements CommandLineRunner {

    @Autowired
    private CoffeeService coffeeService;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        List<Coffee> allCoffee = coffeeService.findAllCoffee();
        allCoffee.forEach(c -> System.out.println(c));
    }
}
