package com.zlk.gjj.registerAndAccount.entity.vo;

import lombok.Getter;
import lombok.Setter;

/**
 * 汇缴清册的辅助类
 * @author wangzheng
 * @version 1.0
 * @date 2019/10/24 14:09
 */
@Setter
@Getter
public class Emp_Rem {
    /**
     * 个人的id      对应数据库中 employee_id 的字段
     */
    private int employeeId;
    /**
     * 个人的姓名      对应数据库中 employee_name的字段
     */
    private String employeeName;
    /**
     * 个人的国籍      对应数据库中 employee_nationnality 的字段
     */
    private String employeeNationnality;
    /**
     * 个人的证件名      对应数据库中 employee_papers_name 的字段
     */
    private String employeePapersName;
    /**
     * 个人的证件号      对应数据库中 employee_papers_num 的字段
     */
    private String employeePapersNum;

    /**
     * 汇缴清册的id      对应数据库中 remittance_id 的字段
     */
    private Integer remittanceId;
    /**
     * 单位登记id      对应数据库中 unit_regist_id 的字段
     */
    private String unitRegisterId;
    /**
     * 二级管理辅助信息      对应数据库中 sa_id 的字段
     */
    private String saId;
    /**
     *缴存基数      对应数据库中 deposit_base 的字段
     */
    private Double depositBase;
    /**
     * 单位月缴存额       对应数据库中 unit_deposite 的字段
     */
    private Double unitDeposite;
    /**
     * 个人月缴存额       对应数据库中 employee_deposite 的字段
     */
    private Double employeeDeposite;
    /**
     * 月缴存额合计       对应数据库中 deposite_total 的字段
     */
    private Double depositeTotal;
}
