package com.lucky.spring.receiver.topic;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * Created by zhangdd on 2020/9/20
 */
@Component
@RabbitListener(queues = "topic.man")
public class TopicManReceiver {

    @RabbitHandler
    public void process(Map msg) {
        System.out.println("TopicManReceiver消费者收到消息  : " +
                msg.toString());
    }
}
