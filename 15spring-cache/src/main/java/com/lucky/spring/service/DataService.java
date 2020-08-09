package com.lucky.spring.service;

import java.util.List;

/**
 * Created by zhangdd on 2020/8/9
 */
public interface DataService {

    List<String> findAllName();

    void reloadPerson();
}
