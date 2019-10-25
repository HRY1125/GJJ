package com.zlk.gjj.registerAndAccount.agent.service.impl;

import com.zlk.gjj.registerAndAccount.agent.mapper.AgentMapper;
import com.zlk.gjj.registerAndAccount.agent.service.AgentService;
import com.zlk.gjj.registerAndAccount.entity.Agent;
import com.zlk.gjj.registerAndAccount.util.IdUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        agent.setAgentType("非证书用户");
        agent.setAgentId(IdUtils.getUnitId(10));
        Integer integer = agentMapper.insertAgent(agent);
        String message = "";
        if(integer>0){
            message = "经办人添加成功";
        }else {
            message = "添加失败";
        }
        return message;
    }

    @Override
    public String updateAgentById(Agent agent) {
        Integer integer = agentMapper.updateAgentById(agent);
        String message = "";
        if(integer>0){
            message = "经办人添加成功";
        }else {
            message = "添加失败";
        }
        return message;
    }

    @Override
    public String findUnitRegisterIdByUkeyOrAgentUserName(Agent agent) {
        return agentMapper.findUnitRegisterIdByUkeyOrAgentUserName(agent);
    }

}
