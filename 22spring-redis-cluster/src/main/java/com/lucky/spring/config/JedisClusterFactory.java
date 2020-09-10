package com.lucky.spring.config;

import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by zhangdd on 2020/9/9
 */
@Configuration
public class JedisClusterFactory {

    @Autowired
    private RedisProperties redisProperties;


    @Bean
    public JedisCluster jedisCluster() {
        Set<HostAndPort> nodes = new HashSet<>();
        for (String ipPort : redisProperties.getNodes()) {
            String[] ipPortPair = ipPort.split(":");
            nodes.add(new HostAndPort(ipPortPair[0].trim(),
                    Integer.valueOf(ipPortPair[1].trim())));
        }
        // jedis 连接池的配置没有使用
        return new JedisCluster(nodes,
                redisProperties.getConnectionTimeout(),
                1000,
                1,
                new GenericObjectPoolConfig());//需要密码连接的创建对象方式
    }
}
