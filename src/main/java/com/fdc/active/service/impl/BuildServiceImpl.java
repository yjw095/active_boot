package com.fdc.active.service.impl;

import com.fdc.active.dao.ResidentialInfoMapper;
import com.fdc.active.domain.ResidentialInfo;
import com.fdc.active.service.BuildService;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2018/5/28.
 */
@Service("buildService")
public class BuildServiceImpl implements BuildService {


    @Autowired
    ResidentialInfoMapper residentialInfoMapper;


    private static final Logger log = org.slf4j.LoggerFactory.getLogger(BuildServiceImpl.class);

    @Cacheable(value="info", key="#pinyin")
    public ResidentialInfo selectByPinyin(String pinyin){
        ResidentialInfo info = residentialInfoMapper.selectByPinyin(pinyin);
        return info;
    }





}
