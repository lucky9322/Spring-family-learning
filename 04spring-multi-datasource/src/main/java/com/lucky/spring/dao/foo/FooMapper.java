package com.lucky.spring.dao.foo;

import com.lucky.spring.model.foo.Foo;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface FooMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Foo record);

    int insertSelective(Foo record);

    Foo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Foo record);

    int updateByPrimaryKey(Foo record);

    List<Foo> queryList();
}