package com.lucky.spring.dao;

import com.lucky.spring.model.OrderCoffee;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 《扩展Mapper映射文件操作，由Mybatis Generator插件自动生成，多次生成，不会覆盖》
 *
 * @author Mybatis Generator
 * @date 2020-08-03
 */
@Repository
public interface OrderCoffeeMapperExt extends OrderCoffeeMapper {

    /**
     * 创建订单时，该订单包含的咖啡
     *
     * @param orderCoffees
     * @return
     */
    int batchInsert(@Param("orderCoffees") List<OrderCoffee> orderCoffees);
}