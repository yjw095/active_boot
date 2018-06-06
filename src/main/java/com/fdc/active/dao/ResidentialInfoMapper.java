package com.fdc.active.dao;

import com.fdc.active.domain.ResidentialInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ResidentialInfoMapper {
    int deleteByPrimaryKey(String id);

    int insert(ResidentialInfo record);

    int insertSelective(ResidentialInfo record);

    ResidentialInfo selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(ResidentialInfo record);

    int updateByPrimaryKeyWithBLOBs(ResidentialInfo record);

    int updateByPrimaryKey(ResidentialInfo record);

    ResidentialInfo selectByPinyin(@Param("pinyin") String pinyin);

}