package com.fit2cloud.distlock.config;

import com.alibaba.fastjson.support.spring.FastJsonRedisSerializer;
import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.RedisTemplate;

@Configuration
public class RedisConfig {

    @Autowired
    private RedisTemplate redisTemplate;

    @Bean("myRedisTemplate")
    public RedisTemplate redisTemplate() {
        FastJsonRedisSerializer serializer = new FastJsonRedisSerializer(String.class);
        redisTemplate.setKeySerializer(serializer);
        redisTemplate.setValueSerializer(serializer);
        return redisTemplate;
    }

    @Bean
    public RedissonClient redissonClient() {
        // 1. Create config object
        Config config = new Config();
        config.useSingleServer()
                .setAddress("redis://127.0.0.1:6379").setPassword("fit2cloud").setDatabase(1);
        return Redisson.create(config);
    }

}
