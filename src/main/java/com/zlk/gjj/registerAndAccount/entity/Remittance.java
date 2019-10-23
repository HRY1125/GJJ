package com.zlk.gjj.registerAndAccount.entity;

import lombok.Getter;
import lombok.Setter;

/**
 * 汇缴清册表的实体类
 * @author wangzheng
 * @version 1.0
 * @date 2019/10/22 9:59
 */
@Setter
@Getter
public class Remittance {
    /**
     * 汇缴清册的id      对应数据库中 remittance_id 的字段
     */
    private Integer remittanceId;
    /**
     * 单位登记id      对应数据库中 unit_regist_id 的字段
     */
    private String unitRegisterId;
    /**
     * 个人的id      对应数据库中 employee_id 的字段
     */
    private Integer employeeId;
    /**
     * 二级管理辅助信息      对应数据库中 sa_id 的字段
     */
    private String saId;
    /**
     *缴存基数      对应数据库中 deposit_base 的字段
     */
    private Double depositBase;

}