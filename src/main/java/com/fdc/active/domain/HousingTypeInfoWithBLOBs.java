package com.fdc.active.domain;

public class HousingTypeInfoWithBLOBs extends HousingTypeInfo {
    private String housingDesc;

    private String houseTypeTag;

    public String getHousingDesc() {
        return housingDesc;
    }

    public void setHousingDesc(String housingDesc) {
        this.housingDesc = housingDesc == null ? null : housingDesc.trim();
    }

    public String getHouseTypeTag() {
        return houseTypeTag;
    }

    public void setHouseTypeTag(String houseTypeTag) {
        this.houseTypeTag = houseTypeTag == null ? null : houseTypeTag.trim();
    }
}