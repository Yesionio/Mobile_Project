package com.yesion.service;

import java.util.List;

public interface ITChargeService {
    List[] queryCharge();

    boolean updateCharge(String chargeCode, String chargeName, double charge);

    boolean updateChargeRule(String funcId, String funcName, String[] chargeList);
}
