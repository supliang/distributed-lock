package com.fit2cloud.distlock.service.impl;

import com.alibaba.fastjson.support.spring.FastJsonRedisSerializer;
import com.fit2cloud.distlock.entity.Good;
import com.fit2cloud.distlock.mapper.GoodMapper;
import com.fit2cloud.distlock.service.DistLockService;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

@Service("redisLockService")
public class RedisLockService implements DistLockService {

    @Resource
    private GoodMapper goodMapper;
    @Resource
    private RedisTemplate<String, Integer> myRedisTemplate;

    @Override
    public synchronized void buy(Long id) {
        try {
            if (myRedisTemplate.opsForValue().setIfAbsent("buy", 1, 30, TimeUnit.SECONDS)) {
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
            }
        } finally {
            myRedisTemplate.delete("buy");
        }
    }

}
