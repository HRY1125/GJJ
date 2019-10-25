package com.zlk.gjj.registerAndAccount.unitlogin.service;

import com.zlk.gjj.registerAndAccount.entity.Unit;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

public interface UnitService {

    /**
     *  根据用户名，密码查找单位用户
     *@method findByUnitId
     *@params [unit]
     *@return com.zlk.gjj.registerAndAccount.entity.Unit
     *@author zhang
     *@time 2019/10/22  14:46
     */
    Unit findByUnitId(Unit unit);

    /**
     *  单位用户注册
     *@method insertUnit
     *@params [unit]
     *@return java.lang.String
     *@author zhang
     *@time 2019/10/22  17:18
     */
    String insertUnit(Unit unit);

    /**
     *  返回所有unitid的集合
     *@method findAllUnitId
     *@params []
     *@return java.util.List<java.lang.String>
     *@author zhang
     *@time 2019/10/22  17:34
     */
    List<String> findAllUnitId();

    /**
     *  根据unitid更改unit信息
     *@method undateUnitByUnitId
     *@params [unit]
     *@return java.lang.Integer
     *@author zhang
     *@time 2019/10/22  20:23
     */
    Integer updateUnitByUnitId(Unit unit);

    /**
     *  登录账号
     *@method login
     *@params [unit]
     *@return java.lang.String
     *@author zhang
     *@time 2019/10/22  20:37
     */
    String login(Unit unit);

    /**
     *  根据证件号码查找用户
     *@method findUnitByPapersNum
     *@params [papersNum]
     *@return com.zlk.gjj.registerAndAccount.entity.Unit
     *@author zhang
     *@time 2019/10/22  19:11
     */
    Unit findUnitByPapersNum(String papersNum);
}
