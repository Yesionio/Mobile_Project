package com.yesion.dao;

import com.yesion.pojo.TCharge;
import com.yesion.pojo.TCharge_Rule;

import java.util.List;

public interface ITChargeDao {
    List queryCharge();

    List queryChargeRule();

    void deleteAllData(String funcId);

    boolean insertAllData(TCharge_Rule[] rules);
}
