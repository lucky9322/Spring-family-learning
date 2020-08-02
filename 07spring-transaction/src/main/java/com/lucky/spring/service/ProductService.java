package com.lucky.spring.service;

/**
 * Created by zhangdd on 2020/7/26
 */
public interface ProductService {
    void insertRecord();

    void insertThenRollback() throws RuntimeException;

    void invokeInsertThenRollback() throws RuntimeException;

    void insertRecordWhenCrash();
}
