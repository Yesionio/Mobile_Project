package com.yesion.dao;

public interface ITMobileDao {
    boolean saveAllMobile(String[] mobs, String type);

    int queryNumCount(String number);
}
