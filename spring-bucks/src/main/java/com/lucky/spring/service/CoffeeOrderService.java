package com.lucky.spring.service;

import com.lucky.spring.dao.OrderCoffeeMapperExt;
import com.lucky.spring.dao.OrderMapper;
import com.lucky.spring.dao.OrderMapperExt;
import com.lucky.spring.model.Coffee;
import com.lucky.spring.model.Order;
import com.lucky.spring.model.OrderCoffee;
import com.lucky.spring.model.OrderStateEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by zhangdd on 2020/8/3
 */
@Service
@Slf4j
public class CoffeeOrderService {

    @Autowired
    OrderCoffeeMapperExt orderCoffeeMapperExt;

    @Autowired
    OrderMapperExt orderMapperExt;

    @Autowired
    OrderMapper orderMapper;


    @Transactional
    public Order createOrder(String customer, Coffee... coffees) {
        Date now = new Date();
        Order order = Order.builder().state(OrderStateEnum.INIT.getVal())
                .customer(customer)
                .createTime(now).build();
        orderMapper.insertSelective(order);

        List<OrderCoffee> orderCoffees = Arrays.stream(coffees).map(item -> {
            return OrderCoffee.builder().coffeeOrderId(order.getId()).itemsId(item.getId()).build();
        }).collect(Collectors.toList());

        int i = orderCoffeeMapperExt.batchInsert(orderCoffees);
        if (i <= 0) {
            throw new RuntimeException("下单失败");
        }
        log.info("下单信息 customer:{},coffees:{}", customer, coffees.toString());
        return order;
    }

    @Transactional
    public boolean updateOrderState(Order order, OrderStateEnum state) {
        if (state.getVal().compareTo(order.getState()) < 0) {
            log.error("Wrong State order,state:{},order.state:{}", state, order.getState());
            return false;
        }
        order.setState(state.getVal());
        order.setUpdateTime(new Date());
        orderMapper.updateByPrimaryKeySelective(order);
        return true;
    }
}
