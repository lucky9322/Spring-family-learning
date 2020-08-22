package com.lucky.spring.model;

import java.util.Date;
import lombok.*;

@Data
@EqualsAndHashCode
@ToString(callSuper = true)
@Builder
public class Coffee {
    private Long id;

    private String name;

    private Long price;

    private Date createTime;

    private Date updateTime;
}