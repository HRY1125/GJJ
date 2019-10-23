package com.zlk.gjj.registerAndAccount.entity;

public class PayIn {
    /**单位Id*/
    private String unitId;
    /**缴款方式申请表Id*/
    private int payIdId;
    /**单位登记号*/
    private String unitRegisterId;
    /**缴款方式*/
    private String payMethod;
    /**委托收款*/
    private String receiptUnitName;
    /**委托收款单位账号*/
    private String receiptUnitAccount;
    /**托收单位开户银行名称*/
    private String receiptUnitBank;
    /**银行交换号*/
    private String bankExchangeNum;
    /**支付系统号*/
    private String paySusNum;
    /**托收日期*/
    private String receiptDate;
    /**汇款单位名称*/
    private String remitUnitName;
    /**汇款单位开户银行名称*/
    private String remitBankName;
    /**汇款单位账号*/
    private int remitUnitAccount;

    public PayIn(String unitId, int payIdId, String unitRegisterId, String payMethod, String receiptUnitName, String receiptUnitAccount, String receiptUnitBank, String bankExchangeNum, String paySusNum, String receiptDate, String remitUnitName, String remitBankName, int remitUnitAccount) {
        this.unitId = unitId;
        this.payIdId = payIdId;
        this.unitRegisterId = unitRegisterId;
        this.payMethod = payMethod;
        this.receiptUnitName = receiptUnitName;
        this.receiptUnitAccount = receiptUnitAccount;
        this.receiptUnitBank = receiptUnitBank;
        this.bankExchangeNum = bankExchangeNum;
        this.paySusNum = paySusNum;
        this.receiptDate = receiptDate;
        this.remitUnitName = remitUnitName;
        this.remitBankName = remitBankName;
        this.remitUnitAccount = remitUnitAccount;
    }

    public String getUnitId() {
        return unitId;
    }

    public void setUnitId(String unitId) {
        this.unitId = unitId;
    }

    public int getPayIdId() {
        return payIdId;
    }

    public void setPayIdId(int payIdId) {
        this.payIdId = payIdId;
    }

    public String getUnitRegisterId() {
        return unitRegisterId;
    }

    public void setUnitRegisterId(String unitRegisterId) {
        this.unitRegisterId = unitRegisterId;
    }

    public String getPayMethod() {
        return payMethod;
    }

    public void setPayMethod(String payMethod) {
        this.payMethod = payMethod;
    }

    public String getReceiptUnitName() {
        return receiptUnitName;
    }

    public void setReceiptUnitName(String receiptUnitName) {
        this.receiptUnitName = receiptUnitName;
    }

    public String getReceiptUnitAccount() {
        return receiptUnitAccount;
    }

    public void setReceiptUnitAccount(String receiptUnitAccount) {
        this.receiptUnitAccount = receiptUnitAccount;
    }

    public String getReceiptUnitBank() {
        return receiptUnitBank;
    }

    public void setReceiptUnitBank(String receiptUnitBank) {
        this.receiptUnitBank = receiptUnitBank;
    }

    public String getBankExchangeNum() {
        return bankExchangeNum;
    }

    public void setBankExchangeNum(String bankExchangeNum) {
        this.bankExchangeNum = bankExchangeNum;
    }

    public String getPaySusNum() {
        return paySusNum;
    }

    public void setPaySusNum(String paySusNum) {
        this.paySusNum = paySusNum;
    }

    public String getReceiptDate() {
        return receiptDate;
    }

    public void setReceiptDate(String receiptDate) {
        this.receiptDate = receiptDate;
    }

    public String getRemitUnitName() {
        return remitUnitName;
    }

    public void setRemitUnitName(String remitUnitName) {
        this.remitUnitName = remitUnitName;
    }

    public String getRemitBankName() {
        return remitBankName;
    }

    public void setRemitBankName(String remitBankName) {
        this.remitBankName = remitBankName;
    }

    public int getRemitUnitAccount() {
        return remitUnitAccount;
    }

    public void setRemitUnitAccount(int remitUnitAccount) {
        this.remitUnitAccount = remitUnitAccount;
    }

    public PayIn() {
    }

    @Override
    public String toString() {
        return "PayIn{" +
                "unitId='" + unitId + '\'' +
                ", payIdId=" + payIdId +
                ", unitRegisterId='" + unitRegisterId + '\'' +
                ", payMethod='" + payMethod + '\'' +
                ", receiptUnitName='" + receiptUnitName + '\'' +
                ", receiptUnitAccount='" + receiptUnitAccount + '\'' +
                ", receiptUnitBank='" + receiptUnitBank + '\'' +
                ", bankExchangeNum='" + bankExchangeNum + '\'' +
                ", paySusNum='" + paySusNum + '\'' +
                ", receiptDate='" + receiptDate + '\'' +
                ", remitUnitName='" + remitUnitName + '\'' +
                ", remitBankName='" + remitBankName + '\'' +
                ", remitUnitAccount=" + remitUnitAccount +
                '}';
    }
}
