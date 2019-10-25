package com.zlk.gjj.registerAndAccount.entity;

import lombok.Getter;
import lombok.Setter;

/**
 * 个人表的实体类
 * @author wangzheng
 * @version 1.0
 * @date 2019/10/22 9:58
 */
@Setter
@Getter
public class Employee {
    /**
     * 单位的id        对应数据库中 unit_id 的字段
     */
    private String unitId;
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
     * 个人的卡     对应数据库中 employee_card_regist_status 的字段
     */
    private String employeeCardRegistStatus;

    /**
     * 所属部门     对应数据库中 department_name 的字段
     */
    private String departmentName;
}
