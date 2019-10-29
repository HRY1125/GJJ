package com.zlk.gjj.registerAndAccount.agent.controller;

import com.zlk.gjj.registerAndAccount.agent.service.AgentService;
import com.zlk.gjj.registerAndAccount.entity.Agent;
import com.zlk.gjj.registerAndAccount.entity.UnitRegister;
import com.zlk.gjj.registerAndAccount.unitRegister.service.UnitRegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: gjj
 * @description: Agent控制器
 * @author: zyx
 * @create: 2019-10-23 20:06
 */
@Controller
@RequestMapping(value = "/agent")
public class AgentController {

    @Autowired
    private AgentService agentService;
    @Autowired
    private UnitRegisterService unitRegisterService;

    @RequestMapping(value = "/toAgent")
    public String toAgent(Model model, HttpServletRequest request) throws Exception{
        String unitId = (String) request.getSession().getAttribute("ID");
        if (unitId==null){
            model.addAttribute("retmsg","登录异常,请重新登陆");
            return "default";
        }

        List<Agent> agentList = agentService.findAgentByUId(unitId);
        for (Agent agent : agentList) {
            model.addAttribute("agent",agent);
        }
        return "agent";
    }

    @RequestMapping(value = "/toAgentTable")
    public String toAgentTable(Model model, HttpServletRequest request) throws Exception{
        String unitId = (String) request.getSession().getAttribute("ID");
        if (unitId==null){
            model.addAttribute("retmsg","登录异常,请重新登陆");
            return "default";
        }
        List<Agent> agentList = agentService.findAgentByUId(unitId);
        for (Agent agent : agentList) {
            model.addAttribute("agent",agent);
            model.addAttribute("unitId",agent.getUnitId());
            model.addAttribute("unitRegisterId",agent.getUnitRegisterId());
        }
        return "agent_table";
    }

    @RequestMapping(value = "/insertAgent")
    public String insertAgent(Model model, Agent agent) throws Exception{
        String message = agentService.insertAgent(agent);
        model.addAttribute("message","message");
        return "agent";
    }

    @RequestMapping(value = "/updateAgent")
    public String updateAgent(Model model,Agent agent) throws Exception{
        String message = agentService.updateAgentById(agent);
        model.addAttribute("message","message");
        return "agent";
    }

    @RequestMapping("/insert")
    @ResponseBody
    public Map insertAgent1(HttpServletRequest request, Agent agent){
        String unitId = (String) request.getSession().getAttribute("ID");
        UnitRegister unitRegister = unitRegisterService.selectUnitRegisterByUId(unitId);
        agent.setUnitId(unitId);
        agent.setUnitRegisterId(unitRegister.getUnitRegisterId());
        agentService.insertAgent(agent);
        Map map = new HashMap();
        map.put("message","添加成功");
        return map;
    }

    @RequestMapping("/update")
    @ResponseBody
    public Map updateAgent1(@RequestBody Agent agent){
        agentService.updateAgentByAId(agent);
        Map map = new HashMap();
        map.put("message","修改成功");
        return map;
    }

    @RequestMapping("/delete")
    @ResponseBody
    public Map delAgent1(@RequestBody Agent agent){
        agentService.deleteAgentByAgentId(agent);
        Map map = new HashMap();
        map.put("message","删除成功");
        return map;
    }

    @RequestMapping("/select")
    @ResponseBody
    public Map selAgentAll1(HttpServletRequest request,Integer page,Integer limit){
        String unitId = (String) request.getSession().getAttribute("ID");
        int offset=(page-1)*limit;
        List<Agent> agentList = agentService.findAgentByUIdAll(unitId,offset, limit);
        int count = agentService.findCountByUnitId(unitId);
        Map map = new HashMap();
        map.put("code",0);
        map.put("message","");
        map.put("count",count);
        map.put("data",agentList);
        return map;
    }
}
