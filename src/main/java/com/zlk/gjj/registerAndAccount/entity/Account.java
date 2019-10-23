package com.zlk.gjj.registerAndAccount.entity;

public class Account {
    private String accountId;
    private String unitRegisterId;
    private String unitId;
    private String accountType;
    private String businessKind;
    private String capitalSource;
    private String allocateUnit;
    private String isSecondAssist;
    private String agentDepartment;
    private int  payDay;
    private int  firstRemitMonth;
    private int  yearListRatify;
    private int  unitDepositeRatio;
    private String isMonthConfirm;
    private String payMethod;

    public String getPayMethod() {
        return payMethod;
    }

    public void setPayMethod(String payMethod) {
        this.payMethod = payMethod;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getUnitRegisterId() {
        return unitRegisterId;
    }

    public void setUnitRegisterId(String unitRegisterId) {
        this.unitRegisterId = unitRegisterId;
    }

    public String getUnitId() {
        return unitId;
    }

    public void setUnitId(String unitId) {
        this.unitId = unitId;
    }

    public String getBusinessKind() {
        return businessKind;
    }

    public void setBusinessKind(String businessKind) {
        this.businessKind = businessKind;
    }

    public String getCapitalSource() {
        return capitalSource;
    }

    public void setCapitalSource(String capitalSource) {
        this.capitalSource = capitalSource;
    }

    public String getAllocateUnit() {
        return allocateUnit;
    }

    public void setAllocateUnit(String allocateUnit) {
        this.allocateUnit = allocateUnit;
    }

    public String getIsSecondAssist() {
        return isSecondAssist;
    }

    public void setIsSecondAssist(String isSecondAssist) {
        this.isSecondAssist = isSecondAssist;
    }

    public String getAgentDepartment() {
        return agentDepartment;
    }

    public void setAgentDepartment(String agentDepartment) {
        this.agentDepartment = agentDepartment;
    }

    public int getPayDay() {
        return payDay;
    }

    public void setPayDay(int payDay) {
        this.payDay = payDay;
    }

    public int getFirstRemitMonth() {
        return firstRemitMonth;
    }

    public void setFirstRemitMonth(int firstRemitMonth) {
        this.firstRemitMonth = firstRemitMonth;
    }

    public int getYearListRatify() {
        return yearListRatify;
    }

    public void setYearListRatify(int yearListRatify) {
        this.yearListRatify = yearListRatify;
    }

    public int getUnitDepositeRatio() {
        return unitDepositeRatio;
    }

    public void setUnitDepositeRatio(int unitDepositeRatio) {
        this.unitDepositeRatio = unitDepositeRatio;
    }

    public String getIsMonthConfirm() {
        return isMonthConfirm;
    }

    public void setIsMonthConfirm(String isMonthConfirm) {
        this.isMonthConfirm = isMonthConfirm;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }



    public Account() {
    }

    public Account(String accountId, String unitRegisterId, String unitId, String accountType, String businessKind, String capitalSource, String allocateUnit, String isSecondAssist, String agentDepartment, int payDay, int firstRemitMonth, int yearListRatify, int unitDepositeRatio, String isMonthConfirm, String payMethod) {
        this.accountId = accountId;
        this.unitRegisterId = unitRegisterId;
        this.unitId = unitId;
        this.accountType = accountType;
        this.businessKind = businessKind;
        this.capitalSource = capitalSource;
        this.allocateUnit = allocateUnit;
        this.isSecondAssist = isSecondAssist;
        this.agentDepartment = agentDepartment;
        this.payDay = payDay;
        this.firstRemitMonth = firstRemitMonth;
        this.yearListRatify = yearListRatify;
        this.unitDepositeRatio = unitDepositeRatio;
        this.isMonthConfirm = isMonthConfirm;
        this.payMethod = payMethod;
    }

    @Override
    public String toString() {
        return "Account{" +
                "accountId='" + accountId + '\'' +
                ", unitRegisterId='" + unitRegisterId + '\'' +
                ", unitId='" + unitId + '\'' +
                ", accountType='" + accountType + '\'' +
                ", businessKind='" + businessKind + '\'' +
                ", capitalSource='" + capitalSource + '\'' +
                ", allocateUnit='" + allocateUnit + '\'' +
                ", isSecondAssist='" + isSecondAssist + '\'' +
                ", agentDepartment='" + agentDepartment + '\'' +
                ", payDay=" + payDay +
                ", firstRemitMonth=" + firstRemitMonth +
                ", yearListRatify=" + yearListRatify +
                ", unitDepositeRatio=" + unitDepositeRatio +
                ", isMonthConfirm='" + isMonthConfirm + '\'' +
                ", payMethod='" + payMethod + '\'' +
                '}';
    }
}
