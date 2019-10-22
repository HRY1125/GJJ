package com.zlk.gjj.registerAndAccount.unitlogin.service.impl;

import com.zlk.gjj.registerAndAccount.entity.Unit;
import com.zlk.gjj.registerAndAccount.unitlogin.mapper.UnitMapper;
import com.zlk.gjj.registerAndAccount.unitlogin.service.UnitService;
import com.zlk.gjj.registerAndAccount.util.UnitIdUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: gjj
 * @description: Unit业务层实现类
 * @author: zyx
 * @create: 2019-10-22 14:41
 */
@Service
public class UnitServiceImpl implements UnitService {
    @Autowired
    private UnitMapper unitMapper;

    @Override
    public Unit findByUnitId(Unit unit) {
        return unitMapper.findByUnitId(unit);
    }

    @Override
    public String insertUnit(Unit unit) {
        String message = "";
        String papersNum = unit.getPapersNum();
        Unit unit1 = unitMapper.findUnitByPapersNum(papersNum);
        if(unit1 != null){
            message = "该证件已注册，不可重复注册";
            return message;
        }else {
//            String unitId = new UnitIdUtil().getUnitId();
            String unitId = "1411";
            List<String> unitIds = findAllUnitId();
            while (unitIds.contains(unitId)){
                unitId = new UnitIdUtil().getUnitId();
            }
            unit.setUnitId(unitId);
            unit.setStatus("0");
            unit.setErrorTimes(0);
            Integer flag = unitMapper.insertUnit(unit);
            if(flag>0){
                return message="注册成功";
            }else {
                return message="注册失败";
            }
        }
    }

    @Override
    public List<String> findAllUnitId() {
        return unitMapper.findAllUnitId();
    }

    @Override
    public Integer updateUnitByUnitId(Unit unit) {
        return unitMapper.updateUnitByUnitId(unit);
    }

    @Override
    public String login(Unit unit) {
        String unitId = unit.getUnitId();
        String password = unit.getPassword();
        String msg="";
        if(unitId != null){
            Unit unit1 = unitMapper.findByUnitId(unit);
            if(unit1!=null){
                if(!unit1.getPassword().equals(password)){
                    unit1.setErrorTimes(unit1.getErrorTimes()+1);
                    unitMapper.updateUnitByUnitId(unit1);
                    if(unit1.getErrorTimes()>=3){
                        unit1.setErrorTimes(0);
                        unitMapper.updateUnitByUnitId(unit1);
                        msg="登录错误3次，退出系统";
                    }else {
                        msg="密码错误";
                    }
                }else {
                    if("1".equals(unit1.getStatus())){
                        msg="该用户为认证用户，请使用认证用户登录";
                    }else{
                        unit1.setErrorTimes(0);
                        unitMapper.updateUnitByUnitId(unit1);
                        msg = "登录成功";
                    }
                }

            }else {
                msg =" 用户名未注册";
            }
        }else {
           msg = "用户不能为空";
        }
        return msg;
    }

}
