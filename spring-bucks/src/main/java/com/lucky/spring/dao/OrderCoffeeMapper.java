package com.lucky.spring.dao;

import com.lucky.spring.model.OrderCoffee;

public interface OrderCoffeeMapper {
    int deleteByPrimaryKey(Long id);

    int insert(OrderCoffee record);

    int insertSelective(OrderCoffee record);

    OrderCoffee selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(OrderCoffee record);

    int updateByPrimaryKey(OrderCoffee record);
}