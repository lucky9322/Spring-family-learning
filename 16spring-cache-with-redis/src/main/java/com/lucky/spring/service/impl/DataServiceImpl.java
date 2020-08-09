package com.lucky.spring.service.impl;

import com.lucky.spring.service.DataService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhangdd on 2020/8/9
 */
@Service
@Slf4j
public class DataServiceImpl implements DataService {

    @Cacheable(value = "person")
    @Override
    public List<String> findAllName() {
        log.info(" mock query from db");
        //模拟从数据库查询数据
        List<String> data = new ArrayList<>();
        data.add("张飞");
        data.add("赵云");
        data.add("许褚");

        return data;
    }

    @CacheEvict(value = "person")
    @Override
    public void reloadPerson(){
        log.info("clear cache data");
    }
}
