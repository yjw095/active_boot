package com.fdc.active.domain;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * Created by youjw on 2018/6/26.
 * 提供给 第三方发布房源 签名使用字段
 */
public class SHhouse implements Serializable{


    private String token ;
    private String residentialId;
    private String residentialName;
    private Integer room;
    private Integer hall;
    private Integer toilet;
    private Integer kitchen;
    private Integer balcony;
    private Float acreage;
    private Float totalPrice;
    private Float averagePrice;
    private String houseTitle;
    private String houseType;
    private String houseTypeDesc;
    private String decorateType;
    private String decorateTypeDesc;
    private String orientationType;
    private String orientationTypeDesc;
    private Integer currentFloorNum;
    private Integer totalFloorNum;
    private String prSituation;
    private String prSituationDesc;
    private String prType;
    private String prTypeDesc;
    private Long prSignDate;
    private String prAgeLimit;
    private String prAgeLimitDesc;
    private String yearBuilt;
    private String houseLabel;
    private String operateLabel;
    private String operateLabelDesc;
    private String houseDetailDesc;
    private String contact;
    private String contactPhone;


    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getHouseTitle() {
        return houseTitle;
    }

    public void setHouseTitle(String houseTitle) {
        this.houseTitle = houseTitle;
    }

    public String getResidentialId() {
        return residentialId;
    }

    public void setResidentialId(String residentialId) {
        this.residentialId = residentialId;
    }

    public String getResidentialName() {
        return residentialName;
    }

    public void setResidentialName(String residentialName) {
        this.residentialName = residentialName;
    }

    public Integer getRoom() {
        return room;
    }

    public void setRoom(Integer room) {
        this.room = room;
    }

    public Integer getHall() {
        return hall;
    }

    public void setHall(Integer hall) {
        this.hall = hall;
    }

    public Integer getToilet() {
        return toilet;
    }

    public void setToilet(Integer toilet) {
        this.toilet = toilet;
    }

    public Float getAcreage() {
        return acreage;
    }

    public void setAcreage(Float acreage) {
        this.acreage = acreage;
    }

    public Float getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Float totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getHouseTypeDesc() {
        return houseTypeDesc;
    }

    public void setHouseTypeDesc(String houseTypeDesc) {
        this.houseTypeDesc = houseTypeDesc;
    }

    public String getDecorateTypeDesc() {
        return decorateTypeDesc;
    }

    public void setDecorateTypeDesc(String decorateTypeDesc) {
        this.decorateTypeDesc = decorateTypeDesc;
    }

    public Integer getCurrentFloorNum() {
        return currentFloorNum;
    }

    public void setCurrentFloorNum(Integer currentFloorNum) {
        this.currentFloorNum = currentFloorNum;
    }

    public Integer getTotalFloorNum() {
        return totalFloorNum;
    }

    public void setTotalFloorNum(Integer totalFloorNum) {
        this.totalFloorNum = totalFloorNum;
    }

    public String getPrSituationDesc() {
        return prSituationDesc;
    }

    public void setPrSituationDesc(String prSituationDesc) {
        this.prSituationDesc = prSituationDesc;
    }

    public String getHouseDetailDesc() {
        return houseDetailDesc;
    }

