package com.zlk.gjj.registerAndAccount.entity;

import lombok.Getter;
import lombok.Setter;

/**
 * @program: gjj
 * @description: 单位实体类
 * @author: zyx
 * @create: 2019-10-21 22:44
 */
@Getter
@Setter
public class Unit {
    /**单位id*/
    private String unitId;
    /**单位证件人姓名*/
    private String agentName;
    /**单位经办人证件名称*/
    private String papersName;
    /**单位经办人证件号码*/
    private String papersNum;
    /**单位名称*/
    private String unitName;
    /**单位经办人手机*/
    private String agentPhone;
    /**单位邮箱*/
    private String unitEmail;
    /**单位用户密码*/
    private String password;
    /**单位用户状态*/
    private String status;
    /**用户登录失败次数*/
    private Integer errorTimes;
}
