package com.stone.bean;

public class SupplyBegKey {
    private String phone;

    private String name;

    private Integer supplyBegId;

    private String typeName;

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getSupplyBegId() {
        return supplyBegId;
    }

    public void setSupplyBegId(Integer supplyBegId) {
        this.supplyBegId = supplyBegId;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName == null ? null : typeName.trim();
    }
}