package com.zlk.gjj.registerAndAccount.unitlogin.mapper;

import com.zlk.gjj.registerAndAccount.entity.Unit;

import java.util.List;

public interface UnitMapper {

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
     *@return java.lang.Integer
     *@author zhang
     *@time 2019/10/22  17:18
     */
    Integer insertUnit(Unit unit);

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
     *  根据证件号码查找用户
     *@method findUnitByPapersNum
     *@params [papersNum]
     *@return com.zlk.gjj.registerAndAccount.entity.Unit
     *@author zhang
     *@time 2019/10/22  19:11
     */
    Unit findUnitByPapersNum(String papersNum);

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
     *  根据单位名称查找单位id
     *@method findUnitIdByUnitName
     *@params [unitName]
     *@return java.lang.String
     *@author zhang
     *@time 2019/10/29  15:24
     */
    String findUnitIdByUnitName(String unitName);


}
