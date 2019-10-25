package com.zlk.gjj.registerAndAccount.unitRegister.service.impl;

import com.zlk.gjj.registerAndAccount.agent.mapper.AgentMapper;
import com.zlk.gjj.registerAndAccount.entity.Agent;
import com.zlk.gjj.registerAndAccount.entity.UnitRegister;
import com.zlk.gjj.registerAndAccount.unitRegister.mapper.UnitRegisterMapper;
import com.zlk.gjj.registerAndAccount.unitRegister.service.UnitRegisterService;
import com.zlk.gjj.registerAndAccount.unitlogin.mapper.UnitMapper;
import com.zlk.gjj.registerAndAccount.util.IdUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UnitRegisterServiceImpl implements UnitRegisterService {

    @Autowired
    private UnitRegisterMapper UnitRegisterMapper;
    @Autowired
    private UnitMapper unitMapper;
    @Autowired
    private AgentMapper agentMapper;

    @Override
    public String selectUnitRegisterUnitId(UnitRegister unitRegister) {
        return UnitRegisterMapper.selectUnitRegisterUnitId(unitRegister);
    }

    @Override
    public UnitRegister selectUnitRegisterByName(String unitName) {
        return UnitRegisterMapper.selectUnitRegisterByName(unitName);
    }

    @Override
    public List<String> selectOrgCode() {
        return UnitRegisterMapper.selectOrgCode();
    }

    @Override
    @Transactional
    public String insertUnitRegister(UnitRegister unitRegister) {
        String unitRegisterId = IdUtils.getUnitId(8);
        unitRegister.setUnitRegisterId(unitRegisterId);
        Integer integer = UnitRegisterMapper.insertUnitRegister(unitRegister);
        Agent agent = new Agent();
        agent.setUnitId(unitRegister.getUnitId());
        agent.setUnitRegisterId(unitRegisterId);
        Integer integer1 = agentMapper.updateAgentById(agent);
        String message = "";
        if(integer>0 && integer1>0){
            return message = "单位登记成功";
        }else {
            return message = "单位登记失败";
        }
    }

    @Override
    public String selectUnitNameByUnitRegisterId(String unitRegisterId) {
        return UnitRegisterMapper.selectUnitNameByUnitRegisterId(unitRegisterId);
    }

    @Override
    public UnitRegister selectUnitRegisterByURId(String unitRegisterId) {
        return UnitRegisterMapper.selectUnitRegisterByURId(unitRegisterId);
    }

    @Override
    public UnitRegister selectUnitRegisterByUId(String unitId) {
        return UnitRegisterMapper.selectUnitRegisterByUId(unitId);
    }

    @Override
    public Integer updateUnitRegister(UnitRegister unitRegister) {
        return UnitRegisterMapper.updateUnitRegister(unitRegister);
    }


}
