package com.fdc.active.dao;

import com.fdc.active.domain.WxFormId;

public interface WxFormIdMapper {
    int insert(WxFormId record);

    int insertSelective(WxFormId record);
}