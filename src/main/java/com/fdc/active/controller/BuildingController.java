package com.fdc.active.controller;


import com.fdc.active.service.BuildService;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Administrator on 2018/5/28.
 */
@Controller
public class BuildingController {


    private static final Logger log = org.slf4j.LoggerFactory.getLogger(BuildingController.class);
    @Autowired
    BuildService buildService;

    @RequestMapping(value ="/activeboot.all", method = RequestMethod.GET)
    @ResponseBody
    public String home(){
        int a = buildService.update();
        return "你好，world  " + a;
    }


    @RequestMapping(value ="/activeboot.getone", method = RequestMethod.GET)
    @ResponseBody
    public String updateOne(String pinyin){
        int a = buildService.updateByResId(pinyin);
        return "the result:" + a;
    }





}
