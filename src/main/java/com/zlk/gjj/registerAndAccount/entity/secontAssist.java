package com.zlk.gjj.registerAndAccount.entity;

public class secontAssist {
    private String saId;
    private String unitId;
    private String departmentId;
    private String departmentName;
    private String departmentCode;


    public String getSaId() {
        return saId;
    }

    public void setSaId(String saId) {
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

    public secontAssist(String saId, String unitId, String departmentId, String departmentName, String departmentCode) {
        this.saId = saId;
        this.unitId = unitId;
        this.departmentId = departmentId;
        this.departmentName = departmentName;
        this.departmentCode = departmentCode;
    }

    public secontAssist() {
    }

    @Override
    public String toString() {
        return "secontAssist{" +
                "saId='" + saId + '\'' +
                ", unitId='" + unitId + '\'' +
                ", departmentId='" + departmentId + '\'' +
                ", departmentName='" + departmentName + '\'' +
                ", departmentCode='" + departmentCode + '\'' +
                '}';
    }
}
