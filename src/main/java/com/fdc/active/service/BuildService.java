package com.fdc.active.service;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.fastjson.JSON;
import com.fdc.active.dao.*;
import com.fdc.active.domain.ResidentialInfo;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by Administrator on 2018/5/28.
 */
@Service("buildService")
public class BuildService {


    @Autowired
    ResidentialInfoMapper residentialInfoMapper;


    private static final Logger log = org.slf4j.LoggerFactory.getLogger(BuildService.class);

    @Cacheable(value="info", key="#pinyin")
    public ResidentialInfo selectByPinyin(String pinyin){
        ResidentialInfo info = residentialInfoMapper.selectByPinyin(pinyin);
        return info;
    }





}
