package com.yesion.pojo;

import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class TAccount implements Serializable, ThePojo {
    public TAccount() {
    }

    public TAccount(int accountId, String contactPerson, String contactAddress, double accountBalance) {
        this.accountId = accountId;
        this.contactPerson = contactPerson;
        this.contactAddress = contactAddress;
        this.accountBalance = accountBalance;
    }

    private int accountId;
    private String contactPerson;
    private String contactAddress;
    private double accountBalance;

    @JSONField(serialize = false)
    private Set<TUser> users = new HashSet<TUser>();

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public String getContactPerson() {
        return contactPerson;
    }

    public void setContactPerson(String contactPerson) {
        this.contactPerson = contactPerson;
    }

    public String getContactAddress() {
        return contactAddress;
    }

    public void setContactAddress(String contactAddress) {
        this.contactAddress = contactAddress;
    }

    public double getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(double accountBalance) {
        this.accountBalance = accountBalance;
    }

    public Set<TUser> getUsers() {
        return users;
    }

    public void setUsers(Set<TUser> users) {
        this.users = users;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("TAccount{");
        sb.append("accountId='").append(accountId).append('\'');
        sb.append(", contactPerson='").append(contactPerson).append('\'');
        sb.append(", contactAddress='").append(contactAddress).append('\'');
        sb.append(", accountBalance=").append(accountBalance);
        sb.append('}');
        return sb.toString();
    }
}
