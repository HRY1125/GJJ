package com.zlk.gjj.registerAndAccount.unitRegister.mapper;

import com.zlk.gjj.registerAndAccount.entity.UnitRegister;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UnitRegisterMapper {

    String selectUnitRegisterUnitId (UnitRegister unitRegister);

    /**
     *  根据单位名称查询登记信息
     *@method selectUnitRegisterByName
     *@params [unitName]
     *@return com.zlk.gjj.registerAndAccount.entity.UnitRegister
     *@author zhang
     *@time 2019/10/23  10:22
     */
    UnitRegister selectUnitRegisterByName(String unitName);

    /**
     *  查找所有登记过的单位组织代码
     *@method selectOrgCode
     *@params []
     *@return java.util.List<java.lang.String>
     *@author zhang
     *@time 2019/10/23  10:25
     */
    List<String> selectOrgCode();

    /**
     *  增加新单位登记
     *@method insertUnitRegister
     *@params [unitRegister]
     *@return java.lang.Integer
     *@author zhang
     *@time 2019/10/23  13:44
     */
    Integer insertUnitRegister(UnitRegister unitRegister);

    /**
     *  根据unitregisterid查找单位名称
     *@method selectUnitNameByUnitRegisterId
     *@params [unitRegisterId]
     *@return java.lang.String
     *@author zhang
     *@time 2019/10/23  21:41
     */
    String selectUnitNameByUnitRegisterId(String unitRegisterId);

    /**
     *  根据单位登记号查找单位登记信息
     *@method selectUnitRegisterByURId
     *@params [unitRegisterId]
     *@return com.zlk.gjj.registerAndAccount.entity.UnitRegister
     *@author zhang
     *@time 2019/10/24  16:15
     */
    UnitRegister selectUnitRegisterByURId(String unitRegisterId);

    /**
     *  根据单位id查找单位登记信息
     *@method selectUnitRegisterByUId
     *@params [unitId]
     *@return com.zlk.gjj.registerAndAccount.entity.UnitRegister
     *@author zhang
     *@time 2019/10/24  17:04
     */
    UnitRegister selectUnitRegisterByUId(String unitId);

    /**
     *  更改单位登记信息
     *@method updateUnitRegister
     *@params [unitRegister]
     *@return java.lang.Integer
     *@author zhang
     *@time 2019/10/24  17:15
     */
    Integer updateUnitRegister(UnitRegister unitRegister);

}
