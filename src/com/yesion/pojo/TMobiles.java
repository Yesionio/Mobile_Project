package com.yesion.pojo;

import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class TMobiles implements Serializable, ThePojo {
    public TMobiles(String mobileNumber, String mobileType, String cardNumber, String isAvailable) {
        this.mobileNumber = mobileNumber;
        this.mobileType = mobileType;
        this.cardNumber = cardNumber;
        this.isAvailable = isAvailable;
    }

    public TMobiles() {
    }

    private String mobileNumber;
    private String mobileType;
    private String cardNumber;
    private String isAvailable;
    @JSONField(serialize = false)
    private Set<TUser> users = new HashSet<TUser>();

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getMobileType() {
        return mobileType;
    }

    public void setMobileType(String mobileType) {
        this.mobileType = mobileType;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getIsAvailable() {
        return isAvailable;
    }

    public void setIsAvailable(String isAvailable) {
        this.isAvailable = isAvailable;
    }

    public Set<TUser> getUsers() {
        return users;
    }

    public void setUsers(Set<TUser> users) {
        this.users = users;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("TMobiles{");
        sb.append("mobileNumber='").append(mobileNumber).append('\'');
        sb.append(", mobileType='").append(mobileType).append('\'');
        sb.append(", cardNumber='").append(cardNumber).append('\'');
        sb.append(", isAvailable='").append(isAvailable).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
