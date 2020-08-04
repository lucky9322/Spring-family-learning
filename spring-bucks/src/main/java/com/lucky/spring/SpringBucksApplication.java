package com.lucky.spring;

import com.lucky.spring.dao.CoffeeMapperExt;
import com.lucky.spring.model.Coffee;
import com.lucky.spring.model.Order;
import com.lucky.spring.model.OrderStateEnum;
import com.lucky.spring.service.CoffeeOrderService;
import com.lucky.spring.service.CoffeeService;
import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
@MapperScan(basePackages = {"com.lucky.spring.dao"})
@Slf4j
public class SpringBucksApplication implements CommandLineRunner {

    @Autowired
    private CoffeeMapperExt coffeeMapperExt;

    @Autowired
    private CoffeeService coffeeService;
    @Autowired
    private CoffeeOrderService orderService;

    public static void main(String[] args) {
        SpringApplication.run(SpringBucksApplication.class, args);
    }


    @Override
    public void run(String... args) throws Exception {
        List<Coffee> coffees = coffeeMapperExt.queryAll();
        log.info("All Coffee: {}", coffees);

        Coffee latte = coffeeService.queryOneCoffee("Latte");
        if (latte != null) {
            Order order = orderService.createOrder("Li Lei", latte);

            log.info("Update INIT to PAID: {}", orderService.updateOrderState(order, OrderStateEnum.PAID));
            log.info("Update PAID to INIT: {}", orderService.updateOrderState(order, OrderStateEnum.INIT));

        }

    }
}
