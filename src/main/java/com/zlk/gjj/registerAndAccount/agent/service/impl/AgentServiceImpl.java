package com.zlk.gjj.registerAndAccount.agent.service.impl;

import com.zlk.gjj.registerAndAccount.agent.mapper.AgentMapper;
import com.zlk.gjj.registerAndAccount.agent.service.AgentService;
import com.zlk.gjj.registerAndAccount.entity.Agent;
import com.zlk.gjj.registerAndAccount.util.IdUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: gjj
 * @description: Agent业务实现类
 * @author: zyx
 * @create: 2019-10-23 20:05
 */
@Service
public class AgentServiceImpl implements AgentService {
    @Autowired
    private AgentMapper agentMapper;

    @Override
    public String insertAgent(Agent agent) {
        String agentId = IdUtils.getUnitId(10);
        List<String> agentIds = agentMapper.findAllAgentId();
        while (agentIds.contains(agentId)){
            agentId = IdUtils.getUnitId(10);
        }
        agent.setAgentId(agentId);
        agent.setAgentType("非证书用户");
        agent.setAgentId(IdUtils.getUnitId(10));
        Integer integer = agentMapper.insertAgent(agent);
        String message = "";
        if(integer>0){
            message = "经办人添加成功";
        }else {
            message = "经办人添加失败";
        }
        return message;
    }

    @Override
    public String updateAgentById(Agent agent) {
        String agentId = IdUtils.getUnitId(10);
        List<String> agentIds = agentMapper.findAllAgentId();
        while (agentIds.contains(agentId)){
            agentId = IdUtils.getUnitId(10);
        }
        agent.setAgentId(agentId);
        Integer integer = agentMapper.updateAgentById(agent);
        String message = "";
        if(integer>0){
            message = "经办人修改成功";
        }else {
            message = "经办人修改失败";
        }
        return message;
    }

    @Override
    public String findUnitRegisterIdByUkeyOrAgentUserName(Agent agent) {
        return agentMapper.findUnitRegisterIdByUkeyOrAgentUserName(agent);
    }

    @Override
    public List<Agent> findAgentByUId(String unitId) {
        return agentMapper.findAgentByUId(unitId);
    }

    @Override
    public Integer updateAgentByAId(Agent agent) {
        return agentMapper.updateAgentByAId(agent);
    }

    @Override
    public List<Agent> findAgentByUIdAll(String unitId, int offset, int limit) {
        return agentMapper.findAgentByUIdAll(unitId,offset,limit);
    }

    @Override
    public Integer findCountByUnitId(String unitId) {
        return agentMapper.findCountByUnitId(unitId);
    }

    @Override
    public Integer deleteAgentByAgentId(Agent agent) {
        return agentMapper.deleteAgentByAgentId(agent);
    }

}
