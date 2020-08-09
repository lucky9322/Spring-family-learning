package com.lucky.spring;

import com.lucky.spring.service.DataService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
@Slf4j
public class Application implements CommandLineRunner {

    @Autowired
    private DataService dataService;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        log.info("count {}", dataService.findAllName().size());

        for (int i = 0; i < 5; i++) {
            log.info("再次执行查询");
            dataService.findAllName();
        }

        dataService.reloadPerson();
        log.info("read after refresh");
        dataService.findAllName().forEach(p -> {
            log.info("person:{}", p);
        });
    }
}
