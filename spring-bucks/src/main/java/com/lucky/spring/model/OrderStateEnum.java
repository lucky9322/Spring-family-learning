package com.lucky.spring.model;

import lombok.Getter;

/**
 * Created by zhangdd on 2020/8/3
 */
@Getter
public enum OrderStateEnum {
    INIT(10),
    PAID(11),
    BREWING(12),//制作中
    BREWED(13),//制作完成
    TAKEN(14),//取货
    CANCELLED(15);//取消订单

    private Integer val;

    OrderStateEnum(Integer val) {
        this.val = val;
    }
}
