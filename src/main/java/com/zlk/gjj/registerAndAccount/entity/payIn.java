package com.zlk.gjj.registerAndAccount.entity;

public class payIn {
    private String unitId;
    private int payIdId;
    private String unitRegistId;
    private String payMethod;
    private String receiptUnitName;
    private String receiptUnitAccount;
    private String receiptUnitBank;
    private String bankExchangeNum;
    private String paySusNum;
    private String receiptDate;
    private String remitUnitName;
    private String remitBankName;
    private int remitUnitAccount;

    public payIn(String unitId, int payIdId, String unitRegistId, String payMethod, String receiptUnitName, String receiptUnitAccount, String receiptUnitBank, String bankExchangeNum, String paySusNum, String receiptDate, String remitUnitName, String remitBankName, int remitUnitAccount) {
        this.unitId = unitId;
        this.payIdId = payIdId;
        this.unitRegistId = unitRegistId;
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

    public String getUnitRegistId() {
        return unitRegistId;
    }

    public void setUnitRegistId(String unitRegistId) {
        this.unitRegistId = unitRegistId;
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

    public payIn() {
    }

    @Override
    public String toString() {
        return "payIn{" +
                "unitId='" + unitId + '\'' +
                ", payIdId=" + payIdId +
                ", unitRegistId='" + unitRegistId + '\'' +
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
