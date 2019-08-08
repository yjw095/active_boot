package com.fdc.active.controller;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.fdc.active.domain.ResidentialInfo;
import com.fdc.active.service.BuildService;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2018/5/28.
 */
@Controller
public class BuildingController {


    private static final Logger log = org.slf4j.LoggerFactory.getLogger(BuildingController.class);
    @Autowired
    BuildService buildService;



    @RequestMapping(value ="/activeboot.getone", method = RequestMethod.GET)
    public ModelAndView getone(String pinyin){
        ModelAndView mode = new ModelAndView();
        mode.setViewName("house");
        ResidentialInfo info = buildService.selectByPinyin(pinyin);
        mode.addObject("info" , info);
        return mode;
    }

    @RequestMapping(value ="/activeboot.getone2", method = RequestMethod.GET)
    public ModelAndView getone2(String pinyin){
        ModelAndView mode = new ModelAndView();
        mode.setViewName("house");
        ResidentialInfo info = buildService.selectByPinyin(pinyin);
        mode.addObject("info" , info);
        return mode;
    }



}
