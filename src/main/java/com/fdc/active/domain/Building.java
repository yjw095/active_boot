package com.fdc.active.domain;

public class Building {
    private String id;

    private String residentialSubId;

    private String bulidingNum;

    private Integer cellsNum;

    private Integer floorNum;

    private Long openTime;

    private String openShowTime;

    private Long junctionRoomTime;

    private String junctionRoomShowTime;

    private Long completeTime;

    private String completeShowTime;

    private Long checkInTime;

    private String checkInShowTime;

    private Float share;

    private Integer households;

    private String proportionOfHousehold;

    private String preSalePermit;

    private Long createTime;

    private Long updateTime;

    private String saleState;

    private String residentialInfoId;

    private String delState;

    private String olddbBaseId;

    private String olddbSaleinfoId;

    private String buildingLabel;

    private String housingTypeId;

    private String shardingId;

    private Float sunshineTime;

    private String bind;

    private String orientation;

    private String buildingDesc;

    private String building;

    private String tags;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getResidentialSubId() {
        return residentialSubId;
    }

    public void setResidentialSubId(String residentialSubId) {
        this.residentialSubId = residentialSubId == null ? null : residentialSubId.trim();
    }

    public String getBulidingNum() {
        return bulidingNum;
    }

    public void setBulidingNum(String bulidingNum) {
        this.bulidingNum = bulidingNum == null ? null : bulidingNum.trim();
    }

    public Integer getCellsNum() {
        return cellsNum;
    }

    public void setCellsNum(Integer cellsNum) {
        this.cellsNum = cellsNum;
    }

    public Integer getFloorNum() {
        return floorNum;
    }

    public void setFloorNum(Integer floorNum) {
        this.floorNum = floorNum;
    }

    public Long getOpenTime() {
        return openTime;
    }

    public void setOpenTime(Long openTime) {
        this.openTime = openTime;
    }

    public String getOpenShowTime() {
        return openShowTime;
    }

    public void setOpenShowTime(String openShowTime) {
        this.openShowTime = openShowTime == null ? null : openShowTime.trim();
    }

    public Long getJunctionRoomTime() {
        return junctionRoomTime;
    }

    public void setJunctionRoomTime(Long junctionRoomTime) {
        this.junctionRoomTime = junctionRoomTime;
    }

    public String getJunctionRoomShowTime() {
        return junctionRoomShowTime;
    }

    public void setJunctionRoomShowTime(String junctionRoomShowTime) {
        this.junctionRoomShowTime = junctionRoomShowTime == null ? null : junctionRoomShowTime.trim();
    }

    public Long getCompleteTime() {
        return completeTime;
    }

    public void setCompleteTime(Long completeTime) {
        this.completeTime = completeTime;
    }

    public String getCompleteShowTime() {
        return completeShowTime;
    }

    public void setCompleteShowTime(String completeShowTime) {
        this.completeShowTime = completeShowTime == null ? null : completeShowTime.trim();
    }

    public Long getCheckInTime() {
        return checkInTime;
    }

    public void setCheckInTime(Long checkInTime) {
        this.checkInTime = checkInTime;
    }

    public String getCheckInShowTime() {
        return checkInShowTime;
    }

    public void setCheckInShowTime(String checkInShowTime) {
        this.checkInShowTime = checkInShowTime == null ? null : checkInShowTime.trim();
    }

    public Float getShare() {
        return share;
    }

    public void setShare(Float share) {
        this.share = share;
    }

    public Integer getHouseholds() {
        return households;
    }

    public void setHouseholds(Integer households) {
        this.households = households;
    }

    public String getProportionOfHousehold() {
        return proportionOfHousehold;
    }

    public void setProportionOfHousehold(String proportionOfHousehold) {
        this.proportionOfHousehold = proportionOfHousehold == null ? null : proportionOfHousehold.trim();
    }

    public String getPreSalePermit() {
        return preSalePermit;
    }

    public void setPreSalePermit(String preSalePermit) {
        this.preSalePermit = preSalePermit == null ? null : preSalePermit.trim();
    }

    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    public Long getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Long updateTime) {
        this.updateTime = updateTime;
    }

    public String getSaleState() {
        return saleState;
    }

    public void setSaleState(String saleState) {
        this.saleState = saleState == null ? null : saleState.trim();
    }

    public String getResidentialInfoId() {
        return residentialInfoId;
    }

    public void setResidentialInfoId(String residentialInfoId) {
        this.residentialInfoId = residentialInfoId == null ? null : residentialInfoId.trim();
    }

    public String getDelState() {
        return delState;
    }

    public void setDelState(String delState) {
        this.delState = delState == null ? null : delState.trim();
    }

    public String getOlddbBaseId() {
        return olddbBaseId;
    }

    public void setOlddbBaseId(String olddbBaseId) {
        this.olddbBaseId = olddbBaseId == null ? null : olddbBaseId.trim();
    }

    public String getOlddbSaleinfoId() {
        return olddbSaleinfoId;
    }

    public void setOlddbSaleinfoId(String olddbSaleinfoId) {
        this.olddbSaleinfoId = olddbSaleinfoId == null ? null : olddbSaleinfoId.trim();
    }

    public String getBuildingLabel() {
        return buildingLabel;
    }

    public void setBuildingLabel(String buildingLabel) {
        this.buildingLabel = buildingLabel == null ? null : buildingLabel.trim();
    }

    public String getHousingTypeId() {
        return housingTypeId;
    }

    public void setHousingTypeId(String housingTypeId) {
        this.housingTypeId = housingTypeId == null ? null : housingTypeId.trim();
    }

    public String getShardingId() {
        return shardingId;
    }

    public void setShardingId(String shardingId) {
        this.shardingId = shardingId == null ? null : shardingId.trim();
    }

    public Float getSunshineTime() {
        return sunshineTime;
    }

    public void setSunshineTime(Float sunshineTime) {
        this.sunshineTime = sunshineTime;
    }

    public String getBind() {
        return bind;
    }

    public void setBind(String bind) {
        this.bind = bind == null ? null : bind.trim();
    }

    public String getOrientation() {
        return orientation;
    }

    public void setOrientation(String orientation) {
        this.orientation = orientation == null ? null : orientation.trim();
    }

    public String getBuildingDesc() {
        return buildingDesc;
    }

    public void setBuildingDesc(String buildingDesc) {
        this.buildingDesc = buildingDesc == null ? null : buildingDesc.trim();
    }

    public String getBuilding() {
        return building;
    }

    public void setBuilding(String building) {
        this.building = building == null ? null : building.trim();
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags == null ? null : tags.trim();
    }
}