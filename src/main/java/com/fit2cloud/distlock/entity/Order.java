package com.fit2cloud.distlock.entity;

import java.util.Date;

public class Order {

    private Long id;

    private Long goodId;

    private Long userId;

    public Long getId() {
        return id;
    }

    public Order setId(Long id) {
        this.id = id;
        return this;
    }

    public Long getGoodId() {
        return goodId;
    }

    public Order setGoodId(Long goodId) {
        this.goodId = goodId;
        return this;
    }

    public Long getUserId() {
        return userId;
    }

    public Order setUserId(Long userId) {
        this.userId = userId;
        return this;
    }
}
