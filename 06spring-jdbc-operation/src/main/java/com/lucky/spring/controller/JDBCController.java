package com.lucky.spring.controller;

import com.lucky.spring.module.Product;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

/**
 * Created by zhangdd on 2020/7/21
 */

@RestController
@Slf4j
public class JDBCController {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @GetMapping("/api/jdbc-oper/createTable")
    public void createTable() {
        String sql = "create table product (id int primary key auto_increment,name varchar(64),description varchar(128))";
        jdbcTemplate.execute(sql);
    }

    @GetMapping("/api/jdbc-oper/addData")
    public void addData() {
        String sql = "insert into product(name) values(?)";
        Arrays.asList("Java编程思想", "Spring boot in action", "spark")
                .forEach(p -> {
                    jdbcTemplate.update(sql, p);
                });
    }

    @GetMapping("/api/jdbc-oper/updateData")
    public void updateData() {
        String sql = "update product set description='这是Java编程思想' where name ='Java编程思想'";
        jdbcTemplate.update(sql);
    }

    @GetMapping("/api/jdbc-oper/deleteData")
    public void deleteData() {
        String sql = "";
        jdbcTemplate.update(sql);
    }

    @GetMapping("/api/jdbc-oper/queryForInt")
    public void queryForInt() {
        String sql = "select count(*) from product";
        Integer totalNum = jdbcTemplate.queryForObject(sql, Integer.class);
        System.out.println(totalNum);
    }

    @GetMapping("/api/jdbc-oper/queryName")
    public void queryName() {
        String sql = "select name from product";
        List<String> names = jdbcTemplate.queryForList(sql, String.class);
        System.out.println(names);
    }

    @GetMapping("/api/jdbc-oper/queryProduct")
    public void queryProduct() {
        String sql = "select * from product";
        List<Product> productList = jdbcTemplate.query(sql, new RowMapper<Product>() {
            @Nullable
            @Override
            public Product mapRow(ResultSet resultSet, int i) throws SQLException {
                return Product.builder()
                        .id(resultSet.getInt(1))
                        .name(resultSet.getString(2))
                        .build();
            }
        });
        productList.forEach(product -> log.info("product:{}", product));

    }

    @GetMapping("/api/jdbc-oper/batchInsert")
    public void batchInsert() {
        String sql = "insert into product (name) values (?)";
        List<String> products = Arrays.asList("product1", "product2", "product3");
        jdbcTemplate.batchUpdate(sql, new BatchPreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement preparedStatement, int i) throws SQLException {
                preparedStatement.setString(1, products.get(i));
            }
            @Override
            public int getBatchSize() {
                return products.size();
            }
        });

    }


}
