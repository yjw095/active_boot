package com.fdc.active.service.decorator;

import com.fdc.active.domain.ResidentialInfo;

/**
 * Created by Administrator on 2019/8/7.
 * 抽象类
 *  方法
 *
 */
public abstract class ComponentService {

    public abstract ResidentialInfo getInfoByPinyin(String pinyin);


}
