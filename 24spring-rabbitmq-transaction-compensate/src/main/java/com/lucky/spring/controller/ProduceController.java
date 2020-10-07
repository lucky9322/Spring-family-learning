package com.lucky.spring.controller;

import com.lucky.spring.entity.ProduceInfo;
import com.lucky.spring.util.RabbitUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by zhangdd on 2020/10/7
 */
@RestController
public class ProduceController {
    @Autowired
    private RabbitUtil rabbitUtil;

    /**
     * 发送消息到交换器
     *
     * @param produceInfo
     */
    @PostMapping("/produce/sendMessage")
    public void sendMessage(@RequestBody ProduceInfo produceInfo) {
        rabbitUtil.convertAndSend(produceInfo.getExchangeName(),
                produceInfo.getRoutingKey(),
                produceInfo);
    }
}
