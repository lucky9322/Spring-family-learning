package com.lucky.spring.dao;

import com.lucky.spring.model.Person;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 《扩展Mapper映射文件操作，由Mybatis Generator插件自动生成，多次生成，不会覆盖》
 *
 * @author Mybatis Generator
 * @date 2020-08-08
 */
@Repository
public interface PersonMapperExt extends PersonMapper {

    int batchUpdate(@Param("persons") List<Person> persons);
}