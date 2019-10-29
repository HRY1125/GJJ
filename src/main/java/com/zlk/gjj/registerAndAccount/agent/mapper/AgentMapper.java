package com.zlk.gjj.registerAndAccount.agent.mapper;

import com.zlk.gjj.registerAndAccount.entity.Agent;
import org.apache.ibatis.annotations.Param;

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
    List<Agent> findAgentByUId(String unitId);

    /**
     *  查找全部agentid
     *@method findAllAgentId
     *@params []
     *@return java.util.List<java.lang.String>
     *@author zhang
     *@time 2019/10/25  17:11
     */
    List<String> findAllAgentId();

    /**
     *  根据agentid修改agent信息
     *@method updateAgentByAId
     *@params [agent]
     *@return java.lang.Integer
     *@author zhang
     *@time 2019/10/29  20:24
     */
    Integer updateAgentByAId(Agent agent);

    /**
     *  分页查找本单位所有agent
     *@method findAgentByUIdAll
     *@params [unitId, offset, limit]
     *@return java.util.List<com.zlk.gjj.registerAndAccount.entity.Agent>
     *@author zhang
     *@time 2019/10/29  20:43
     */
    List<Agent> findAgentByUIdAll(@Param("unitId")String  unitId, @Param("offset") int offset, @Param("limit") int limit);


    /**
     *  统计同一单位经办人数量
     *@method findCountByUnitId
     *@params [unitId]
     *@return java.lang.Integer
     *@author zhang
     *@time 2019/10/29  20:44
     */
    Integer findCountByUnitId(String unitId);

    /**
     *  根据经办人id删除经办人信息
     *@method deleteAgentByAgentId
     *@params [agent]
     *@return java.lang.Integer
     *@author zhang
     *@time 2019/10/29  20:51
     */
    Integer deleteAgentByAgentId(Agent agent);
}
