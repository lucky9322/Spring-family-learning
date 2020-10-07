package com.lucky.spring.entity;

import java.io.Serializable;

/**
 * Created by zhangdd on 2020/10/7
 */
public class ProduceInfo implements Serializable {

    private static final long serialVersionUID = -5816966739399349770L;
    /**
     * 交换器名称
     */
    private String exchangeName;

    /**
     * 路由键key
     */
    private String routingKey;

    /**
     * 消息内容
     */
    public String msg;

    public String getExchangeName() {
        return exchangeName;
    }

    public void setExchangeName(String exchangeName) {
        this.exchangeName = exchangeName;
    }

    public String getRoutingKey() {
        return routingKey;
    }

    public void setRoutingKey(String routingKey) {
        this.routingKey = routingKey;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
