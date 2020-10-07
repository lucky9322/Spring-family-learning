package com.lucky.spring.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by zhangdd on 2020/10/7
 */
@Configuration
public class DynamicConsumeListener {

    private Logger log = LoggerFactory.getLogger(DynamicConsumeListener.class);

    /**
     * 使用 SimpleMessageListenerContainer 实现动态监听
     *
     * @param connectionFactory
     * @return
     */
    @Bean
    public SimpleMessageListenerContainer messageListenerContainer(ConnectionFactory connectionFactory) {
        SimpleMessageListenerContainer container = new SimpleMessageListenerContainer(connectionFactory);
        container.setMessageListener(message -> {
            log.info("ConsumerMessageListen，收到消息: {}", message.toString());
        });
        return container;
    }
}
