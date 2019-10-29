package com.zlk.gjj.registerAndAccount.entity;

public class SecondAssist {
    /**部门Id*/
    private Integer saId;
    /**单位Id*/
    private String unitId;
    /**部门编号*/
    private String departmentId;
    /**部门名称*/
    private String departmentName;
    /**部门代码*/
    private String departmentCode;


    public SecondAssist() {
    }

    public SecondAssist(Integer saId, String unitId, String departmentId, String departmentName, String departmentCode) {
        this.saId = saId;
        this.unitId = unitId;
        this.departmentId = departmentId;
        this.departmentName = departmentName;
        this.departmentCode = departmentCode;
    }

    public Integer getSaId() {
        return saId;
    }

    public void setSaId(Integer saId) {
        this.saId = saId;
    }

    public String getUnitId() {
        return unitId;
    }

    public void setUnitId(String unitId) {
        this.unitId = unitId;
    }

    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getDepartmentCode() {
        return departmentCode;
    }

    public void setDepartmentCode(String departmentCode) {
        this.departmentCode = departmentCode;
    }

    @Override
    public String toString() {
        return "SecondAssist{" +
                "saId=" + saId +
                ", unitId='" + unitId + '\'' +
                ", departmentId='" + departmentId + '\'' +
                ", departmentName='" + departmentName + '\'' +
                ", departmentCode='" + departmentCode + '\'' +
                '}';
    }
}
