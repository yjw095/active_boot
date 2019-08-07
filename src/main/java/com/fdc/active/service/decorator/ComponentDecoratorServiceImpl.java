package com.fdc.active.service.decorator;

import com.fdc.active.dao.ResidentialInfoMapper;
import com.fdc.active.domain.ResidentialInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2019/8/7.
 */
@Service("componentDecoratorService")
public class ComponentDecoratorServiceImpl extends ComponentDecoratorService{

    @Autowired
    ResidentialInfoMapper residentialInfoMapper;

    @Override
    public List<ResidentialInfo> selectList() {
        return residentialInfoMapper.getList();
    }

    @Override
    public ResidentialInfo getInfoByPinyin(String pinyin) {
        return residentialInfoMapper.selectByPinyin(pinyin);
    }
}