    public void setHouseDetailDesc(String houseDetailDesc) {
        this.houseDetailDesc = houseDetailDesc;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getContactPhone() {
        return contactPhone;
    }

    public void setContactPhone(String contactPhone) {
        this.contactPhone = contactPhone;
    }

    public Integer getKitchen() {
        return kitchen;
    }

    public void setKitchen(Integer kitchen) {
        this.kitchen = kitchen;
    }

    public Integer getBalcony() {
        return balcony;
    }

    public void setBalcony(Integer balcony) {
        this.balcony = balcony;
    }

    public Float getAveragePrice() {
        return averagePrice;
    }

    public void setAveragePrice(Float averagePrice) {
        this.averagePrice = averagePrice;
    }

    public String getHouseType() {
        return houseType;
    }

    public void setHouseType(String houseType) {
        this.houseType = houseType;
    }

    public String getDecorateType() {
        return decorateType;
    }

    public void setDecorateType(String decorateType) {
        this.decorateType = decorateType;
    }

    public String getOrientationType() {
        return orientationType;
    }

    public void setOrientationType(String orientationType) {
        this.orientationType = orientationType;
    }

    public String getOrientationTypeDesc() {
        return orientationTypeDesc;
    }

    public void setOrientationTypeDesc(String orientationTypeDesc) {
        this.orientationTypeDesc = orientationTypeDesc;
    }

    public String getPrSituation() {
        return prSituation;
    }

    public void setPrSituation(String prSituation) {
        this.prSituation = prSituation;
    }

    public String getPrType() {
        return prType;
    }

    public void setPrType(String prType) {
        this.prType = prType;
    }

    public String getPrTypeDesc() {
        return prTypeDesc;
    }

    public void setPrTypeDesc(String prTypeDesc) {
        this.prTypeDesc = prTypeDesc;
    }

    public Long getPrSignDate() {
        return prSignDate;
    }

    public void setPrSignDate(Long prSignDate) {
        this.prSignDate = prSignDate;
    }

    public String getPrAgeLimit() {
        return prAgeLimit;
    }

    public void setPrAgeLimit(String prAgeLimit) {
        this.prAgeLimit = prAgeLimit;
    }

    public String getPrAgeLimitDesc() {
        return prAgeLimitDesc;
    }

    public void setPrAgeLimitDesc(String prAgeLimitDesc) {
        this.prAgeLimitDesc = prAgeLimitDesc;
    }

    public String getYearBuilt() {
        return yearBuilt;
    }

    public void setYearBuilt(String yearBuilt) {
        this.yearBuilt = yearBuilt;
    }

    public String getHouseLabel() {
        return houseLabel;
    }

    public void setHouseLabel(String houseLabel) {
        this.houseLabel = houseLabel;
    }

    public String getOperateLabel() {
        return operateLabel;
    }

    public void setOperateLabel(String operateLabel) {
        this.operateLabel = operateLabel;
    }

    public String getOperateLabelDesc() {
        return operateLabelDesc;
    }

    public void setOperateLabelDesc(String operateLabelDesc) {
        this.operateLabelDesc = operateLabelDesc;
    }

    public Object[] getField()throws Exception{
        Class cls = this.getClass();
        List<String> list = new ArrayList<>();
        Field[] fields = cls.getDeclaredFields();
        for(Field field : fields) {
            field.setAccessible(true);
            String name = field.getName();
            list.add(name);
        }
        return list.toArray();
    }


    @Override
    public String toString() {
        return "SHhouse{" +
                "token='" + token + '\'' +
                ", residentialId='" + residentialId + '\'' +
                ", residentialName='" + residentialName + '\'' +
                ", room=" + room +
                ", hall=" + hall +
                ", toilet=" + toilet +
                ", kitchen=" + kitchen +
                ", balcony=" + balcony +
                ", acreage=" + acreage +
                ", totalPrice=" + totalPrice +
                ", averagePrice=" + averagePrice +
                ", houseTitle='" + houseTitle + '\'' +
                ", houseType='" + houseType + '\'' +
                ", houseTypeDesc='" + houseTypeDesc + '\'' +
                ", decorateType='" + decorateType + '\'' +
                ", decorateTypeDesc='" + decorateTypeDesc + '\'' +
                ", orientationType='" + orientationType + '\'' +
                ", orientationTypeDesc='" + orientationTypeDesc + '\'' +
                ", currentFloorNum=" + currentFloorNum +
                ", totalFloorNum=" + totalFloorNum +
                ", prSituation='" + prSituation + '\'' +
                ", prSituationDesc='" + prSituationDesc + '\'' +
                ", prType='" + prType + '\'' +
                ", prTypeDesc='" + prTypeDesc + '\'' +
                ", prSignDate=" + prSignDate +
                ", prAgeLimit='" + prAgeLimit + '\'' +
                ", prAgeLimitDesc='" + prAgeLimitDesc + '\'' +
                ", yearBuilt='" + yearBuilt + '\'' +
                ", houseLabel='" + houseLabel + '\'' +
                ", operateLabel='" + operateLabel + '\'' +
                ", operateLabelDesc='" + operateLabelDesc + '\'' +
                ", contact='" + contact + '\'' +
                ", contactPhone='" + contactPhone + '\'' +
                '}';
    }
}
