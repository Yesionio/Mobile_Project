package com.yesion.pojo;

import java.io.Serializable;

public class TCharge_Rule implements Serializable, ThePojo {
    public TCharge_Rule() {
    }

    public TCharge_Rule(String funcId, String funcName) {
        this.funcId = funcId;
        this.funcName = funcName;
    }

    private String funcId;
    private String funcName;
    private TCharge charge;

    public String getFuncId() {
        return funcId;
    }

    public void setFuncId(String funcId) {
        this.funcId = funcId;
    }

    public String getFuncName() {
        return funcName;
    }

    public void setFuncName(String funcName) {
        this.funcName = funcName;
    }

    public TCharge getCharge() {
        return charge;
    }

    public void setCharge(TCharge charge) {
        this.charge = charge;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("TCharge_Rule{");
        sb.append("funcId='").append(funcId).append('\'');
        sb.append(", funcName='").append(funcName).append('\'');
        sb.append(", charge=").append(charge);
        sb.append('}');
        return sb.toString();
    }
}
