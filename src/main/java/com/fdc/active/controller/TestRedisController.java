package com.fdc.active.controller;

import com.fdc.active.domain.es.ResidentialInfoEs;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.SearchQuery;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * Created by Administrator on 2018/12/3.
 */
@Controller
public class TestRedisController {


    @Autowired
    StringRedisTemplate redisTemplate;

    @Autowired
    ElasticsearchTemplate elasticsearchTemplate ;


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


    @RequestMapping(value ="/activeboot.es", method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> es(String pinyin){
        Map<String,Object> map = new HashMap<>();
        map.put("data","[]");
        QueryBuilder qb = QueryBuilders.termQuery("pinyin", pinyin);
        SearchQuery searchQuery = new NativeSearchQueryBuilder().withQuery(qb).withPageable(new PageRequest(0, 20)).build();

        List<ResidentialInfoEs> list = elasticsearchTemplate.queryForList(searchQuery ,ResidentialInfoEs.class);
        map.put("data", list);
        return map;
    }

}
