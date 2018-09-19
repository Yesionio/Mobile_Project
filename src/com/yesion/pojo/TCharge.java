package com.yesion.pojo;

import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class TCharge implements Serializable, ThePojo {
    public TCharge(String chargeCode, String chargeName, double charge) {
        this.chargeCode = chargeCode;
        this.chargeName = chargeName;
        this.charge = charge;
    }

    public TCharge() {
    }

    private String chargeCode;
    private String chargeName;
    private double charge;

    @JSONField(serialize = false)
    private Set<TCharge_Rule> chargeRules = new HashSet<TCharge_Rule>();

    public String getChargeCode() {
        return chargeCode;
    }

    public void setChargeCode(String chargeCode) {
        this.chargeCode = chargeCode;
    }

    public String getChargeName() {
        return chargeName;
    }

    public void setChargeName(String chargeName) {
        this.chargeName = chargeName;
    }

    public double getCharge() {
        return charge;
    }

    public void setCharge(double charge) {
        this.charge = charge;
    }

    public Set<TCharge_Rule> getChargeRules() {
        return chargeRules;
    }

    public void setChargeRules(Set<TCharge_Rule> chargeRules) {
        this.chargeRules = chargeRules;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("TCharge{");
        sb.append("chargeCode='").append(chargeCode).append('\'');
        sb.append(", chargeName='").append(chargeName).append('\'');
        sb.append(", charge=").append(charge);
        sb.append('}');
        return sb.toString();
    }
}
