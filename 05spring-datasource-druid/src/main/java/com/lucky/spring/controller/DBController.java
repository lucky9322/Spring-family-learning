package com.lucky.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.sql.DataSource;

/**
 * Created by zhangdd on 2020/7/20
 */
@RestController
public class DBController {

    @Autowired
    JdbcTemplate template;

    @GetMapping("/api/getDBInfo")
    public String getDBInfo() {
        DataSource dataSource = template.getDataSource();
        StringBuilder builder = new StringBuilder();
        builder.append("dataSourceType:").append(dataSource.getClass().getSimpleName()).append("\n")
        ;
        return builder.toString();
    }
}
