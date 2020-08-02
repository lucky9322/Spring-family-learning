package com.lucky.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * Created by zhangdd on 2020/7/20
 */
@RestController
public class DataController {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @GetMapping("/api/v1/queryData")
    public Object queryData() {
        try {
            String sql = "select id from t";
            List<Map<String, Object>> result = jdbcTemplate.queryForList(sql);
            return result;
        } catch (Exception e) {
            return "查询失败";
        }
    }
}
