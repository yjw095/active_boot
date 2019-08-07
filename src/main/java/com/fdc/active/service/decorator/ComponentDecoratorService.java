package com.fdc.active.service.decorator;

import com.fdc.active.domain.ResidentialInfo;

import java.util.List;

/**
 * Created by Administrator on 2019/8/7.
 */
public abstract class ComponentDecoratorService extends ComponentService{

    public abstract List<ResidentialInfo> selectList();

}
