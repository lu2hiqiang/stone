package com.stone.bean;

import java.util.Date;

public class SupplyBeg extends SupplyBegKey {
    private String auditId;

    private Integer accessCount;

    private String auditState;

    private Date creatDate;

    private String goodsNumber;

    private String goodsPrice;

    private String address;

    private String goodsPicUrl;

    private String productionTarget;
    
    private User user;

    public String getAuditId() {
        return auditId;
    }

    public void setAuditId(String auditId) {
        this.auditId = auditId == null ? null : auditId.trim();
    }

    public Integer getAccessCount() {
        return accessCount;
    }

    public void setAccessCount(Integer accessCount) {
        this.accessCount = accessCount;
    }

    public String getAuditState() {
        return auditState;
    }

    public void setAuditState(String auditState) {
        this.auditState = auditState == null ? null : auditState.trim();
    }

    public Date getCreatDate() {
        return creatDate;
    }

    public void setCreatDate(Date creatDate) {
        this.creatDate = creatDate;
    }

    public String getGoodsNumber() {
        return goodsNumber;
    }

    public void setGoodsNumber(String goodsNumber) {
        this.goodsNumber = goodsNumber == null ? null : goodsNumber.trim();
    }

    public String getGoodsPrice() {
        return goodsPrice;
    }

    public void setGoodsPrice(String goodsPrice) {
        this.goodsPrice = goodsPrice == null ? null : goodsPrice.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getGoodsPicUrl() {
        return goodsPicUrl;
    }

    public void setGoodsPicUrl(String goodsPicUrl) {
        this.goodsPicUrl = goodsPicUrl == null ? null : goodsPicUrl.trim();
    }

    public String getProductionTarget() {
        return productionTarget;
    }

    public void setProductionTarget(String productionTarget) {
        this.productionTarget = productionTarget == null ? null : productionTarget.trim();
    }

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}