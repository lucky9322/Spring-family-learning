package com.lucky.spring.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Created by zhangdd on 2020/9/9
 */
@Component
@Data
public class RedisProperties {

    @Value("${spring.redis.cluster.nodes}")
    private String[] nodes;

    @Value("${spring.redis.timeout}")
    private int connectionTimeout;

}
