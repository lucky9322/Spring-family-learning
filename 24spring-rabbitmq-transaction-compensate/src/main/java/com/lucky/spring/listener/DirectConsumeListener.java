package com.lucky.spring.listener;

import com.rabbitmq.client.impl.AMQImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.boot.autoconfigure.amqp.RabbitProperties;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;

/**
 * Created by zhangdd on 2020/10/7
 */
@Configuration
public class DirectConsumeListener {

    private Logger log = LoggerFactory.getLogger(DirectConsumeListener.class);

    /**
     * 监听指定队列 mq.direct.1
     *
     * @param message
     */
    @RabbitListener(queues = "mq.direct.1")
    public void consume(Message message) {
        log.info("DirectConsumeListener，收到消息: {}", message.toString());
    }

    /**
     * 监听发红包
     * @param message
     * @param channel
     * @throws IOException
     */
    @RabbitListener(queues = "exchange.send.bonus")
    public void consume(Message message, RabbitProperties.Cache.Channel channel) throws IOException {
        String msgJson = new String(message.getBody(),"UTF-8");
        log.info("收到消息: {}", message.toString());

        //调用发红包接口
    }

    /**
     * 监听发短信
     * @param message
     * @param channel
     * @throws IOException
     */
    @RabbitListener(queues = "exchange.sms.message")
    public void consume(Message message, AMQImpl.Channel channel) throws IOException {
        String msgJson = new String(message.getBody(),"UTF-8");
        log.info("收到消息: {}", message.toString());

        //调用发短信接口
    }
}
