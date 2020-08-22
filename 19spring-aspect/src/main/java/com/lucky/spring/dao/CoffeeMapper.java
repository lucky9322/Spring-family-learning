package com.lucky.spring.dao;

import com.lucky.spring.model.Coffee;

public interface CoffeeMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Coffee record);

    int insertSelective(Coffee record);

    Coffee selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Coffee record);

    int updateByPrimaryKey(Coffee record);
}