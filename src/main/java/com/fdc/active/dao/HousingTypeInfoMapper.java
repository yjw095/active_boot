package com.fdc.active.dao;

import com.fdc.active.domain.HousingTypeInfo;
import com.fdc.active.domain.HousingTypeInfoWithBLOBs;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface HousingTypeInfoMapper {
    int deleteByPrimaryKey(String id);

    int insert(HousingTypeInfoWithBLOBs record);

    int insertSelective(HousingTypeInfoWithBLOBs record);

    HousingTypeInfoWithBLOBs selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(HousingTypeInfoWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(HousingTypeInfoWithBLOBs record);

    int updateByPrimaryKey(HousingTypeInfo record);
}