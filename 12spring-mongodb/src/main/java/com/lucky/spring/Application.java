package com.lucky.spring;

import com.lucky.spring.converter.MoneyReaderConverter;
import com.lucky.spring.model.Coffee;
import com.mongodb.client.result.UpdateResult;
import lombok.extern.slf4j.Slf4j;
import org.joda.money.CurrencyUnit;
import org.joda.money.Money;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.convert.MongoCustomConversions;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

@SpringBootApplication
@Slf4j
public class Application implements CommandLineRunner {


    @Autowired
    MongoTemplate mongoTemplate;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }


    @Bean
    public MongoCustomConversions mongoCustomConversions() {

        return new MongoCustomConversions(Arrays.asList(new MoneyReaderConverter()));
    }


    @Override
    public void run(String... args) throws Exception {
        //saveFindData();
        //updateData();
    }

    private void saveFindData() throws InterruptedException {
        Coffee espresso = Coffee.builder()
                .name("espresso")
                .price(Money.of(CurrencyUnit.of("CNY"), 20.0))
                .createTime(new Date())
                .updateTime(new Date())
                .build();
        mongoTemplate.save(espresso);
        log.info("Coffee {}", espresso);

        List<Coffee> list = mongoTemplate.find(
                Query.query(Criteria.where("name").is("espresso")), Coffee.class
        );
        log.info("find {} coffee", list.size());

        list.forEach(c -> log.info("coffee {}", c));

        TimeUnit.SECONDS.sleep(1000);
    }

    private void updateData() {
        UpdateResult result = mongoTemplate.updateFirst(Query.query(Criteria.where("name").is("espresso")),
                new Update().set("price", Money.ofMajor(CurrencyUnit.of("CNY"), 30)).currentDate("updateTime"),
                Coffee.class);
        log.info("update result:{}", result.getMatchedCount());
    }
}
