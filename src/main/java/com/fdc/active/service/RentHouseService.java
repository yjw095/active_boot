package com.fdc.active.service;

import com.alibaba.dubbo.common.io.StreamUtils;
import com.alibaba.dubbo.config.annotation.Reference;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.text.MessageFormat;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2018/6/6.
 */
@Service("rentHouseService")
public class RentHouseService {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    //@Reference(version="test1.0.0")
    //SyncHouseRentService syncHouseRentService ;
   // @Reference(version = "${hello.service.version}")
   // private SyncResidentialFrontService syncResidentialFrontService ;
    private static final Logger log = org.slf4j.LoggerFactory.getLogger(RentHouseService.class);


    public int sysRes2(String id){
        log.info("id:{}" ,id);
      //  boolean b =syncResidentialFrontService.syncResidential(id,"42_01");
      //  log.info("b:{}" ,b);
        return 0;
    }

    public int sysRes(){
        int index[] = {0};
        String sharding_id = "42_01" ;
        String sql = "SELECT id,`house_special`,tags_id  FROM `residential_sub_info` where `house_special` like ''%h255%'' and residential_info_id = ''{0}''" ;
        String sql2 = "SELECT DISTINCT( `residential_info_id`) as id   FROM `residential_sub_info` where `house_special` like '%h255%'";
        String sql4 = "update residential_sub_info set tags_id = ''{0}'' where id=''{1}'' " ;
        List<String> list = jdbcTemplate.queryForList(sql2,String.class);
        list.stream().forEach(s -> {
            log.info("total:{} index:{} s:{}" ,list.size() ,++index[0] ,s);
            String sql3 = MessageFormat.format(sql,s);
           // log.info("select sub sql:{}" ,sql3);
            List<Map<String,Object>> subs = jdbcTemplate.queryForList(sql3);
            updateSub(subs ,sql4);
            //boolean b = syncResidentialFrontService.syncResidential(s,sharding_id);
            //log.info("asy:{}" ,b);
            log.info("");log.info("");
        });
        return 1;
    }

    public void updateSub( List<Map<String,Object>> subs,String sql4 ){
        for(Map<String,Object> sub: subs){
            String id = sub.get("id").toString();
            String house_special = sub.get("house_special").toString();
            String tags_id = sub.get("tags_id").toString();
            if(tags_id.indexOf("8956")>-1 && tags_id.indexOf("8555")>-1){
                tags_id = tags_id.replace(",8956","");
                tags_id = tags_id.replace("8956,","");
            }
            tags_id = tags_id.replace("8956","8555");
            String sql3 = MessageFormat.format(sql4,tags_id , id);
            int a = jdbcTemplate.update(sql3);
            log.info("two update---:{}" ,a);

        }
    }




}
