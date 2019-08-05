package com.fdc.active.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.concurrent.TimeUnit;

/**
 * Created by Administrator on 2018/12/3.
 */
@Service
public class RedisService<T> {
/*

    @Autowired
    private RedisTemplate redisTemplate;



    public boolean put(final String key,final T value,Long time) {
        ValueOperations<String, T> valueOperations = redisTemplate.opsForValue();
        valueOperations.set(key,value, time ,TimeUnit.MINUTES);
        return true;
    }


    public Object get(final String key) {
        ValueOperations<String, T> valueOperations = redisTemplate.opsForValue();
        return valueOperations.get(key);
    }



    public void delete(String key) {
        redisTemplate.delete(key);
    }

*/


}
