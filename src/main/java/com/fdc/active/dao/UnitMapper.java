package com.fdc.active.dao;

import com.fdc.active.domain.Unit;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UnitMapper {
    int deleteByPrimaryKey(String id);

    int insert(Unit record);

    int insertSelective(Unit record);

    Unit selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Unit record);

    int updateByPrimaryKey(Unit record);

    Integer getCount(@Param("id") String id , @Param("sharding_id") String sharding_id);

    Unit getElevatorNum(@Param("id") String id , @Param("sharding_id") String sharding_id);

    String getMinUnit(@Param("id") String id , @Param("sharding_id") String sharding_id);


}