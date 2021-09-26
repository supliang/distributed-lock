package com.fit2cloud.distlock.service;

public interface DistLockService {
    /**
     * 抢购
     *
     * @param id product id
     */
    void buy(Long id);

}
