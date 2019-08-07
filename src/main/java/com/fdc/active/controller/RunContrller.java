package com.fdc.active.controller;

import com.fdc.active.service.BuildService;
import com.fdc.active.service.impl.RentHouseService;
import org.slf4j.Logger;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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
   // @Reference(version = "${hello.service.version}")
  //  private SyncResidentialFrontService syncResidentialFrontService ;
    @Value(value = "${spring.profiles.active}")
    String profiles ;
    @Value(value = "${hello.service.version}")
    String version ;

    @PostConstruct
    public void init(){
        log.info("---  init  begin to running  profiles:{}, version:{}----" ,profiles ,version);
        //rentHouseService.sysRes2("90BEBF2D-1209-4113-B526-56C4BEA897DD");
       // boolean b =syncResidentialFrontService.syncResidential("90BEBF2D-1209-4113-B526-56C4BEA897DD","42_01");
      //  log.info(" ---- is over  b:{}----" ,b);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        log.info("--- afterPropertiesSet begin to running ----");
    }






}
