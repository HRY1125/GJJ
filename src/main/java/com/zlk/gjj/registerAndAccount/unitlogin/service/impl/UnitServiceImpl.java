package com.zlk.gjj.registerAndAccount.unitlogin.service.impl;

import com.zlk.gjj.registerAndAccount.agent.mapper.AgentMapper;
import com.zlk.gjj.registerAndAccount.entity.Agent;
import com.zlk.gjj.registerAndAccount.entity.Unit;
import com.zlk.gjj.registerAndAccount.unitlogin.mapper.UnitMapper;
import com.zlk.gjj.registerAndAccount.unitlogin.service.UnitService;
import com.zlk.gjj.registerAndAccount.util.IdUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    @Autowired
    private AgentMapper agentMapper;

    @Override
    public Unit findByUnitId(Unit unit) {
        return unitMapper.findByUnitId(unit);
    }

    @Override
    @Transactional
    public String insertUnit(Unit unit) {
        String message = "";
        String papersNum = unit.getPapersNum();
        Unit unit1 = unitMapper.findUnitByPapersNum(papersNum);
        if(unit1 != null){
            message = "该证件已注册，不可重复注册";
            return message;
        }else {
            String unitId = new IdUtils().getUnitId(8);
            List<String> unitIds = findAllUnitId();
            while (unitIds.contains(unitId)){
                unitId = IdUtils.getUnitId(8);
            }
            unit.setUnitId(unitId);
            unit.setStatus("0");
            unit.setErrorTimes(0);
            Integer flag = unitMapper.insertUnit(unit);
            Agent agent = new Agent();
            agent.setAgentName(unit.getAgentName());
            agent.setAgentPapersName(unit.getPapersName());
            agent.setAgentPapersNum(unit.getPapersNum());
            agent.setAgentPhone(unit.getAgentPhone());
            agent.setUnitId(unit.getUnitId());
            agent.setAgentType("证书用户");
            agent.setUkey(IdUtils.getUUID());
            agent.setAgentId(IdUtils.getUnitId(10));
            Integer flag1 = agentMapper.insertAgent(agent);
            if(flag>0 && flag1>0){
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
