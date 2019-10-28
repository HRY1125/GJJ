package com.zlk.gjj.registerAndAccount.entity;

public class Account {
    private String accountId;
    private String unitRegisterId;
    private String unitId;
    private String unitName;
    private String unitPhone;
    //private String accountType;
    private String businessKind;
    private String capitalSource;
    private String allocateUnit;
    private String isSecondAssist;
    private String isAcceptService;
    private String agentDepartment;
    private int  payDay;
    private int  firstRemitMonth;
    private int  yearListRatify;
    private int  unitDepositeRatio;
    private int  unitPeopleDepositeRatio;
    private String isMonthConfirm;
    private String payMethod;

    public String getUnitName() {
        return unitName;
    }

    public void setUnitName(String unitName) {
        this.unitName = unitName;
    }

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


    public String getUnitPhone() {
        return unitPhone;
    }

    public void setUnitPhone(String unitPhone) {
        this.unitPhone = unitPhone;
    }

    public String getIsAcceptService() {
        return isAcceptService;
    }

    public void setIsAcceptService(String isAcceptService) {
        this.isAcceptService = isAcceptService;
    }

    public int getUnitPeopleDepositeRatio() {
        return unitPeopleDepositeRatio;
    }

    public void setUnitPeopleDepositeRatio(int unitPeopleDepositeRatio) {
        this.unitPeopleDepositeRatio = unitPeopleDepositeRatio;
    }

    public Account() {
    }


    public Account(String accountId, String unitRegisterId, String unitId, String unitName, String unitPhone, String businessKind, String capitalSource, String allocateUnit, String isSecondAssist, String isAcceptService, String agentDepartment, int payDay, int firstRemitMonth, int yearListRatify, int unitDepositeRatio, int unitPeopleDepositeRatio, String isMonthConfirm, String payMethod) {
        this.accountId = accountId;
        this.unitRegisterId = unitRegisterId;
        this.unitId = unitId;
        this.unitName = unitName;
        this.unitPhone = unitPhone;
        this.businessKind = businessKind;
        this.capitalSource = capitalSource;
        this.allocateUnit = allocateUnit;
        this.isSecondAssist = isSecondAssist;
        this.isAcceptService = isAcceptService;
        this.agentDepartment = agentDepartment;
        this.payDay = payDay;
        this.firstRemitMonth = firstRemitMonth;
        this.yearListRatify = yearListRatify;
        this.unitDepositeRatio = unitDepositeRatio;
        this.unitPeopleDepositeRatio = unitPeopleDepositeRatio;
        this.isMonthConfirm = isMonthConfirm;
        this.payMethod = payMethod;
    }

    @Override
    public String toString() {
        return "Account{" +
                "accountId='" + accountId + '\'' +
                ", unitRegisterId='" + unitRegisterId + '\'' +
                ", unitId='" + unitId + '\'' +
                ", unitName='" + unitName + '\'' +
                ", unitPhone='" + unitPhone + '\'' +
                ", businessKind='" + businessKind + '\'' +
                ", capitalSource='" + capitalSource + '\'' +
                ", allocateUnit='" + allocateUnit + '\'' +
                ", isSecondAssist='" + isSecondAssist + '\'' +
                ", isAcceptService='" + isAcceptService + '\'' +
                ", agentDepartment='" + agentDepartment + '\'' +
                ", payDay=" + payDay +
                ", firstRemitMonth=" + firstRemitMonth +
                ", yearListRatify=" + yearListRatify +
                ", unitDepositeRatio=" + unitDepositeRatio +
                ", unitPeopleDepositeRatio=" + unitPeopleDepositeRatio +
                ", isMonthConfirm='" + isMonthConfirm + '\'' +
                ", payMethod='" + payMethod + '\'' +
                '}';
    }
}
