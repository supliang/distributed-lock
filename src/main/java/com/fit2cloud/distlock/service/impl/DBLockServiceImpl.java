package com.fit2cloud.distlock.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.fit2cloud.distlock.entity.DbLock;
import com.fit2cloud.distlock.entity.Good;
import com.fit2cloud.distlock.mapper.DBLockMapper;
import com.fit2cloud.distlock.mapper.GoodMapper;
import com.fit2cloud.distlock.service.DistLockService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author Ronny
 */
@Service("dbLockServiceImpl")
public class DBLockServiceImpl implements DistLockService {

    @Resource
    private GoodMapper goodMapper;
    @Resource
    private DBLockMapper dbLockMapper;

    @Override
    public synchronized void buy(Long id) {
        try {
            dbLockMapper.insert(new DbLock().setDbKey("buy").setValue("1"));
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
        } catch (Exception e) {
        } finally {
            dbLockMapper.delete(new QueryWrapper<DbLock>().eq("db_key", "buy"));
        }
    }

}
