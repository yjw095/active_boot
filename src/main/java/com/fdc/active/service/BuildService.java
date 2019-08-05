package com.fdc.active.service;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.fastjson.JSON;
import com.fdc.active.dao.*;
import com.fdc.active.domain.Building;
import com.fdc.active.domain.ResidentialInfo;
import com.fdc.active.domain.Unit;
import com.fdc.home.workstation.service.inter.SyncResidentialFrontService;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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
    BuildingMapper buildingMapper;
    @Autowired
    UnitMapper unitMapper;
    @Autowired
    NhsHousePricePersonAddMapper nhsHousePricePersonAddMapper;
    @Autowired
    NhsHousePriceResultMapper nhsHousePriceResultMapper;
    @Autowired
    ResidentialInfoMapper residentialInfoMapper;


    private static final Logger log = org.slf4j.LoggerFactory.getLogger(BuildService.class);


    public int updateByResId(String pinyin){
        ResidentialInfo info = residentialInfoMapper.selectByPinyin(pinyin);
        if(info == null)return -1;
        Building build = new Building();
        build.setResidentialInfoId(info.getId());
        int a = updateBuild(build);
        return a;
    }

    public int update(){
       // new Thread(() ->{
            updateBuild(null);
      //  });
        return 0 ;
    }

    public int updateBuild(Building record){
        log.info(" this is a running active to update db");
        int[] index = {1};
        String sharding_id = "42_01";
        List<Building> builds = buildingMapper.getAll(record);
        builds.stream().forEach(building -> {
            log.info("size:{} , index:{}" ,builds.size() ,index[0]);
            String bind = building.getBind();
            Integer count = unitMapper.getCount(building.getId(), sharding_id);
            Unit unit = unitMapper.getElevatorNum(building.getId(), sharding_id);
            String minUnitId = unitMapper.getMinUnit(building.getId(), sharding_id);
            Integer floor = 0,households=0,elevatorNum =0,perNum=0;
            if("0".equals(bind)) {
                floor = nhsHousePricePersonAddMapper.getFloor(building.getId(), sharding_id);
                households = nhsHousePricePersonAddMapper.getHouseholds(building.getId(), sharding_id);
                perNum = nhsHousePricePersonAddMapper.getNum(building.getId(),minUnitId, sharding_id);
                if(unit !=  null)elevatorNum = unit.getElevatorNum();
            }
            if("1".equals(bind)) {
                floor = nhsHousePriceResultMapper.getFloor(building.getId(), sharding_id);
                households = nhsHousePriceResultMapper.getHouseholds(building.getId(), sharding_id);
                perNum = nhsHousePriceResultMapper.getNum(building.getId(),minUnitId, sharding_id);
                // log.info("梯户比test:{} {} {}",build.getId(), minUnitId,perNum);
                if(unit !=  null)elevatorNum = unit.getElevator();
            }
            if (count != null && count > 0) building.setCellsNum(count);//单元数
            if (floor != null && floor > 0) building.setFloorNum(floor);//层高
            if (households != null && households > 0) building.setHouseholds(households);//户数
            if (elevatorNum != null && perNum != null && elevatorNum > 0 && perNum > 0)
                building.setProportionOfHousehold(elevatorNum + "梯" + perNum + "户");
            Map<String,Object> param = new HashMap<String, Object>();
            param.put("ids",new String[]{building.getId()});
            param.put("sharding_id",sharding_id);
            List<String> houseTypeIds = nhsHousePriceResultMapper.getHouseTypeIdsByBuildingIds(param);
            if(houseTypeIds != null && houseTypeIds.size()>0){
                String typeIds = houseTypeIds.stream().collect(Collectors.joining(","));
                building.setHousingTypeId(typeIds);
            }


            if(building.getFloorNum()!= null ||  building.getCellsNum() != null
                    || building.getHouseholds() != null ||  building.getProportionOfHousehold() != null
                    || building.getHousingTypeId() != null){

                int a = buildingMapper.updateByPrimaryKeySelective(building);
                log.info(" a:{}  building:{}" , a , JSON.toJSONString(building));
                log.info("size:{} , index:{}" ,builds.size() ,index[0]);

            }
            index[0]++ ;
            try {
                if(record == null)
                 Thread.sleep(2000);
            }catch (Exception e){

            }

        });
        return builds.size();
    }



}
