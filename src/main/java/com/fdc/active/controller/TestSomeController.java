package com.fdc.active.controller;

import com.fdc.active.domain.ResidentialInfo;
import com.fdc.active.service.decorator.ComponentDecoratorService;
import com.fdc.active.service.decorator.ComponentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2019/8/7.
 */
@Controller
public class TestSomeController {

    @Autowired
    ComponentService componentDecoratorService ;
    @Autowired
    ComponentDecoratorService componentDecoratorService2;
    @Autowired
    ComponentService componentService;

    @RequestMapping(value ="/some1", method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> getInfo(String pinyin){
        Map<String,Object> map = new HashMap<>();
        map.put("data","[]");
        ResidentialInfo info = componentDecoratorService.getInfoByPinyin(pinyin);
        map.put("data", info);
        return map;
    }


    @RequestMapping(value ="/some2", method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> getInfo2(String pinyin){
        Map<String,Object> map = new HashMap<>();
        map.put("data","[]");
        List<ResidentialInfo> info = componentDecoratorService2.selectList();
        map.put("data", info);
        return map;
    }

    @RequestMapping(value ="/some3", method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> getInfo3(String pinyin){
        Map<String,Object> map = new HashMap<>();
        map.put("data","[]");
        ResidentialInfo info = componentService.getInfoByPinyin(pinyin);
        map.put("data", info);
        return map;
    }

}
