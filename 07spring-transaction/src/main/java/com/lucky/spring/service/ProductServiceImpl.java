package com.lucky.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by zhangdd on 2020/7/26
 */
@Service
public class ProductServiceImpl implements ProductService {


    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    //通过设置@Transactional就开启了事务
    @Transactional
    public void insertRecord() {
        jdbcTemplate.execute("insert into product(name,description) values ('spring boot in action 1','书籍 spring boot in action 1') ");
    }

    @Override
    @Transactional(rollbackFor = RuntimeException.class)
    public void insertThenRollback() throws RuntimeException {
        jdbcTemplate.execute("insert into product(name,description) values ('spring boot in action 2','书籍 spring boot in action 2') ");
        throw new RuntimeException();
    }

    /**
     * 调用带有事务注解的方法
     * 这种形式 事务不会回滚，即数据会插入到数据库里
     *
     * @throws RuntimeException
     */
    @Override
    public void invokeInsertThenRollback() throws RuntimeException {
        insertThenRollback();
    }

    /**
     * 调用的普通方法发生了异常
     * <p>
     * 数据会回滚
     */
    @Override
    @Transactional(rollbackFor = RuntimeException.class)
    public void insertRecordWhenCrash() {
        jdbcTemplate.execute("insert into product(name,description) values ('spring boot in action 3','书籍 spring boot in action 3') ");
        crash();
    }

    private void crash() throws RuntimeException {
        throw new RuntimeException();
    }
}
