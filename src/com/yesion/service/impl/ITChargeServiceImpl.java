package com.yesion.service.impl;

import com.yesion.dao.ITChargeDao;
import com.yesion.dao.UtilDao;
import com.yesion.pojo.TCharge;
import com.yesion.pojo.TCharge_Rule;
import com.yesion.service.ITChargeService;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.stream.Stream;

public class ITChargeServiceImpl implements ITChargeService {
    private ITChargeDao chargeDao;

    private UtilDao utilDao;

    public ITChargeDao getChargeDao() {
        return chargeDao;
    }

    public void setChargeDao(ITChargeDao chargeDao) {
        this.chargeDao = chargeDao;
    }

    public UtilDao getUtilDao() {
        return utilDao;
    }

    public void setUtilDao(UtilDao utilDao) {
        this.utilDao = utilDao;
    }

    @Override
    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    public List[] queryCharge() {

        List list = chargeDao.queryChargeRule();
        List<Map> liMap = new ArrayList<>();
        list.forEach((object)->{
            Map<String, Object> map = new HashMap<>();
            TCharge_Rule charge_rule = (TCharge_Rule)object;
            map.put("funcId", charge_rule.getFuncId());
            map.put("chargeCode", charge_rule.getCharge().getChargeCode());
            map.put("funcName", charge_rule.getFuncName());
            liMap.add(map);
        });
        return new List[]{chargeDao.queryCharge(), liMap};
    }

    @Transactional
    public boolean updateCharge(String chargeCode, String chargeName, double charge) {
        TCharge tCharge = new TCharge(chargeCode, chargeName, charge);
        return utilDao.update(tCharge);
    }

    @Override
    @Transactional
    public boolean updateChargeRule(String funcId, String funcName, String[] chargeList) {
        chargeDao.deleteAllData(funcId);
        if (chargeList.length == 0) return true;
        List<TCharge> xx = new ArrayList<>();
        List li = chargeDao.queryCharge();
        Stream stream = li.stream();
        stream.forEach((value) -> {
            TCharge tCharge = (TCharge) value;
            // System.out.println(Arrays.binarySearch(chargeList, tCharge.getChargeCode()) + "  " + tCharge.getChargeCode());
            if (Arrays.binarySearch(chargeList, tCharge.getChargeCode()) >= 0) {
                xx.add(tCharge);
            }
        });
        stream.close();
        TCharge_Rule[] rules = new TCharge_Rule[xx.size()];
        for (int i = 0; i < xx.size(); i++) {
            TCharge_Rule rule = new TCharge_Rule(funcId, funcName);
            rule.setCharge(xx.get(i));
            rules[i] = rule;
        }
        return chargeDao.insertAllData(rules);
    }
}
