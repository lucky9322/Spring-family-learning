package com.lucky.spring;

import com.lucky.spring.config.RedisProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.redis.core.RedisTemplate;
import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;

import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class Application implements CommandLineRunner {


    @Autowired
    RedisTemplate redisTemplate;


    @Autowired
    private JedisCluster jedisCluster;


    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        //opeByRedisTemplate();
        opeByJedisCluster();
    }

    private void opeByRedisTemplate() {
        redisTemplate.opsForValue().set("name", "张三");
        String name = (String) redisTemplate.opsForValue().get("name");
        System.out.println(name);
    }

    private void opeByJedisCluster() {
        jedisCluster.set("name", "李四");
        System.out.println(jedisCluster.get("name"));
    }
}
