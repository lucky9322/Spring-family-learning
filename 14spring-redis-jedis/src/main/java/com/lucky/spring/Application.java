package com.lucky.spring;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

@SpringBootApplication
@Slf4j
public class Application implements CommandLineRunner {

    @Autowired
    private JedisPoolConfig jedisPoolConfig;

    @Autowired
    private JedisPool jedisPool;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    @ConfigurationProperties("redis")
    public JedisPoolConfig jedisPoolConfig() {
        return new JedisPoolConfig();
    }

    @Bean(destroyMethod = "close")
    public JedisPool jedisPool(@Value("${redis.host}") String host) {
        return new JedisPool(jedisPoolConfig(), host);
    }

    @Override
    public void run(String... args) throws Exception {
        log.info(jedisPoolConfig.toString());

        try (Jedis jedis = jedisPool.getResource()) {
            jedis.set("name", "张三");

            log.info("redis value:{}", jedis.get("name"));
        }
    }
}
