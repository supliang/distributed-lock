package com.fit2cloud.distlock.entity;

public class DbLock {

    private Long id;

    private String dbKey;

    private String value;

    public Long getId() {
        return id;
    }

    public DbLock setId(Long id) {
        this.id = id;
        return this;
    }

    public String getDbKey() {
        return dbKey;
    }

    public DbLock setDbKey(String dbKey) {
        this.dbKey = dbKey;
        return this;
    }

    public String getValue() {
        return value;
    }

    public DbLock setValue(String value) {
        this.value = value;
        return this;
    }
}
