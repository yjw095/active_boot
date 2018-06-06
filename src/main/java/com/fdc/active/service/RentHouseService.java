package com.fdc.active.service;

import com.alibaba.dubbo.config.annotation.Reference;
import com.fdc.home.workstation.service.inter.SyncHouseRentService;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2018/6/6.
 */
@Service("rentHouseService")
public class RentHouseService {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Reference(version="test1.0.0")
    SyncHouseRentService syncHouseRentService ;
    private static final Logger log = org.slf4j.LoggerFactory.getLogger(RentHouseService.class);



    public int sysHouse(){
        String sharding_id = "42_01";
        String sql = "select id from house_rent where  operate_label = 'c56' and del_state = '0' and publish_state='2'";
        List<String> list = jdbcTemplate.queryForList(sql,String.class);
        list.stream().forEach(s -> {
            try {
                boolean b = syncHouseRentService.syncHouseRent(s, sharding_id);
                log.info("total:{}  b:{}" ,list.size() ,b);
            }catch (Exception e){
                log.error("" ,e);
            }
        });
        return 0;
    }


}
