package com.fdc.active.domain.es;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;


@Document(indexName="home_test",type="residential_info_front", shards =5, replicas = 0)
public class ResidentialInfoEs {

    private String _id;
    @Id
    private String id;

    @Field(type = FieldType.Text ,index = false)
    private String residentialName;

    @Field(type = FieldType.Double ,index = false)
    private Double xSite;
    @Field(type = FieldType.Double ,index = false)
    private Double ySite;
    @Field(type = FieldType.Long ,index = false)
    private Long createTime;

    @Field(type = FieldType.Long ,index = false)
    private Long updateTime;
    @Field(type = FieldType.Text ,index = false)
    private String auditStatus;
    @Field(type = FieldType.Text ,index = false)
    private String isRecommend;
    @Field(type = FieldType.Text ,index = false)
    private String districtId;
    @Field(type = FieldType.Text ,index = false)
    private String districtName;
    @Field(type = FieldType.Text ,index = false)
    private String districtSubId;
    @Field(type = FieldType.Text ,index = false)
    private String districtSubName;
    private String address;
    @Field(type = FieldType.Text ,index = false)
    private String pinyin;

    @Field(type = FieldType.Nested ,index = false)
    private String tradingArea;


    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getResidentialName() {
        return residentialName;
    }

    public void setResidentialName(String residentialName) {
        this.residentialName = residentialName;
    }

    public Double getxSite() {
        return xSite;
    }

    public void setxSite(Double xSite) {
        this.xSite = xSite;
    }

    public Double getySite() {
        return ySite;
    }

    public void setySite(Double ySite) {
        this.ySite = ySite;
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

    public String getAuditStatus() {
        return auditStatus;
    }

    public void setAuditStatus(String auditStatus) {
        this.auditStatus = auditStatus;
    }

    public String getIsRecommend() {
        return isRecommend;
    }

    public void setIsRecommend(String isRecommend) {
        this.isRecommend = isRecommend;
    }

    public String getDistrictId() {
        return districtId;
    }

    public void setDistrictId(String districtId) {
        this.districtId = districtId;
    }

    public String getDistrictName() {
        return districtName;
    }

    public void setDistrictName(String districtName) {
        this.districtName = districtName;
    }

    public String getDistrictSubId() {
        return districtSubId;
    }

    public void setDistrictSubId(String districtSubId) {
        this.districtSubId = districtSubId;
    }

    public String getDistrictSubName() {
        return districtSubName;
    }

    public void setDistrictSubName(String districtSubName) {
        this.districtSubName = districtSubName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPinyin() {
        return pinyin;
    }

    public void setPinyin(String pinyin) {
        this.pinyin = pinyin;
    }

    public String getTradingArea() {
        return tradingArea;
    }

    public void setTradingArea(String tradingArea) {
        this.tradingArea = tradingArea;
    }
}