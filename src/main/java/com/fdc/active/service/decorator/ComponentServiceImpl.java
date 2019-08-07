package com.fdc.active.service.decorator;

import com.fdc.active.dao.ResidentialInfoMapper;
import com.fdc.active.domain.ResidentialInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2019/8/7.
 */
@Service("componentService")
public class ComponentServiceImpl extends ComponentService {


    @Autowired
    ResidentialInfoMapper residentialInfoMapper;

    @Override
    public ResidentialInfo getInfoByPinyin(String pinyin) {
        return residentialInfoMapper.selectByPinyin(pinyin);
    }
}
