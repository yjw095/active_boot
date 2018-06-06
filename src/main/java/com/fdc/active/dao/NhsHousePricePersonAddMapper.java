package com.fdc.active.dao;

import com.fdc.active.domain.NhsHousePricePersonAdd;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface NhsHousePricePersonAddMapper {
    int deleteByPrimaryKey(String id);

    int insert(NhsHousePricePersonAdd record);

    int insertSelective(NhsHousePricePersonAdd record);

    NhsHousePricePersonAdd selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(NhsHousePricePersonAdd record);

    int updateByPrimaryKey(NhsHousePricePersonAdd record);


    Integer getFloor(@Param("id")String id , @Param("sharding_id")String sharding_id);

    Integer getNum(@Param("id")String id,@Param("unit")String unit ,@Param("sharding_id")String sharding_id);

    Integer getHouseholds(@Param("id")String id ,@Param("sharding_id")String sharding_id);

}