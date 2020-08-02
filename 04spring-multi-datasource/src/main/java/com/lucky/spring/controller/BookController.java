package com.lucky.spring.controller;

import com.lucky.spring.config.BookConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by zhangdd on 2020/7/16
 */
@RestController
public class BookController {

    @Autowired
    BookConfig bookConfig;

    @GetMapping("/api/queryBook")
    public String queryBook() {
        StringBuilder builder = new StringBuilder();
        StringBuilder bookInfo = builder.append(bookConfig.getName())
                .append(",")
                .append(bookConfig.getPrice())
                .append(",")
                .append(bookConfig.getVersion());
        return bookInfo.toString();
    }
}
