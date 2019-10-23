package com.zlk.gjj.registerAndAccount.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * @program: gjj
 * @description: 单位登记实体类
 * @author: zyx
 * @create: 2019-10-22 10:51
 */
@Getter
@Setter
public class UnitRegister {
    /**单位登记号*/
    private String unitRegisterId;
    /**单位id*/
    private String unitId;
    /**单位名称*/
    private String unitName;
    /**单位组织机构代码*/
    private String orgCode;
    /**单位证件名称*/
    private String unitPapersName;
    /**单位证件号码*/
    private String unitPapersNum;
    /**单位性质代码*/
    private String unitPropertyCode;
    /**法人或负责人*/
    private String legalPerson;
    /**法人或负责人证件名称*/
    private String lpPapersName;
    /**法人或负责人国别*/
    private String nationality;
    /**法人或负责人证件号码*/
    private String lpPapersNum;
    /**单位注册地址*/
    private String unitRegisterAddress;
    /**单位办公地址*/
    private String unitOfficeAddress;
    /**是否具有法人资格*/
    private String isLP;
    /**单位创建时间*/
    private Date unitBuildDate;
    /**上级单位*/
    private String superiorUnit;
}
