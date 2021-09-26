package com.fit2cloud.distlock.service.impl;

import com.fit2cloud.distlock.entity.Good;
import com.fit2cloud.distlock.mapper.GoodMapper;
import com.fit2cloud.distlock.service.DistLockService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author Ronny
 */
@Service("singleLockServiceImpl")
public class SingleLockServiceImpl implements DistLockService {

    @Resource
    private GoodMapper goodMapper;

    @Override
    public synchronized void buy(Long id) {
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

}
