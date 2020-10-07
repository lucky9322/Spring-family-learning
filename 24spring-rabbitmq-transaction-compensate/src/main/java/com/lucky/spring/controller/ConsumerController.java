package com.lucky.spring.controller;

import com.lucky.spring.entity.ConsumerInfo;
import com.lucky.spring.util.RabbitUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by zhangdd on 2020/10/7
 */
@RestController
public class ConsumerController {

    @Autowired
    private SimpleMessageListenerContainer container;

    @Autowired
    private RabbitUtil rabbitUtil;

    private Logger log = LoggerFactory.getLogger(ConsumerController.class);

    /**
     * 添加队列到监听器
     *
     * @param consumerInfo
     */
    @PostMapping("/consume/addQueue")
    public void addQueue(@RequestBody ConsumerInfo consumerInfo) {
        boolean existQueue = rabbitUtil.existQueue(consumerInfo.getQueueName());
        if (!existQueue) {
            throw new RuntimeException("当前队列不存在");
        }
        //添加mq监听的队列
        container.addQueueNames(consumerInfo.getQueueName());
        //打印监听容器中正在监听到队列
        log.info("container-queue:{}", container.getQueueNames());
    }

    /**
     * 移除正在监听的队列
     *
     * @param consumerInfo
     */
    @PostMapping("/consume/removeQueue")
    public void removeQueue(@RequestBody ConsumerInfo consumerInfo) {
        //移除mq监听的队列
        container.removeQueueNames(consumerInfo.getQueueName());
        //打印监听容器中正在监听到队列
        log.info("container-queue:{}", container.getQueueNames());
    }

    /**
     * 查询监听容器中正在监听到的队列
     */
    @PostMapping("/consume/queryListenerQueue")
    public void queryListenerQueue() {
        log.info("container-queue:{}", container.getQueueNames());
    }
}
