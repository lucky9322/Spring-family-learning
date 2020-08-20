package com.lucky.spring;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.ReactiveRedisConnectionFactory;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.ReactiveRedisTemplate;
import org.springframework.data.redis.core.ReactiveStringRedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializationContext;
import reactor.core.publisher.Mono;

import javax.annotation.Resources;
import javax.validation.constraints.Size;
import java.net.URL;

@SpringBootApplication
@Slf4j
public class Application implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }


    @Autowired
    private ReactiveRedisTemplate<String, String> reactiveRedisTemplate;

    @Override
    public void run(String... args) throws Exception {
        reactiveRedisTemplate
                .opsForValue()
                .set("name", "李四")
                .subscribe(b -> log.info("set result:{}", b),
                        e -> log.error("set data error:{}", e));
    }
}
