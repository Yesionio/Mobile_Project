package com.yesion.pojo;

import java.io.Serializable;

public class TOperator implements Serializable, ThePojo {
    public TOperator(String operatorId, String operatorName, String operatorPwd, String isAdmin) {
        this.operatorId = operatorId;
        this.operatorName = operatorName;
        this.operatorPwd = operatorPwd;
        this.isAdmin = isAdmin;
    }

    public TOperator() {
    }

    private String operatorId;
    private String operatorName;
    private String operatorPwd;
    private String isAdmin;

    public String getOperatorId() {
        return operatorId;
    }

    public void setOperatorId(String operatorId) {
        this.operatorId = operatorId;
    }

    public String getOperatorName() {
        return operatorName;
    }

    public void setOperatorName(String operatorName) {
        this.operatorName = operatorName;
    }

    public String getOperatorPwd() {
        return operatorPwd;
    }

    public void setOperatorPwd(String operatorPwd) {
        this.operatorPwd = operatorPwd;
    }

    public String getIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(String isAdmin) {
        this.isAdmin = isAdmin;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("TOperator{");
        sb.append("operatorId='").append(operatorId).append('\'');
        sb.append(", operatorName='").append(operatorName).append('\'');
        sb.append(", operatorPwd='").append(operatorPwd).append('\'');
        sb.append(", isAdmin='").append(isAdmin).append('\'');
        sb.append('}');
        return sb.toString();
    }


}
