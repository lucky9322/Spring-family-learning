package com.lucky.spring.controller;

import com.lucky.spring.model.T;
import com.lucky.spring.service.DataOpeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * Created by zhangdd on 2020/7/10
 */
@RestController
public class DataOperationController {


    @Autowired
    DataOpeService service;

    @GetMapping("/api/queryData")
    public String queryData() {
        return service.queryData();
    }

    @PostMapping("/api/addData")
    public String addData() {
        try {
            service.addData();
            return "add data success";
        } catch (Exception e) {
            e.printStackTrace();
            return "add data fail";
        }
    }
}
