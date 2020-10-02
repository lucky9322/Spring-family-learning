package com.lucky.spring.controller;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * Created by zhangdd on 2020/9/16
 */
@RestController
public class SendDirectMsgController {

    @Autowired
    RabbitTemplate rabbitTemplate;


    @GetMapping("/sendDirectMsg")
    public void sendDirectMsg() {
        String uuid = String.valueOf(UUID.randomUUID());
        String msg = "test message, hello!";
        String createTime = new Date().toString();
        Map<String,Object> map=new HashMap<>();
        map.put("messageId",uuid);
        map.put("messageData",msg);
        map.put("createTime",createTime);

        //将消息携带绑定键值：directRouting 发送到交换机 directExchange
        rabbitTemplate.convertAndSend("directExchange", "directRouting", map);
    }
}
