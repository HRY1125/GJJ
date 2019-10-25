package com.zlk.gjj.registerAndAccount.agent.service;

import com.zlk.gjj.registerAndAccount.entity.Agent;

public interface AgentService {

    /**
     *  添加经办人
     *@method insertAgent
     *@params [agent]
     *@return java.lang.String
     *@author zhang
     *@time 2019/10/23  17:08
     */
    String insertAgent(Agent agent);

    /**
     *  根据id更改经办人信息
     *@method updateAgentById
     *@params [agent]
     *@return java.lang.String
     *@author zhang
     *@time 2019/10/23  20:02
     */
    String updateAgentById(Agent agent);

    /**
     *  根据ukey或agentUserName查找unitRegisterId
     *@method findUnitRegisterIdByUkey
     *@params [agent]
     *@return java.lang.String
     *@author zhang
     *@time 2019/10/23  21:35
     */
    String findUnitRegisterIdByUkeyOrAgentUserName(Agent agent);

    /**
     *  更加unitid查找agent对象
     *@method findAgentByUId
     *@params [unitId]
     *@return com.zlk.gjj.registerAndAccount.entity.Agent
     *@author zhang
     *@time 2019/10/25  11:52
     */
    Agent findAgentByUId(String unitId);
}
