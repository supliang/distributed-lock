package com.fit2cloud.distlock.controller;

import com.fit2cloud.distlock.service.DistLockService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author Rory
 */
@RestController
public class OrderController {

    //@Resource(name = "singleLockServiceImpl")
    //private DistLockService distLockService;

    //@Resource(name = "dbLockServiceImpl")
    //private DistLockService distLockService;

    //@Resource(name = "redisLockService")
    //private DistLockService distLockService;

    @Resource(name = "redissonLockService")
    private DistLockService distLockService;

    @GetMapping("/buy/{id}")
    public void buy(@PathVariable Long id) {
        distLockService.buy(id);
    }

}
