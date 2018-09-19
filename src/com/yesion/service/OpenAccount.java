package com.yesion.service;

import com.yesion.pojo.TCustomer;

public interface OpenAccount {
    boolean checkIdNumber(String idNumber);

    void saveCustomer(TCustomer customer);

    int chkNumber(String number);
}
