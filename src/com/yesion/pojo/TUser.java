package com.yesion.pojo;

import java.io.Serializable;

public class TUser implements Serializable, ThePojo {
    public TUser(int userId, String roamingStatus, String comLevel) {
        this.userId = userId;
        this.roamingStatus = roamingStatus;
        this.comLevel = comLevel;
    }

    private int userId;
    private TMobiles mobiles;
    private String roamingStatus;
    private String comLevel;
    private TCustomer customer;
    private TAccount account;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public TMobiles getMobiles() {
        return mobiles;
    }

    public void setMobiles(TMobiles mobiles) {
        this.mobiles = mobiles;
    }

    public String getRoamingStatus() {
        return roamingStatus;
    }

    public void setRoamingStatus(String roamingStatus) {
        this.roamingStatus = roamingStatus;
    }

    public String getComLevel() {
        return comLevel;
    }

    public void setComLevel(String comLevel) {
        this.comLevel = comLevel;
    }

    public TCustomer getCustomer() {
        return customer;
    }

    public void setCustomer(TCustomer customer) {
        this.customer = customer;
    }

    public TAccount getAccount() {
        return account;
    }

    public void setAccount(TAccount account) {
        this.account = account;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("TUser{");
        sb.append("userId=").append(userId);
        sb.append(", mobiles=").append(mobiles);
        sb.append(", roamingStatus='").append(roamingStatus).append('\'');
        sb.append(", comLevel='").append(comLevel).append('\'');
        sb.append(", customer=").append(customer);
        sb.append(", account=").append(account);
        sb.append('}');
        return sb.toString();
    }
}
