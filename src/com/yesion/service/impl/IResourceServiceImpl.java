package com.yesion.service.impl;

import com.yesion.dao.ITMobileDao;
import com.yesion.service.IResourceService;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public class IResourceServiceImpl implements IResourceService {
    private ITMobileDao mobileDao;

    public void setMobileDao(ITMobileDao mobileDao) {
        this.mobileDao = mobileDao;
    }

    public ITMobileDao getMobileDao() {
        return mobileDao;
    }

    @Override
    @Transactional
    public boolean saveResource(String from, String to, String type) {
        long fromNum = Long.parseLong(from);
        long toNum = Long.parseLong(to);
        int total = (int)(toNum - fromNum);
        String[] mobs = new String[total+1];

        for (int i = 0; i <= total; i++) {
            mobs[i] = Long.toString(fromNum + i);
        }
        return mobileDao.saveAllMobile(mobs, type);
    }
}
