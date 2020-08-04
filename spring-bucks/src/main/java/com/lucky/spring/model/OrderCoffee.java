package com.lucky.spring.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class OrderCoffee {

    private Long id;

    private Long coffeeOrderId;

    private Long itemsId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCoffeeOrderId() {
        return coffeeOrderId;
    }

    public void setCoffeeOrderId(Long coffeeOrderId) {
        this.coffeeOrderId = coffeeOrderId;
    }

    public Long getItemsId() {
        return itemsId;
    }

    public void setItemsId(Long itemsId) {
        this.itemsId = itemsId;
    }
}