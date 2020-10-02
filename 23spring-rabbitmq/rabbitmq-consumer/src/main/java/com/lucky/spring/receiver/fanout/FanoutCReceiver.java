package com.lucky.spring.receiver.fanout;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * Created by zhangdd on 2020/9/20
 */
@Component
@RabbitListener(queues = "fanout.C")
public class FanoutCReceiver {

    @RabbitHandler
    public void process(Map testMessage) {
        System.out.println("FanoutReceiverC消费者收到消息  : " +
                testMessage.toString());
    }

}
