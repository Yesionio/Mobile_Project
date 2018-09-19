package com.yesion.pojo;

import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class TCustomer implements Serializable, ThePojo {

    public TCustomer(int customerId, String idType, String idNumber, String customerName, String customerBirthday, String customerSex, String customerAddress) {
        CustomerId = customerId;
        this.idType = idType;
        this.idNumber = idNumber;
        this.customerName = customerName;
        this.customerBirthday = customerBirthday;
        this.customerSex = customerSex;
        this.customerAddress = customerAddress;
    }

    public TCustomer() {
    }

    private int CustomerId;
    private String idType;
    private String idNumber;
    private String customerName;
    private String customerBirthday;
    private String customerSex;
    private String customerAddress;

    @JSONField(serialize = false)
    private Set<TUser> users = new HashSet<TUser>();


    public int getCustomerId() {
        return CustomerId;
    }

    public void setCustomerId(int customerId) {
        CustomerId = customerId;
    }

    public String getIdType() {
        return idType;
    }

    public void setIdType(String idType) {
        this.idType = idType;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerBirthday() {
        return customerBirthday;
    }

    public void setCustomerBirthday(String customerBirthday) {
        this.customerBirthday = customerBirthday;
    }

    public String getCustomerSex() {
        return customerSex;
    }

    public void setCustomerSex(String customerSex) {
        this.customerSex = customerSex;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    public Set<TUser> getUsers() {
        return users;
    }

    public void setUsers(Set<TUser> users) {
        this.users = users;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("TCustomer{");
        sb.append("CustomerId=").append(CustomerId);
        sb.append(", idType='").append(idType).append('\'');
        sb.append(", idNumber='").append(idNumber).append('\'');
        sb.append(", customerName='").append(customerName).append('\'');
        sb.append(", customerBirthday='").append(customerBirthday).append('\'');
        sb.append(", customerSex='").append(customerSex).append('\'');
        sb.append(", customerAddress='").append(customerAddress).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
