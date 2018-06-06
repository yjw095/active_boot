package com.fdc.active.dao;

import com.fdc.active.domain.Building;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BuildingMapper {
    int deleteByPrimaryKey(String id);

    int insert(Building record);

    int insertSelective(Building record);

    Building selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Building record);

    int updateByPrimaryKey(Building record);

    List<Building> getAll(Building record);

}