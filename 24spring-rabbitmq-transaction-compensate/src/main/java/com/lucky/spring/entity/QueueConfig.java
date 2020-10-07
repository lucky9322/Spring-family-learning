package com.lucky.spring.entity;

import java.io.Serializable;

/**
 * Created by zhangdd on 2020/10/7
 */
public class QueueConfig implements Serializable {


    private static final long serialVersionUID = -6576396650731444495L;
    /**
     * 交换器类型
     */
    private String exchangeType;

    /**
     * 交换器名称
     */
    private String exchangeName;

    /**
     * 队列名称
     */
    private String queueName;

    /**
     * 路由键key
     */
    private String routingKey;

    public String getExchangeType() {
        return exchangeType;
    }

    public void setExchangeType(String exchangeType) {
        this.exchangeType = exchangeType;
    }

    public String getExchangeName() {
        return exchangeName;
    }

    public void setExchangeName(String exchangeName) {
        this.exchangeName = exchangeName;
    }

    public String getQueueName() {
        return queueName;
    }

    public void setQueueName(String queueName) {
        this.queueName = queueName;
    }

    public String getRoutingKey() {
        return routingKey;
    }

    public void setRoutingKey(String routingKey) {
        this.routingKey = routingKey;
    }
}