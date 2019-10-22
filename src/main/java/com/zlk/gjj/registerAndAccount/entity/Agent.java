package com.zlk.gjj.registerAndAccount.entity;

import lombok.Getter;
import lombok.Setter;

/**
 * @program: gjj
 * @description: 经办人实体类
 * @author: zyx
 * @create: 2019-10-21 21:35
 */
@Getter
@Setter
public class Agent {
    /**经办人id*/
    private String agentId;
    /**单位id*/
    private String unitId;
    /**单位登记号*/
    private String unitRegisterId;
    /**经办人姓名*/
    private String agentName;
    /**经办人证件名称*/
    private String agentPapersName;
    /**经办人证件号码*/
    private String agentPapersNum;
    /**经办人国别*/
    private String nationality;
    /**经办人办公电话*/
    private String officePhone;
    /**经办人手机号*/
    private String agentPhone;
    /**经办人邮箱*/
    private String agentEmail;

}
