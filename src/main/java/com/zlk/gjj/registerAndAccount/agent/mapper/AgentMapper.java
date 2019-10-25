package com.zlk.gjj.registerAndAccount.agent.mapper;

import com.zlk.gjj.registerAndAccount.entity.Agent;

import java.util.List;

public interface AgentMapper {

    /**
     *  添加经办人
     *@method insertAgent
     *@params [agent]
     *@return java.lang.Integer
     *@author zhang
     *@time 2019/10/23  17:08
     */
    Integer insertAgent(Agent agent);

    /**
     *  根据id更改经办人信息
     *@method updateAgentById
     *@params [agent]
     *@return java.lang.Integer
     *@author zhang
     *@time 2019/10/23  20:02
     */
    Integer updateAgentById(Agent agent);

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

    /**
     *  查找全部agentid
     *@method findAllAgentId
     *@params []
     *@return java.util.List<java.lang.String>
     *@author zhang
     *@time 2019/10/25  17:11
     */
    List<String> findAllAgentId();

}
