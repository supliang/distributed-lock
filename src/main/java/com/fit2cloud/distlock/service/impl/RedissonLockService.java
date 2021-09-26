package com.fit2cloud.distlock.service.impl;

import com.fit2cloud.distlock.entity.Good;
import com.fit2cloud.distlock.mapper.GoodMapper;
import com.fit2cloud.distlock.service.DistLockService;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("redissonLockService")
public class RedissonLockService implements DistLockService {

    @Resource
    private GoodMapper goodMapper;

    @Resource
    private RedissonClient redissonClient;

    @Override
    public void buy(Long id) {
        RLock lock = redissonClient.getLock("buy");
        try {
            lock.lock();
            Good good = goodMapper.selectById(id);
            int stock = good.getStock();
            System.out.println("库存:" + stock);
            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (stock <= 0) {
                return;
            }
            good.setStock(stock - 1);
            goodMapper.updateById(good);
        } finally {
            lock.unlock();
        }
    }
}
