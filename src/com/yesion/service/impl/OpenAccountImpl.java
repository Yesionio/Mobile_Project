package com.yesion.service.impl;

import com.yesion.dao.ITCustomerDao;
import com.yesion.dao.ITMobileDao;
import com.yesion.dao.UtilDao;
import com.yesion.pojo.TCustomer;
import com.yesion.service.OpenAccount;

public class OpenAccountImpl implements OpenAccount {
    private ITCustomerDao customerDao;
    private UtilDao utilDao;
    private ITMobileDao mobileDao;

    public ITCustomerDao getCustomerDao() {
        return customerDao;
    }

    public void setCustomerDao(ITCustomerDao customerDao) {
        this.customerDao = customerDao;
    }

    public UtilDao getUtilDao() {
        return utilDao;
    }

    public void setUtilDao(UtilDao utilDao) {
        this.utilDao = utilDao;
    }

    public ITMobileDao getMobileDao() {
        return mobileDao;
    }

    public void setMobileDao(ITMobileDao mobileDao) {
        this.mobileDao = mobileDao;
    }

    @Override
    public boolean checkIdNumber(String idNumber) {
        return customerDao.queryIdNumCount(idNumber) == 0;
    }

    @Override
    public void saveCustomer(TCustomer customer) {
        utilDao.save(customer);
    }

    @Override
    public int chkNumber(String number) {
        return mobileDao.queryNumCount(number);
    }
}
