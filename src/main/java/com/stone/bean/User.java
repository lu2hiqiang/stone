package com.stone.bean;

import java.util.Date;

public class User extends UserKey {
    private String password;

    private String companyName;

    private String wechat;

    private String email;

    private String address;

    private Date creatDate;

    private String landLine;

    private String fax;

    private String cardJust;

    private String license;

    private String mineLicense;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName == null ? null : companyName.trim();
    }

    public String getWechat() {
        return wechat;
    }

    public void setWechat(String wechat) {
        this.wechat = wechat == null ? null : wechat.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public Date getCreatDate() {
        return creatDate;
    }

    public void setCreatDate(Date creatDate) {
        this.creatDate = creatDate;
    }

    public String getLandLine() {
        return landLine;
    }

    public void setLandLine(String landLine) {
        this.landLine = landLine == null ? null : landLine.trim();
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax == null ? null : fax.trim();
    }

    public String getCardJust() {
        return cardJust;
    }

    public void setCardJust(String cardJust) {
        this.cardJust = cardJust == null ? null : cardJust.trim();
    }

    public String getLicense() {
        return license;
    }

    public void setLicense(String license) {
        this.license = license == null ? null : license.trim();
    }

    public String getMineLicense() {
        return mineLicense;
    }

    public void setMineLicense(String mineLicense) {
        this.mineLicense = mineLicense == null ? null : mineLicense.trim();
    }
}