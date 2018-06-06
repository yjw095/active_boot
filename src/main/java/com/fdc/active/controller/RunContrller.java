package com.fdc.active.controller;

import com.fdc.active.service.BuildService;
import com.fdc.active.service.RentHouseService;
import org.slf4j.Logger;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;

import javax.annotation.PostConstruct;

/**
 * Created by Administrator on 2018/6/5.
 */
@Controller
public class RunContrller implements InitializingBean {

    private static final Logger log = org.slf4j.LoggerFactory.getLogger(RunContrller.class);
    @Autowired
    BuildService buildService;
    @Autowired
    private RentHouseService rentHouseService;
    @Value(value = "${spring.profiles.active}")
    String profiles ;


   @PostConstruct
    public void init(){
        log.info("---  init  begin to running  profiles:{}----" ,profiles);
        rentHouseService.sysHouse();
        log.info(" ---- is over ----");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        log.info("--- afterPropertiesSet begin to running ----");
    }






}
