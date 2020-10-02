package com.lucky.spring.config;

import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Exchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by zhangdd on 2020/9/20
 */
@Configuration
public class MsgCallbackRabbitConfig {

    /**
     * 新增一个交换机，但是不给这个交换机绑定队列
     * @return
     */
    @Bean
    public DirectExchange lonelyDirectExchange() {
        return new DirectExchange("lonelyDirectExchange");
    }
}
