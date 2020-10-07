package com.lucky.spring.config;

import com.lucky.spring.util.RabbitUtil;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by zhangdd on 2020/10/7
 */
@Configuration
public class RabbitConfig {


    /**
     * init factory of connection
     *
     * @param host
     * @param port
     * @param username
     * @param password
     * @return
     */
    @Bean
    public ConnectionFactory connectionFactory(@Value("${spring.rabbitmq.host}") String host,
                                               @Value("${spring.rabbitmq.port}") int port,
                                               @Value("${spring.rabbitmq.username}") String username,
                                               @Value("${spring.rabbitmq.password}") String password) {
        CachingConnectionFactory connectionFactory = new CachingConnectionFactory();
        connectionFactory.setHost(host);
        connectionFactory.setPort(port);
        connectionFactory.setUsername(username);
        connectionFactory.setPassword(password);
        return connectionFactory;
    }

    /**
     * 重新实例化 RabbitAdmin操作类
     *
     * @param connectionFactory
     * @return
     */
    @Bean
    public RabbitAdmin rabbitAdmin(ConnectionFactory connectionFactory) {
        return new RabbitAdmin(connectionFactory);
    }

    /**
     * 重新实例化 RabbitTemplate操作类
     *
     * @param connectionFactory
     * @return
     */
    @Bean
    public RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory) {
        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        //数据转换为json存入消息队列
        rabbitTemplate.setMessageConverter(new Jackson2JsonMessageConverter());
        return rabbitTemplate;
    }

    @Bean
    public RabbitUtil rabbitUtil() {
        return new RabbitUtil();
    }

}
