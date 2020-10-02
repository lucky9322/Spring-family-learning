package com.lucky.spring.receiver.direct;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * Created by zhangdd on 2020/9/19
 */
@Component
@RabbitListener(queues = "directQueue")//配置要监听的队列的名字
public class DirectReceiver {
    @RabbitHandler
    public void process(Map msg) {
        System.out.println("DirectReceiver:收到的消息是:" + msg.toString());
    }
}
