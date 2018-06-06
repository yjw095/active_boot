package com.fdc.active.dao;

import com.fdc.active.domain.NhsHousePriceResult;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface NhsHousePriceResultMapper {
    int deleteByPrimaryKey(String id);

    int insert(NhsHousePriceResult record);

    int insertSelective(NhsHousePriceResult record);

    NhsHousePriceResult selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(NhsHousePriceResult record);

    int updateByPrimaryKeyWithBLOBs(NhsHousePriceResult record);

    int updateByPrimaryKey(NhsHousePriceResult record);

    Integer getFloor(@Param("id")String id , @Param("sharding_id")String sharding_id);

    Integer getNum(@Param("id")String id,@Param("unit")String unit ,@Param("sharding_id")String sharding_id);

    Integer getHouseholds(@Param("id")String id ,@Param("sharding_id")String sharding_id);

    List<String> getHouseTypeIdsByBuildingIds(Map<String, Object> pamMap);


}