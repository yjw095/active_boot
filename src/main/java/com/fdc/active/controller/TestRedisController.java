package com.fdc.active.controller;

import com.fdc.active.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.concurrent.TimeUnit;

/**
 * Created by Administrator on 2018/12/3.
 */
@Controller
public class TestRedisController {

    @Autowired
    RedisService redisService ;

    @Autowired
    StringRedisTemplate redisTemplate;

    @RequestMapping(value ="/activeboot.redis", method = RequestMethod.GET)
    @ResponseBody
    public String home(String key,String get){
        if(get == null){
          //  redisService.put( key,"world" ,5L);
        }
       // Object obj = redisService.get(key);

        return "你好，world  " ;
    }

    @RequestMapping(value ="/activeboot.redis2", method = RequestMethod.GET)
    @ResponseBody
    public String home2(String key,String get){
        ValueOperations<String, String> opsForValue = redisTemplate.opsForValue();
        if(get == null){
            opsForValue.set( key,"cluster test",5, TimeUnit.MINUTES);
        }
        String str = opsForValue.get(key);
        // Object obj = redisService.get(key);
        return "你好，world  " + str;
    }

}
