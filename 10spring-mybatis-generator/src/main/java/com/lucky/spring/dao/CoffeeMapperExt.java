package com.lucky.spring.dao;

import com.lucky.spring.model.Coffee;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 《扩展Mapper映射文件操作，由Mybatis Generator插件自动生成，多次生成，不会覆盖》
 *
 * @author Mybatis Generator
 * @date 2020-08-02
 */
@Repository
public interface CoffeeMapperExt extends CoffeeMapper {


    /**
     * 小于某个价格的咖啡
     * @param price
     * @return
     */
    List<Coffee> queryLessThanByPrice(@Param("price") Long price);

    /**
     * 大于某个价格的咖啡
     * @param price
     * @return
     */
    List<Coffee> queryGreaterThanByPrice(@Param("price") Long price);
}