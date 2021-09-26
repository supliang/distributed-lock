package com.fit2cloud.distlock.entity;

public class Good {

    private Long id;

    private String name;

    private Integer stock;

    public Long getId() {
        return id;
    }

    public Good setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Good setName(String name) {
        this.name = name;
        return this;
    }

    public Integer getStock() {
        return stock;
    }

    public Good setStock(Integer stock) {
        this.stock = stock;
        return this;
    }
}
