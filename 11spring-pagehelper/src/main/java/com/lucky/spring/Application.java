package com.lucky.spring;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lucky.spring.dao.CoffeeMapperExt;
import com.lucky.spring.model.Coffee;
import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
@MapperScan("com.lucky.spring.dao")
@Slf4j
public class Application implements CommandLineRunner {

    @Autowired
    CoffeeMapperExt coffeeMapperExt;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        PageHelper.startPage(1, 0);
        List<Coffee> coffees = coffeeMapperExt.queryCoffeeList();
        PageInfo<Coffee> info = new PageInfo<>(coffees);
        log.info("coffees:{}", coffees);
        log.info("pageNum:{}",info.getPageNum());
        log.info("pageSize:{}",info.getPageSize());
        log.info("total:{}",info.getTotal());
        log.info("hasPreviousPage:{}",info.isHasPreviousPage());
        log.info("hasNextPage:{}",info.isHasNextPage());
    }
}
