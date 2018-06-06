package com.fdc.active.domain;

public class Unit {
    private String id;

    private String unitNum;

    private String buildingId;

    private String residentialInfoId;

    private Long createTime;

    private Long updateTime;

    private String bind;

    private Integer elevatorNum;

    private String delState;

    private String shardingId;

    private String unit;

    private String propertyType;

    private Integer elevator;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getUnitNum() {
        return unitNum;
    }

    public void setUnitNum(String unitNum) {
        this.unitNum = unitNum == null ? null : unitNum.trim();
    }

    public String getBuildingId() {
        return buildingId;
    }

    public void setBuildingId(String buildingId) {
        this.buildingId = buildingId == null ? null : buildingId.trim();
    }

    public String getResidentialInfoId() {
        return residentialInfoId;
    }

    public void setResidentialInfoId(String residentialInfoId) {
        this.residentialInfoId = residentialInfoId == null ? null : residentialInfoId.trim();
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

    public String getBind() {
        return bind;
    }

    public void setBind(String bind) {
        this.bind = bind == null ? null : bind.trim();
    }

    public Integer getElevatorNum() {
        return elevatorNum;
    }

    public void setElevatorNum(Integer elevatorNum) {
        this.elevatorNum = elevatorNum;
    }

    public String getDelState() {
        return delState;
    }

    public void setDelState(String delState) {
        this.delState = delState == null ? null : delState.trim();
    }

    public String getShardingId() {
        return shardingId;
    }

    public void setShardingId(String shardingId) {
        this.shardingId = shardingId == null ? null : shardingId.trim();
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit == null ? null : unit.trim();
    }

    public String getPropertyType() {
        return propertyType;
    }

    public void setPropertyType(String propertyType) {
        this.propertyType = propertyType == null ? null : propertyType.trim();
    }

    public Integer getElevator() {
        return elevator;
    }

    public void setElevator(Integer elevator) {
        this.elevator = elevator;
    }
}